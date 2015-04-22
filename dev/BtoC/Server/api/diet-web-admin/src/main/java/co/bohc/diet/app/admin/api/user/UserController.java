package co.bohc.diet.app.admin.api.user;

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
}
