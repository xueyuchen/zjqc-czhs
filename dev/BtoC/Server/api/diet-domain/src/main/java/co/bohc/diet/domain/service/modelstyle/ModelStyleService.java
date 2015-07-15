package co.bohc.diet.domain.service.modelstyle;

import java.util.List;

import co.bohc.diet.domain.model.ModelStyle;

public interface ModelStyleService {

    public List<ModelStyle> findAll(Integer modelId);
}
