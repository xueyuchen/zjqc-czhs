package co.bohc.diet.domain.service.admin;

import co.bohc.diet.domain.model.MAdminUser;
import co.bohc.diet.domain.service.CrudService;

public interface AdminService extends CrudService<MAdminUser, Integer> {

    public Boolean checkUserName(String loginId, String password);
}
