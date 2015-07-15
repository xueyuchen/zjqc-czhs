package co.bohc.diet.domain.repository.brand;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.bohc.diet.domain.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    public Brand findByBrandId(Integer brandId);
    
    @Query(value = "SELECT b FROM Brand b WHERE b.delFlg IS NULL")
    public List<Brand> findAllBydelFlg();
}
