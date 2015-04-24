package co.bohc.diet.domain.service.paper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.common.Environment;
import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.model.Paper;
import co.bohc.diet.domain.repository.code.CodeRepository;
import co.bohc.diet.domain.repository.paper.PaperRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;
import co.bohc.diet.domain.service.code.CodeService;

@Service
@Transactional(readOnly = true)
public class PaperServiceImpl extends CrudServiceImpl<Paper, Integer, PaperRepository> implements PaperService {

    private static final String HASNOCODE = "无效条码！";
    private static final String HASDELETE = "条码已被删除！";

    @Inject
    private Environment env;

    @Inject
    private CodeService codeService;

    @Inject
    public void setRepository(PaperRepository repository) {
        super.setRepository(repository);
    }

    @Inject
    private CodeRepository codeRepository;

    @Override
    public Integer countNum() {
        Integer printNum = repository.countNum();
        return printNum;
    }

    @Override
    public void createpaper(Integer printSize) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        Integer season = getSeason();
        Paper paper = null;
        for (int i = 1; i <= printSize; i++) {
            for (int j = 1; j <= 100; j++) {
                paper = new Paper();
                paper.setCreDt(new Date());
                paper.setPaperCode(String.valueOf(year%10) + String.valueOf(season) + printSizeStr(i) + printNumStr(j));
                paper.setPrintNum(season);
                paper.setPrintSize(printSize);
                repository.save(paper);
            }
        }
    }

    private String printNumStr(Integer printNum) {
        String printNumStr = String.valueOf(printNum);
        if (printNumStr.length() == 1) {
            printNumStr = "0" + printNumStr;
        }
        return printNumStr;
    }

    private String printSizeStr(Integer printSize) {
        String printSizeStr = String.valueOf(printSize);
        switch (printSizeStr.length()) {
        case 1:
            printSizeStr = "00" + printSizeStr;
            break;
        case 2:
            printSizeStr = "0" + printSizeStr;
            break;
        }
        return printSizeStr;
    }

    @Override
    public void createfile() {
        File dir = new File(env.getPaperFilePath());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, TimeUtils.dateToStr(new Date()));
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
        List<Paper> papers = repository.findAllByDate(fromDt, toDt);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter write = new BufferedWriter(osw);
            Iterator<Paper> it = papers.iterator();
            while (it.hasNext()) {
                write.write(it.next().getPaperCode());
                write.newLine();
            }
            write.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public List<String> enterInfos(String paperCode, String reportCode, String carLicensePlate, String codeArray) {
        Paper paper = repository.findOneByPaperCode(paperCode);
        List<String> errors = new ArrayList<String>();
        if (paper == null) {
            errors.add("残值单号无效！");
            return errors;
        }
        Date date = new Date();
        String[] codes = codeArray.split("\n");
        List<Code> codesSave = new ArrayList<Code>();
        if (codes != null) {
            for (int i = 0; i < codes.length; i++) {
                Code code = codeRepository.findByCodeNum(codes[i]);
                if (code == null) {
                    errors.add(codes[i] + "：" + HASNOCODE);
                } else if (code != null && code.getDelFlg() != null) {
                    errors.add(codes[i] + "：" + HASDELETE + "\n" + "条码归属：" + code.getLocal() + " "
                            + code.getWorker().getWorkerName());
                } else if (code != null && code.getCheckDt() != null) {
                    errors.add(codes[i] + "：" + "该条码已于：" + TimeUtils.datetimeToStr(code.getCheckDt()) + "扫描通过！" + "\n"
                            + "条码归属：" + code.getLocal() + " " + code.getWorker().getWorkerName());
                } else {
                    codesSave.add(code);
                }
            }
            if (errors.size() == 0) {
                Iterator<Code> it = codesSave.iterator();
                while(it.hasNext()){
                    Code c = it.next();
                    c.setCheckDt(date);
                    c.setCodeKbn("CK");
                    c.setPaper(paper);
                }
                paper.setCarLicensePlate(carLicensePlate);
                paper.setReportCode(reportCode);
                paper.setEntryDt(date);
            } else {
                return errors;
            }
        }
        errors.add("录入完成！");
        return errors;
    }

    @Override
    public List<PaperOutput> countPaper(Date fromDt, Date toDt) {
        List<Paper> papers = repository.findByEntryDt(fromDt, toDt);
        List<PaperOutput> outputs = new ArrayList<PaperOutput>();
        PaperOutput output = null;
        Iterator<Paper> it = papers.iterator();
        while(papers != null && it.hasNext()){
            output = new PaperOutput();
            Paper paper = it.next();
            output.setCarLicensePlate(paper.getCarLicensePlate());
            output.setEntryDt(paper.getEntryDt());
            output.setPaperCode(paper.getPaperCode());
            output.setReportCode(paper.getReportCode());
            output.setCountCode(paper.getCodes().size());
            outputs.add(output);
        }
        return outputs;
    }
    
    private Integer getSeason(){
        int season = 0;  
        
        Calendar c = Calendar.getInstance();  
        c.setTime(new Date());  
        int month = c.get(Calendar.MONTH);  
        switch (month) {  
        case Calendar.JANUARY:  
        case Calendar.FEBRUARY:  
        case Calendar.MARCH:  
            season = 1;  
            break;  
        case Calendar.APRIL:  
        case Calendar.MAY:  
        case Calendar.JUNE:  
            season = 2;  
            break;  
        case Calendar.JULY:  
        case Calendar.AUGUST:  
        case Calendar.SEPTEMBER:  
            season = 3;  
            break;  
        case Calendar.OCTOBER:  
        case Calendar.NOVEMBER:  
        case Calendar.DECEMBER:  
            season = 4;  
            break;  
        default:  
            break;  
        }  
        return season;  
    }
}
