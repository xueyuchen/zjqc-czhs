package co.bohc.diet.domain.service.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.bohc.diet.domain.common.Environment;
 
public class BohUserDetailsService implements UserDetailsService {
  
	
    @Inject
    private Environment env;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
	


}
