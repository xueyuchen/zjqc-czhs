package co.bohc.diet.domain.common.exception;

public class S3Exception extends RuntimeException {


	private static final long serialVersionUID = 1L;
		
	public S3Exception(){	
	}

	public S3Exception(Throwable cause){
		super(cause);
	}
}
