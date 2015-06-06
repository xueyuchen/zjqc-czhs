package co.bohc.diet.app.admin.api.worker;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.time.DateUtils;
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
    public String tocreate(){
        return "worker/createworker";
    }
    
    @RequestMapping(value = "tostatistics")
    public String toWorkerTotal(){
        return "worker/workertotal";
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
    public List<WorkerCodeOutput> statisticsCode(WorkerCriteria criteria){
//        Date fromDt = TimeUtils.strToDate(fromDtStr);
//        Date toDt = TimeUtils.strToDate(toDtStr);
        return workerService.findCodeNumByWorker(criteria);
    }
}
