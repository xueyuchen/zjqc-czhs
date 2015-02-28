package co.bohc.diet.domain.service.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class BohSecurityContextHolder {

    public static int getCurrentId() {
 
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    		
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof CustomUserDetails) {
            	return ((CustomUserDetails) principal).getId();
            }
        }
        
        throw new AccessDeniedException("Get Security Context fail.");
    }
    
    public static UserDetails getCurrentUserDetails() {
    	 
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    		
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof CustomUserDetails) {
            	return (UserDetails) principal;
            }
        }
        
        throw new AccessDeniedException("Get Security Context fail.");
    }
}
