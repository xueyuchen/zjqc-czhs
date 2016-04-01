package co.bohc.diet.domain.service.garage;

import java.util.List;

import co.bohc.diet.domain.model.Garage;
import co.bohc.diet.domain.service.CrudService;

public interface GarageService extends CrudService<Garage, Integer> {

	public List<Garage> findAllGarage();
}
