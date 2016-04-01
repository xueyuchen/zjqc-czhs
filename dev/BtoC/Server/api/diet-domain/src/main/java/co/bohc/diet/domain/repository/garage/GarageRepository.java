package co.bohc.diet.domain.repository.garage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.bohc.diet.domain.model.Garage;

public interface GarageRepository extends JpaRepository<Garage, Integer> {

	@Query(value = "SELECT g FROM Garage g where g.delFlg = 0")
	public List<Garage> findAllGarage();
}
