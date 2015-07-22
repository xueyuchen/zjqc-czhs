package co.bohc.diet.domain.repository.accessory;

import java.util.List;

import co.bohc.diet.domain.model.Accessory;

public interface AccesstoryRepositoryCustom {

    public List<Accessory> findByParam(AccessorySearchPar accessorySearchPar);
    
    public List<Accessory> findByParamSale(AccessorySearchPar accessorySearchPar);
}
