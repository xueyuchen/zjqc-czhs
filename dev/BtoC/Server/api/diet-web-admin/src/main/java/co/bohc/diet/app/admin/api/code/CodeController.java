package co.bohc.diet.app.admin.api.code;

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
import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.service.code.CodeService;
import co.bohc.diet.domain.service.worker.WorkerService;

@Controller
@RequestMapping("codes")
public class CodeController {

    @Inject
    private WorkerService workerService;

    @Inject
    private CodeService codeService;

    private static final String FILEPATH = "D:/codefile";

    @RequestMapping(value = "tocre", method = RequestMethod.GET)
    public String toCreCode(Model model) {
        model.addAttribute("workers", workerService.findWorkers());
        return "czcode/crecode";
    }

    @RequestMapping(value = "tocheck", method = RequestMethod.GET)
    public String toCheckcode() {
        return "czcode/checkcode";
    }

    @RequestMapping(value = "toenter", method = RequestMethod.GET)
    public String toEnterCode() {
        return "czcode/entercode";
    }

    @RequestMapping(value = "todestroy", method = RequestMethod.GET)
    public String toDestroyCode(Model model) {
        List<String> persons = codeService.allWorks();
        model.addAttribute("persons", persons);
        return "czcode/destroycode";
    }

    @RequestMapping(value = "destroycode", method = RequestMethod.POST)
    public String destroyCode(String person) {
        return null;
    }

    // @RequestMapping(value = "login", method = RequestMethod.GET)
    // public String toLogin() {
    // return "czcode/login";
    // }

    @RequestMapping(value = "checkcode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkCode(Code code, HttpServletResponse resp) {
        resp.addHeader("Content-Type", "application/json");
        Map<String, Object> map = codeService.checkCode(code.getCodeNum());
        return map;
    }

    @RequestMapping(value = "createcode", method = RequestMethod.POST)
    @ResponseBody
    public void creatCode(Integer num, String local, Integer workerId, HttpServletResponse response) {
        String workerName = codeService.createCode(num, local, workerId);
        codeService.createfile(workerName);
        downLoadFile(response, workerName);
    }

    @RequestMapping(value = "getworks", method = RequestMethod.GET)
    @ResponseBody
    public List<String> allWorks() {
        return codeService.allWorks();
    }

    private void downLoadFile(HttpServletResponse response, String workerName) {
        String fileName = "/" + workerName;
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
}
