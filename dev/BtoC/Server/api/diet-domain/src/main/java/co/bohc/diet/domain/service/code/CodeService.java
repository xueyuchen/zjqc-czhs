package co.bohc.diet.domain.service.code;

import java.util.List;
import java.util.Map;

import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.service.CrudService;

public interface CodeService extends CrudService<Code, Integer>{

    public Map<String, Object> checkCode(String codeNum);
    
    public List<Code> createCode(Integer num, String local);
}