package co.bohc.diet.app.admin.api.user;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.model.Paper;
import co.bohc.diet.domain.repository.paper.PaperRepository;
import co.bohc.diet.domain.service.admin.AdminService;
import co.bohc.diet.domain.service.code.CodeService;
import co.bohc.diet.domain.service.paper.PaperService;

@Controller
@RequestMapping(value = "users")
public class UserController {

    private static final String FILEPATH = "c:/queryfile";

    @Inject
    private AdminService adminService;

    @Inject
    private PaperService paperService;
    
    @Inject
    private CodeService codeService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "userindex/login";
    }

    @RequestMapping(value = "lgi", method = RequestMethod.POST)
    public String checklogin(HttpServletResponse resp, HttpServletRequest req, String userName, String password) {
        if (adminService.checkUserName(userName, password)) {
            req.getSession().setAttribute("_", "czhs");
            req.getSession().setMaxInactiveInterval(9000);
            try {
                resp.sendRedirect("../papers/toenter");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            resp.sendRedirect("login");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "lgiphone", method = RequestMethod.POST)
    public String checkloginPhone(HttpServletResponse resp, HttpServletRequest req, String userName, String password) {
        if (adminService.checkUserName(userName, password)) {
            req.getSession().setAttribute("_", "czhs");
            req.getSession().setMaxInactiveInterval(9000);
            return "success";
        }
        return null;
    }

    @RequestMapping(value = "querypaper", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryPaper(String option, String code) {
        if ("czdh".equals(option)) {
            Map<String, Object> map = paperService.queryPaper(option, code);
            return map;
        } else if ("czbm".equals(option)) {
            return codeService.checkCode(code);
        }
        return null;
    }

    @RequestMapping(value = "downjpg", method = RequestMethod.POST)
    public void downJpg(String carLicensePlate, String paperCode, HttpServletResponse response) {
        if (carLicensePlate == null || "".equals(carLicensePlate)) {
            try {
                response.sendRedirect("../");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String fileName = "/" + carLicensePlate + ".jpg";
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
