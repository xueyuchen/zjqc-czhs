package co.bohc.diet.domain.common;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;

import co.bohc.diet.domain.common.utils.CryptUtil;
import co.bohc.diet.domain.common.utils.EncryptUtils;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Test {
	
	private static final String KEY = "123"; 
	

	public static void main(String[] args) {
		Environment env = new Environment();
		String userId = "9";
		String userIdStr = CryptUtil.decryptAES("d86695ac93db9f0b826a74ab5584be06", env.getEncryptSeed());
		System.out.println(env.getEncryptSeed());
		System.out.println(CryptUtil.encryptAES(userId, "Q4DoV6UF"));
		System.out.println(userIdStr);
		long l = System.currentTimeMillis() + DateUtils.MILLIS_PER_DAY
                * 7;
		System.out.println(l);
		System.out.println(EncryptUtils.encodeMD5("20" + "$" + "1425532382107" + "a9091ebef3877a48d2a5fa0751d4d995dc5daa6b"));
	}
}
