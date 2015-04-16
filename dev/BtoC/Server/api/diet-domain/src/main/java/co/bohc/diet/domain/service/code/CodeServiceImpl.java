package co.bohc.diet.domain.service.code;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.common.enums.CodeKbn;
import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.repository.code.CodeRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;

@Service
@Transactional(readOnly = true)
public class CodeServiceImpl extends CrudServiceImpl<Code, Integer, CodeRepository> implements CodeService {

    @Inject
    public void setRepository(CodeRepository repository) {
        super.setRepository(repository);
    }

    /**
     * 检查code
     */
    @Override
    @Transactional
    public Map<String, Object> checkCode(String codeNum) {
        Code code = repository.findByCodeNum(codeNum);
        Map<String, Object> map = new HashMap<String, Object>();
        if (code == null) {
            String message = "此编码不存在！";
            map.put("codeNum", codeNum);
            map.put("message", message);
            return map;
        }
        if (code.getCodeKbn() == null) {
            Date date = new Date();
            code.setCheckDt(date);
            code.setCodeKbn(CodeKbn.NG.getLabel());
            repository.save(code);
            String message = "残值编码扫描通过！";
            map.put("message", message);
            map.put("codeNum", codeNum);
            return map;
        } else {
            String message = "此残值编码在 " + code.getCheckDt() + " 已扫描过！";
            map.put("codeNum", codeNum);
            map.put("message", message);
            return map;
        }
    }

    /**
     * 批量生成code
     */
    @Transactional
    public List<Code> createCode(Integer num, String local, String person) {
        Code code = null;
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        Integer year = cal.get(Calendar.YEAR);
        Integer month = cal.get(Calendar.MONTH);
        Integer lastCodeSeq = codeIndex(local, month, year);
        List<Code> codes = new ArrayList<Code>();
        for (int i = 0; i < num; i++) {
            code = new Code();
            String codeNum = String.valueOf(year) + String.valueOf(month) + String.valueOf(local) + "00"
                    + creatCodeSeq(lastCodeSeq);
            code.setLocal(local);
            code.setCreDt(date);
            code.setCodeNum(codeNum);
            code.setPerson(person);
            repository.save(code);
            codes.add(code);
        }
        return codes;
    }

    private Integer codeIndex(String local, Integer month, Integer year) {
        Code lastCode = repository.findLastCodeNum(local);
        if(lastCode == null){
            return 1;
        }
        String lastCodeMonth = String.valueOf(lastCode.getCodeNum().charAt(1));
        String lastCodeYear = String.valueOf(lastCode.getCodeNum().charAt(0));
        if (month.equals(Integer.parseInt(lastCodeMonth)) && year.equals(Integer.parseInt(lastCodeYear))) {
            Integer num = Integer.parseInt(lastCode.getCodeNum().substring(5));
            return num;
        } else {
            return 1;
        }
    }
    
    private String creatCodeSeq(Integer lastCodeSeq){
        String s = String.valueOf(lastCodeSeq);
        String zeroNum = "0";
        for(int i = 0; i < 6-s.length(); i++){
            zeroNum += "0";
        }
        return zeroNum + s;
    }
}
