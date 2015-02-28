package co.bohc.diet.domain.common.utils;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelocityUtils {

	public final static String PREFIX = "META-INF/velocity/";
	public final static String REPOSITORY_PACKAGE = "co.bohc.diet.domain.repository.";
	static {
		try {

			Properties p = new Properties();
			p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
			p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
			p.setProperty("file.resource.loader.class",
					"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			Velocity.init(p);
		} catch (Exception e) {
			throw new RuntimeException(
					"Exception occurs while initialize the velociy.", e);
		}
	}

	public static String render() {
		StackTraceElement stackTraceElement = Thread.currentThread()
				.getStackTrace()[2];
		String clazz = stackTraceElement.getClassName();
		String method = stackTraceElement.getMethodName();

		String templateName = clazz.replace(
				REPOSITORY_PACKAGE, "").replaceAll("\\.", "/")
				+ "_" + method + ".vm";
		return renderRepository(templateName, null);
	}
	
	public static String render(Object model) {
		StackTraceElement stackTraceElement = Thread.currentThread()
				.getStackTrace()[2];
		String clazz = stackTraceElement.getClassName();
		String method = stackTraceElement.getMethodName();

		String templateName = clazz.replace(
				REPOSITORY_PACKAGE, "").replaceAll("\\.", "/")
				+ "_" + method + ".vm";
		return renderRepository(templateName, model);
	}

	private static String renderRepository(String templateName, Object model) {
		return render(PREFIX + templateName,model);
	}
	
	@SuppressWarnings("unchecked")
	public static String render(String templatePath, Object model) {

		try {
			VelocityContext context = null;

			if (model != null) {
				
				Map<String, ?> mapContext = null;
				if (model instanceof Map) {
					mapContext = (Map<String, ?>) model;
				} else {
					mapContext = BeanUtils.describe(model);
				}
				context = new VelocityContext(mapContext);
			} else {
				context = new VelocityContext();
			}

			Template template = Velocity.getTemplate(templatePath);
			StringWriter writer = new StringWriter();
			template.merge(context, writer);
			return writer.toString();
		} catch (Exception e) {
			throw new RuntimeException("Parse template failed.", e);
		}
	}
	
	public static void main(String[] args) {
		
		StringWriter writer = new StringWriter();
		VelocityContext context = new VelocityContext();
		context.put("loginId", "");
		Velocity.evaluate(context, writer, "test", "#if($loginId&&$loginId!='') qweqe #end");
		
		System.out.println(writer.toString());
	}
}