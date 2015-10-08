package co.bohc.diet.domain.service.status;

import java.util.Date;
import java.util.List;

import co.bohc.diet.domain.model.Status;

public interface StatusService {

	public StatusOutput statusBByWeek(Date centerDate, Integer isNext);
	
	public List<Status> statusByDay(Date date);
}
