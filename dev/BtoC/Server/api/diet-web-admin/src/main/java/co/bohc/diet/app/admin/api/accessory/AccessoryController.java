package co.bohc.diet.app.admin.api.accessory;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.model.Accessory;
import co.bohc.diet.domain.repository.accessory.AccessoryOutput;
import co.bohc.diet.domain.repository.accessory.AccessorySearchPar;
import co.bohc.diet.domain.service.accessory.AccessoryService;

@Controller
@RequestMapping(value = "accessories")
public class AccessoryController {

    @Inject
    private AccessoryService accessoryService;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<AccessoryOutput> findAccessory(AccessorySearchPar accessorySearchPar){
//        AccessorySearchPar accessorySearchPar = new AccessorySearchPar(modelId, styleId, partId);
        accessorySearchPar.getModelId();
        return accessoryService.findByParam(accessorySearchPar);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String saveAccessory(String level, Integer modelId, String imgDataUrl, Integer styleId, Integer partId, HttpServletRequest req){
        String header = req.getHeader("X-APP-KEY");
        if(!"you have logined".equals(header)){
            return null;
        }
        System.out.println(imgDataUrl);
        accessoryService.saveAccessory(level, modelId, styleId, partId, imgDataUrl);
        return null;
    }
    
    @RequestMapping(value = "{brandId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Accessory> findByBrandId(@PathVariable Integer brandId){
        return accessoryService.findByBrandId(brandId);
    }
}
