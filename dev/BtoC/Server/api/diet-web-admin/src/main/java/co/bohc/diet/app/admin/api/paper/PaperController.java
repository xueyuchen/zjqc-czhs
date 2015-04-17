package co.bohc.diet.app.admin.api.paper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "papers")
public class PaperController {
    
    @RequestMapping(value = "tocre", method = RequestMethod.GET)
    public String toCrePaper(){
        return "czpaper/crepaper";
    }
    
    @RequestMapping(value = "tototal", method = RequestMethod.GET)
    public String toPaperTatol(){
        return "czpaper/papertotal";
    }

}
