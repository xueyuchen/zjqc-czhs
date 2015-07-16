package co.bohc.diet.app.admin.api.part;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.model.Part;
import co.bohc.diet.domain.service.part.PartService;

@Controller
@RequestMapping(value = "parts")
public class PartController {

    @Inject
    private PartService partService;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Part> findAll(){
        return partService.findAll();
    }
}
