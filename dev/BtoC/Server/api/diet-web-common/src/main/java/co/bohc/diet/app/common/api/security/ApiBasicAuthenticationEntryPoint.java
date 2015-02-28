package co.bohc.diet.app.common.api.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.util.Assert;
import org.terasoluna.gfw.common.exception.ExceptionCodeResolver;

import co.bohc.diet.app.common.api.result.ApiError;
import co.bohc.diet.app.common.api.result.ApiErrorCreator;
import co.bohc.diet.app.common.util.JsonResponseUtils;


public class ApiBasicAuthenticationEntryPoint implements AuthenticationEntryPoint, InitializingBean {
    //~ Static fields/initializers =====================================================================================

    @SuppressWarnings("unused")
	private static final Log logger = LogFactory.getLog(ApiBasicAuthenticationEntryPoint.class);


	//~ Instance fields ================================================================================================


    @Inject
    private ApiErrorCreator apiErrorCreator;

    @Inject
    private ExceptionCodeResolver exceptionCodeResolver;
    
    
    private String realmName;

    //~ Methods ========================================================================================================

    public void afterPropertiesSet() throws Exception {
        Assert.hasText(realmName, "realmName must be specified");
    }

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
    	
				
        String errorCode = exceptionCodeResolver.resolveExceptionCode(authException);
        ApiError apiError = apiErrorCreator.createApiError(request, errorCode, authException.getLocalizedMessage());

        response.addHeader("WWW-Authenticate", "Basic realm=\"" + realmName + "\"");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		JsonResponseUtils.writeJson(response, apiError);
        
       // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
 
    }

    public String getRealmName() {
        return realmName;
    }

    public void setRealmName(String realmName) {
        this.realmName = realmName;
    }

}
