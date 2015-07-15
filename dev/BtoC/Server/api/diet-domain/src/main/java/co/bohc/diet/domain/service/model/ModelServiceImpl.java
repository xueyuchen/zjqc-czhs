package co.bohc.diet.domain.service.model;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.model.Model;
import co.bohc.diet.domain.repository.model.ModelRepository;

@Service
@Transactional(readOnly = true)
public class ModelServiceImpl implements ModelService {

    @Inject
    private ModelRepository modelRepository;
    
    @Override
    public List<Model> findByBrandId(Integer brandId) {
        List<Model> models = modelRepository.findAllBydelFlg(brandId);
        for(int i = 0; i<models.size(); i++){
            models.get(i).setAccessories(null);
            models.get(i).setModelStyles(null);
            models.get(i).setBrand(null);
        }
        return models;
    }

}
