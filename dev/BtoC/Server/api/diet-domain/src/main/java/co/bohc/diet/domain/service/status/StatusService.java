package co.bohc.diet.domain.service.status;

import java.util.Date;

public interface StatusService {

	public StatusOutput statusBByWeek(Date centerDate, Integer isNext);
}
