package co.bohc.diet.app.common.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonResponseUtils {
	
	public static void writeJson(HttpServletResponse response, Object object) {

		ObjectMapper objectMapper = null;

		objectMapper = new ObjectMapper();
		String result = "";

		try {
			result = objectMapper.writeValueAsString(object);
		} catch (Exception e1) {

		}

		response.setContentType("text/text;charset=UTF-8");
		response.setHeader("Charset", "UTF-8");

		try {
			response.getWriter().write(result);
		} catch (IOException e) {

		}
	}
}
