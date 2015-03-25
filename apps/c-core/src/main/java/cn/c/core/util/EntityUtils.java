package cn.c.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author hz453@126.com
 */
public class EntityUtils {

	public static Object copy(Object dto, Object domian) {

		if (dto == null || domian == null) {
			return null;
		}

		Class<?> dtoClass = dto.getClass();
		Class<?> domianClass = domian.getClass();

		
		//Field[] fArray = dtoClass.getDeclaredFields();
		List<Field> dtoFields = new ArrayList<Field>();
		getAllDeclaredFields(dtoFields, dtoClass);
		
		
		for (Field f : dtoFields) {
			// if(c.getMethod("") != null )
			//System.out.println(f.getName());
			String filedName = f.getName();

			Method m = getSeterMethod(dtoClass, filedName);
			Method m1 = getGeterMethod(domianClass, filedName);

			if (m == null || m1 == null) {
				continue;
			}

			if (f.getType().equals(m1.getReturnType()) && !f.getType().equals(Class.class)) {

				if (Collection.class.isAssignableFrom(f.getType())) {
					System.out.println(f.getType());

				} else {
					invoke(dto, m, invoke(domian, m1));
					//m.invoke(dto, m1.invoke(domian));
				}

			} else {
				invoke(dto, m, copy(newInstance(f.getType()), invoke(domian, m1)));
				//m.invoke(dto, copy(f.getType().newInstance(), m1.invoke(domian)));
				
			}
		}
		return dto;

	}
	
	public static <T> T copy(Class<T> dtoClass, Object domian)  {

		T dto = newInstance(dtoClass);
		copy(dto, domian);
		return dto;
	}
	
	public static <T> T newInstance(Class<T> clazz){
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	public static Object invoke(Object obj, Method method, Object... args){
		Object object = null;
		try {
			object = method.invoke(obj, args);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
	public static Method getMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes) {
		Method method = null;
		try {
			method = clazz.getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e) {
			//e.printStackTrace();
			throw new cn.c.core.excepion.NoSuchMethodException(e);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return method;
	}
	
	
	public static void getAllDeclaredFields(List<Field> fieldList, Class<?> superClass){
		if(superClass.equals(Object.class)) {
			return;
		}
		Field[] fields = superClass.getDeclaredFields();
		for(Field field : fields) {
			fieldList.add(field);
		}
		getAllDeclaredFields(fieldList, superClass.getSuperclass());
	}
	
	public static boolean containsMethod(Class<?> clazz, String methodName) {
		Method method = getMethod(clazz, methodName);
		return method != null ? true : false;
	}

	public static Method getMethod(Class<?> clazz, String methodName) {
		return getMethod(clazz, methodName, false);
	}
	
	public static Method getMethod(Class<?> clazz, String methodName, boolean required) {
		Method method = null;
		Method[] mArray = clazz.getMethods();
		for (Method m : mArray) {
			if (m.getName().equals(methodName)) {
				method = m;
				break;
			}
		}
		if(required && method==null) {
			throw new cn.c.core.excepion.NoSuchMethodException(clazz.getPackage().getName());
		}
		return method;
	}
	
	public static Method getGeterMethod(Class<?> clazz, String filedName) {
		return getGeterMethod(clazz, filedName, false);
	}
	public static Method getGeterMethod(Class<?> clazz, String filedName, boolean required) {
		String methodNameSuffix = filedName.toUpperCase().charAt(0) + filedName.substring(1);
		Method method = getMethod(clazz, "get" + methodNameSuffix, required);
		if(method == null) {
			method = getMethod(clazz, "is" + methodNameSuffix, required);
		}
		return method;
	}

	public static Method getSeterMethod(Class<?> clazz, String filedName) {
		return getSeterMethod(clazz, filedName, false);
	}
	public static Method getSeterMethod(Class<?> clazz, String filedName, boolean required) {
		String methodName = "set" + filedName.toUpperCase().charAt(0) + filedName.substring(1);
		return getMethod(clazz, methodName, required);
	}


}
