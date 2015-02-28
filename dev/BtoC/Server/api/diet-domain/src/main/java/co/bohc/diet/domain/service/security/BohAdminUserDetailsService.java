package co.bohc.diet.domain.service.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.bohc.diet.domain.model.MAdminUser;
import co.bohc.diet.domain.service.adminuser.AdminUserService;
 
public class BohAdminUserDetailsService implements UserDetailsService {
  
	
    @Inject
    private AdminUserService adminUserService;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	MAdminUser mAdminUser = adminUserService.findOneByLoginId(username);

        if (mAdminUser == null) {
        	throw new UsernameNotFoundException(username);  
        }
        
        return new BohAdminUserDetails(mAdminUser);
    }

}
