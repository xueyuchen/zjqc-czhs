package co.bohc.diet.domain.repository.worker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.Worker;
import co.bohc.diet.domain.service.worker.WorkerCodeOutput;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    @Query(value = "SELECT w FROM Worker w WHERE w.workerId = :workerId AND w.delFlg IS NULL")
    public Worker findByWorkerName(@Param("workerId")Integer workerId);
    
    @Query(value = "SELECT w FROM Worker w WHERE w.delFlg IS NULL")
    public List<Worker> findAllWorkerByDelFlg();
    
    @Query(value = "SELECT w FROM Worker w WHERE w.workerName = :workerName AND w.delFlg IS NULL")
    public Worker findByWorkerName(@Param("workerName")String workerName);
    
}
