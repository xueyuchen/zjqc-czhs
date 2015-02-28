package co.bohc.diet.domain.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

public class PropertiesUtils extends BeanUtils {

	public static void copyProperties(Object source, Object target)
			throws BeansException {
		copyProperties(source, target, null, (String[]) null);
	}

	private static void copyProperties(Object source, Object target,
			Class<?> editable, String... ignoreProperties)
			throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");

		Class<?> actualEditable = target.getClass();

		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);

		for (PropertyDescriptor targetPd : targetPds) {
			Method writeMethod = targetPd.getWriteMethod();
			if (writeMethod != null) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(
						source.getClass(), targetPd.getName());
				if (sourcePd != null) {
					Method readMethod = sourcePd.getReadMethod();
					if (readMethod != null
							&& ClassUtils.isAssignable(
									writeMethod.getParameterTypes()[0],
									readMethod.getReturnType())) {
						try {
							if (readMethod.invoke(source) == null) {
								continue;
							}
							if (!Modifier.isPublic(readMethod
									.getDeclaringClass().getModifiers())) {
								readMethod.setAccessible(true);
							}
							Object value = readMethod.invoke(source);
							if (!Modifier.isPublic(writeMethod
									.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						} catch (Throwable ex) {
							throw new FatalBeanException(
									"Could not copy property '"
											+ targetPd.getName()
											+ "' from source to target", ex);
						}
					}
				}
			}
		}
	}
}
