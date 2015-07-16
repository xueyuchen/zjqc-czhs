package co.bohc.diet.app.admin.api.accessory;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.model.Accessory;
import co.bohc.diet.domain.service.accessory.AccessoryService;

@Controller
@RequestMapping(value = "accessories")
public class AccessoryController {

    @Inject
    private AccessoryService accessoryService;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Accessory> findAccessory(String modelName, String styleName, String partName){
        if(modelName == null && styleName == null && partName == null){
            return accessoryService.findByCreDt();
        }else{
            try {
                partName = new String(partName.getBytes("ISO8859-1"), "UTF-8");
                modelName = new String(modelName.getBytes("ISO8859-1"), "UTF-8");
                styleName = new String(styleName.getBytes("ISO8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return accessoryService.findByModelStylePart(modelName, styleName, partName);
        }
    }
}
