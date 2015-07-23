package co.bohc.diet.domain.repository.accessory;

import java.util.List;

import org.springframework.data.domain.Pageable;

import co.bohc.diet.domain.model.Accessory;

public interface AccesstoryRepositoryCustom {

    public List<Accessory> findByParam(AccessorySearchPar accessorySearchPar, Pageable pageable);
    
    public Long countByParam(AccessorySearchPar accessorySearchPar);
    
    public List<Accessory> findByParamSale(AccessorySearchPar accessorySearchPar);
}
