package co.bohc.diet.domain.common.exception;

public class NotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;
		
	public NotFoundException(){	
	}

	public NotFoundException(Throwable cause){
		super(cause);
	}
}
