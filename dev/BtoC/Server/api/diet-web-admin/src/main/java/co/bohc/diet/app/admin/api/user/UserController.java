package co.bohc.diet.app.admin.api.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "users")
public class UserController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "userindex/login";
    }
    
    @RequestMapping(value = "lgi", method = RequestMethod.POST)
    public String checklogin(HttpServletResponse resp, HttpServletRequest req){
        req.getSession().setAttribute("_", "1234");
        return "czpaper/papertotal";
    }
}
