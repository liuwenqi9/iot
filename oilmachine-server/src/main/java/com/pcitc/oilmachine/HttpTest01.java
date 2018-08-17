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
import java.util.Date;

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
	static String deviceid = "325500183";
	static String stncode = "32550018";
	
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
		//System.out.println("===="+DateUtils.format(new Date(), "yyyyMMdd"));
		/*String str = "bjsy_smpay325500180520180705018a787568624d904f0162b45a619e0c51";
		String accountdate = str.substring(20, 28);
		Date date = DateUtils.parseDate(accountdate, "yyyyMMdd");
		System.out.println(DateUtils.format(date));
		String classnumber = str.substring(28, 30);
		System.out.println(accountdate);
		System.out.println(classnumber);*/
		getPosRecord(0);
		
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

}
