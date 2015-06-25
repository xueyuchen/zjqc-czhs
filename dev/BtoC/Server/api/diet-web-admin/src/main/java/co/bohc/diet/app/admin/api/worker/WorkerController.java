package co.bohc.diet.app.admin.api.worker;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.repository.code.WorkerCriteria;
import co.bohc.diet.domain.service.worker.WorkerCodeOutput;
import co.bohc.diet.domain.service.worker.WorkerService;

@Controller
@RequestMapping(value = "workers")
public class WorkerController {
    
    @Inject
    private WorkerService workerService;
    
    @RequestMapping(value = "tocre")
    public String tocreate(HttpServletRequest req){
        String session = (String) req.getSession().getAttribute("_");
        if(session != null && session == "czhs"){
            return "worker/createworker";
        }else{
            return null;
        }
    }
    
    @RequestMapping(value = "tostatistics")
    public String toWorkerTotal(HttpServletRequest req){
        String session = (String) req.getSession().getAttribute("_");
        if(session.equals("czhsUser")){
            return "worker/workertotal_user";
        }else if(session.equals("czhs")){
            return "worker/workertotal";
        }else{
            return null;
        }
    }

    @RequestMapping(value = "createworker", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> createworker(String workerName, String local){
        String message = workerService.createWorker(workerName, local);
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", message);
        return map;
    }
    
    @RequestMapping(value = "statisticsworker", method = RequestMethod.POST)
    @ResponseBody
    public Page<WorkerCodeOutput> statisticsCode(WorkerCriteria criteria, Pageable pageable){
//        Date fromDt = TimeUtils.strToDate(fromDtStr);
//        Date toDt = TimeUtils.strToDate(toDtStr);
        criteria.setFromDt(TimeUtils.getStartTimeOfDay(criteria.getFromDt()));
        criteria.setToDt(TimeUtils.getEndTimeOfDay(criteria.getToDt()));
        return workerService.findCodeNumByWorker(criteria, pageable);
    }
}
