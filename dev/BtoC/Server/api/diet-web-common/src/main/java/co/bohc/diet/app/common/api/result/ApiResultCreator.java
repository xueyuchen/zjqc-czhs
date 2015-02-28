package co.bohc.diet.app.common.api.result;
import javax.inject.Inject;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class ApiResultCreator {

    @Inject
    MessageSource messageSource;

    public ApiResult createApiResult(WebRequest request, String messageCode,
            String defaultErrorMessage, Object... arguments) {
        String localizedMessage = messageSource.getMessage(messageCode,
                arguments, defaultErrorMessage, request.getLocale());
        return new ApiResult(messageCode, localizedMessage);
    }
}