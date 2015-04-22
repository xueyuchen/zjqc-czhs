package co.bohc.diet.domain.repository.paper;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.Paper;

public interface PaperRepository extends JpaRepository<Paper, Integer>{

    @Query(value = "SELECT TOP 1 print_num AS printNum FROM paper ORDER BY print_num DESC", nativeQuery = true)
    public Integer countNum();
    
    @Query(value = "SELECT p FROM Paper p WHERE p.creDt >= :fromDt AND p.creDt <= :toDt")
    public List<Paper> findAllByDate(@Param("fromDt")Date fromDt, @Param("toDt")Date toDt);
}
