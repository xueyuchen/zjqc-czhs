package co.bohc.diet.app.admin.api.status;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.service.status.StatusOutput;
import co.bohc.diet.domain.service.status.StatusService;

@Controller
@RequestMapping(value = "status")
public class StatusController {

	@Inject
	private StatusService statusService;
	
	@RequestMapping(value = "statusBByWeek", method = RequestMethod.GET)
	@ResponseBody
	public StatusOutput statusBByWeek(String dateStr, Integer isNext) {
		Date centerDate = TimeUtils.strToDate(dateStr);
		return statusService.statusBByWeek(centerDate, isNext);
	}
}
