package co.bohc.diet.domain.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ClassPathResourceUtils {

	public static String readClassPathFile(String classPath) {
		Resource rource = new ClassPathResource(classPath);

		if (rource.exists()) {
			StringBuffer buffer = new StringBuffer();

			try {
				BufferedReader bf = new BufferedReader(new InputStreamReader(
						rource.getInputStream(), "UTF-8"));
				String line = "";
				while ((line = bf.readLine()) != null) {
					buffer.append(line);
				}
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			return buffer.toString();
		} else {
			return null;
		}
	}

}
