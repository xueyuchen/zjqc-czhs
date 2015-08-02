package co.bohc.diet.app.admin.api.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.service.admin.AdminService;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @Inject
    private AdminService adminService;

    @RequestMapping(value = "logina", method = RequestMethod.POST)
    public String login(String username, String password, HttpServletResponse resp, HttpServletRequest req) {
        Integer rol = adminService.checkUserName(username, password);
        if (rol == -1) {
            return "admin/login";
        } else if (rol == 1) {
            try {
                resp.sendRedirect("upload");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            return "admin/upload";
        }
        return password;
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String toAdmin() {
        return "admin/upload";
    }
    
    @RequestMapping(value = "uploadtoB", method = RequestMethod.GET)
    public String toUploadToB(){
        return "admin/uploadToB";
    }

    @RequestMapping(value = "tologin", method = RequestMethod.GET)
    public String tologin() {
        return "admin/login";
    }
    
    @RequestMapping(value = "changes", method = RequestMethod.GET)
    public String toChange() {
        return "admin/change";
    }
    
    @RequestMapping(value = "changesB", method = RequestMethod.GET)
    public String toChangeB() {
        return "admin/changeB";
    }
}
