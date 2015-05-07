package co.bohc.diet.app.admin.api.paper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.service.paper.PaperOutput;
import co.bohc.diet.domain.service.paper.PaperService;

@Controller
@RequestMapping(value = "papers")
public class PaperController {

    private static final String FILEPATH = "c:/paperfile";

    @Inject
    private PaperService paperService;

    @RequestMapping(value = "toenter", method = RequestMethod.GET)
    public String toEnterCode() {
        return "czpaper/enterpaper";
    }

    @RequestMapping(value = "tocre", method = RequestMethod.GET)
    public String toCrePaper(Model model) {
        Integer countNum = paperService.countNum();
        if (countNum == null) {
            countNum = 0;
        }
        model.addAttribute("countNum", countNum);
        return "czpaper/crepaper";
    }

    @RequestMapping(value = "tototal", method = RequestMethod.GET)
    public String toPaperTatol() {
        return "czpaper/papertotal";
    }

    @RequestMapping(value = "createpaper", method = RequestMethod.POST)
    public void createpaper(HttpServletResponse response, Integer printSize) {
        Date date = paperService.createpaper(printSize);
        paperService.createfile();
        String fileName = "/" + TimeUtils.dateToStr(new Date());
        try {
            File file = new File(FILEPATH + fileName);// path是根据日志路径和文件名拼接出来的
            String filename = file.getName();// 获取日志文件名称
            InputStream fis = new BufferedInputStream(new FileInputStream(FILEPATH + fileName));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
            response.addHeader("Content-Disposition", "attachment;filename="
                    + new String(filename.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            os.write(buffer);// 输出文件
            os.flush();
            os.close();
        } catch (IOException e) {

        }
    }

    @RequestMapping(value = "check", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkPaper(String paperCode, String reportCode, String carLicensePlate, String codeArray) {
        Map<String, Object> messages = paperService.enterInfos(paperCode, reportCode, carLicensePlate, codeArray, false);
        return messages;
    }
    
    @RequestMapping(value = "enter", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> enterPaper(String paperCode, String reportCode, String carLicensePlate, String codeArray) {
        Map<String, Object> messages = paperService.enterInfos(paperCode, reportCode, carLicensePlate, codeArray, true);
        return messages;
    }

    @RequestMapping(value = "StatisticsPaper", method = RequestMethod.GET)
    @ResponseBody
    public List<PaperOutput> countPaper(Date fromDt, Date toDt) {
        return paperService.countPaper(fromDt, toDt);

    }

}
