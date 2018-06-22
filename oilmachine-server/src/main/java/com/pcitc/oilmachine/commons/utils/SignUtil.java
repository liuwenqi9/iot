package com.pcitc.oilmachine.commons.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 签名算法工具类
 * 
 * @author 王少亭
 */
public class SignUtil {
	
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	/**
	 * MD5加密签名
	 * 
	 * @param params
	 *            参数信息
	 * @param paternerKey
	 *            商户交易秘钥
	 * @return String 签名结果
	 * @throws UnsupportedEncodingException
	 */
	public static String md5Sign(Map<String, Object> params, String paternerKey) throws UnsupportedEncodingException {
		String string1 = createSign(params, false);
		String stringSignTemp = string1 + "&key=" + paternerKey;
		String signValue = DigestUtils.md5Hex(stringSignTemp).toUpperCase();
		return signValue;
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
				if(value instanceof List || value instanceof Map ){
					valueString = JSON.toJSONString(value);
				}else{
					valueString = value.toString();
				}
			}
			if (encode) {
				temp.append(URLEncoder.encode(valueString, Constant.DEFAULT_CHAR_SET));
			} else {
				temp.append(valueString);
			}
		}
		return temp.toString();
	}
	
	/**
	 * RSA生成签名
	 * @author 王少亭
	 * @param content 待加签串
	 * @param privateKey 私钥
	 * @return
	 * 2017年3月9日下午3:46:22
	 */
	public static String rsaSign(Map<String, Object> params, String privateKey) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

			signature.initSign(priKey);
			
			String content = createSign(params,true);
			signature.update(content.getBytes(Constant.DEFAULT_CHAR_SET));

			byte[] signed = signature.sign();

			return Base64.encode(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * RSA验证签名
	 * @author 王少亭
	 * @param params
	 * @param sign
	 * @param ali_public_key
	 * @return
	 * 2017年3月13日上午9:36:50
	 */
	public static boolean rsaVerify(Map<String, Object> params, String sign, String ali_public_key) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			byte[] encodedKey = Base64.decode(ali_public_key);
			PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

			signature.initVerify(pubKey);
			
			String content = createSign(params,true);
			signature.update(content.getBytes(Constant.DEFAULT_CHAR_SET));

			boolean bverify = signature.verify(Base64.decode(sign));
			return bverify;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	/**
	 * MD5加密签名
	 * @param json json数据
	 * @param paternerKey 商户交易秘钥
	 * @param exclude 不需要加入签名的数据
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String md5Sign(JSONObject json, String paternerKey, String[] exclude) throws UnsupportedEncodingException {
		if(paternerKey == null) {
			paternerKey = "";
		}
		Set<String> keys = json.keySet();
		List<String> excludeList = null;
		if(exclude != null && exclude.length > 0) {
			excludeList = Arrays.asList(exclude);
		} else {
			excludeList = new ArrayList<String>();
		}
		Map<String, Object> params = new TreeMap<String, Object>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for(String key : keys) {
			if(null == key || "".endsWith(key) || excludeList.contains(key)) {
				continue;
			}
			params.put(key, json.get(key));
		}
		String string1 = createSign(params, false);
		String stringSignTemp = string1 + "&key=" + paternerKey;
		String signValue = DigestUtils.md5Hex(stringSignTemp).toUpperCase();
		return signValue;
	}
	
	/**
	 * 使用私钥校验签名
	 * @param jsonData 报文
	 * @param signKey 报文中签名的Key
	 * @param privateKey 私钥
	 * @param paternerKey 商户交易秘钥
	 * @param exclude 不需要加入签名的数据Key
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static boolean jsonVerifyWithPrivateKey(JSONObject jsonData, String signKey, String privateKey, 
				String paternerKey, String[] exclude) throws UnsupportedEncodingException, InvalidKeyException, 
				InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, 
				NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		if(exclude == null || exclude.length < 1) {
			exclude = new String[] {signKey};
		} else if(!Arrays.asList(exclude).contains(signKey)){
			String[] _t = new String[exclude.length + 1];
			System.arraycopy(exclude, 0, _t, 0, exclude.length);
			_t[exclude.length] = signKey;
			exclude = _t;
		}
		String ecsign = jsonData.getString(signKey);
		String md5sign = md5Sign(jsonData, paternerKey, exclude);
		String decryptedSign = RsaUtil.decryptWithPrivateKeyForString(Base64.decode(ecsign), Base64.decode(privateKey));
		return md5sign.equals(decryptedSign);
	}
	
	/**
	 * 使用私钥对报文进行签名
	 * @param jsonData 数据
	 * @param signKey 报文中签名的Key
	 * @param privateKey 私钥
	 * @param paternerKey 商户交易秘钥
	 * @param exclude 不需要加入签名的数据Key
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static String jsonSignWithPrivateKey(JSONObject jsonData, String privateKey, String paternerKey, 
			String[] exclude) throws UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException, 
			IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		String md5sign = md5Sign(jsonData, paternerKey, exclude);
		return Base64.encode(RsaUtil.encryptWithPrivateKey(md5sign, Base64.decode(privateKey)));
	}
	
	
	/**
	 * 使用公钥校验签名
	 * @param jsonData 报文
	 * @param signKey 报文中签名的Key
	 * @param privateKey 私钥
	 * @param paternerKey 商户交易秘钥
	 * @param exclude 不需要加入签名的数据Key
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static boolean jsonVerifyWithPublicKey(JSONObject jsonData, String signKey, String publicKey, 
				String paternerKey, String[] exclude) throws UnsupportedEncodingException, InvalidKeyException, 
				InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, 
				NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		if(exclude == null || exclude.length < 1) {
			exclude = new String[] {signKey};
		} else if(!Arrays.asList(exclude).contains(signKey)){
			String[] _t = new String[exclude.length + 1];
			System.arraycopy(exclude, 0, _t, 0, exclude.length);
			_t[exclude.length] = signKey;
			exclude = _t;
		}
		String ecsign = jsonData.getString(signKey);
		String md5sign = md5Sign(jsonData, paternerKey, exclude);
		String decryptedSign = RsaUtil.decryptWithPublicKeyForString(Base64.decode(ecsign), Base64.decode(publicKey));
		return md5sign.equals(decryptedSign);
	}
	
	/**
	 * 使用公钥对报文进行签名
	 * @param jsonData 数据
	 * @param signKey 报文中签名的Key
	 * @param privateKey 私钥
	 * @param paternerKey 商户交易秘钥
	 * @param exclude 不需要加入签名的数据Key
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws ShortBufferException 
	 */
	public static String jsonSignWithPublicKey(JSONObject jsonData, String publicKey, String paternerKey, 
			String[] exclude) throws UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException, 
			IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException {
		String md5sign = md5Sign(jsonData, paternerKey, exclude);
		return Base64.encode(RsaUtil.encryptWithPublicKey(md5sign, Base64.decode(publicKey)));
	}

}