package com.pcitc.oilmachine.service.aliyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import sun.misc.BASE64Encoder;

@Service
public class AESDecode {
	 
	final static String ak_id1 = "LTAI2wXIKvvbNpRI"; //用户ak
	final static String ak_secret1 = "6j27fyF96pEAGz2TgaCn1eK5kxs1S9"; // 用户ak_secret
	final static String url = "https://dtplus-cn-shanghai.data.aliyuncs.com/face/verify";//人脸比对----后付费！
    
	/*
     * 计算MD5+BASE64
     */
    public static String MD5Base64(String s) {
        if (s == null)
            return null;
        String encodeStr = "";
        byte[] utfBytes = s.getBytes();
        MessageDigest mdTemp;
        try {
            mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(utfBytes);
            byte[] md5Bytes = mdTemp.digest();
            BASE64Encoder b64Encoder = new BASE64Encoder();
            encodeStr = b64Encoder.encode(md5Bytes);
        } catch (Exception e) {
            throw new Error("Failed to generate MD5 : " + e.getMessage());
        }
        return encodeStr;
    }
    /*
     * 计算 HMAC-SHA1
     */
    public static String HMACSha1(String data, String key) {
        String result;
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            result = (new BASE64Encoder()).encode(rawHmac);
        } catch (Exception e) {
            throw new Error("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }
    /*
     * 等同于javaScript中的 new Date().toUTCString();
     */
    public static String toGMTString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
        df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return df.format(date);
    }
    /*
     * 发送POST请求
     */
    public static String sendPost(String url, String body, String ak_id, String ak_secret) throws Exception {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        int statusCode = 200;
        try {
            URL realUrl = new URL(url);
            /*
             * http header 参数
             */
            String method = "POST";
            String accept = "application/json";
            String content_type = "application/json";
            String path = realUrl.getFile();
            String date = toGMTString(new Date());
            // 1.对body做MD5+BASE64加密
            String bodyMd5 = MD5Base64(body);
            String stringToSign = method + "\n" + accept + "\n" + bodyMd5 + "\n" + content_type + "\n" + date + "\n"
                    + path;
            // 2.计算 HMAC-SHA1
            String signature = HMACSha1(stringToSign, ak_secret);
            // 3.得到 authorization header
            String authHeader = "Dataplus " + ak_id + ":" + signature;
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", accept);
            conn.setRequestProperty("content-type", content_type);
            conn.setRequestProperty("date", date);
            conn.setRequestProperty("Authorization", authHeader);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(body);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            statusCode = ((HttpURLConnection)conn).getResponseCode();
            if(statusCode != 200) {
                in = new BufferedReader(new InputStreamReader(((HttpURLConnection)conn).getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (statusCode != 200) {
            throw new IOException("\nHttp StatusCode: "+ statusCode + "\nErrorMessage: " + result);
        }
        return result;
    }
    /*
     * GET请求
     */
    public static String sendGet(String url, String ak_id, String ak_secret) throws Exception {
        String result = "";
        BufferedReader in = null;
        int statusCode = 200;
        try {
            URL realUrl = new URL(url);
            /*
             * http header 参数
             */
            String method = "GET";
            String accept = "application/json";
            String content_type = "application/json";
            String path = realUrl.getFile();
            String date = toGMTString(new Date());
            // 1.对body做MD5+BASE64加密
            // String bodyMd5 = MD5Base64(body);
            String stringToSign = method + "\n" + accept + "\n" + "" + "\n" + content_type + "\n" + date + "\n" + path;
            // 2.计算 HMAC-SHA1
            String signature = HMACSha1(stringToSign, ak_secret);
            // 3.得到 authorization header
            String authHeader = "Dataplus " + ak_id + ":" + signature;
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", accept);
            connection.setRequestProperty("content-type", content_type);
            connection.setRequestProperty("date", date);
            connection.setRequestProperty("Authorization", authHeader);
            connection.setRequestProperty("Connection", "keep-alive");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            statusCode = ((HttpURLConnection)connection).getResponseCode();
            if(statusCode != 200) {
                in = new BufferedReader(new InputStreamReader(((HttpURLConnection)connection).getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statusCode != 200) {
            throw new IOException("\nHttp StatusCode: "+ statusCode + "\nErrorMessage: " + result);
        }
        return result;
    }
   
    /**
     * 人脸比对
     * @param url1
     * @param url2
     * @return
     */
    public static String FaceVerify(String url1, String url2){
    	JSONObject json = new JSONObject();
        try {
        	String body = "{\"type\":\"0\",\"image_url_1\": \""+url1+"\", \"image_url_2\":\""+url2+"\"}";
			String str = sendPost(url, body, ak_id1, ak_secret1);
			com.alibaba.fastjson.JSONObject parseObject = com.alibaba.fastjson.JSONObject.parseObject(str);
			System.out.println("parseObject="+parseObject);
			String confidence = parseObject.getString("confidence");
			System.out.println("confidence="+confidence);
			if(confidence != null){
				Integer valueOf = Integer.valueOf(confidence);
				if(valueOf > 85){
					json.put("success", true);
					json.put("msg", "同一人，置信度：" + confidence);
				}else{
					json.put("success", false);
					json.put("msg", "不是同一人，相似度：" + confidence);
				}
			}else{
				json.put("success", false);
	    		json.put("msg", "返回值错误！");
			}
		} catch (Exception e) {
			json.put("success", false);
    		json.put("msg", e.getMessage());
			e.printStackTrace();
		}
        return json.toString();
    }
    
    /**
     * 人脸查找
     * @param url1
     * @return
     */
    public static String FaceSearch(String url1){
    	JSONObject json = new JSONObject();
    	try {
    		//人脸库
    		List<String> listURL = new ArrayList<String>();
    		listURL.add("http://crm.efueloil.cn/iot/60/65ff1c7309754d218159eae173530ce3.jpg");
    		listURL.add("http://crm.efueloil.cn/iot/118/7dba451aec7a45d49448ddfa0261a919.jpg");
    		if(listURL.size() > 0){
    			String returnStr = "";
    			List<String> relist = new ArrayList<String>();
	    		for (String url2 : listURL) {
	    			String body = "{\"type\":\"0\",\"image_url_1\": \""+url1+"\", \"image_url_2\":\""+url2+"\"}";
					returnStr = sendPost(url, body, ak_id1, ak_secret1);
	    			System.out.println("response body:" + returnStr);
	    			com.alibaba.fastjson.JSONObject parseObject = com.alibaba.fastjson.JSONObject.parseObject(returnStr);
	    			System.out.println("parseObject="+parseObject);
	    			String confidence = parseObject.getString("confidence");
	    			System.out.println("confidence="+confidence);
	    			if(confidence != null){
	    				String split = confidence.substring(0, confidence.indexOf("."));
						Integer valueOf = Integer.valueOf(split);
	    				if(valueOf > 85){
	    					relist.add(url2);
	    				}
	    			}
	    		}
	    		if(relist.size() > 0){
	    			json.put("success", true);
	    			json.put("msg", relist);
	    		}else{
	    			json.put("success", false);
	        		json.put("msg", "未找到相同用户。");
	    		}
	    	}else{
	    		json.put("success", false);
	    		json.put("msg", "数据库为空！");
	    	}
    	} catch (Exception e) {
    		json.put("success", false);
    		json.put("msg", e.getMessage());
    		e.printStackTrace();
    	}
        return json.toString();
    }
    
    public static void main(String[] args) throws Exception {
        
    	// 发送POST请求示例
        /*String ak_id1 = "LTAI2wXIKvvbNpRI"; //用户ak
        String ak_secret1 = "6j27fyF96pEAGz2TgaCn1eK5kxs1S9"; // 用户ak_secret
        String url = "https://dtplus-cn-shanghai.data.aliyuncs.com/face/verify";//人脸比对
        String body = "{\"type\":\"0\",\"image_url_1\": \"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2766206122,2168701153&fm=27&gp=0.jpg\", \"image_url_2\":\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3805283330,2252868156&fm=27&gp=0.jpg\"}";
        String sendPost = sendPost(url, body, ak_id1, ak_secret1);
		System.out.println("response body:" + sendPost);
		com.alibaba.fastjson.JSONObject parseObject = com.alibaba.fastjson.JSONObject.parseObject(sendPost);
		System.out.println("parseObject="+parseObject);
		String confidence = parseObject.getString("confidence");
		System.out.println("confidence="+confidence);*/
		
        // 发送GET请求
        /*String ak_id1 = "NMV.............5jv"; //用户ak
        String ak_secret1 = "Fgs...............3zu"; // 用户ak_secret
        String url1 = "https://shujuapi.aliyun.com/org_code/service_code/api_name?param1=xxx&param2=xxx";
        System.out.println("response body:" + sendGet(url1, ak_id1, ak_secret1));*/
		String url2 = "http://crm.efueloil.cn/iot/118/7dba451aec7a45d49448ddfa0261a919.jpg";
		System.out.println("返回参数："+FaceSearch(url2));
        
    }
}
