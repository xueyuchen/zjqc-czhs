package co.bohc.diet.domain.service.accessory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sun.misc.BASE64Decoder;
import co.bohc.diet.domain.model.Accessory;
import co.bohc.diet.domain.model.Model;
import co.bohc.diet.domain.model.Part;
import co.bohc.diet.domain.model.Style;
import co.bohc.diet.domain.repository.accessory.AccessoryOutput;
import co.bohc.diet.domain.repository.accessory.AccessoryRepository;
import co.bohc.diet.domain.repository.accessory.AccessorySearchPar;
import co.bohc.diet.domain.repository.model.ModelRepository;
import co.bohc.diet.domain.repository.part.PartRepository;
import co.bohc.diet.domain.repository.style.StyleRepository;

@Service
@Transactional(readOnly = true)
public class AccessoryServiceImpl implements AccessoryService {

    @Inject
    private AccessoryRepository accessoryRepository;
    @Inject
    private ModelRepository modelRepository;
    @Inject
    private PartRepository partRepository;
    @Inject
    private StyleRepository styleRepository;

    @Override
    public List<Accessory> findByModelStylePart(String modelName, String styleName, String partName) {
        List<Accessory> accessories = accessoryRepository.findByModelStylePart(modelName, styleName, partName);
        for (int i = 0; i < accessories.size(); i++) {
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return accessories;
    }

    @Override
    public List<Accessory> findByCreDt() {
        List<Accessory> accessories = accessoryRepository.findByCreDt();
        for (int i = 0; i < accessories.size(); i++) {
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return accessories;
    }

    @Override
    public void saveAccessory(String level, Integer modelId, Integer styleId, Integer partId, String imgDataUrl) {
        String accessoryImg = generateImage(modelId, styleId, partId, imgDataUrl);
        Model model = modelRepository.findOne(modelId);
        Style style = styleRepository.findOne(styleId);
        Part part = partRepository.findOne(partId);
        String accessoryName = model.getBrand().getBrandName() + " " + model.getModelName() + " "
                + style.getStyleName() + " " + part.getPartName();
        Accessory accessory = new Accessory();
        accessory.setAccessoryImg(accessoryImg);
        accessory.setAccessoryName(accessoryName);
        accessory.setAccessoryNum(getImgName(modelId, styleId, partId));
        accessory.setCreDt(new Date());
        accessory.setModel(model);
        accessory.setPart(part);
        accessory.setStyle(style);
        accessory.setLevel(level);
        accessoryRepository.save(accessory);

    }

    public String generateImage(Integer modelId, Integer styleId, Integer partId, String imgDataUrl) { // 对字节数组字符串进行Base64解码并生成图片
        String modelIdStr = String.valueOf(modelId);
        String styleIdStr = String.valueOf(styleId);
        String partIdStr = String.valueOf(partId);
        if (imgDataUrl == null) // 图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        imgDataUrl = imgDataUrl.split(",")[1];
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgDataUrl);
            // for(int i=0;i<b.length;++i)
            // {
            // if(b[i]<0)
            // {//调整异常数据
            // b[i]+=256;
            // }
            // }
            // 生成jpeg图片
            String imgName = "image/img/" + modelIdStr + "/" + styleIdStr + "/" + partIdStr + "/"
                    + getImgName(modelId, styleId, partId) + ".jpg";
            File pageElementFileDir = new File("c://project//czxsxt//html//image//img//" + modelIdStr + "//"
                    + styleIdStr + "//" + partIdStr);
            if (!pageElementFileDir.exists()) {
                pageElementFileDir.mkdirs();
            }
            String imgFilePath = "c://project//czxsxt//html//image//img//" + modelIdStr + "//" + styleIdStr + "//"
                    + partIdStr + "//" + getImgName(modelId, styleId, partId) + ".jpg";// 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return imgName;
        } catch (Exception e) {
            return null;
        }
    }

    private String getImgName(Integer modelId, Integer styleId, Integer partId) {
        Integer count = accessoryRepository.findCountByMSP(modelId, styleId, partId);
        if (count == null) {
            count = 0;
        } else {
            count = count + 1;
        }
        String modelIdStr = String.valueOf(modelId);
        String styleIdStr = String.valueOf(styleId);
        String partIdStr = String.valueOf(partId);
        String countNumStr = String.valueOf(count);
        if (modelIdStr.length() == 1) {
            modelIdStr = "00" + modelIdStr;
        } else if(modelIdStr.length() == 2){
            modelIdStr = "0" + modelIdStr;
        }
        if (styleIdStr.length() == 1) {
            styleIdStr = "0" + styleIdStr;
//        } else if (styleIdStr.length() == 2) {
//            styleIdStr = "0" + styleIdStr;
        }
        if (partIdStr.length() == 1) {
            partIdStr = "00" + partIdStr;
        } else if (partIdStr.length() == 2) {
            partIdStr = "0" + partIdStr;
        }
        Integer zeroNum = 5 - countNumStr.length();
        for (int i = 0; i < zeroNum; i++) {
            countNumStr = "0" + countNumStr;
        }
        return modelIdStr + styleIdStr + partIdStr + countNumStr;
    }

    @Override
    public Page<Accessory> findByBrandId(Integer brandId, Pageable pageable) {
        List<Accessory> accessories = accessoryRepository.findByBrandId(brandId, pageable);
        Integer count = accessoryRepository.countByBrandId(brandId);
        Page<Accessory> page = new PageImpl<Accessory>(accessories, pageable, count);
        if (accessories == null) {
            return null;
        }
        for (int i = 0; i < accessories.size(); i++) {
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return page;
    }

    @Override
    public List<Accessory> findByParam(AccessorySearchPar accessorySearchPar) {
        return accessoryRepository.findByParam(accessorySearchPar);
    }
    
    @Override
    public List<Accessory> findByParamSale(AccessorySearchPar accessorySearchPar) {
        return accessoryRepository.findByParamSale(accessorySearchPar);
    }

    @Override
    public List<Accessory> findByBrandIdSale(Integer brandId) {
        List<Accessory> accessories = null;
        if(brandId == null){
            accessories = accessoryRepository.findByCreDtSale();
        }else{
            accessories = accessoryRepository.findByBrandIdAndSale(brandId);
        }
        if (accessories == null) {
            return null;
        }
        for (int i = 0; i < accessories.size(); i++) {
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return accessories;
    }
    
    @Override
    public List<Accessory> findByBrandIdAndSale(Integer brandId) {
        List<Accessory> accessories = accessoryRepository.findByBrandIdAndSale(brandId);
        if (accessories == null) {
            return null;
        }
        for (int i = 0; i < accessories.size(); i++) {
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return accessories;
    }

    @Override
    @Transactional
    public Accessory saveSaleMoney(Integer accessoryId, Double saleMoney) {
        Accessory accessory = accessoryRepository.findOne(accessoryId);
        if(accessory == null || accessory.getSaleDt() != null){
            return null;
        }
        accessory.setSaleDt(new Date());
        accessory.setSaleMoney(saleMoney);
        accessoryRepository.save(accessory);
        return accessory;
    }
}
