package co.bohc.diet.domain.service.code;

import java.util.List;
import java.util.Map;

import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.model.Worker;
import co.bohc.diet.domain.service.CrudService;
import co.bohc.diet.domain.service.worker.WorkerOutput;

public interface CodeService extends CrudService<Code, Integer> {

    public Map<String, Object> checkCode(String codeNum);

    public WorkerOutput createCode(Integer num, Integer workerId);

    public void createfile(WorkerOutput worker);
    
    public List<String> allWorks();
    
    public List<Worker> destroyCode(Integer workerId);
    
    public void saveCodes(List<Code> codes);

}
