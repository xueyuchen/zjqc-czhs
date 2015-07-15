package co.bohc.diet.domain.service.brand;

import java.util.List;

import co.bohc.diet.domain.model.Brand;

public interface BrandService {

    public Brand findBrand(Integer brandId);
    
    public List<Brand> findAllBrand();
}
