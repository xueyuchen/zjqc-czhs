package co.bohc.diet.domain.service.code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.model.Worker;
import co.bohc.diet.domain.repository.code.CodeRepository;
import co.bohc.diet.domain.repository.worker.WorkerRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;
import co.bohc.diet.domain.service.worker.WorkerOutput;

@Service
@Transactional(readOnly = true)
public class CodeServiceImpl extends CrudServiceImpl<Code, Integer, CodeRepository> implements CodeService {

    @Inject
    public void setRepository(CodeRepository repository) {
        super.setRepository(repository);
    }

    @Inject
    private WorkerRepository workerRepository;

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
            String message = "此残值编码不存在！";
            map.put("message", message);
            return map;
        }
        if (code.getDelFlg() != null && code.getDelFlg().equals(String.valueOf(1))) {
            String message = "此残值编码已被销毁！";
            map.put("codeNum", code.getCheckNum());
            map.put("message", message);
            map.put("creDt", TimeUtils.datetimeToStr(code.getCreDt()));
            map.put("local", code.getLocal());
            map.put("workerName", code.getWorker().getWorkerName());
            return map;
        }
        if (code.getCheckDt() != null) {
            String message = "此残值编码已于：" + TimeUtils.datetimeToStr(code.getCheckDt()) + "录入过！";
            map.put("codeNum", code.getCheckNum());
            map.put("message", message);
            map.put("creDt", TimeUtils.datetimeToStr(code.getCreDt()));
            map.put("local", code.getLocal());
            map.put("workerName", code.getWorker().getWorkerName());
            return map;
        } else {
            String message = "此残值编码未被使用！";
            map.put("codeNum", code.getCheckNum());
            map.put("message", message);
            map.put("creDt", TimeUtils.datetimeToStr(code.getCreDt()));
            map.put("local", code.getLocal());
            map.put("workerName", code.getWorker().getWorkerName());
            return map;
        }
    }

    /**
     * 批量生成code
     */
    @Transactional
    public WorkerOutput createCode(Integer num, Integer workerId) {
        Calendar cal = Calendar.getInstance();
        Integer month = cal.get(Calendar.MONTH) + 1;
        Integer year = cal.get(Calendar.YEAR) % 10;
        Date date = cal.getTime();
        Integer lastCodeSeq = codeIndex(month, year, workerId);
        String monthStr = null;
        String workerIdStr = null;
        String localStr = null;
        Worker codeWorker = workerRepository.findByWorkerName(workerId);
        if (String.valueOf(month).length() == 1) {
            monthStr = "0" + String.valueOf(month);
        }
        if (codeWorker.getLocal().length() == 1) {
            localStr = "0" + codeWorker.getLocal();
        }
        switch (String.valueOf(workerId).length()) {
        case 1:
            workerIdStr = "00" + String.valueOf(workerId);
            break;
        case 2:
            workerIdStr = "0" + String.valueOf(workerId);
            break;
        case 3:
            workerIdStr = String.valueOf(workerId);
            break;
        }
        Code code = null;
        Worker worker = null;
        for (int i = 1; i <= num; i++) {
            code = new Code();
            worker = new Worker();
            String codeNum = String.valueOf(year) + monthStr + localStr + workerIdStr + creatCodeSeq(lastCodeSeq + i);
            code.setLocal(codeWorker.getLocal());
            code.setCreDt(date);
            code.setCodeNum(codeNum);
            worker.setWorkerId(workerId);
            code.setWorker(worker);
            repository.save(code);
        }
        WorkerOutput output = new WorkerOutput();
        output.setWorkerId(codeWorker.getWorkerId());
        output.setWorkerName(codeWorker.getWorkerName());
        return output;
    }

    private Integer codeIndex(Integer month, Integer year, Integer workerId) {
        Code lastCode = repository.findLastCodeNum(workerId);
        if (lastCode == null) {
            return 0;
        }
        /**
         * 检测当前月之前是否有生成过编码
         */
        Calendar cal = Calendar.getInstance();
        cal.setTime(lastCode.getCreDt());
        if (month.equals(cal.get(Calendar.MONTH) + 1) && year.equals(cal.get(Calendar.YEAR) % 10)) {
            Integer num = Integer.parseInt(lastCode.getCodeNum().substring(8));
            return num;
        } else {
            return 0;
        }
    }

    private String creatCodeSeq(Integer lastCodeSeq) {
        String s = String.valueOf(lastCodeSeq);
        String zeroNum = "";
        for (int i = 0; i < 4 - s.length(); i++) {
            zeroNum += "0";
        }
        return zeroNum + s;
    }

    @Override
    public void createfile(WorkerOutput worker) {
        File dir = new File(env.getCodeFilePath());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, worker.getWorkerName());
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date date = new Date();
        Date fromDt = TimeUtils.getStartTimeOfDay(date);
        Date toDt = TimeUtils.getEndTimeOfDay(date);
        List<Code> codes = repository.findByWorkerIdAndCreDt(worker.getWorkerId(), fromDt, toDt);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter write = new BufferedWriter(osw);
            Iterator<Code> it = codes.iterator();
            while (it.hasNext()) {
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
    @Transactional
    public void destroyCode(Integer workerId) {
        List<Code> codes = repository.findByWorkerId(workerId);
        Iterator<Code> it = codes.iterator();
        Code code = null;
        while (it.hasNext()) {
            code = it.next();
            code.setDelFlg("1");
            update(code);
        }
    }

}
