package co.bohc.diet.domain.repository.status;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

	@Query(value = "SELECT s FROM Status s WHERE s.creDt >= :fromDt AND s.creDt <= :toDt")
	public List<Status> statusChangeByWeek(@Param("fromDt") Date fromDt, @Param("toDt") Date toDt);
}
