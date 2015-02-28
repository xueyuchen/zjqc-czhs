package co.bohc.diet.domain.common.utils;


public abstract class PwdResetTokenUtils {

	public static String makeToken(String userId, long expireTime,String userPassword) {
	    
		return EncryptUtils.encodeMD5(userId + "$" + expireTime + userPassword);
	}
	
}