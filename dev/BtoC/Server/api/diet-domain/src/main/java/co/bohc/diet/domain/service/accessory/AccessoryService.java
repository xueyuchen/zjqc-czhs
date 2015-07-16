package co.bohc.diet.domain.service.accessory;

import java.util.List;

import co.bohc.diet.domain.model.Accessory;

public interface AccessoryService {

    public List<Accessory> findByModelStylePart(String modelName, String styleName, String partName);
}
