package co.bohc.diet.domain.service.accessory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.bohc.diet.domain.model.Accessory;
import co.bohc.diet.domain.repository.accessory.AccessoryOutput;
import co.bohc.diet.domain.repository.accessory.AccessorySearchPar;

public interface AccessoryService {

    public List<Accessory> findByModelStylePart(String modelName, String styleName, String partName);
    
    public List<Accessory> findByCreDt();
    
    public void saveAccessory(String level, Integer modelId, Integer styleId, Integer partId, String imgDataUrl);
    
    public Page<Accessory> findByBrandId(Integer brandId, Pageable pageable);
    
    public Page<Accessory> findByParam(AccessorySearchPar accessorySearchPar, Pageable pageable);
    
    public List<Accessory> findByParamSale(AccessorySearchPar accessorySearchPar);
    
    public List<Accessory> findByBrandIdSale(Integer brandId);

    public List<Accessory> findByBrandIdAndSale(Integer brandId);
    
    public Accessory saveSaleMoney(Integer accessoryId, Double saleMoney);
    
//    public LucenePage SearchByLucene(String key);
    
    public void savePicture();

    public LucenePage SearchByLucene(String key, Integer page);
    
    public List<LuceneOutput> searchByLuceneDate(String key);
}
