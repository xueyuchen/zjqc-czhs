package co.bohc.diet.domain.service.paper;

import co.bohc.diet.domain.model.Paper;
import co.bohc.diet.domain.service.CrudService;

public interface PaperService extends CrudService<Paper, Integer> {

    public Integer countNum();
    
    public void createpaper(Integer printNum, Integer printSize);
    
    public void createfile();
}
