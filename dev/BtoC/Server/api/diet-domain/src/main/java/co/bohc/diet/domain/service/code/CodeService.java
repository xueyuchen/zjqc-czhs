package co.bohc.diet.domain.service.code;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.service.CrudService;

public interface CodeService extends CrudService<Code, Integer> {

    public Map<String, Object> checkCode(String codeNum);

    public String createCode(Integer num, String local, Integer workerId);

    public void createfile(String workerName);
    
    public List<String> allWorks();
    
    public void destroyCode(String person);

}
