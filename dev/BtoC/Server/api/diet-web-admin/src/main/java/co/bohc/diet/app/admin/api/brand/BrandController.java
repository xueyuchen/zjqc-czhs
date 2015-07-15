package co.bohc.diet.app.admin.api.brand;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.model.Brand;
import co.bohc.diet.domain.service.brand.BrandService;

@Controller
@RequestMapping(value = "brands")
public class BrandController {

    @Inject
    private BrandService brandService;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Brand> listBrand(){
        return brandService.findAllBrand();
    }
}
