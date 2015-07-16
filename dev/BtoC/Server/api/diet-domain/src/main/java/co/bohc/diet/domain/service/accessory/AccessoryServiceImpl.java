package co.bohc.diet.domain.service.accessory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.model.Accessory;
import co.bohc.diet.domain.repository.accessory.AccessoryRepository;

@Service
@Transactional(readOnly = true)
public class AccessoryServiceImpl implements AccessoryService {

    @Inject
    private AccessoryRepository accessoryRepository;
    
    @Override
    public List<Accessory> findByModelStylePart(String modelName, String styleName, String partName) {
        List<Accessory> accessories = accessoryRepository.findByModelStylePart(modelName, styleName, partName);
        for(int i = 0; i < accessories.size(); i++){
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return accessories;
    }

    @Override
    public List<Accessory> findByCreDt() {
        List<Accessory> accessories = accessoryRepository.findByCreDt();
        for(int i = 0; i < accessories.size(); i++){
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return accessories;
    }

}
