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
import org.terasoluna.gfw.common.exception.ExceptionCodeResolver;

import co.bohc.diet.app.common.api.result.ApiError;
import co.bohc.diet.app.common.api.result.ApiErrorCreator;
import co.bohc.diet.app.common.util.JsonResponseUtils;

public class ApiAuthenticationEntryPoint implements AuthenticationEntryPoint, InitializingBean {
    // ~ Static fields/initializers
    // =====================================================================================

    @SuppressWarnings("unused")
    private static final Log logger = LogFactory.getLog(ApiAuthenticationEntryPoint.class);

    @Inject
    private ApiErrorCreator apiErrorCreator;

    @Inject
    private ExceptionCodeResolver exceptionCodeResolver;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        String errorCode = exceptionCodeResolver.resolveExceptionCode(authException);
        ApiError apiError = apiErrorCreator.createApiError(request, errorCode, authException.getLocalizedMessage());

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        JsonResponseUtils.writeJson(response, apiError);
    }

}
