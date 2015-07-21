package co.bohc.diet.domain.service.accessory;

import java.util.List;

import co.bohc.diet.domain.model.Accessory;
import co.bohc.diet.domain.repository.accessory.AccessoryOutput;
import co.bohc.diet.domain.repository.accessory.AccessorySearchPar;

public interface AccessoryService {

    public List<Accessory> findByModelStylePart(String modelName, String styleName, String partName);
    
    public List<Accessory> findByCreDt();
    
    public void saveAccessory(String level, Integer modelId, Integer styleId, Integer partId, String imgDataUrl);
    
    public List<Accessory> findByBrandId(Integer brandId);
    
    public List<AccessoryOutput> findByParam(AccessorySearchPar accessorySearchPar);
}
