package co.bohc.diet.domain.service.admin;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.model.MAdminUser;
import co.bohc.diet.domain.repository.admin.AdminRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl extends CrudServiceImpl<MAdminUser, Integer, AdminRepository> implements AdminService {

    @Inject
    public void setRepository(AdminRepository repository) {
        super.setRepository(repository);
    }

    @Override
    public Integer checkUserName(String loginId, String password) {
        MAdminUser user = repository.findByLoginId(loginId);
        if (user == null || !user.getPassword().equals(password)) {
            return -1;
        } else if(user.getAdminRoleKbn().equals("SU")){
            return 1;
        }else if (user.getAdminRoleKbn().equals("AM")){
            return 0;
        }else{
            return 1;
        }
    }

}
