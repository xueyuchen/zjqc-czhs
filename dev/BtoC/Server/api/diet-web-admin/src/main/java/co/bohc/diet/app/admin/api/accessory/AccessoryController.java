package co.bohc.diet.app.admin.api.accessory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import sun.misc.BASE64Encoder;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import co.bohc.diet.domain.model.Accessory;
import co.bohc.diet.domain.repository.accessory.AccessoryOutput;
import co.bohc.diet.domain.repository.accessory.AccessorySearchPar;
import co.bohc.diet.domain.service.accessory.AccessoryService;
import co.bohc.diet.domain.service.accessory.LuceneOutput;
import co.bohc.diet.domain.service.accessory.LucenePage;

@Controller
@RequestMapping(value = "accessories")
public class AccessoryController {

    @Inject
    private AccessoryService accessoryService;

//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public Page<Accessory> findAccessory(@RequestParam(required = false) Integer brandId,
//            @RequestParam(required = false) Integer modelId, @RequestParam(required = false) Integer styleId,
//            @RequestParam(required = false) Integer partId, Pageable pageable) {
//        AccessorySearchPar accessorySearchPar = new AccessorySearchPar(modelId, styleId, partId);
//        return accessoryService.findByParam(accessorySearchPar, pageable);
//    }

//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseBody
//    public String saveAccessory(String level, Integer modelId, String imgDataUrl, Integer styleId, Integer partId,
//            HttpServletRequest req) {
//        String header = req.getHeader("X-APP-KEY");
//        if (!"you have logined".equals(header)) {
//            try {
//                throw new Exception();
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        System.out.println(imgDataUrl);
//        accessoryService.saveAccessory(level, modelId, styleId, partId, imgDataUrl);
//        return null;
//    }

//    @RequestMapping(value = "{brandId}", method = RequestMethod.GET)
//    @ResponseBody
//    public Page<Accessory> findByBrandId(@PathVariable Integer brandId, Pageable pageable) {
//        return accessoryService.findByBrandId(brandId, pageable);
//    }

//    @RequestMapping(value = "sale/{brandId}", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Accessory> findByBrandIdSale(@PathVariable Integer brandId) {
//        return accessoryService.findByBrandIdAndSale(brandId);
//    }

//    @RequestMapping(value = "sale", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Accessory> findBySale(@RequestParam(required = false) Integer brandId,
//            @RequestParam(required = false) Integer modelId, @RequestParam(required = false) Integer styleId,
//            @RequestParam(required = false) Integer partId) {
//        if (modelId == null && styleId == null && partId == null) {
//            return accessoryService.findByBrandIdSale(brandId);
//        } else {
//            AccessorySearchPar accessorySearchPar = new AccessorySearchPar(modelId, styleId, partId);
//            return accessoryService.findByParamSale(accessorySearchPar);
//        }
//    }

    @RequestMapping(value = "sale", method = RequestMethod.POST)
    @ResponseBody
    public String saveSaleMoney(Integer accessoryId, Double saleMoney) {
        Accessory accessory = accessoryService.saveSaleMoney(accessoryId, saleMoney);
        return "success";
    }

//    @RequestMapping(value = "search", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Accessory> searchByName(String brandName, String modelName, String styleName, String partName) {
//        try {
//            brandName = new String(brandName.getBytes("ISO8859-1"), "UTF-8").trim();
//            modelName = new String(modelName.getBytes("ISO8859-1"), "UTF-8").trim();
//            styleName = new String(styleName.getBytes("ISO8859-1"), "UTF-8").trim();
//            partName = new String(partName.getBytes("ISO8859-1"), "UTF-8").trim();
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return accessoryService.findByModelStylePart(modelName, styleName, partName);
//    }

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

    @RequestMapping(value = "upload")
    public String toUpload(){
        return "admin/upload";
    }
    
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public void imgsUpload(HttpServletRequest req, HttpServletResponse resp) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
        String fileName = req.getParameter("name");
        String chunk = req.getParameter("chunk");
        File newFile = new File("C:\\fileUpload\\" + fileName);
        if(!newFile.exists()){
            try {
                newFile.createNewFile();
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
        }
        MultipartFile mf = multipartRequest.getFile("file");
        System.out.println(mf.getOriginalFilename());
        InputStream is = null;
        try {
            is = mf.getInputStream();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        OutputStream os = null;
        if("0".equals(chunk)){
            try {
                os = new FileOutputStream(newFile);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }else{
            try {
                os = new FileOutputStream(newFile, true);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
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
                os.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    @RequestMapping(value = "adminLucene", method = RequestMethod.GET)
    @ResponseBody
    public List<LuceneOutput> search(String key) {
        return accessoryService.searchByLuceneDate(key);
    }
    
    @RequestMapping(value = "copy", method = RequestMethod.GET)
    @ResponseBody
    public void copyPicture(){
        System.out.println("begin task");
        accessoryService.savePicture();
        System.out.println("end task");
    }
    
    @RequestMapping(value = "date", method = RequestMethod.GET)
    @ResponseBody
    public List<Accessory> findByDate(String key){
        return accessoryService.findByDate(key);
        
    }
    
    @RequestMapping(value = "copytoa", method = RequestMethod.GET)
    @ResponseBody
    public void savePhotoToA(){
        accessoryService.savePictureToA();
        
    }
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Accessory findByNum(@PathVariable String accessoryNum){
        return accessoryService.findByNum(accessoryNum);
    }
    
    @RequestMapping(value = "{accessoryNum}")
    public String changeAccessory(@PathVariable String accessoryNum, ModelAndView model){
        Accessory accessory = accessoryService.findByNum(accessoryNum);
        model.addObject("accessory", accessory);
        return "admin/detail";
    }
}
