package co.bohc.diet.app.admin.api.code;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.service.code.CodeService;

@Controller
@RequestMapping("code")
public class CodeController {

    @Inject
    private CodeService codeService;

    @RequestMapping(value = "tocre", method = RequestMethod.GET)
    public String toCreCode() {
        return "czcode/crecode";
    }

    @RequestMapping(value = "tocheckcode", method = RequestMethod.GET)
    public String tocheckcode() {
        return "czcode/check";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String tohome(){
        return "czcode/home";
    }
    
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin(){
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
    public List<Code> creatCode(Integer num, String local){
        return codeService.createCode(num, local);
    }
}
