package home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("codes")
public class CodeController {

    @RequestMapping(value = "tohome", method = RequestMethod.GET)
    public String tohome(){
        return "layout/template";
    }
}
