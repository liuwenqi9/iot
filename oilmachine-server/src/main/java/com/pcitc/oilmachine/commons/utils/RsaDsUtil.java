package com.pcitc.oilmachine.commons.utils;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


/**
 * 使用ECDSA进行签名或签名校�?
 * @author CZLQ
 *
 */
public class RsaDsUtil {
	
	/**
	 * 签名
	 * @param data 数据
	 * @param privateKey 私钥
	 * @return 签名
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 */
	public static byte[] sign(byte[] data, PrivateKey privateKey) throws NoSuchAlgorithmException, 
			InvalidKeyException, SignatureException {
		Signature signature = Signature.getInstance("SHA512withRSA");
		signature.initSign(privateKey);
		signature.update(data);
		return signature.sign();
	}
	
	/**
	 * 签名
	 * @param data 数据
	 * @param privateKey 私钥
	 * @return 签名
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 * @throws InvalidKeySpecException
	 */
	public static byte[] sign(byte[] data, byte[] privateKey) throws NoSuchAlgorithmException, 
			InvalidKeyException, SignatureException, InvalidKeySpecException {
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return sign(data, (PrivateKey) keyFactory.generatePrivate(pkcs8EncodedKeySpec));
	}
	
	/**
	 * 签名校验
	 * @param data 数据
	 * @param sign 签名
	 * @param publicKey 公钥
	 * @return 校验结果
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 */
	public static boolean verify(byte[] data, byte[] sign, PublicKey publicKey) throws NoSuchAlgorithmException, 
			InvalidKeyException, SignatureException {
		Signature signature = Signature.getInstance("SHA512withRSA");
		signature.initVerify(publicKey);
		signature.update(data);
		return signature.verify(sign);
	}
	
	/**
	 * 签名校验
	 * @param data 数据
	 * @param sign 签名
	 * @param publicKey 公钥
	 * @return 校验结果
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 * @throws InvalidKeySpecException
	 */
	public static boolean verify(byte[] data, byte[] sign, byte[] publicKey) throws NoSuchAlgorithmException, 
			InvalidKeyException, SignatureException, InvalidKeySpecException {
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return verify(data, sign, keyFactory.generatePublic(x509EncodedKeySpec));
	}

}
