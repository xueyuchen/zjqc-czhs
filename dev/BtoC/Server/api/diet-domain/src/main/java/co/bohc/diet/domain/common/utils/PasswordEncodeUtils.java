package co.bohc.diet.domain.common.utils;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public abstract class PasswordEncodeUtils {
	
    public static String encodePassword(String rawPass, Object salt){
    	ShaPasswordEncoder sha = new ShaPasswordEncoder();       
        sha.setEncodeHashAsBase64(false);       
        return sha.encodePassword(rawPass, salt);
   }
}
