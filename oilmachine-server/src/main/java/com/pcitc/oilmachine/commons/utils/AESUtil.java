package com.pcitc.oilmachine.commons.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.thoughtworks.xstream.core.util.Base64Encoder;

/**
 * @version V1.0
 * @desc AES 加密工具类
 */
public class AESUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法
    

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密

            return Base64.encodeBase64String(result);//通过Base64转码返回
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));

            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));

            return new String(result, "utf-8");
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
    	return new SecretKeySpec(Base64.decodeBase64(password), KEY_ALGORITHM);// 转换为AES专用密钥
    }
    
    public static byte[] getSecretKeyByte(final String password){
    	String key = getSecretKeyStr(password);
    	return Base64.decodeBase64(key);
    }
    
    public static String getSecretKeyStr(final String password){
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);

            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            //AES 要求密钥长度为 128
            kg.init(128, random);

            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
           return Base64.encodeBase64String(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    

    public static void main(String[] args) throws Exception{
    	/*String s = "{\"tenantId\":\"f652e66ac0714627aa66c58471455680\",\"serviceCode\":\"com.pcitc.oilmachine.service.mobile.UserAuthenticationService\"}";
        String s1 = AESUtil.encrypt(s, "1234567891234567891234");
        System.out.println("s1:" + s1);*/
        String s1 = "XyVM5BrrWxpSLWdrW98qZMhnypW015vXN6BM6fPYcWvKeBkjeLgQRZJ6/5Uhxe/HUl4TPcbUrf/LCrxDPKscMFNH6fY7mm+LoPfQBiMEJtCd/n7ne+U2ylNVrye/HAtmc9uQBvLKhYFsT759d+IbLC/9eAVVkfSBgPDmgd7abHE=";
        System.out.println(AESUtil.decrypt(s1, "XadWaEHHdZvK8bDJUi+4kg=="));
        
        System.out.println(getSecretKeyStr("1234567891234567891234"));
        

    }

}