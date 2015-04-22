package co.bohc.diet.domain.service.paper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.common.Environment;
import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.model.Paper;
import co.bohc.diet.domain.repository.paper.PaperRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;

@Service
@Transactional(readOnly = true)
public class PaperServiceImpl extends CrudServiceImpl<Paper, Integer, PaperRepository> implements PaperService {

    @Inject
    private Environment env;

    @Inject
    public void setRepository(PaperRepository repository) {
        super.setRepository(repository);
    }

    @Override
    public Integer countNum() {
        Integer printNum = repository.countNum();
        return printNum;
    }

    @Override
    public void createpaper(Integer printNum, Integer printSize) {
        String printNumStr = printNumStr(printNum);
        String printSizeStr = printSizeStr(printSize);
        Paper paper = null;
        for (int i = 1; i <= printSize; i++) {
            for (int j = 0; j < 100; j++) {
                paper = new Paper();
                paper.setCreDt(new Date());
                paper.setPaperCode(printNumStr + printSizeStr + printSizeStr(i) + printNumStr(j));
                paper.setPrintNum(printNum);
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

}
