/**
 * 
 */
package co.bohc.diet.domain.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * @author ying.dong
 * 
 */
public abstract class EncryptUtils {

	/**
	 * Encrypt by SHA
	 * 
	 * @param plain
	 * @param salt
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encryptBySHA(String plain, String salt) {

		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		sha.setEncodeHashAsBase64(false);
		return sha.encodePassword(plain, salt);
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 *
	 * @author wangyuhao
	 */
	public static final String encodeMD5(String data) {

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");

            // Now, compute hash.
            digest.update(data.getBytes());
            return encodeHex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * 
	 * @param bytes
	 * @return
	 *
	 * @author wangyuhao
	 */
	public static final String encodeHex(byte[] bytes) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        int i;

        for (i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buf.toString();
    }
}
