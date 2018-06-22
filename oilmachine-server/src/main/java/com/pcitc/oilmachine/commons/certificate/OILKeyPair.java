package com.pcitc.oilmachine.commons.certificate;

import java.security.PrivateKey;
import java.security.PublicKey;

import org.apache.commons.codec.binary.Base64;

public class OILKeyPair {
	
	private PublicKey publicKey;
	private PrivateKey privateKey;
	
	public OILKeyPair(PublicKey publicKey,PrivateKey privateKey){
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}
	 
	public PublicKey getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}
	
	/**
	 * 获取私钥byte数组
	 * @return
	 */
	public byte[] getBytePrivateKey(){
		return privateKey.getEncoded();
	}
	/**
	 * 获取公钥byte数组
	 * @return
	 */
	public byte[] getBytePublicKey(){
		return publicKey.getEncoded();
	}
	/**
	 * 获取经过Base64编码的私钥
	 */
	public String getBase64PrivateKey(){
		return Base64.encodeBase64String(getBytePrivateKey());
	}
	/**
	 * 获取经过Base64编码的公钥
	 */
	public String getBase64PublicKey(){
		return Base64.encodeBase64String(getBytePublicKey());
	}
	 
	 
	 
}
