package com.pcitc.oilmachine.commons.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * 使用Blowfish进行加解密
 * @author CZLQ
 *
 */
public class Blowfish {
	
	/**
	 * 创建秘钥
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static Key generateKey() throws NoSuchAlgorithmException {
		return generateKey(128);
	}
	
	/**
	 * 创建秘钥
	 * @param arg0 秘钥长度
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static Key generateKey(int arg0) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
		keyGenerator.init(arg0);
		Key key = null;
		byte[] b = null;
		do {
			key = keyGenerator.generateKey();
			b = key.getEncoded();
		} while (b[b.length - 1] == 0);
		return key;
	}
	
	/**
	 * 将数组秘钥转换为Key秘钥
	 * @param key 秘钥
	 * @return
	 */
	public static Key convertKey(byte[] key) {
		return new SecretKeySpec(key, "Blowfish"); 
	}
	
	/**
	 * 加密
	 * @param data 数据
	 * @param key 秘钥
	 * @return 加密后的数据
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	public static byte[] encrypt(byte[] data, Key key) throws NoSuchAlgorithmException, 
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] bKey = key.getEncoded();
		if(bKey[bKey.length - 1] == 0) {
			new InvalidKeyException("The key end by ZERO!");
		}
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(data);
	}
	
	/**
	 * 加密
	 * @param data 数据
	 * @param key 秘钥
	 * @return 加密后的数据
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] encrypt(byte[] data, byte[] key) throws NoSuchAlgorithmException, 
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		return encrypt(data, convertKey(key));
	}
	
	/**
	 * 解密
	 * @param data 加密的数据
	 * @param key 秘钥
	 * @return 解密后的数据
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	public static byte[] decrypt(byte[] data, Key key) throws NoSuchAlgorithmException, 
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipherDecrypt = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
		return cipherDecrypt.doFinal(data);
	}
	
	/**
	 * 解密
	 * @param data 加密的数据
	 * @param key 秘钥
	 * @return 解密后的数据
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	public static byte[] decrypt(byte[] data, byte[] key) throws NoSuchAlgorithmException, 
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		return decrypt(data, convertKey(key));
	}

}
