package co.bohc.diet.domain.service.paper;

import java.util.Date;
import java.util.List;

import co.bohc.diet.domain.model.Paper;
import co.bohc.diet.domain.service.CrudService;

public interface PaperService extends CrudService<Paper, Integer> {

    public Integer countNum();
    
    public void createpaper(Integer printSize);
    
    public void createfile();
    
    public List<String> enterInfos(String paperCode, String reportCode, String carLicensePlate, String codeArray);

    public List<PaperOutput> countPaper(Date fromDt, Date toDt);
}
