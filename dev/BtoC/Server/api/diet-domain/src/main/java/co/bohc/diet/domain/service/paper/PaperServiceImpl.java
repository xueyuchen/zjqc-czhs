package co.bohc.diet.domain.service.paper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.common.Environment;
import co.bohc.diet.domain.common.enums.LocalEnums;
import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.model.Paper;
import co.bohc.diet.domain.repository.code.CodeRepository;
import co.bohc.diet.domain.repository.paper.PaperRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;

@Service
@Transactional(readOnly = true)
public class PaperServiceImpl extends CrudServiceImpl<Paper, Integer, PaperRepository> implements PaperService {

    private static final String HASNOCODE = "无效条码！";
    private static final String HASDELETE = "条码已被删除！";

    @Inject
    private Environment env;

    @Inject
    public void setRepository(PaperRepository repository) {
        super.setRepository(repository);
    }

    @Inject
    private CodeRepository codeRepository;

    @Override
    public Integer countNum() {
        Date date = new Date();
        Integer count = repository.countNum(TimeUtils.getStartTimeOfMonth(date), TimeUtils.getEndTimeOfMonth(date));
        return count;
    }

    @Override
    public Date createpaper(Integer printSize) {
        Date date = new Date();
        String s = repository
                .findLastOneByMonth(TimeUtils.getStartTimeOfMonth(date), TimeUtils.getEndTimeOfMonth(date));
        Integer beginCodeNum = 1;
        if (s != null) {
            beginCodeNum = Integer.valueOf(s.substring(3)) + 1;
        }
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        Integer month = cal.get(Calendar.MONTH) + 1;
        String monthStr = null;
        if (month <= 10) {
            monthStr = "0" + String.valueOf(month);
        }
        Paper paper = null;
        for (int i = beginCodeNum; i <= beginCodeNum + printSize - 1; i++) {
            paper = new Paper();
            paper.setCreDt(date);
            paper.setPaperCode(String.valueOf(year % 10) + monthStr + printSizeStr(i));
            paper.setPrintSize(printSize);
            paper.setPrintNum(printSize);
            repository.save(paper);
        }
        return date;
    }

    private String printSizeStr(Integer printSize) {
        String printSizeStr = String.valueOf(printSize);
        switch (printSizeStr.length()) {
        case 1:
            printSizeStr = "000" + printSizeStr;
            break;
        case 2:
            printSizeStr = "00" + printSizeStr;
            break;
        case 3:
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
    public Map<String, Object> enterInfos(String paperCode, String reportCode, String carLicensePlate,
            String codeArray, Boolean isSave) {
        Boolean isCodeRight = true;
        Integer codeTotal = null;
        Paper paper = repository.findOneByPaperCode(paperCode);
        List<String> errors = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        if (paper == null) {
            errors.add("残值单号无效！");
            map.put("errors", errors);
            return map;
        }
        Date date = new Date();
        String[] codes = codeArray.split("\n");
        codeTotal = codes.length;
        List<Code> codesSave = new ArrayList<Code>();
        if (codes != null) {
            for (int i = 0; i < codes.length; i++) {
                Code code = codeRepository.findByCodeNum(codes[i]);
                if (!"000000000000".equals(codes[i])) {
                    if (code == null) {
                        errors.add(codes[i] + "：" + HASNOCODE);
                        isCodeRight = false;
                    } else if (code != null && code.getDelFlg() != null) {
                        errors.add(codes[i] + "：" + HASDELETE + "\n" + "条码归属：" + code.getLocal() + " "
                                + code.getWorker().getWorkerName());
                        isCodeRight = false;
                    } else if (code != null && code.getCheckDt() != null) {
                        errors.add(codes[i] + "：" + "该条码已于：" + TimeUtils.datetimeToStr(code.getCheckDt()) + "扫描通过！"
                                + "\n" + "条码归属：" + LocalEnums.getByName(code.getLocal()) + " "
                                + code.getWorker().getWorkerName());
                        isCodeRight = false;
                    } else {
                        errors.add(codes[i] + "：" + "该条码扫描通过！条码归属：" + LocalEnums.getByName(code.getLocal()) + " "
                                + code.getWorker().getWorkerName());
                        codesSave.add(code);
                    }
                } else {
                    errors.add(codes[i] + "：" + "该条码扫为通用条码！");
                }
            }
            if (isSave && isCodeRight) {
                Iterator<Code> it = codesSave.iterator();
                while (it.hasNext()) {
                    Code c = it.next();
                    c.setCheckDt(date);
                    c.setCodeKbn("CK");
                    c.setPaper(paper);
                }
                paper.setCarLicensePlate(carLicensePlate);
                paper.setReportCode(reportCode);
                paper.setEntryDt(date);
                paper.setPrintNum(codes.length);
            } else {
                map.put("errors", errors);
                return map;
            }
        }
        errors.add("录入完成！");
        map.put("errors", errors);
        map.put("codeTotal", codeTotal);
        return map;
    }

    @Override
    public List<PaperOutput> countPaper(Date fromDt, Date toDt) {
        List<Paper> papers = repository.findByEntryDt(fromDt, toDt);
        List<PaperOutput> outputs = new ArrayList<PaperOutput>();
        PaperOutput output = null;
        Iterator<Paper> it = papers.iterator();
        while (papers != null && it.hasNext()) {
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

    private Integer getSeason() {
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

    @Override
    public Map<String, Object> queryPaper(String option, String code) {
        Paper paper = repository.findOneByPaperCode(code);
        String message = null;
        Map<String, Object> map = new HashMap<String, Object>();
        if (paper == null) {
            message = "此残值单号无效！";
        } else if (paper != null && paper.getEntryDt() == null) {
            message = "此残值单号未被录入！";
        } else {
            try {
                BufferedImage buffImage = ImageIO.read(new File("c:/czhdb.jpg"));
                Graphics g = buffImage.getGraphics();
                Font font = new Font("黑体", Font.ITALIC, 20);
                g.setFont(font);
                g.setColor(Color.RED);
                g.drawString(paper.getPaperCode(), 606, 94);
                font = new Font("黑体", Font.ITALIC, 20);
                g.setFont(font);
                g.setColor(Color.BLACK);
                g.drawString(paper.getReportCode(), 206, 164);
                font = new Font("黑体", Font.ITALIC, 20);
                g.setFont(font);
                g.setColor(Color.BLACK);
                g.drawString(paper.getCarLicensePlate(), 206, 201);
                font = new Font("黑体", Font.ITALIC, 20);
                g.setFont(font);
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(paper.getPrintNum()), 206, 233);
                font = new Font("黑体", Font.ITALIC, 20);
                g.setFont(font);
                g.setColor(Color.BLACK);
                g.drawString(TimeUtils.dateToStr(paper.getEntryDt()), 206, 264);

                FileOutputStream outImg = new FileOutputStream(new File("c:/queryfile/" + paper.getCarLicensePlate()
                        + ".jpg"));
                ImageIO.write(buffImage, "jpg", outImg);
                outImg.flush();
                outImg.close();
                map.put("paperCode", paper.getPaperCode());
                map.put("carLicensePlate", paper.getCarLicensePlate());
            } catch (Exception e) {

            }
            message = "此残值单号已录入完成！";
        }
        map.put("message", message);
        return map;
    }

    @Override
    public String WCQueryPaper(String code) {
        Paper paper = repository.findOneByPaperCode(code);
        if (paper == null) {
            return "残值单号不存在！\n 感谢使用PICC残值查询服务！";
        } else if (paper != null && paper.getEntryDt() == null) {
            return "此残值单号未被录入！\n 感谢使用PICC残值查询服务！";
        } else {
            return "此残值单号已录入完成！\n 感谢使用PICC残值查询服务！";
        }
    }
}
