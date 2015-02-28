package co.bohc.diet.domain.common.exception;

public class TrialAccessDeniedException extends RuntimeException {


	private static final long serialVersionUID = 1L;
		
	public TrialAccessDeniedException(){	
	}

	public TrialAccessDeniedException(Throwable cause){
		super(cause);
	}
}
