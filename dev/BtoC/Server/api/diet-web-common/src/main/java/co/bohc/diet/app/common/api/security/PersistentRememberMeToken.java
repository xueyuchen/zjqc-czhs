package co.bohc.diet.app.common.api.security;

import org.apache.commons.codec.digest.DigestUtils;


public class PersistentRememberMeToken {
	
    private final Integer userId;
    private final String email;
    private final String authToken;
    private final String password;
    private  Long time;
    
    
	public PersistentRememberMeToken(Integer userId, String email,
			String authToken, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.authToken = authToken;
		this.password = password;
	}
	
	public PersistentRememberMeToken(Integer userId, String email, String password ) {
		super();
		this.userId = userId;
		this.email = email;
		this.time = System.currentTimeMillis();
        this.password = password;
		String plainAuth = this.userId + this.password + this.time;
		this.authToken = DigestUtils.shaHex(plainAuth);
	}

	public Integer getUserId() {
		return userId;
	}
	
	public String getEmail() {
		return email;
	}
	public String getAuthToken() {
		return authToken;
	}
	
	public Long getTime() {
		return time;
	}

	public boolean validateAuthToken(String presentedToken,final Long time ){
		
		if (presentedToken!=null && presentedToken.equals(this.authToken)){
			String plainAuth = this.userId +this.password + time;
		    String encodeAuth = DigestUtils.shaHex(plainAuth); 
		    if (presentedToken.equals(encodeAuth)){
		    	return true;
		    }
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(DigestUtils.shaHex("123") );
	}

}