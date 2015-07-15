package co.bohc.diet.app.admin.api.model;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.model.Model;
import co.bohc.diet.domain.service.model.ModelService;

@Controller
@RequestMapping(value = "models")
public class ModelController {

    @Inject
    private ModelService modelService;
    
    @RequestMapping(value = "{brandId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Model> listModel(@PathVariable Integer brandId){
        return modelService.findByBrandId(brandId);
    }
}
