package co.bohc.diet.domain.service.adminuser;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.bohc.diet.domain.model.MAdminUser;
import co.bohc.diet.domain.service.CrudService;

/**
 * Created by dhc
 * 2014-12-01
 * AdminUser Service Interface
 */
public interface AdminUserService extends CrudService<MAdminUser,Integer> {

    /**
     * AdminUser login
     *
     * @param loginId  The AdminUser's login id
     * @return MAdminUser Object
     */
    public MAdminUser findOneByLoginId(String loginId);

	public Page<AdminUserOutput> findPageAdminUser(Pageable pageable);

	public MAdminUser updateAdminUser(AdminUserInput adminUserInput);

	public MAdminUser createAdminUser(AdminUserCreateInput adminUserInput);

	public MAdminUser deleteAdminUser(Integer adminUserId);

	public MAdminUser findOneById(Integer currentAdminUserId);
	
	public List<AdminUserOutput> findAllByadminRoleKbn(String adminRoleKbn);
	/**
	 * @author dcy created at 2014-12-31
	 * @return
	 */
    List<AdminUserInfoOutput> findAllDelFlagOffExpert();
}
