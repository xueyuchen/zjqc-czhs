package co.bohc.diet.domain.repository.paper;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.Paper;

public interface PaperRepository extends JpaRepository<Paper, Integer> {

    @Query(value = "SELECT COUNT(*) AS count FROM paper WHERE cre_dt >= :fromDt AND cre_dt <= :toDt",
           nativeQuery = true)
    public Integer countNum(@Param("fromDt") Date fromDt, @Param("toDt") Date toDt);

    @Query(value = "SELECT p FROM Paper p WHERE p.creDt >= :fromDt AND p.creDt <= :toDt")
    public List<Paper> findAllByDate(@Param("fromDt") Date fromDt, @Param("toDt") Date toDt);

    public Paper findOneByPaperCode(String paperCode);

    @Query(value = "SELECT p FROM Paper p WHERE p.entryDt >= :fromDt AND p.entryDt <= :toDt AND p.delFlg IS NULL")
    public List<Paper> findByEntryDt(@Param("fromDt") Date fromDt, @Param("toDt") Date toDt);

    @Query(
           value = "SELECT TOP 1 p.paper_code FROM paper p WHERE p.cre_dt >= :fromDt AND p.cre_dt <= :toDt ORDER BY p.paper_id DESC",
           nativeQuery = true)
    public String findLastOneByMonth(@Param("fromDt") Date fromDt, @Param("toDt") Date toDt);
    
}
