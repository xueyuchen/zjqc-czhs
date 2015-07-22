package co.bohc.diet.app.admin.api.accessory;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Accessory> findAccessory(@RequestParam(required = false) Integer brandId,
            @RequestParam(required = false) Integer modelId, @RequestParam(required = false) Integer styleId,
            @RequestParam(required = false) Integer partId) {
        AccessorySearchPar accessorySearchPar = new AccessorySearchPar(modelId, styleId, partId);
        return accessoryService.findByParam(accessorySearchPar);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String saveAccessory(String level, Integer modelId, String imgDataUrl, Integer styleId, Integer partId,
            HttpServletRequest req) {
        String header = req.getHeader("X-APP-KEY");
        if (!"you have logined".equals(header)) {
            try {
                throw new Exception();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(imgDataUrl);
        accessoryService.saveAccessory(level, modelId, styleId, partId, imgDataUrl);
        return null;
    }

    @RequestMapping(value = "{brandId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Accessory> findByBrandId(@PathVariable Integer brandId) {
        return accessoryService.findByBrandId(brandId);
    }
    @RequestMapping(value = "sale/{brandId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Accessory> findByBrandIdSale(@PathVariable Integer brandId) {
        return accessoryService.findByBrandIdAndSale(brandId);
    }
    @RequestMapping(value = "sale", method = RequestMethod.GET)
    @ResponseBody
    public List<Accessory> findBySale(@RequestParam(required = false) Integer brandId,
            @RequestParam(required = false) Integer modelId, @RequestParam(required = false) Integer styleId,
            @RequestParam(required = false) Integer partId) {
        if(modelId == null && styleId == null && partId == null){
            return accessoryService.findByBrandIdSale(brandId);
        }else{
            AccessorySearchPar accessorySearchPar = new AccessorySearchPar(modelId, styleId, partId);
            return accessoryService.findByParamSale(accessorySearchPar);
        }
    }
    
    @RequestMapping(value = "sale", method = RequestMethod.POST)
    @ResponseBody
    public String saveSaleMoney(Integer accessoryId, Double saleMoney) {
        Accessory accessory = accessoryService.saveSaleMoney(accessoryId, saleMoney);
        return "success";
    }
    
    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ResponseBody
    public List<Accessory> searchByName(String brandName, String modelName, String styleName, String partName){
        try {
            brandName = new String(brandName.getBytes("ISO8859-1"), "UTF-8").trim();
            modelName = new String(modelName.getBytes("ISO8859-1"), "UTF-8").trim();
            styleName = new String(styleName.getBytes("ISO8859-1"), "UTF-8").trim();
            partName = new String(partName.getBytes("ISO8859-1"), "UTF-8").trim();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return accessoryService.findByModelStylePart(modelName, styleName, partName);
    }
}
