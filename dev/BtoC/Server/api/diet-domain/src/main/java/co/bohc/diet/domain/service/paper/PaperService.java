package co.bohc.diet.domain.service.paper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.bohc.diet.domain.model.Paper;
import co.bohc.diet.domain.service.CrudService;

public interface PaperService extends CrudService<Paper, Integer> {

    public Integer countNum();
    
    public Date createpaper(Integer printSize);
    
    public void createfile();
    
    public Map<String, Object> enterInfos(String paperCode, String reportCode, String carLicensePlate, String codeArray, Boolean isSave);

    public Page<PaperOutput> countPaper(Date fromDt, Date toDt, Pageable pageable);
    
    public Map<String, Object> queryPaper(String option, String code);
    
    public Map<String, Object> queryPaperByCph(String option, String code);
    
    public String WCQueryPaper(String code);
}
