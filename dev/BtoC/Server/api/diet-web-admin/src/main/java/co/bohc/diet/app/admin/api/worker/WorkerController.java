package co.bohc.diet.app.admin.api.worker;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "createworker", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> createworker(String workerName, String local){
        String message = workerService.createWorker(workerName, local);
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", message);
        return map;
    }
}
