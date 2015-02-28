package co.bohc.diet.domain.service.code;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.bohc.diet.domain.common.enums.CodeKbn;
import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.repository.code.CodeRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;

@Service
public class CodeServiceImpl extends CrudServiceImpl<Code, Integer, CodeRepository> implements CodeService {

    @Inject
    public void setRepository(CodeRepository repository) {
        super.setRepository(repository);
    }

    @Override
    public Map<String, Object> checkCode(String codeNum) {
        Code code = repository.findByCodeNum(codeNum);
        Map<String, Object> map = new HashMap<String, Object>();
        if(code.getCodeKbn() == null){
            Date date = new Date();
            code.setCheckDt(date);
            code.setCodeKbn(CodeKbn.NG.getLabel());
            repository.save(code);
            String message = "残值编码扫描通过！";
            map.put("message", message);
            map.put("codeNum", codeNum);
            return map;
        }else{
            String message = "此残值编码在 "+code.getCheckDt()+" 已扫描过！";
            map.put("message", message);
            return map;
        }
    }
    
}
