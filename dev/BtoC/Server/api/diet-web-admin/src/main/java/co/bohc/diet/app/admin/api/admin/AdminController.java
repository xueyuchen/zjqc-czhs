package co.bohc.diet.app.admin.api.admin;

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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String login(String username, String password, HttpServletResponse resp) {
        Integer rol = adminService.checkUserName(username, password);
        if (rol == -1) {
            return null;
        } else {
            Cookie cookie = new Cookie("czpjlr", "you have logined");
            resp.addCookie(cookie);
            return "success";
        }
    }
}
