package co.bohc.diet.domain.repository.code;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.Code;

public interface CodeRepository extends JpaRepository<Code, Integer>{

    public Code findByCodeNum(String codeNum);
    
    @Query(value = "SELECT TOP 1 * FROM code where local = :local ORDER BY code_id DESC", nativeQuery = true)
    public Code findLastCodeNum(@Param("local")String local);
    
    @Query(value = "SELECT c FROM Code c WHERE c.creDt >= :fromTime and c.creDt <= :endTime")
    public List<Code> findByCreDt(@Param("fromTime")Date fromTime, @Param("endTime")Date endTime);
    
    @Query(value = "SELECT c.person FROM Code c WHERE c.codeKbn IS NULL GROUP BY c.person")
    public List<String> allWorks();
    
    @Query(value = "SELECT c FROM Code c where c.person = :person AND c.codeKbn IS NULL")
    public List<Code> findByPerson(@Param("person")String person);
}
