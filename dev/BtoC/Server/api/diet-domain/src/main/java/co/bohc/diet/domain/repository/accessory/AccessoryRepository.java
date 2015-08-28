package co.bohc.diet.domain.repository.accessory;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.Accessory;

public interface AccessoryRepository extends JpaRepository<Accessory, Integer>, AccesstoryRepositoryCustom {

//    @Query(
//           value = "SELECT a FROM Accessory a WHERE a.saleDt IS NULL AND a.model.modelName = :modelName AND a.style.styleName = :styleName AND a.part.partName = :partName")
//    public List<Accessory> findByModelStylePart(@Param("modelName") String modelName,
//            @Param("styleName") String styleName, @Param("partName") String partName);
    
    @Query(value = "SELECT a FROM Accessory a WHERE a.saleDt IS NULL ORDER BY a.creDt DESC")
    public List<Accessory> findByCreDt();
    
    @Query(value = "SELECT a FROM Accessory a ORDER BY a.creDt DESC")
    public List<Accessory> findByCreDtSale();
    
//    @Query(value = "SELECT COUNT(a) FROM Accessory a WHERE a.saleDt IS NULL AND a.model.modelId = :modelId AND a.style.styleId = :styleId AND a.part.partId = :partId")
//    public Integer findCountByMSP(@Param("modelId") Integer modelId, @Param("styleId") Integer styleId, @Param("partId") Integer partId);

//    @Query(value = "SELECT a FROM Accessory a WHERE a.saleDt IS NULL AND a.model.brand.brandId = :brandId")
//    public List<Accessory> findByBrandId(@Param("brandId") Integer brandId, Pageable pageable);
    
//    @Query(value = "SELECT COUNT(a) FROM Accessory a WHERE a.saleDt IS NULL AND a.model.brand.brandId = :brandId")
//    public Integer countByBrandId(@Param("brandId") Integer brandId);
    
//    @Query(value = "SELECT a FROM Accessory a WHERE a.model.brand.brandId = :brandId")
//    public List<Accessory> findByBrandIdAndSale(@Param("brandId") Integer brandId);
    
    @Query(value = "SELECT a FROM Accessory a WHERE a.creDt >= :fromDt AND a.creDt <= :toDt AND a.saleDt IS NULL AND a.level = 1")
    public List<Accessory> findByDate(@Param("fromDt") Date fromDt, @Param("toDt") Date toDt);
    
    @Query(value = "SELECT COUNT(a) FROM Accessory a WHERE a.creDt >= :fromDt AND a.creDt <= :toDt")
    public Integer countByMonth(@Param("fromDt") Date fromDt, @Param("toDt") Date toDt);
    
    @Query(value = "SELECT a FROM Accessory a WHERE a.accessoryNum = :accessoryNum AND a.level = 1")
    public Accessory findByNum(@Param("accessoryNum") String accessoryNum);
    
    @Query(value = "SELECT a FROM Accessory a WHERE a.accessoryNum = :accessoryNum AND a.level = 2")
    public Accessory findByNumFromB(@Param("accessoryNum") String accessoryNum);
    
    @Query(value = "SELECT a FROM Accessory a WHERE a.accessoryNum = :accessoryNum")
    public Accessory findOneByNum(@Param("accessoryNum") String accessoryNum);
    
    @Query(value="SELECT a FROM Accessory a WHERE a.saleDt >= :fromDt AND a.saleDt <= :toDt")
    public List<Accessory> findByWeek(@Param("fromDt") Date fromDt, @Param("toDt") Date toDt);
}
