package co.bohc.diet.app.admin.api.modelstyle;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.model.ModelStyle;
import co.bohc.diet.domain.service.modelstyle.ModelStyleService;

@Controller
@RequestMapping(value = "modelStyles")
public class ModelStyleCollection {

    @Inject
    private ModelStyleService modelStyleService;
    
    @RequestMapping(value = "{modelId}", method=RequestMethod.GET)
    @ResponseBody
    public List<ModelStyle> findAllModelStyle(@PathVariable Integer modelId){
        return modelStyleService.findAll(modelId);
    }
}
