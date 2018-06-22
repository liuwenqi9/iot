package com.pcitc.oilmachine.commons.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Base64编码工具类
 */
public class Base64 {
	private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

	public static String encode(byte[] data) {
		int start = 0;
		int len = data.length;
		StringBuffer buf = new StringBuffer(data.length * 3 / 2);

		int end = len - 3;
		int i = start;
		int n = 0;

		while (i <= end) {
			int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 0x0ff) << 8) | (((int) data[i + 2]) & 0x0ff);

			buf.append(legalChars[(d >> 18) & 63]);
			buf.append(legalChars[(d >> 12) & 63]);
			buf.append(legalChars[(d >> 6) & 63]);
			buf.append(legalChars[d & 63]);

			i += 3;

			if (n++ >= 14) {
				n = 0;
				buf.append(" ");
			}
		}

		if (i == start + len - 2) {
			int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 255) << 8);

			buf.append(legalChars[(d >> 18) & 63]);
			buf.append(legalChars[(d >> 12) & 63]);
			buf.append(legalChars[(d >> 6) & 63]);
			buf.append("=");
		} else if (i == start + len - 1) {
			int d = (((int) data[i]) & 0x0ff) << 16;

			buf.append(legalChars[(d >> 18) & 63]);
			buf.append(legalChars[(d >> 12) & 63]);
			buf.append("==");
		}

		return buf.toString();
	}

	private static int decode(char c) {
		if (c >= 'A' && c <= 'Z')
			return ((int) c) - 65;
		else if (c >= 'a' && c <= 'z')
			return ((int) c) - 97 + 26;
		else if (c >= '0' && c <= '9')
			return ((int) c) - 48 + 26 + 26;
		else
			switch (c) {
			case '+':
				return 62;
			case '/':
				return 63;
			case '=':
				return 0;
			default:
				throw new RuntimeException("unexpected code: " + c);
			}
	}

	/**
	 * Decodes the given Base64 encoded String to a new byte array. The byte array holding the decoded data is returned.
	 */
	public static byte[] decode(String s) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			decode(s, bos);
		} catch (IOException e) {
			throw new RuntimeException();
		}
		byte[] decodedBytes = bos.toByteArray();
		try {
			bos.close();
			bos = null;
		} catch (IOException ex) {
			System.err.println("Error while decoding BASE64: " + ex.toString());
		}
		return decodedBytes;
	}
	
	private static void decode(String s, OutputStream os) throws IOException {
		int i = 0;
		int len = s.length();
		while (true) {
			while (i < len && s.charAt(i) <= ' ')
				i++;
			if (i == len)
				break;
			int tri = (decode(s.charAt(i)) << 18) + (decode(s.charAt(i + 1)) << 12) + (decode(s.charAt(i + 2)) << 6) + (decode(s.charAt(i + 3)));
			os.write((tri >> 16) & 255);
			if (s.charAt(i + 2) == '=')
				break;
			os.write((tri >> 8) & 255);
			if (s.charAt(i + 3) == '=')
				break;
			os.write(tri & 255);
			i += 4;
		}
	}
	
	/**
	 * 
	 * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 * @param imgFilePath
	 */
	public static String getImageString(String imgFilePath) {
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		return encode(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * 
	 * Base64字符串转 InputStream流对象
	 * @param base64string	base64编码的字符串
	 */
	public static InputStream base64ToStream(String base64String) {
		ByteArrayInputStream stream = null;
		try {
			byte[] bytes = decode(base64String);
			stream = new ByteArrayInputStream(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stream;
	}
	/**
	 * InputStream流对象转换成字节
	 */
	public static byte[] streamToByte(InputStream input)  {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int len = 0;
		byte[] b = new byte[1024];
		try {
			while ((len = input.read(b, 0, b.length)) != -1) {
				bos.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] buffer = bos.toByteArray();
		return buffer;
	}
	
	/**
	 * 将Base64String转成图片文件
	 * @param imgStr	Base64编码的字符串
	 * @param imgFilePath	图片文件保存的路径
	 */
	public static boolean generateImage(String imgStr, String imgFilePath) {
		// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		try {
			// Base64解码
			byte[] bytes = decode(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		
		String imgFilePath ="D:\\测试.jpg";// 待测试图片
		String imageString = Base64.getImageString(imgFilePath);
		//String zipString = GZipUtil.gzipString(imageString);
		
		System.err.println("压缩前长度：" + imageString.length());
		System.err.println("--------------------------------------------------------");
		//System.err.println("压缩后长度：" + zipString.length());
		
		
		String path ="D:\\Backup\\a.jpg";
		boolean flag = Base64.generateImage(imageString,path);
		if(flag){
			System.out.println("图片生成成功！");
		}
	}
}
