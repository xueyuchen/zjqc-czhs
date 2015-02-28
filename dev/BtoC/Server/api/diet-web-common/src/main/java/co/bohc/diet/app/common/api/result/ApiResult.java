package co.bohc.diet.app.common.api.result;


import co.bohc.diet.domain.common.constants.MessageId;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ApiResult {
	
	public final static ApiResult SUCCESS  =  new ApiResult(MessageId.E_EX_MM_0000);

    private String code;
    
    @JsonInclude( value=Include.NON_NULL)
    private String message;
    
    @JsonInclude( value=Include.NON_NULL)
    private Object result;
    
    
	public ApiResult() {
	}
    
	public ApiResult(String code) {
		super();
		this.code = code;
	}
	
	public ApiResult(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ApiResult(String code, String message, Object result) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}
	
    

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}    
    
}
