package co.bohc.diet.app.common.api.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class TokenBasedAuthenticationFilter extends UsernamePasswordAuthenticationFilter  {
	
	
	@Override
	protected String obtainPassword(HttpServletRequest request) {
		System.out.println("obtinaPassword: " + request.getHeader(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY));
		return request.getHeader(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY);
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		System.out.println("obtainUsername: " + request.getHeader(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY));		
		return request.getHeader(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY);
	}

}