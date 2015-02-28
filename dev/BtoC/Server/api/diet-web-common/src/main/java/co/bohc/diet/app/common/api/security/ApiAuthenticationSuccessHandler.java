package co.bohc.diet.app.common.api.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import co.bohc.diet.app.common.util.JsonResponseUtils;

public class ApiAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {

	@Inject
	MessageSource messageSource;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
            	JsonResponseUtils.writeJson(response, (UserDetails) principal);
            }
        }

	}


}