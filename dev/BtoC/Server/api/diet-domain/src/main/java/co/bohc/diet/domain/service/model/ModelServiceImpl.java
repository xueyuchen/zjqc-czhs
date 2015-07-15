package co.bohc.diet.domain.service.model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.model.Accessory;
import co.bohc.diet.domain.model.Model;
import co.bohc.diet.domain.model.ModelStyle;
import co.bohc.diet.domain.repository.model.ModelRepository;

@Service
@Transactional(readOnly = true)
public class ModelServiceImpl implements ModelService {

    @Inject
    private ModelRepository modelRepository;
    
    @Override
    public List<Model> findByBrandId(Integer brandId) {
        List<Model> models = modelRepository.findAllBydelFlg(brandId);
        Iterator<Model> it = models.iterator();
        Model model = null;
        while(it.hasNext()){
            model = it.next();
            model.setAccessories(null);
            model.setModelStyles(null);
        }
        return models;
    }

}
