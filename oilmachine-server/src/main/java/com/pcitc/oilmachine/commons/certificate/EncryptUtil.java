package com.pcitc.oilmachine.commons.certificate;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class EncryptUtil {
	static {
		// 系统添加BC加密算法 以后系统中调用的算法都是BC的算法
		Security.addProvider(new BouncyCastleProvider());
	}
	/**
	 * 加密算法RSA
	 */
	public static final String KEY_ALGORITHM = "RSA";

	/**
	 * 签名算法
	 */
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	/**
	 * 获取公钥的key
	 */
	//private static final String PUBLIC_KEY = "RSAPublicKey";

	/**
	 * 获取私钥的key
	 */
	//private static final String PRIVATE_KEY = "RSAPrivateKey";

	/**
	 * RSA最大加密明文大小
	 */
	private static final int MAX_ENCRYPT_BLOCK = 117;

	/**
	 * RSA最大解密密文大小
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;
	/**
	 * 字符编码
	 */
	//private static final String DEFAULT_CHAR_SET = "UTF-8";

	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	public static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";

	public static final String CIPHER_ALGORITHM_CBC_NO = "AES/CBC/NoPadding";

	/**   
	 * 用私钥对信息生成数字签名    
	 *   
	 * @param data 已加密数据  
	 * @param privateKey  私钥(Base64编码)  
	 * @return  
	 * @throws Exception  
	 */
	public static String sign(String data, String privateKey) throws Exception {
		return sign(data.getBytes("UTF-8"), privateKey);
	}

	public static String sign(byte[] data, String privateKey) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateK);
		signature.update(data);
		return Base64.encodeBase64String(signature.sign());
	}

	/**
	 * 校验数字签名
	 * @param data 已加密数据
	 * @param publicKey 公钥(Base64编码)
	 * @param sign 数字签名 
	 * @return
	 * @throws Exception
	 * 
	 */
	public static boolean verify(String data, String publicKey, String sign) throws Exception {
		return verify(data.getBytes("UTF-8"), publicKey, sign);
	}

	public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(publicKey);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicK = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicK);
		signature.update(data);
		return signature.verify(Base64.decodeBase64(sign));
	}

	/**
	 * 私钥解密
	 * @param encryptedData 已加密数据
	 * @param privateKey私钥(Base64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(String encryptedData, String privateKey) throws Exception {
		return decryptByPrivateKey(encryptedData.getBytes(), privateKey);
	}

	public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;
	}

	/**
	 * 公钥解密
	 * @param encryptedData 已加密数据
	 * @param publicKey 公钥(Base64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(String encryptedData, String publicKey) throws Exception {
		return decryptByPublicKey(encryptedData.getBytes(), publicKey);
	}

	public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;
	}

	/**
	 * 公钥加密
	 * @param data 源数据
	 * @param publicKey公钥(Base64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(String data, String publicKey) throws Exception {
		return encryptByPublicKey(data.getBytes(), publicKey);
	}

	public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;
	}

	/**
	 * @param data 源数据
	 * @param privateKey 私钥(Base64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(String data, String privateKey) throws Exception {
		return encryptByPrivateKey(data.getBytes(), privateKey);
	}

	public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;
	}

	/**
	* AES加密
	* @param sSrc
	* @param sKey
	* @return
	* @throws Exception
	*/
	public static byte[] encryptBCB(String sSrc, String sKey) throws Exception {
		if (sKey == null || sKey.length() != 22) {
			System.out.print("Key不合法");
			return null;
		}
		byte[] raw = Base64.decodeBase64(sKey + "=");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
		IvParameterSpec iv = new IvParameterSpec(raw);
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes("UTF-8"));

		return encrypted;
	}
	 // decode后aes解密
    public static String decryptBCB(String sSrc, String sKey) throws Exception {
    	return decryptBCB(Base64.decodeBase64(sSrc),sKey);
    }
    // 解密
    public static String decryptBCB(byte[] sSrc, String sKey) throws Exception {
        try {
        	 if (sKey == null || sKey.length() != 22) {
                 return null;
             }
            
            byte[] raw = Base64.decodeBase64(sKey+"=");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
            IvParameterSpec iv = new IvParameterSpec(raw);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            try {
                byte[] original = cipher.doFinal(sSrc);
                String originalString = new String(original,"UTF-8");
                return originalString;
            } catch (Exception e) {
            	e.printStackTrace();
                return null;
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
            return null;
        }
    }
    /**
	 * 构造签名
	 * 
	 * @param params
	 * @param encode
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String createSign(Map<String, Object> params, boolean encode) throws UnsupportedEncodingException {
		Set<String> keysSet = params.keySet();
		Object[] keys = keysSet.toArray();
		Arrays.sort(keys);
		StringBuffer temp = new StringBuffer();
		boolean first = true;
		for (Object key : keys) {
			Object value = params.get(key);
			String valueString = "";
			if (null != value && !"".equals(value.toString().trim())) {
				if (first) {
					first = false;
				} else {
					temp.append("&");
				}
				temp.append(key).append("=");
				/*if(value instanceof List || value instanceof Map || value instanceof DUserInfo || value instanceof DCardInfo || value instanceof DAccount){
					valueString = JSON.toJSONString(value);
				}else{
					valueString = value.toString();
				}*/
				valueString = value.toString();
			}
			if (encode) {
				temp.append(URLEncoder.encode(valueString, "UTF-8"));
			} else {
				temp.append(valueString);
			}
		}
		return temp.toString();
	}
	
	public static OILKeyPair getKeyPair() throws NoSuchAlgorithmException{
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	    keyGen.initialize(1024);
	    KeyPair pair = keyGen.generateKeyPair();
        OILKeyPair oileyPair = new OILKeyPair(pair.getPublic(),pair.getPrivate());
        return oileyPair;
 }
}
