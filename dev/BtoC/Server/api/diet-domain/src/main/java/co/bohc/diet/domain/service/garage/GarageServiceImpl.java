package co.bohc.diet.domain.service.garage;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.model.Garage;
import co.bohc.diet.domain.repository.garage.GarageRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;

@Service
@Transactional(readOnly = true)
public class GarageServiceImpl extends CrudServiceImpl<Garage, Integer, GarageRepository>implements GarageService {

	@Inject
	public void setRepository(GarageRepository repository) {
		super.setRepository(repository);
	}

	@Override
	public List<Garage> findAllGarage() {
		// TODO Auto-generated method stub
		return repository.findAllGarage();
	}

}
