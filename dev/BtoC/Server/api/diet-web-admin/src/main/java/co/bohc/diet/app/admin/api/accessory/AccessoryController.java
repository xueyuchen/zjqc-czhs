package co.bohc.diet.app.admin.api.accessory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.model.Accessory;
import co.bohc.diet.domain.repository.accessory.AccessorySearchPar;
import co.bohc.diet.domain.service.accessory.AccessoryService;
import co.bohc.diet.domain.service.accessory.LucenePage;

@Controller
@RequestMapping(value = "accessories")
public class AccessoryController {

    @Inject
    private AccessoryService accessoryService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<Accessory> findAccessory(@RequestParam(required = false) Integer brandId,
            @RequestParam(required = false) Integer modelId, @RequestParam(required = false) Integer styleId,
            @RequestParam(required = false) Integer partId, Pageable pageable) {
        AccessorySearchPar accessorySearchPar = new AccessorySearchPar(modelId, styleId, partId);
        return accessoryService.findByParam(accessorySearchPar, pageable);
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
    public Page<Accessory> findByBrandId(@PathVariable Integer brandId, Pageable pageable) {
        return accessoryService.findByBrandId(brandId, pageable);
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
        if (modelId == null && styleId == null && partId == null) {
            return accessoryService.findByBrandIdSale(brandId);
        } else {
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
    public List<Accessory> searchByName(String brandName, String modelName, String styleName, String partName) {
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

    @RequestMapping(value = "lucene", method = RequestMethod.GET)
    @ResponseBody
    public LucenePage search(String key, Integer page, Integer size) {
        try {
            key = new String(key.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return accessoryService.SearchByLucene(key, page);
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public void imgsUpload(HttpServletRequest req, HttpServletResponse resp) {
        String fileName = "123.jpg";
        System.out.println(fileName);
        InputStream is = null;
        OutputStream os = null;
        try {
            os = new FileOutputStream("C:\\fileUpload\\" + fileName);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            is = req.getInputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int byteread = 0;
        int bytesum = 0;
        if (is != null) {
            byte[] buffer = new byte[1024 * 10];
            try {
                while ((byteread = is.read(buffer)) != -1) {
                    bytesum += byteread; // 字节数 文件大小
                    System.out.println(bytesum);
                    os.write(buffer, 0, byteread);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
