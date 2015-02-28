package co.bohc.diet.app.admin.api.code;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.bohc.diet.domain.model.Code;
import co.bohc.diet.domain.service.code.CodeService;

@Controller
@RequestMapping("code")
public class CodeController {
    
    @Inject
    private CodeService codeService;

    @RequestMapping(value = "tocre", method = RequestMethod.GET)
    public String toCreCode(){
        return "czcode/crecode";
    }
    
    @RequestMapping(value = "checkcode", method = RequestMethod.GET)
    public String getCode(Code code, ModelAndView model){
        Map<String, Object> map = codeService.checkCode(code.getCodeNum());
        model.addObject("map", map);
        return "czcode/onecode";
    }
}
