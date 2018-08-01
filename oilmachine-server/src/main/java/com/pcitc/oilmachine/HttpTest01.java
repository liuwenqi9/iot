package com.pcitc.oilmachine;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bouncycastle.util.encoders.Base64;

import javax.imageio.stream.FileImageInputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.pcitc.oilmachine.commons.certificate.SDKUtil;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.ByteUtil;
import com.pcitc.oilmachine.commons.utils.Md5Util;
import com.pcitc.oilmachine.form.MobileDataInfo;

public class HttpTest01 {
	
	public static String publickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCT1HcDaEZG6kJzdZ6pADaME0PbIQGLtz9RLLkqXhi/e7fYP4tdPkRNRJVz9Be232i9VITlat343kY+YrlGtdmnBROLVfl4+yp1wmW+MyiySkYpPyTtJYeTWBoYpyPc3s5SmBYX3ks2eihlkfaEaCRf5ujZS550QQs43zTnynz+LwIDAQAB";
	public static String privatekey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJPUdwNoRkbqQnN1nqkANowTQ9shAYu3P1EsuSpeGL97t9g/i10+RE1ElXP0F7bfaL1UhOVq3fjeRj5iuUa12acFE4tV+Xj7KnXCZb4zKLJKRik/JO0lh5NYGhinI9zezlKYFhfeSzZ6KGWR9oRoJF/m6NlLnnRBCzjfNOfKfP4vAgMBAAECgYAMxGCy7qKDJWAv0IyvU9FiL5fAqQ0VH/Jb9FzZh97jSrAKARLsLqB/e9jcdsxFgu3szAveNGiPQcMXSDdwH+x4Gokd2VxvzeRVEDfIh0UfrZXFqXAS9UwerGR8W3EyxhzpMm3G9rqyelS1PvIV7uqhTzMrJgSYlgQtw2KqmAVG4QJBANHljJj6M2/0MEhhNV4v0Ju5kBIX0hh4GRY43lYGE14wFYBI72aBpafd3g+jBXZw9DuD8w1crf86yIxwiI7reAUCQQC0TOousQ/i849EPx5QSLbczH8oz8Gdea2ddnOr3gDlCtIzKqFMeQCVLWupy/Kv0iqjDN3eBQyELUKSEbc39LejAkBd2JqSU1voNG/aDMyFvi8xUThfPpNLKXdd/jM6lyDVvf3/C50uYc0lTwfYSfVJTZuFeKuVT9jkAu5kDHSiIhnZAkBwdHir3qv19cup2WRi1reXR8UYA1zTh40N5U+IJtOQCAvK9g/czqvaX5YDNb2MhB0rzV6kl6mS11fqGzqXn/7ZAkEAuedhuJP97N9cmWUW78le1G7lhWV/iXGQAQuKbbW2CzFBsvX7ikqooz7c6sCAU4iuKMEVdGI0GYicwd5URCT7Pw==";
	
	public static String publickey2 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC3WqqW1hE6tnkhtatG0HS5IJDTcbkQt5iivq1yL3cpqTsdsD1m88HTsza1jiKFPzC6cixHnxk9bG2IVfZX4kkRu/sinlBFQNbW96ZtS7CF66FZhE75BUVQj/wyYTS26Iq7lyRK2LNpBtl9DHg7q48AYP68SkZqF8iYUe9F/9DrbwIDAQAB";
	static String url = "http://localhost:8080/iot/mobile/HttpAppApi.do";
	//static String url = "http://10.248.245.197:8080/iot/mobile/HttpAppApi.do";
	//static String url = "http://10.177.9.168:8080/iot/mobile/HttpAppApi.do";
	static String deviceid = "105015011";
	static String stncode = "10501501";
	
	public static void main(String[] args) throws IOException {
		//getHexString
		/*byte[] bytes = ByteUtil.str2Byte("京NZK281", "GB2312");
		System.out.println(ByteUtil.getHexString(bytes));
		System.out.println(Integer.valueOf("1111",2).toString());*/
		/*byte[] bytes = ByteUtil.long2byte(3255001801l, 4);
		System.out.println(ByteUtil.getHexString(bytes));*/
		String basestr = "AAAEEgggGAcJGTMJAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAkAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADuT4Go=";
		/*
		byte[] bytes = ByteUtil.long2byte(325500181l, 4);
		System.out.println(ByteUtil.getHexString(bytes));*/
		/*getPosRecord(2);
		
		String ttypeStr = "1000";
		ttypeStr = ttypeStr.substring(ttypeStr.length()-4, ttypeStr.length());
		System.out.println(ttypeStr);*/
		/*String str = "97# 清洁汽油@97#";
		String[] gns = str.split("@");
		if(gns.length == 2) {
			System.out.println(gns[1]);
		}else {
			System.out.println(str);
		}*/
		/*String str = "10004";
		System.out.println(str.substring(3, 5));*/
		BigDecimal bvol = new BigDecimal("1").divide(new BigDecimal(100));
		System.out.println(bvol.doubleValue());
	}
	
	
	
	
	public static void main1(String[] args) throws Exception {
		System.out.println("************网点:"+stncode+"加油机:"+deviceid+"签到开始*************");
		String result = signIn(stncode,deviceid);
		JSONObject signResult = JSONObject.parseObject(result);
		int code = signResult.getIntValue("code");
		if(code == 0){
			System.out.println("************网点:"+stncode+"加油机:"+deviceid+"签到成功*************");
			String success = signResult.getString("success");
			JSONObject successResult = JSONObject.parseObject(success);
			String signid = successResult.getString("signid");
			String publickey = successResult.getString("publickey");
			System.out.println(getVehicleNOs(signid, publickey));
			System.out.println(uploadposrecord(signid, publickey));
			
			System.out.println(getVehicleNOsByphone(signid, publickey, "15010185663"));
			/*String vehicleAccessResult = vehicleAccess(signid, publickey, "京A12345",Md5Util.MD5("123456"),"1", "92", "7.5", "01", "3");
			System.out.println("vehicleAccess:"+vehicleAccessResult);
			JSONObject vehicleAccessResultJson = JSONObject.parseObject(vehicleAccessResult);
			int vehicleAccessResultJsoncode = vehicleAccessResultJson.getIntValue("code");
			if(vehicleAccessResultJsoncode == 0){
				System.out.println("************车牌认证,冻结预付款成功*************");
				String vehicleAccessSuccessStr = vehicleAccessResultJson.getString("success");
				
				JSONObject vehicleAccessSuccessStrJson = JSONObject.parseObject(vehicleAccessSuccessStr);
				String sign = vehicleAccessSuccessStrJson.getString("sign");
				String amount = vehicleAccessSuccessStrJson.getString("amount");
				String useableamount = vehicleAccessSuccessStrJson.getString("useableamount");
				String username = vehicleAccessSuccessStrJson.getString("username");
				String saleno = vehicleAccessSuccessStrJson.getString("saleno");
				String userid = vehicleAccessSuccessStrJson.getString("userid");
				String accountid = vehicleAccessSuccessStrJson.getString("accountid");
				String getLoginUserinfo = getLoginUserinfo(signid, publickey, userid, sign, saleno, accountid);
				JSONObject getLoginUserinfoJson = JSONObject.parseObject(getLoginUserinfo);
				int getLoginUserinfocode = getLoginUserinfoJson.getIntValue("code");
				if(getLoginUserinfocode == 0){
					System.out.println("************获取用户信息查看预授权结果成功,可以出油*************");
					System.out.println("用户:"+username+"***"+"账户总可用余额:"+amount+"****");
					System.out.println("本次加油最大可用金额:"+useableamount+"****");
					String gasSuccess = gasSuccess(signid, publickey, userid, sign, "115", "15", accountid, saleno);
					System.out.println("加油完成:"+gasSuccess);
				}else{
					System.out.println("************获取用户信息查看预授权结果失败,不能出油*************");
				}
			}else{
				System.out.println("************车牌认证,冻结预付款失败*************");
			}*/
		}else{
			System.out.println("************加油机签到不成功*************");
		}
	}
	
	public static void getPosRecord(int nozzleno){
		try {
					
					HttpURLConnection httpConn;
					URL url_1 = new URL(url);
					httpConn = (HttpURLConnection) url_1.openConnection();
					httpConn.setDoOutput(true);// 使用 URL 连接进行输出
					httpConn.setDoInput(true);// 使用 URL 连接进行输入
					httpConn.setUseCaches(false);// 忽略缓存
					httpConn.setRequestMethod("POST");// 设置URL请求方法
					httpConn.setConnectTimeout(15000);
					httpConn.setReadTimeout(15000);
					httpConn.setRequestProperty("Content-Type", "application/octet-stream");

					JSONObject pa1 = new JSONObject();
					//加油机签到
					pa1.put("tenantid", "f652e66ac0714627aa66c58471455680");
					pa1.put("stncode", stncode);
					//pa1.put("nozzleno", nozzleno);
					//pa1.put("deviceidconnid", deviceid);
					MobileDataInfo md = new MobileDataInfo();
					md.setData(pa1.toJSONString());
					md.setFunName("orderService,getPosRecord");
					String requestString = JSONObject.toJSONString(md);
					// 建立输出流，并写入数据
					OutputStream outputStream = httpConn.getOutputStream();
					outputStream.write(requestString.getBytes("UTF-8"));
					outputStream.flush();
					outputStream.close();
					// 获得响应状态
					int responseCode = httpConn.getResponseCode();
					if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
						StringBuffer sb = new StringBuffer();
						String readLine;
						BufferedReader responseReader;
						// 处理响应流，必须与服务器响应流输出的编码一致
						responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
						while ((readLine = responseReader.readLine()) != null) {
							sb.append(readLine);
						}
						System.out.println(sb.toString());
						responseReader.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	
	
	
	public static String gasSuccess(String signid,String publickey,String userid,String sign,String amount,String liter,String accountid,String approveId){
		String mri = null;
		try {
					HttpURLConnection httpConn;
					URL url_1 = new URL(url);
					httpConn = (HttpURLConnection) url_1.openConnection();
					httpConn.setDoOutput(true);// 使用 URL 连接进行输出
					httpConn.setDoInput(true);// 使用 URL 连接进行输入
					httpConn.setUseCaches(false);// 忽略缓存
					httpConn.setRequestMethod("POST");// 设置URL请求方法
					httpConn.setConnectTimeout(15000);
					httpConn.setReadTimeout(15000);
					httpConn.setRequestProperty("Content-Type", "application/octet-stream");

					JSONObject pa1 = new JSONObject();
					pa1.put("userid", userid);
					 pa1.put("amount", amount);
					 pa1.put("sign", sign);
					 pa1.put("liter", liter);
					 pa1.put("accountid", accountid);
					 pa1.put("saleno", approveId);
					 pa1.put("transdata", "AAAByhAgGAYGEzciAQAEERAAABRIce5rKAAAAAAAAWH2KGMAAAAAAAAAAAEAEBEQAABQlYcTEQBQlYcAAAAZABAAEQIQUgAAAAMVCAADpi4AAAAAAAAAAAAAAL/zqCg=");
					JSONObject pa2 = new JSONObject();
					pa2.put("serviceCode", "com.pcitc.oilmachine.service.mobile.UserAuthenticationService");
					pa2.put("tenantId", "f652e66ac0714627aa66c58471455680");
					MobileDataInfo md = new MobileDataInfo();
					md.setAssistdata(pa2.toJSONString());
					md.setData(pa1.toJSONString());
					md.setFunName("gasSuccess");
					md = SDKUtil.securityOReturnMsg(md, Constant.SIGNIN_SECURITY_CODE, publickey);
					md.setSignid(signid);
					
					String requestString = JSONObject.toJSONString(md);
					// 建立输出流，并写入数据
					OutputStream outputStream = httpConn.getOutputStream();
					outputStream.write(requestString.getBytes("UTF-8"));
					outputStream.flush();
					outputStream.close();
					// 获得响应状态
					int responseCode = httpConn.getResponseCode();
					if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
						StringBuffer sb = new StringBuffer();
						String readLine;
						BufferedReader responseReader;
						// 处理响应流，必须与服务器响应流输出的编码一致
						responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
						while ((readLine = responseReader.readLine()) != null) {
							sb.append(readLine);
						}
						JSONObject jso = JSONObject.parseObject(sb.toString());
						if("signIn".equals(jso.getString("funName"))){
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), "sMc2IdYJ30jEtVXiTjqGRw==");
						}else{
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), jso.getString("randomcode"), privatekey);
						}
						responseReader.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return mri;
	}
	
	public static String getLoginUserinfo(String signid,String publickey,String userid,String sign,String approveId,String accountid){
		String mri = null;
		try {
					
					HttpURLConnection httpConn;
					URL url_1 = new URL(url);
					httpConn = (HttpURLConnection) url_1.openConnection();
					httpConn.setDoOutput(true);// 使用 URL 连接进行输出
					httpConn.setDoInput(true);// 使用 URL 连接进行输入
					httpConn.setUseCaches(false);// 忽略缓存
					httpConn.setRequestMethod("POST");// 设置URL请求方法
					httpConn.setConnectTimeout(15000);
					httpConn.setReadTimeout(15000);
					httpConn.setRequestProperty("Content-Type", "application/octet-stream");

					JSONObject pa1 = new JSONObject();
					pa1.put("userid", userid);
					 pa1.put("sign", sign);
					 pa1.put("saleno",approveId);
					 pa1.put("accountid","accid002");
					JSONObject pa2 = new JSONObject();
					pa2.put("serviceCode", "com.pcitc.oilmachine.service.mobile.UserAuthenticationService");
					pa2.put("tenantId", "f652e66ac0714627aa66c58471455680");
					MobileDataInfo md = new MobileDataInfo();
					md.setAssistdata(pa2.toJSONString());
					md.setData(pa1.toJSONString());
					md.setFunName("getLoginUserinfo");
					md = SDKUtil.securityOReturnMsg(md, Constant.SIGNIN_SECURITY_CODE, publickey);
					md.setSignid(signid);
					
					String requestString = JSONObject.toJSONString(md);
					// 建立输出流，并写入数据
					OutputStream outputStream = httpConn.getOutputStream();
					outputStream.write(requestString.getBytes("UTF-8"));
					outputStream.flush();
					outputStream.close();
					// 获得响应状态
					int responseCode = httpConn.getResponseCode();
					if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
						StringBuffer sb = new StringBuffer();
						String readLine;
						BufferedReader responseReader;
						// 处理响应流，必须与服务器响应流输出的编码一致
						responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
						while ((readLine = responseReader.readLine()) != null) {
							sb.append(readLine);
						}
						JSONObject jso = JSONObject.parseObject(sb.toString());
						if("signIn".equals(jso.getString("funName"))){
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), "sMc2IdYJ30jEtVXiTjqGRw==");
						}else{
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), jso.getString("randomcode"), privatekey);
						}
						responseReader.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return mri;
	}
	
	public static String uploadposrecord(String signid,String publickey){
		String mri = null;
		try {
					
					HttpURLConnection httpConn;
					URL url_1 = new URL(url);
					httpConn = (HttpURLConnection) url_1.openConnection();
					httpConn.setDoOutput(true);// 使用 URL 连接进行输出
					httpConn.setDoInput(true);// 使用 URL 连接进行输入
					httpConn.setUseCaches(false);// 忽略缓存
					httpConn.setRequestMethod("POST");// 设置URL请求方法
					httpConn.setConnectTimeout(15000);
					httpConn.setReadTimeout(15000);
					httpConn.setRequestProperty("Content-Type", "application/octet-stream");
					JSONObject pa1 = new JSONObject();
					pa1.put("deviceid", "105015011");
					pa1.put("stncode", "10501501");
					String transdata = "AAAByhAgGAYGEzciAQAEERAAABRIce5rKAAAAAAAAWH2KGMAAAAAAAAAAAEAEBEQAABQlYcTEQBQlYcAAAAZABAAEQIQUgAAAAMVCAADpi4AAAAAAAAAAAAAAL/zqCg=";
					pa1.put("transdata", transdata);
					pa1.put("screencode", "1");
					JSONObject pa2 = new JSONObject();
					pa2.put("serviceCode", "com.pcitc.oilmachine.service.mobile.UserAuthenticationService");
					pa2.put("tenantId", "f652e66ac0714627aa66c58471455680");
					MobileDataInfo md = new MobileDataInfo();
					md.setAssistdata(pa2.toJSONString());
					md.setData(pa1.toJSONString());
					md.setFunName("uploadPosRecord");
					md = SDKUtil.securityOReturnMsg(md, Constant.SIGNIN_SECURITY_CODE, publickey);
					md.setSignid(signid);
					
					String requestString = JSONObject.toJSONString(md);
					// 建立输出流，并写入数据
					OutputStream outputStream = httpConn.getOutputStream();
					outputStream.write(requestString.getBytes("UTF-8"));
					outputStream.flush();
					outputStream.close();
					// 获得响应状态
					int responseCode = httpConn.getResponseCode();
					if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
						StringBuffer sb = new StringBuffer();
						String readLine;
						BufferedReader responseReader;
						// 处理响应流，必须与服务器响应流输出的编码一致
						responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
						while ((readLine = responseReader.readLine()) != null) {
							sb.append(readLine);
						}
						JSONObject jso = JSONObject.parseObject(sb.toString());
						if("signIn".equals(jso.getString("funName"))){
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), "sMc2IdYJ30jEtVXiTjqGRw==");
						}else{
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), jso.getString("randomcode"), privatekey);
						}
						responseReader.close();
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return mri;
	}
	
	public static String getVehicleNOs(String signid,String publickey){
		String mri = null;
		try {
					
					HttpURLConnection httpConn;
					URL url_1 = new URL(url);
					httpConn = (HttpURLConnection) url_1.openConnection();
					httpConn.setDoOutput(true);// 使用 URL 连接进行输出
					httpConn.setDoInput(true);// 使用 URL 连接进行输入
					httpConn.setUseCaches(false);// 忽略缓存
					httpConn.setRequestMethod("POST");// 设置URL请求方法
					httpConn.setConnectTimeout(15000);
					httpConn.setReadTimeout(15000);
					httpConn.setRequestProperty("Content-Type", "application/octet-stream");
					JSONObject pa1 = new JSONObject();
					pa1.put("deviceid", "325500181");
					 pa1.put("stncode", "32550018");
					JSONObject pa2 = new JSONObject();
					pa2.put("serviceCode", "com.pcitc.oilmachine.service.mobile.UserAuthenticationService");
					pa2.put("tenantId", "f652e66ac0714627aa66c58471455680");
					MobileDataInfo md = new MobileDataInfo();
					md.setAssistdata(pa2.toJSONString());
					md.setData(pa1.toJSONString());
					md.setFunName("getVehicleNOs");
					md = SDKUtil.securityOReturnMsg(md, Constant.SIGNIN_SECURITY_CODE, publickey);
					md.setSignid(signid);
					
					String requestString = JSONObject.toJSONString(md);
					// 建立输出流，并写入数据
					OutputStream outputStream = httpConn.getOutputStream();
					outputStream.write(requestString.getBytes("UTF-8"));
					outputStream.flush();
					outputStream.close();
					// 获得响应状态
					int responseCode = httpConn.getResponseCode();
					if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
						StringBuffer sb = new StringBuffer();
						String readLine;
						BufferedReader responseReader;
						// 处理响应流，必须与服务器响应流输出的编码一致
						responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
						while ((readLine = responseReader.readLine()) != null) {
							sb.append(readLine);
						}
						JSONObject jso = JSONObject.parseObject(sb.toString());
						if("signIn".equals(jso.getString("funName"))){
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), "sMc2IdYJ30jEtVXiTjqGRw==");
						}else{
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), jso.getString("randomcode"), privatekey);
						}
						responseReader.close();
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return mri;
	}
	
	public static String getVehicleNOsByphone(String signid,String publickey,String phoneno){
		String mri = null;
		try {
					
					HttpURLConnection httpConn;
					URL url_1 = new URL(url);
					httpConn = (HttpURLConnection) url_1.openConnection();
					httpConn.setDoOutput(true);// 使用 URL 连接进行输出
					httpConn.setDoInput(true);// 使用 URL 连接进行输入
					httpConn.setUseCaches(false);// 忽略缓存
					httpConn.setRequestMethod("POST");// 设置URL请求方法
					httpConn.setConnectTimeout(15000);
					httpConn.setReadTimeout(15000);
					httpConn.setRequestProperty("Content-Type", "application/octet-stream");

					JSONObject pa1 = new JSONObject();
					//加油机签到
					pa1.put("phoneno", phoneno);
					JSONObject pa2 = new JSONObject();
					pa2.put("serviceCode", "com.pcitc.oilmachine.service.mobile.UserAuthenticationService");
					pa2.put("tenantId", "f652e66ac0714627aa66c58471455680");
					MobileDataInfo md = new MobileDataInfo();
					md.setAssistdata(pa2.toJSONString());
					md.setData(pa1.toJSONString());
					md.setFunName("getVehicleNOsByphone");
					md = SDKUtil.securityOReturnMsg(md, Constant.SIGNIN_SECURITY_CODE, publickey);
					md.setSignid(signid);
					
					String requestString = JSONObject.toJSONString(md);
					// 建立输出流，并写入数据
					OutputStream outputStream = httpConn.getOutputStream();
					outputStream.write(requestString.getBytes("UTF-8"));
					outputStream.flush();
					outputStream.close();
					// 获得响应状态
					int responseCode = httpConn.getResponseCode();
					if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
						StringBuffer sb = new StringBuffer();
						String readLine;
						BufferedReader responseReader;
						// 处理响应流，必须与服务器响应流输出的编码一致
						responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
						while ((readLine = responseReader.readLine()) != null) {
							sb.append(readLine);
						}
						JSONObject jso = JSONObject.parseObject(sb.toString());
						if("signIn".equals(jso.getString("funName"))){
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), "sMc2IdYJ30jEtVXiTjqGRw==");
						}else{
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), jso.getString("randomcode"), privatekey);
						}
						responseReader.close();
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return mri;
	}
	
	public static String vehicleAccess(String signid,String publickey,String carNum,String password,String pwtype,String oilcode,String price,String nozzleno,String screencode){
		String mri = null;
		try {
					
					HttpURLConnection httpConn;
					URL url_1 = new URL(url);
					httpConn = (HttpURLConnection) url_1.openConnection();
					httpConn.setDoOutput(true);// 使用 URL 连接进行输出
					httpConn.setDoInput(true);// 使用 URL 连接进行输入
					httpConn.setUseCaches(false);// 忽略缓存
					httpConn.setRequestMethod("POST");// 设置URL请求方法
					httpConn.setConnectTimeout(15000);
					httpConn.setReadTimeout(15000);
					httpConn.setRequestProperty("Content-Type", "application/octet-stream");

					JSONObject pa1 = new JSONObject();
					//加油机签到
					pa1.put("carNum", carNum);
					pa1.put("pwtype", pwtype);
					pa1.put("password", password);
					pa1.put("oilcode", oilcode);
					pa1.put("price", price);
					pa1.put("oilno", "93#");
					pa1.put("nozzleno", nozzleno);
					pa1.put("screencode", screencode);
					JSONObject pa2 = new JSONObject();
					pa2.put("serviceCode", "com.pcitc.oilmachine.service.mobile.UserAuthenticationService");
					pa2.put("tenantId", "f652e66ac0714627aa66c58471455680");
					MobileDataInfo md = new MobileDataInfo();
					md.setAssistdata(pa2.toJSONString());
					md.setData(pa1.toJSONString());
					md.setFunName("vehicleAccess");
					md = SDKUtil.securityOReturnMsg(md, Constant.SIGNIN_SECURITY_CODE, publickey);
					md.setSignid(signid);
					
					String requestString = JSONObject.toJSONString(md);
					// 建立输出流，并写入数据
					OutputStream outputStream = httpConn.getOutputStream();
					outputStream.write(requestString.getBytes("UTF-8"));
					outputStream.flush();
					outputStream.close();
					// 获得响应状态
					int responseCode = httpConn.getResponseCode();
					if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
						StringBuffer sb = new StringBuffer();
						String readLine;
						BufferedReader responseReader;
						// 处理响应流，必须与服务器响应流输出的编码一致
						responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
						while ((readLine = responseReader.readLine()) != null) {
							sb.append(readLine);
						}
						JSONObject jso = JSONObject.parseObject(sb.toString());
						if("signIn".equals(jso.getString("funName"))){
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), "sMc2IdYJ30jEtVXiTjqGRw==");
						}else{
							mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), jso.getString("randomcode"), privatekey);
						}
						responseReader.close();
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
				return mri;
	}
	
	
	
	
	/**
	 * 油机签到
	 * @return
	 */
	public static String signIn(String stncode,String deviceid){
		String mri = null;
try {
			
			HttpURLConnection httpConn;
			URL url_1 = new URL(url);
			httpConn = (HttpURLConnection) url_1.openConnection();
			httpConn.setDoOutput(true);// 使用 URL 连接进行输出
			httpConn.setDoInput(true);// 使用 URL 连接进行输入
			httpConn.setUseCaches(false);// 忽略缓存
			httpConn.setRequestMethod("POST");// 设置URL请求方法
			httpConn.setConnectTimeout(15000);
			httpConn.setReadTimeout(15000);
			httpConn.setRequestProperty("Content-Type", "application/octet-stream");

			JSONObject pa1 = new JSONObject();
			//加油机签到
			pa1.put("stncode", stncode);
			pa1.put("deviceid", deviceid);
			pa1.put("publickey", publickey);
			JSONObject pa2 = new JSONObject();
			pa2.put("serviceCode", "com.pcitc.oilmachine.service.mobile.UserAuthenticationService");
			pa2.put("tenantId", "f652e66ac0714627aa66c58471455680");
			MobileDataInfo md = new MobileDataInfo();
			md.setAssistdata(pa2.toJSONString());
			md.setData(pa1.toJSONString());
			md.setFunName("signIn");
			md = SDKUtil.securityOReturnMsg(md, "sMc2IdYJ30jEtVXiTjqGRw==");
			
			String requestString = JSONObject.toJSONString(md);
			// 建立输出流，并写入数据
			OutputStream outputStream = httpConn.getOutputStream();
			outputStream.write(requestString.getBytes("UTF-8"));
			outputStream.flush();
			outputStream.close();
			// 获得响应状态
			int responseCode = httpConn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
				StringBuffer sb = new StringBuffer();
				String readLine;
				BufferedReader responseReader;
				// 处理响应流，必须与服务器响应流输出的编码一致
				responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine);
				}
				JSONObject jso = JSONObject.parseObject(sb.toString());
				if("signIn".equals(jso.getString("funName"))){
					mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), "sMc2IdYJ30jEtVXiTjqGRw==");
				}else{
					mri = SDKUtil.securityOReceiveMsg(jso.getString("data"), jso.getString("randomcode"), privatekey);
				}
				responseReader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mri;
	}
	
	public static byte[] image2byte(String path){
	    byte[] data = null;
	    FileImageInputStream input = null;
	    try {
	      input = new FileImageInputStream(new File(path));
	      ByteArrayOutputStream output = new ByteArrayOutputStream();
	      byte[] buf = new byte[1024];
	      int numBytesRead = 0;
	      while ((numBytesRead = input.read(buf)) != -1) {
	      output.write(buf, 0, numBytesRead);
	      }
	      data = output.toByteArray();
	      output.close();
	      input.close();
	    }
	    catch (FileNotFoundException ex1) {
	      ex1.printStackTrace();
	    }
	    catch (IOException ex1) {
	      ex1.printStackTrace();
	    }
	    return data;
	  }

}
