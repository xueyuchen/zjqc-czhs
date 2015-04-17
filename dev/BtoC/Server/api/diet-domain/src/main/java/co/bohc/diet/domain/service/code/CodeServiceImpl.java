package co.bohc.diet.domain.service.code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.common.Environment;
import co.bohc.diet.domain.common.enums.CodeKbn;
import co.bohc.diet.domain.common.utils.TimeUtils;
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

    @Inject
    private Environment env;
    
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
        Integer year = cal.get(Calendar.YEAR)%10;
        Integer month = cal.get(Calendar.MONTH) + 1;
        Integer lastCodeSeq = codeIndex(local, month, year);
        List<Code> codes = new ArrayList<Code>();
        for (int i = 1; i <= num; i++) {
            code = new Code();
            String codeNum = String.valueOf(year) + String.valueOf(month) + String.valueOf(local) + "00"
                    + creatCodeSeq(lastCodeSeq + i);
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
            return 0;
        }
        String lastCodeMonth = String.valueOf(lastCode.getCodeNum().charAt(1));
        String lastCodeYear = String.valueOf(lastCode.getCodeNum().charAt(0));
        if (month.equals(Integer.parseInt(lastCodeMonth)) && year.equals(Integer.parseInt(lastCodeYear))) {
            Integer num = Integer.parseInt(lastCode.getCodeNum().substring(5));
            return num;
        } else {
            return 0;
        }
    }
    
    private String creatCodeSeq(Integer lastCodeSeq){
        String s = String.valueOf(lastCodeSeq);
        String zeroNum = "";
        for(int i = 0; i < 6-s.length(); i++){
            zeroNum += "0";
        }
        return zeroNum + s;
    }

    @Override
    public void createfile() {
        File dir = new File(env.getCodeFilePath());
        Date date = new Date();
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(dir, TimeUtils.dateToStr(date));
        if(file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter write = new BufferedWriter(osw);
            List<Code> codes = repository.findByCreDt(TimeUtils.getStartTimeOfDay(date), TimeUtils.getEndTimeOfDay(date));
            Iterator<Code> it = codes.iterator();
            while(it.hasNext()){
                write.write(it.next().getCodeNum());
                write.newLine();
            }
            write.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<String> allWorks() {
        return repository.allWorks();
    }

    @Override
    public void destroyCode(String person) {
        List<Code> codes = repository.findByPerson(person);
        Iterator<Code> it = codes.iterator();
        while(it.hasNext()){
        }
    }
}
