package co.bohc.diet.domain.service.part;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.model.Part;
import co.bohc.diet.domain.repository.part.PartRepository;

@Service
@Transactional(readOnly = true)
public class PartServiceImpl implements PartService {

    @Inject
    private PartRepository partRepository;
    
    @Override
    public List<Part> findAll() {
        return partRepository.findAllByDelFlg();
    }

}
