package co.bohc.diet.domain.service.brand;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.model.Brand;
import co.bohc.diet.domain.repository.brand.BrandRepository;


@Service
@Transactional(readOnly = true)
public class BrandServiceImpl implements BrandService {

    @Inject
    private BrandRepository brandRepository;
    
    @Override
    public Brand findBrand(Integer brandId) {
        return brandRepository.findByBrandId(brandId);
    }

    @Override
    public List<Brand> findAllBrand() {
        List<Brand> brands = brandRepository.findAllBydelFlg();
        Iterator<Brand> it = brands.iterator();
        while(it.hasNext()){
            it.next().setModels(null);
        }
        return brands;
    }

}
