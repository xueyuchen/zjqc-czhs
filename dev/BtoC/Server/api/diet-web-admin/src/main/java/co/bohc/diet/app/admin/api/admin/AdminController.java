package co.bohc.diet.app.admin.api.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
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

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(String username, String password, HttpServletResponse resp) {
        Integer rol = adminService.checkUserName(username, password);
        if (rol == -1) {
            try {
                resp.sendRedirect("login");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if(rol == 1){
            try {
                resp.sendRedirect("upload");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            try {
                resp.sendRedirect("upload");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String toAdmin(){
        return "admin/admin";
    }
    
    @RequestMapping(value = "tologin", method = RequestMethod.GET)
    public String tologin(){
        return "admin/login";
    }
}
