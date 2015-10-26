package co.bohc.diet.domain.repository.code;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.service.worker.WorkerCodeOutput;

public interface CodeRepository extends JpaRepository<Code, Integer>, CodeRepositoryCustom{

    public Code findByCodeNum(String codeNum);
    
    @Query(value = "SELECT TOP 1 * FROM code where worker_id = :workerId ORDER BY code_id DESC", nativeQuery = true)
    public Code findLastCodeNum(@Param("workerId")Integer workerId);
    
    @Query(value = "SELECT c FROM Code c WHERE c.creDt >= :fromTime and c.creDt <= :endTime ORDER BY c.codeId")
    public List<Code> findByCreDt(@Param("fromTime")Date fromTime, @Param("endTime")Date endTime);
    
    @Query(value = "SELECT c.worker.workerName FROM Code c WHERE c.codeKbn IS NULL GROUP BY c.worker.workerId")
    public List<String> allWorks();
    
    @Query(value = "SELECT c FROM Code c where c.worker.workerId = :workerId AND c.codeKbn IS NULL")
    public List<Code> findByWorkerId(@Param("workerId")Integer workerId);
    
    @Query(value = "SELECT c FROM Code c WHERE c.worker.workerId = :workerId AND c.creDt >= :fromDt AND c.creDt <= :toDt")
    public List<Code> findByWorkerIdAndCreDt(@Param("workerId")Integer workerId, @Param("fromDt")Date fromDt, @Param("toDt")Date toDt);

    @Query(value = "SELECT c FROM Code c WHERE c.codeKbn IS NULL AND c.checkDt IS NULL AND c.creDt < :toDt")
    public List<Code> findNoExpired(@Param("toDt")Date toDt);
    
    @Query(value = "SELECT c FROM Code c WHERE c.codeKbn IS NULL AND c.checkDt IS NULL AND c.creDt > :fromDt AND c.creDt < :toDt ")
    public List<Code> findNoExpiredByMonth(@Param("fromDt")Date fromDt, @Param("toDt")Date toDt);
}
