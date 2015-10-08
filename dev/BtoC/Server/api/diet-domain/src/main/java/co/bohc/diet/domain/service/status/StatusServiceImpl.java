package co.bohc.diet.domain.service.status;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.bouncycastle.jce.provider.JDKDSASigner.stdDSA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.model.Status;
import co.bohc.diet.domain.repository.status.StatusRepository;
import co.bohc.diet.domain.service.accessory.SaleHistoryOutput;

@Service
@Transactional(readOnly = true)
public class StatusServiceImpl implements StatusService {

	@Inject
	private StatusRepository statusRepository;

	private StatusOutput initOutput(Date fromDt) {
		StatusOutput output = new StatusOutput();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDt);
		for (int i = 0; i < 7; i++) {
			output.getDays()[i] = TimeUtils.dateToStr(cal.getTime());
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		return output;
	}

	@Override
	public StatusOutput statusBByWeek(Date centerDate, Integer isNext) {
		Date fromDt = null;
		Date toDt = null;
		StatusOutput output = null;
		if (isNext == 0) {
			fromDt = TimeUtils.getFirstDayOfWeek(centerDate);
			toDt = TimeUtils.getLastDayOfWeek(centerDate);
			output = initOutput(fromDt);
		} else if (isNext == -1) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(centerDate);
			cal.add(Calendar.DAY_OF_MONTH, -7);
			fromDt = TimeUtils.getFirstDayOfWeek(cal.getTime());
			toDt = TimeUtils.getLastDayOfWeek(cal.getTime());
			output = initOutput(fromDt);
		} else if (isNext == 1) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(centerDate);
			cal.add(Calendar.DAY_OF_MONTH, 7);
			fromDt = TimeUtils.getFirstDayOfWeek(cal.getTime());
			toDt = TimeUtils.getLastDayOfWeek(cal.getTime());
			output = initOutput(fromDt);
		}
		List<Status> statuses = statusRepository.statusChangeByWeek(fromDt, toDt);
		Iterator<Status> it = statuses.iterator();
		while (it.hasNext()) {
			Status status = it.next();
			Date date = status.getCreDt();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int day = cal.get(Calendar.DAY_OF_WEEK) - 1;
			if (day == 0) {
				day = 6;
			} else {
				day = day - 1;
			}
			if (status.getStatusFrom() == 0 && status.getStatusTo() == 1) {
				output.getToIn()[day] = output.getToIn()[day] + 1;
			} else if (status.getStatusFrom() == 1 && status.getStatusTo() == 2) {
				output.getToFix()[day] = output.getToFix()[day] + 1;
			} else if (status.getStatusFrom() == 2 && status.getStatusTo() == 3) {
				output.getToFinish()[day] = output.getToFinish()[day] + 1;
			}
		}
		output.setList(statuses);
		return output;
	}

	@Override
	public List<Status> statusByDay(Date date) {
		Date fromDt = TimeUtils.getStartTimeOfDay(date);
		Date toDt = TimeUtils.getEndTimeOfDay(date);
		return statusRepository.statusChangeByWeek(fromDt, toDt);
	}
	
	

}
