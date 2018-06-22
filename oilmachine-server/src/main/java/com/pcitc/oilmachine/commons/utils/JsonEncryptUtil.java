package com.pcitc.oilmachine.commons.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

import com.alibaba.fastjson.JSONObject;

/**
 * 对报文进行加密
 * @author CZLQ
 *
 */
public class JsonEncryptUtil {
	
	/**
	 * 创建临时秘钥并加密指定数据，同时使用私钥加密临时秘钥
	 * @param jsonData 报文数据
	 * @param encryptDataKey 报文中加密数据的属性名称
	 * @param sysKey 报文中存放临时秘钥的属性名称
	 * @param privateKey 私钥
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static void encryptJsonWithPrivateKey(JSONObject jsonData, String encryptDataKey, String sysKey, String privateKey) throws NoSuchAlgorithmException, 
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, 
			NoSuchPaddingException, NoSuchProviderException, ShortBufferException {
		Key reSysKey = Blowfish.generateKey();
		String sysKeyStr = Base64.encode(RsaUtil.encryptWithPrivateKey(reSysKey.getEncoded(), Base64.decode(privateKey)));
		String data = jsonData.getString(encryptDataKey);
		data = Base64.encode(Blowfish.encrypt(data.getBytes(), reSysKey));
		jsonData.put(sysKey, sysKeyStr);
		jsonData.put(encryptDataKey, data);
	}
	
	/**
	 * 创建临时秘钥并加密指定数据，同时使用公钥加密临时秘钥
	 * @param jsonData 报文数据
	 * @param encryptDataKey 报文中加密数据的属性名称
	 * @param sysKey 报文中存放临时秘钥的属性名称
	 * @param privateKey 私钥
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static void encryptJsonWithPublicKey(JSONObject jsonData, String encryptDataKey, String sysKey, String publicKey) throws NoSuchAlgorithmException, 
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, 
			NoSuchPaddingException, NoSuchProviderException, ShortBufferException {
		Key reSysKey = Blowfish.generateKey();
		String sysKeyStr = Base64.encode(RsaUtil.encryptWithPublicKey(reSysKey.getEncoded(), Base64.decode(publicKey)));
		String data = jsonData.getString(encryptDataKey);
		data = Base64.encode(Blowfish.encrypt(data.getBytes(), reSysKey));
		jsonData.put(sysKey, sysKeyStr);
		jsonData.put(encryptDataKey, data);
	}
	
	
	/**
	 * 创建临时秘钥并加密指定数据，同时使用公钥加密临时秘钥
	 * @param jsonData 报文数据
	 * @param encryptDataKey 报文中加密数据的属性名称
	 * @param sysKey 报文中存放临时秘钥的属性名称
	 * @param publicKey 公钥
	 */
	public static String encryptDate(JSONObject jsonData, String encryptDataKey,String sysKey, String publicKey) {
		String resyskey = "";
		try {
			// 对报文加密
			JsonEncryptUtil.encryptJsonWithPublicKey(jsonData, encryptDataKey,sysKey, publicKey);
			// 私钥对报文签名
			resyskey = SignUtil.jsonSignWithPublicKey(jsonData, publicKey,"", null);
			
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			throw new BusinessException(
				ExceptionCode.KEY_INVALID.getMsg(),ExceptionCode.KEY_INVALID.getCode());
		} catch (UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException e) {
			e.printStackTrace();
			throw new BusinessException(
				ExceptionCode.CIPHERTEXT_ILLEGAL.getMsg(),ExceptionCode.CIPHERTEXT_ILLEGAL.getCode());
		} catch (InvalidAlgorithmParameterException | InvalidKeySpecException | NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();
			throw new BusinessException(
				ExceptionCode.DECRYPTION_ERROR.getMsg(),ExceptionCode.DECRYPTION_ERROR.getCode());
		} catch (ShortBufferException e) {
			e.printStackTrace();
			throw new BusinessException(
				ExceptionCode.DECRYPTION_ERROR.getMsg(),ExceptionCode.DECRYPTION_ERROR.getCode());
		} 
		return resyskey;
	}
	
	
	/**
	 * 使用公钥校验签名
	 * @param jsonData 报文数据
	 * @param encryptDataKey 报文中加密数据的属性名称
	 * @param sysKey 报文中存放临时秘钥的属性名称
	 * @param publicKey 公钥
	 */
	public static boolean verifySign(JSONObject jsonData, String signKey,
			String publicKey, String paternerKey, String[] exclude) {
		boolean verifySign = false;
		try {
			verifySign = SignUtil.jsonVerifyWithPublicKey(jsonData, signKey, publicKey,paternerKey, exclude);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			throw new BusinessException(
				ExceptionCode.KEY_INVALID.getMsg(),ExceptionCode.KEY_INVALID.getCode());
		} catch (UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException e) {
			e.printStackTrace();
			throw new BusinessException(
				ExceptionCode.CIPHERTEXT_ILLEGAL.getMsg(),ExceptionCode.CIPHERTEXT_ILLEGAL.getCode());
		} catch (InvalidAlgorithmParameterException | InvalidKeySpecException | NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();
			throw new BusinessException(
				ExceptionCode.DECRYPTION_ERROR.getMsg(),ExceptionCode.DECRYPTION_ERROR.getCode());
		} catch (ShortBufferException e) {
			e.printStackTrace();
			throw new BusinessException(
				ExceptionCode.DECRYPTION_ERROR.getMsg(),ExceptionCode.DECRYPTION_ERROR.getCode());
		} 
		return verifySign;
	}
	
	/**
	 * 解密数据
	 * @param data 加密数据包
	 * @param sysKey 报文中存放临时秘钥的属性名称
	 * @param publicKey 公钥
	 */
	public static String decryDate(String sysKey,String publicKey,String data){
		try {
			
			byte[] sysKeyByte = RsaUtil.decryptWithPublicKey(Base64.decode(sysKey), Base64.decode(publicKey));
			data = new String(Blowfish.decrypt(Base64.decode(data), sysKeyByte),"UTF-8");
			
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			throw new BusinessException(
					ExceptionCode.KEY_INVALID.getMsg(),ExceptionCode.KEY_INVALID.getCode());
		} catch ( IllegalBlockSizeException| BadPaddingException | NoSuchPaddingException e) {
			e.printStackTrace();
			throw new BusinessException(
					ExceptionCode.CIPHERTEXT_ILLEGAL.getMsg(),ExceptionCode.CIPHERTEXT_ILLEGAL.getCode());
		} catch (InvalidAlgorithmParameterException | InvalidKeySpecException
				| NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();
			throw new BusinessException(
					ExceptionCode.DECRYPTION_ERROR.getMsg(),ExceptionCode.DECRYPTION_ERROR.getCode());
		} catch (ShortBufferException e) {
			e.printStackTrace();
			throw new BusinessException(
					ExceptionCode.DECRYPTION_ERROR.getMsg(),ExceptionCode.DECRYPTION_ERROR.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return data;
	}

}
