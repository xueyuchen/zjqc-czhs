package co.bohc.diet.app.common.api.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class ApiError extends ApiResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonInclude( value=Include.NON_NULL)
    private String itemPath;
    
    @JsonInclude( value=Include.NON_EMPTY)
    private List<ApiError> errorResults = new ArrayList<ApiError>();
    
    public ApiError() {
	}
    
    public ApiError(String code, String message) {
		super(code,message);
	}

	public ApiError(String code, String message, String itemPath) {
		super(code,message);
		this.itemPath = itemPath;
	}

    public ApiError addDetail(ApiError apiError) {
        errorResults.add(apiError);
        return this;
    }
	
    public ApiError addDetail(String code, String message) {
    	ApiError apiError = new ApiError();
    	apiError.setCode(code);
    	apiError.setMessage(message);
        errorResults.add(apiError);
        return this;
    }

    public ApiError addDetail(String code, String message, String itemPath) {
    	ApiError apiError = new ApiError();
    	apiError.setCode(code);
    	apiError.setMessage(message);
    	apiError.setItemPath(itemPath);
        errorResults.add(apiError);
        return this;
    }

    public String getItemPath() {
		return itemPath;
	}

	public void setItemPath(String itemPath) {
		this.itemPath = itemPath;
	}

	public List<ApiError> getErrorResults() {
		return errorResults;
	}

}