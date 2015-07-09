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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.repository.code.WorkerCriteria;
import co.bohc.diet.domain.service.code.PaperWorkerOutput;
import co.bohc.diet.domain.service.paper.PaperOutput;
import co.bohc.diet.domain.service.paper.PaperService;
import co.bohc.diet.domain.service.worker.WorkerService;

@Controller
@RequestMapping(value = "papers")
public class PaperController {

    private static final String FILEPATH = "c:/paperfile";

    @Inject
    private PaperService paperService;

    @Inject
    private WorkerService workerService;

    @RequestMapping(value = "toenter")
    public String toEnterCode(HttpServletRequest req) {
        String session = (String) req.getSession().getAttribute("_");
        if (session != null && session == "czhs") {
            return "czpaper/enterpaper";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "tocre", method = RequestMethod.GET)
    public String toCrePaper(Model model, HttpServletRequest req) {
        String session = (String) req.getSession().getAttribute("_");
        if (session != null && session == "czhs") {
            Integer countNum = paperService.countNum();
            if (countNum == null) {
                countNum = 0;
            }
            model.addAttribute("countNum", countNum);
            return "czpaper/crepaper";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "tototal", method = RequestMethod.GET)
    public String toPaperTatol() {
        return "czpaper/papertotal";
    }

    @RequestMapping(value = "tototaluser")
    public String toPaperTatolUser() {
        return "czpaper/papertotal_user";
    }

    @RequestMapping(value = "createpaper", method = RequestMethod.POST)
    public void createpaper(HttpServletResponse response, HttpServletRequest req, Integer printSize) {
        String session = (String) req.getSession().getAttribute("_");
        if (session != null && session == "czhs") {
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
                response.addHeader("Content-Disposition",
                        "attachment;filename="
                                + new String(filename.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
                response.addHeader("Content-Length", "" + file.length());
                OutputStream os = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                os.write(buffer);// 输出文件
                os.flush();
                os.close();
            } catch (IOException e) {

            }
        } else {
        }
    }

    @RequestMapping(value = "check", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkPaper(String paperCode, String reportCode, String carLicensePlate, String codeArray) {
        Map<String, Object> messages = paperService
                .enterInfos(paperCode, reportCode, carLicensePlate, codeArray, false);
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
    public Page<PaperOutput> countPaper(Date fromDt, Date toDt, Pageable pageable) {
        return paperService.countPaper(fromDt, toDt, pageable);

    }
}
