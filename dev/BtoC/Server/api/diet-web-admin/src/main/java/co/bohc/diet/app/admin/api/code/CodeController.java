package co.bohc.diet.app.admin.api.code;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.model.Worker;
import co.bohc.diet.domain.service.code.CodeService;
import co.bohc.diet.domain.service.worker.WorkerOutput;
import co.bohc.diet.domain.service.worker.WorkerService;

@Controller
@RequestMapping("codes")
public class CodeController {

    @Inject
    private WorkerService workerService;

    @Inject
    private CodeService codeService;

    private static final String FILEPATH = "c:/codefile";

    @RequestMapping(value = "tocre", method = RequestMethod.GET)
    @RolesAllowed(value = { "ROLE_SU", "ROLE_KE" })
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
        List<Worker> workers = workerService.findWorkers();
        model.addAttribute("workers", workers);
        return "czcode/destroycode";
    }

    @RequestMapping(value = "destroycode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> destroyCode(Integer workerId) {
        codeService.destroyCode(workerId);
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", "编码销毁成功！");
        return map;
    }

    // @RequestMapping(value = "login", method = RequestMethod.GET)
    // public String toLogin() {
    // return "czcode/login";
    // }

    @RequestMapping(value = "checkcode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkCode(String codeNum) {
        Map<String, Object> map = codeService.checkCode(codeNum);
        return map;
    }

    @RequestMapping(value = "createcode", method = RequestMethod.POST)
    public void creatCode(Integer num, Integer workerId, HttpServletResponse response) {
        WorkerOutput worker = codeService.createCode(num, workerId);
        codeService.createfile(worker);
        String fileName = "/" + worker.getWorkerName();
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

    @RequestMapping(value = "getworks", method = RequestMethod.GET)
    @ResponseBody
    public List<String> allWorks() {
        return codeService.allWorks();
    }

}
