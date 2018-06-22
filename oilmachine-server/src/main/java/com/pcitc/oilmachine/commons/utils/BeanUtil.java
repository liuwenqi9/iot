package com.pcitc.oilmachine.commons.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.pcitc.oilmachine.commons.exception.BusinessException;
import com.pcitc.oilmachine.commons.exception.ExceptionCode;


public class BeanUtil extends BeanUtils{

	/**
	 * javaBean 转 MAP
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> objectToMap(Object obj){
		return objectToMap(obj,false);
	}
	public static Map<String, Object> objectToMap(Object obj,boolean isDateTime) throws BusinessException {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					if (getter == null)
						continue;
					Object value = getter.invoke(obj);
					if (value instanceof Date && isDateTime) {
						value = ((Date) value).getTime();
					}
					if (value == null)
						continue;
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionCode.BEAN_TO_MAP_ERROR.getCode(), ExceptionCode.BEAN_TO_MAP_ERROR.getMsg());
		}
		return map;
	}

	/**
	 * MAP转javaBean  
	 * @author 王少亭
	 * @param map
	 * @param obj
	 * @throws BusinessException
	 * 2017年3月14日上午11:17:41
	 */
	public static void mapToObject(Map<String, Object> map, Object obj) throws BusinessException {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (map.containsKey(key)) {
					Object value = map.get(key);
					// 得到property对应的setter方法
					Method setter = property.getWriteMethod();
					if (setter == null) {
						continue;
					}
					setter.invoke(obj, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionCode.BEAN_TO_MAP_ERROR.getCode(), ExceptionCode.BEAN_TO_MAP_ERROR.getMsg());
		}

		return;
	}
	/**
	 * MAP转javaBean  (特殊处理)
	 * @author 王少亭
	 * @param map
	 * @param obj
	 * @throws BusinessException
	 * 2017年3月14日上午11:17:41
	 */
	public static void mapToObjectSpecial(Map<String, Object> map, Object obj) throws BusinessException {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (map.containsKey(key)) {
					Object value = map.get(key);
					// 得到property对应的setter方法
					Method setter = property.getWriteMethod();
					if(value != null){
						if (setter == null) {
							continue;
						}
						if("score".equals(key) || "amount".equals(key) || "productamount".equals(key)){
							value = new BigDecimal(String.valueOf(value));
						}
						if("createdate".equals(key) || "updatetime".equals(key)){
							value = new Date((long)value);
						}
						setter.invoke(obj, value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionCode.BEAN_TO_MAP_ERROR.getCode(), ExceptionCode.BEAN_TO_MAP_ERROR.getMsg());
		}

		return;
	}
	
	public static Map<String,Object> removeBlank4Map(Map<String,Object> map){
		Map<String,Object>  new_Map = new HashMap<String,Object>();
		for (String key : map.keySet()) {
			Object value = map.get(key);
			if(value != null && value instanceof String){
				if(StringUtils.isNotBlank((String)value)){
					new_Map.put(key, value);
				}
			}else{
				if(value != null){
					new_Map.put(key, value);
				}
			}
		}
		return new_Map;
	}
	
	

	/**
	 * 实现原BeanUtils.copy功能，但复制不区分大小写
	 * @author 王少亭
	 * @param source  源对象
	 * @param target  目前对象
	 * @throws BeansException
	 * 2017年9月6日上午10:08:41
	 */
	public static void copyPropertiesIgnoreCase(Object source, Object target) throws BeansException {
		copyPropertiesIgnoreCase(source, target, null, (String[]) null);
	}

	/**
	 * 实现原BeanUtils.copy功能，但复制不区分大小写
	 * @param source
	 * @param target
	 * @param editable
	 * @param ignoreProperties
	 * @throws BeansException
	 */
	private static void copyPropertiesIgnoreCase(Object source, Object target, Class<?> editable, String... ignoreProperties) throws BeansException {

		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");

		Class<?> actualEditable = target.getClass();
		if (editable != null) {
			if (!editable.isInstance(target)) {
				throw new IllegalArgumentException("Target class [" + target.getClass().getName() + "] not assignable to Editable class [" + editable.getName() + "]");
			}
			actualEditable = editable;
		}
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		PropertyDescriptor[] sourcePds = getPropertyDescriptors(source.getClass());
		List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);

		for (PropertyDescriptor targetPd : targetPds) {
			Method writeMethod = targetPd.getWriteMethod();
			if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd == null) {
					for (PropertyDescriptor sourcePd_ : sourcePds) {
						if (sourcePd_.getName().equalsIgnoreCase(targetPd.getName())) {
							sourcePd = getPropertyDescriptor(source.getClass(), sourcePd_.getName());
							break;
						}
					}
				}
				if (sourcePd != null) {
					Method readMethod = sourcePd.getReadMethod();
					if (readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
						try {
							if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
								readMethod.setAccessible(true);
							}
							Object value = readMethod.invoke(source);
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						} catch (Throwable ex) {
							throw new FatalBeanException("Could not copy property '" + targetPd.getName() + "' from source to target", ex);
						}
					}
				}
			}
		}
	}
	
	public static void copyPropertiesExcludeEmpty(Object source, Object target) throws BeansException {
		copyPropertiesExcludeEmpty(source, target, null, (String[]) null);
	}
	/**
	 * 实现原BeanUtils.copy功能，但复制不区分大小写并且源目标值为空时不对目标对象进行覆盖
	 * @param source
	 * @param target
	 * @param editable
	 * @param ignoreProperties
	 * @throws BeansException
	 */
	private static void copyPropertiesExcludeEmpty(Object source, Object target, Class<?> editable, String... ignoreProperties) throws BeansException {

		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");

		Class<?> actualEditable = target.getClass();
		if (editable != null) {
			if (!editable.isInstance(target)) {
				throw new IllegalArgumentException("Target class [" + target.getClass().getName() + "] not assignable to Editable class [" + editable.getName() + "]");
			}
			actualEditable = editable;
		}
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		PropertyDescriptor[] sourcePds = getPropertyDescriptors(source.getClass());
		List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);

		for (PropertyDescriptor targetPd : targetPds) {
			Method writeMethod = targetPd.getWriteMethod();
			if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd == null) {
					for (PropertyDescriptor sourcePd_ : sourcePds) {
						if (sourcePd_.getName().equalsIgnoreCase(targetPd.getName())) {
							sourcePd = getPropertyDescriptor(source.getClass(), sourcePd_.getName());
							break;
						}
					}
				}
				if (sourcePd != null) {
					Method readMethod = sourcePd.getReadMethod();
					if (readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
						try {
							if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
								readMethod.setAccessible(true);
							}
							Object value = readMethod.invoke(source);
							if(value instanceof String){
								if(null == value || "".equals(((String)value).trim())){
									continue;
								}
							}else{
								if(null == value){
									continue;
								}
							}
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						} catch (Throwable ex) {
							throw new FatalBeanException("Could not copy property '" + targetPd.getName() + "' from source to target", ex);
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * 按指定大小，分隔集合，将集合按规定个数分为n个部分
	 * @param list		集合对象
	 * @param pageSize	指定集合大小
	 * @return
	 */
	public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
		List<List<T>> listArray = new ArrayList<List<T>>();
		List<T> subList = null;
		for (int i = 0; i < list.size(); i++) {
			if (i % pageSize == 0) {
				// 每次到达页大小的边界就重新申请一个subList
				subList = new ArrayList<T>();
				listArray.add(subList);
			}
			subList.add(list.get(i));
		}
		return listArray;
	}
}
