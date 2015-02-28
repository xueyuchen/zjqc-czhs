package co.bohc.diet.domain.repository.adminuser;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.MAdminUser;

/**
 * Created by dhc
 * 2014-12-01
 */
public interface AdminUserRepository extends PagingAndSortingRepository<MAdminUser, Integer>, AdminUserRepositoryCustom {
	
	@Query("SELECT a from MAdminUser a WHERE a.loginId = ?1 AND a.delFlg = 0")
    MAdminUser findOneByLoginId(String loginId);
	
	@Query("SELECT a from MAdminUser a WHERE a.loginId = ?1")
    MAdminUser findIsRepeatLoginId(String loginId);
    
    @Modifying
    @Query("UPDATE MAdminUser m SET m.delFlg = 1 WHERE m.adminUserId = :adminUserId")
	int deleteAdminUser(@Param(value = "adminUserId")Integer adminUserId);
    
    @Query("SELECT a from MAdminUser a WHERE a.adminUserId = :adminUserId AND a.delFlg = 0")
	MAdminUser findOneById(@Param(value = "adminUserId")Integer adminUserId);

	Page<MAdminUser> findAllByDelFlg(Integer delFlg, Pageable pageable);
	
	public List<MAdminUser> findAllByadminRoleKbn(String adminRoleKbn);
	
	public List<MAdminUser> findAllByadminRoleKbnAndDelFlg(String adminRoleKbn,Integer delFlg);
	
	@Query("SELECT COUNT(a.adminUserId) AS counts FROM MAdminUser a WHERE a.delFlg = 0")
	Integer countAdminUser();

}
