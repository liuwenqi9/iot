package com.pcitc.oilmachine.commons.utils;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

/**
 * 使用RSA进行加解�?
 * @author CZLQ
 *
 */
public class RsaUtil {

	/**
	 * 使用私钥进行加密
	 * @param data 数据
	 * @param privateKey 私钥
	 * @return 加密后的数据
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws ShortBufferException 
	 */
	public static byte[] encryptWithPrivateKey(byte[] data, PrivateKey privateKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, 
			NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		int bytesChunkLength = 100;
		int decryptedChunksNo = (data.length - 1) / bytesChunkLength + 1;
		int encryptedBytesChunkLength = 256;
		int encryptedBytesLength = decryptedChunksNo * encryptedBytesChunkLength;
		byte[] encryptedFileBytes = new byte[encryptedBytesLength];
		int decryptedByteIndex = 0, encryptedByteIndex = 0;
		for (int i = 0; i < decryptedChunksNo; i++) {
			if (i < decryptedChunksNo - 1) {
				encryptedByteIndex = encryptedByteIndex
						+ cipher.doFinal(data,
								decryptedByteIndex,
								bytesChunkLength,
								encryptedFileBytes, encryptedByteIndex);
				decryptedByteIndex = decryptedByteIndex
						+ bytesChunkLength;
			} else {
				cipher.doFinal(data, decryptedByteIndex,
						data.length - decryptedByteIndex,
						encryptedFileBytes, encryptedByteIndex);
			}
		}
		return encryptedFileBytes;
	}
	
	/**
	 * 使用私钥进行加密
	 * @param data 数据
	 * @param privateKey 私钥
	 * @return 加密后的数据
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static byte[] encryptWithPrivateKey(byte[] data, byte[] privateKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, 
			NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory keyFactoryDecrypt = KeyFactory.getInstance("RSA");
		return encryptWithPrivateKey(data, keyFactoryDecrypt.generatePrivate(keySpec));
	}
	
	/**
	 * 使用私钥进行加密(仅限明文为字符串时使�?)
	 * @param data 数据
	 * @param privateKey 私钥
	 * @return 加密后的数据
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static byte[] encryptWithPrivateKey(String data, byte[] privateKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, 
			InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		return encryptWithPrivateKey(data.getBytes(), privateKey);
	}
	
	/**
	 * 使用公钥进行加密
	 * @param data 数据
	 * @param publicKey 公钥
	 * @return 加密后的数据
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws ShortBufferException 
	 */
	public static byte[] encryptWithPublicKey(byte[] data, PublicKey publicKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, 
			NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		int bytesChunkLength = 100;
		int decryptedChunksNo = (data.length - 1) / bytesChunkLength + 1;
		int encryptedBytesChunkLength = 256;
		int encryptedBytesLength = decryptedChunksNo * encryptedBytesChunkLength;
		byte[] encryptedFileBytes = new byte[encryptedBytesLength];
		int decryptedByteIndex = 0,encryptedByteIndex = 0;
		for (int i = 0; i < decryptedChunksNo; i++) {
			if (i < decryptedChunksNo - 1) {
				encryptedByteIndex = encryptedByteIndex
						+ cipher.doFinal(data,
								decryptedByteIndex,
								bytesChunkLength,
								encryptedFileBytes, encryptedByteIndex);
				decryptedByteIndex = decryptedByteIndex
						+ bytesChunkLength;
			} else {
				cipher.doFinal(data, decryptedByteIndex,
						data.length - decryptedByteIndex,
						encryptedFileBytes, encryptedByteIndex);
			}
		}
		return encryptedFileBytes;
	}
	
	/**
	 * 使用公钥进行加密
	 * @param data 数据
	 * @param publicKey 公钥
	 * @return 加密后的数据
	 * @throws InvalidKeySpecException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static byte[] encryptWithPublicKey(byte[] data, byte[] publicKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, 
			InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return encryptWithPublicKey(data, keyFactory.generatePublic(x509KeySpec));
	}
	
	/**
	 * 使用公钥进行加密(仅限明文为字符串时使�?)
	 * @param data 数据
	 * @param publicKey 公钥
	 * @return 加密后的数据
	 * @throws InvalidKeySpecException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static byte[] encryptWithPublicKey(String data, byte[] publicKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, 
			InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		return encryptWithPublicKey(data.getBytes(), publicKey);
	}
	
	/**
	 * 使用私钥进行解密
	 * @param data 加密数据
	 * @param privateKey 私钥
	 * @return 明文数据
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws ShortBufferException 
	 */
	public static byte[] decryptWithPrivateKey(byte[] data, PrivateKey privateKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, 
			NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		int bytesChunkLength = 256, dlength = data.length;
		int numberOfEncryptedChunks = dlength / bytesChunkLength;
		int decryptedBytesLength = numberOfEncryptedChunks * bytesChunkLength;
		byte[] decryptedFileBytes = new byte[decryptedBytesLength];
		int decryptedByteIndex = 0, encryptedByteIndex = 0;
		for (int i = 0; i < numberOfEncryptedChunks; i++) {
			if (i < numberOfEncryptedChunks - 1) {
				decryptedByteIndex = decryptedByteIndex
						+ cipher.doFinal(data,
								encryptedByteIndex,
								bytesChunkLength,
								decryptedFileBytes, decryptedByteIndex);
				encryptedByteIndex = encryptedByteIndex
						+ bytesChunkLength;
			} else {
				decryptedByteIndex = decryptedByteIndex
						+ cipher.doFinal(data,
								encryptedByteIndex,
								dlength
										- encryptedByteIndex,
								decryptedFileBytes, decryptedByteIndex);
			}
		}
		int dl = decryptedFileBytes.length;
		for(int i = decryptedFileBytes.length - 1; i > -1; --i) {
			if(decryptedFileBytes[i] == 0) {
				dl -= 1;
			} else {
				break;
			}
		}
		byte[] rebytearray = new byte[dl];
		System.arraycopy(decryptedFileBytes, 0, rebytearray, 0, dl);
		return rebytearray;
	}
	
	/**
	 * 使用私钥进行解密
	 * @param data 加密数据
	 * @param privateKey 私钥
	 * @return 明文数据
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static byte[] decryptWithPrivateKey(byte[] data, byte[] privateKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, 
			InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory keyFactoryDecrypt = KeyFactory.getInstance("RSA");
		return decryptWithPrivateKey(data, keyFactoryDecrypt.generatePrivate(keySpec));
	}
	
	/**
	 * 使用私钥进行解密(仅限明文为字符串时使�?)
	 * @param data 加密数据
	 * @param privateKey 私钥
	 * @return 明文数据
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static String decryptWithPrivateKeyForString(byte[] data, byte[] privateKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, 
			NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		return new String(decryptWithPrivateKey(data, privateKey)).trim();
	}
	
	/**
	 * 使用公钥进行解密
	 * @param data 加密数据
	 * @param publicKey 公钥
	 * @return 明文数据
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws ShortBufferException 
	 */
	public static byte[] decryptWithPublicKey(byte[] data, PublicKey publicKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, 
			NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		int bytesChunkLength = 256, dlength = data.length;
		int numberOfEncryptedChunks = dlength / bytesChunkLength;
		int decryptedBytesLength = numberOfEncryptedChunks * bytesChunkLength;
		byte[] decryptedFileBytes = new byte[decryptedBytesLength];
		int decryptedByteIndex = 0, encryptedByteIndex = 0;
		for (int i = 0; i < numberOfEncryptedChunks; i++) {
			if (i < numberOfEncryptedChunks - 1) {
				decryptedByteIndex = decryptedByteIndex
						+ cipher.doFinal(data,
								encryptedByteIndex,
								bytesChunkLength,
								decryptedFileBytes, decryptedByteIndex);
				encryptedByteIndex = encryptedByteIndex
						+ bytesChunkLength;
			} else {
				decryptedByteIndex = decryptedByteIndex
						+ cipher.doFinal(data,
								encryptedByteIndex,
								dlength
										- encryptedByteIndex,
								decryptedFileBytes, decryptedByteIndex);
			}
		}
		int dl = decryptedFileBytes.length;
		for(int i = decryptedFileBytes.length - 1; i > -1; --i) {
			if(decryptedFileBytes[i] == 0) {
				dl -= 1;
			} else {
				break;
			}
		}
		byte[] rebytearray = new byte[dl];
		System.arraycopy(decryptedFileBytes, 0, rebytearray, 0, dl);
		return rebytearray;
	}
	
	
	/**
	 * 使用公钥进行解密
	 * @param data 加密数据
	 * @param publicKey 公钥
	 * @return 明文数据
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static byte[] decryptWithPublicKey(byte[] data, byte[] publicKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, 
			InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return decryptWithPublicKey(data, keyFactory .generatePublic(x509KeySpec));
	}
	
	/**
	 * 使用公钥进行解密(仅限明文为字符串时使�?)
	 * @param data 加密数据
	 * @param publicKey 公钥
	 * @return 明文数据
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static String decryptWithPublicKeyForString(byte[] data, byte[] publicKey) throws InvalidKeyException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, 
			InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		return new String(decryptWithPublicKey(data, publicKey)).trim();
	}
	
}
