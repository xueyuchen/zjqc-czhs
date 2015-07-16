package co.bohc.diet.domain.repository.accessory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.Accessory;

public interface AccessoryRepository extends JpaRepository<Accessory, Integer> {

    @Query(
           value = "SELECT a FROM Accessory a WHERE a.saleDt IS NULL AND a.model.modelName = :modelName AND a.style.styleName = :styleName AND a.part.partName = :partName")
    public List<Accessory> findByModelStylePart(@Param("modelName") String modelName,
            @Param("styleName") String styleName, @Param("partName") String partName);
    
    @Query(value = "SELECT a FROM Accessory a WHERE a.saleDt IS NULL ORDER BY a.creDt DESC")
    public List<Accessory> findByCreDt();
}
