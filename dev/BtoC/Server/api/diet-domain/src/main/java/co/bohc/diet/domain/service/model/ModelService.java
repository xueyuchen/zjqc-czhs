package co.bohc.diet.domain.service.model;

import java.util.List;

import co.bohc.diet.domain.model.Model;

public interface ModelService {

    public List<Model> findByBrandId(Integer brandId);
}
