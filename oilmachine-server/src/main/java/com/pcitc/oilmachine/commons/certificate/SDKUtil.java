package com.pcitc.oilmachine.commons.certificate;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.utils.AESUtil;
import com.pcitc.oilmachine.form.MobileDataInfo;
import com.pcitc.oilmachine.form.MobileResultInfo;

public class SDKUtil {
	
	/**
	 * 油机加密待返回数据
	 * @param businessData
	 * @param publicKey
	 * @param randomKey
	 * @return
	 */
	public static MobileDataInfo securityOReturnMsg(MobileDataInfo businessData,String randomKey, String publicKey) {
		notNull(businessData.getData(), "数据不能为空！");
		notNull(businessData.getAssistdata(), "服务数据不能为空！");
		notNull(businessData.getFunName(), "请求方法不能为空！");
		notNull(publicKey, "不能为空！");
		notNull(randomKey, "随机对称密钥不能为空！");
		MobileDataInfo encryptData = new MobileDataInfo();
		encryptData.setFunName(businessData.getFunName());
		// 生成AES加密密钥
		/*if(randomKey.length() != 22){
			throw new BusinessException("随机密钥长度必须为22位");
		}*/
		// 用业务系统公钥对AES加密密钥进行加密
		try {
			byte[] encryptKey = EncryptUtil.encryptByPublicKey(randomKey, publicKey);
			// 将加密数据进行BASE64转码
			encryptData.setRandomcode(Base64.encodeBase64String(encryptKey));
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("加密对称密钥异常");
		}
		// AES加密重要信息
		try {
			String assistdata = AESUtil.encrypt(businessData.getAssistdata(), randomKey);
			encryptData.setAssistdata(assistdata);
			String data = AESUtil.encrypt(businessData.getData(), randomKey);
			encryptData.setData(data);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("加密明文信息错误");
		}
		return encryptData;
	}
	
	
	/**
	 * 油机解密接收数据
	 * @param encryptData
	 * @param randomkey
	 * @param privateKey
	 * @return
	 */
	public static String securityOReceiveMsg(String encryptData,String randomkey, String privateKey) {
		notNull(encryptData, "数据对象不能为空");
		notNull(privateKey, "私钥不能为空");
		notNull(randomkey, "签名不能为空");
		// 解密AES加密密钥
		String randomStrKey = null;
		try {
			byte[] randomStrKeys = EncryptUtil.decryptByPrivateKey(Base64.decodeBase64(randomkey), privateKey);
			randomStrKey = new String(randomStrKeys);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("解密AES密钥错误");
		}
		// 解密加密数据
		String data = null;
		try {
			data = AESUtil.decrypt(encryptData, randomStrKey);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("解密数据错误");
		}
		return data;
	}
	
	/**
	 * 中心加密返回数据
	 * @param encryptData
	 * @param randomkey
	 * @param privateKey
	 * @return
	 */
	public static String securityCReturnMsg(MobileResultInfo resultData,String randomkey, String publickey) {
		notNull(resultData, "数据不能为空！");
		notNull(publickey, "公钥不能为空！");
		notNull(randomkey, "随机对称密钥不能为空！");
		JSONObject resultObj = new JSONObject();
		// 生成AES加密密钥
		/*if(randomkey.length() != 22){
			throw new BusinessException("随机密钥长度必须为22位");
		}*/
		// 用业务系统公钥对AES加密密钥进行加密
		try {
			byte[] encryptKey = EncryptUtil.encryptByPublicKey(randomkey, publickey);
			// 将加密数据进行BASE64转码
			resultObj.put("randomcode", Base64.encodeBase64String(encryptKey));
			String funname = resultData.getFunName();
			resultObj.put("funName", funname);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("加密对称密钥异常");
		}
		// AES加密重要信息
		try {
			resultData.setFunName(null);
			resultData.setRandomcode(null);
			String data = AESUtil.encrypt(JSONObject.toJSONString(resultData), randomkey);
			resultObj.put("data",data);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("加密明文信息错误");
		}
		return resultObj.toJSONString();
	}
	
	/**
	 * 对称加密
	 * @param encryptData
	 * @param key
	 * @return
	 */
	public static MobileDataInfo securityOReturnMsg(MobileDataInfo encryptData,String key){
		notNull(encryptData, "数据对象不能为空");
		notNull(key, "密钥不能为空");
		// 解密加密数据
		
		String  data = null;
		String  assistdata = null;
		try {
			data = AESUtil.encrypt(encryptData.getData(), key);
			assistdata = AESUtil.encrypt(encryptData.getAssistdata(), key);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("加密数据错误");
		}
		MobileDataInfo resultInfo = new MobileDataInfo();
		try {
			resultInfo.setAssistdata(assistdata);
			resultInfo.setData(data);
			resultInfo.setFunName(encryptData.getFunName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("验签异常！");
		}
		return resultInfo;
	}
	
	/**
	 * 中心对称加密返回数据
	 * @param encryptData
	 * @param key
	 * @return
	 */
	public static String securityCReturnMsg(MobileResultInfo encryptData,String key){
		notNull(encryptData, "数据对象不能为空");
		notNull(key, "密钥不能为空");
		// 解密加密数据
		
		String data = null;
		try {
			data = AESUtil.encrypt(JSONObject.toJSONString(encryptData), key);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("加密数据错误");
		}
		JSONObject resultInfo = new JSONObject();
		try {
			resultInfo.put("funName", encryptData.getFunName());
			resultInfo.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("加密异常");
		}
		return resultInfo.toJSONString();
	}
	
	/**
	 * 中心对称解密
	 * @param encryptData
	 * @param key
	 * @return
	 */
	public static MobileDataInfo securityCReceiveMsg(MobileDataInfo encryptData,String key){
		notNull(encryptData, "数据对象不能为空");
		notNull(key, "密钥不能为空");
		// 解密加密数据
		String data = null;
		String assistdata = null;
		try {
			data = AESUtil.decrypt(encryptData.getData(), key);
			assistdata = AESUtil.decrypt(encryptData.getAssistdata(), key);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("解密数据错误");
		}
		MobileDataInfo resultInfo = new MobileDataInfo();
		try {
			resultInfo.setAssistdata(assistdata);
			resultInfo.setData(data);
			resultInfo.setFunName(encryptData.getFunName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("验签异常！");
		}
		return resultInfo;
	}
	
	/**
	 * 油机对称解密
	 * @param encryptData
	 * @param key
	 * @return
	 */
	public static String securityOReceiveMsg(String encryptData,String key){
		notNull(encryptData, "数据对象不能为空");
		notNull(key, "密钥不能为空");
		// 解密加密数据
		String data = null;
		try {
			data = AESUtil.decrypt(encryptData, key);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("解密数据错误");
		}
		return data;
	}
	
	/**
	 * 中心解密接收数据
	 * @param encryptData
	 * @param randomkey
	 * @param privateKey
	 * @return
	 */
	public static MobileDataInfo securityCReceiveMsg(MobileDataInfo encryptData,String randomkey, String privateKey) {
		notNull(encryptData, "数据对象不能为空");
		notNull(privateKey, "私钥不能为空");
		notNull(randomkey, "签名不能为空");
		MobileDataInfo resultInfo = new MobileDataInfo();
		resultInfo.setFunName(encryptData.getFunName());
		// 解密AES加密密钥
		String randomStrKey = null;
		try {
			byte[] randomStrKeys = EncryptUtil.decryptByPrivateKey(Base64.decodeBase64(randomkey), privateKey);
			randomStrKey = new String(randomStrKeys);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("解密AES密钥错误");
		}
		// 解密加密数据
		String data = null;
		String assistdata = null;
		try {
			data = AESUtil.decrypt(encryptData.getData(), randomStrKey);
			assistdata = AESUtil.decrypt(encryptData.getAssistdata(), randomStrKey);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("解密数据错误");
		}
		try {
			resultInfo.setAssistdata(assistdata);
			resultInfo.setData(data);
			resultInfo.setRandomcode(randomStrKey);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("验签异常！");
		}
		return resultInfo;
	}
	
	private static void notNull(Object o,String msg) {
		if (!(o instanceof String)) {
			if (o == null) {
				throw new BusinessException(msg);
			}
		} else {
			if (o == null || "".equals(((String) o).trim())) {
				throw new BusinessException(msg);
			}
		}
	}
	/**
	 * javaBean 转 MAP
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> objectToMap(Object obj) throws BusinessException {
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
					if(getter == null)
						continue;
					Object value = getter.invoke(obj);
					if(value instanceof Date){
						value = ((Date)value).getTime();
					}
					if (value == null)
						continue;
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("bean转换map异常");
		}
		return map;
	}
}
