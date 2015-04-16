package co.bohc.diet.app.admin.api.code;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.common.Environment;
import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.service.code.CodeService;

@Controller
@RequestMapping("code")
public class CodeController {

    @Inject
    private CodeService codeService;
    
    private static final String FILEPATH = "D:/codefile";

    @RequestMapping(value = "tocre", method = RequestMethod.GET)
    public String toCreCode() {
        return "czcode/crecode";
    }

    @RequestMapping(value = "tocheckcode", method = RequestMethod.GET)
    public String tocheckcode() {
        return "czcode/check";
    }

    @RequestMapping(value = "enter", method = RequestMethod.GET)
    public String tohome() {
        return "czcode/entercode";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin() {
        return "czcode/login";
    }

    @RequestMapping(value = "checkcode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkCode(Code code, HttpServletResponse resp) {
        resp.addHeader("Content-Type", "application/json");
        Map<String, Object> map = codeService.checkCode(code.getCodeNum());
        return map;
    }

    @RequestMapping(value = "createcode", method = RequestMethod.POST)
    @ResponseBody
    public List<Code> creatCode(Integer num, String local, String person) {
        return codeService.createCode(num, local, person);
    }

    @RequestMapping(value = "createfile", method = RequestMethod.GET)
    @ResponseBody
    public boolean creatCodeFile() {
        codeService.createfile();
        return true;
    }

    @RequestMapping(value = "downfile", method = RequestMethod.GET)
    public void downLoadFile(HttpServletResponse response) {
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
}
