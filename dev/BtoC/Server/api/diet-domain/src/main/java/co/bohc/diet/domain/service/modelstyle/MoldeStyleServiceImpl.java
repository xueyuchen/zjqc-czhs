package co.bohc.diet.domain.service.modelstyle;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.model.ModelStyle;
import co.bohc.diet.domain.repository.modelstyle.ModelStyleRepository;

@Service
@Transactional(readOnly = true)
public class MoldeStyleServiceImpl implements ModelStyleService {

    @Inject
    private ModelStyleRepository modelStyleRepository;

    @Override
    public List<ModelStyle> findAll(Integer modelId) {
        List<ModelStyle> modelStyles = modelStyleRepository.findByDelFlg(modelId);
        for(int i = 0; i<modelStyles.size(); i++){
            modelStyles.get(i).setModel(null);
            modelStyles.get(i).getStyle().setAccessories(null);
            modelStyles.get(i).getStyle().setModelStyles(null);
            
        }
        return modelStyles;
    }
}
