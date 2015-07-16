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
    }

}
