package com.pcitc.oilmachine.commons.utils;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

import com.afs.base.exception.ServiceException;

public class ByteUtil {
	
	
	   /**
	    * 将源数组从索引start开始，复制length到目标数组
	    * @param src 源数组
	    * @param target 目标数组
	    * @param start 开始位置
	    * @param length 要复制的长度
	    * @return
	    */
	   public static void copyByteArray(byte[] src,byte[] target,int start,int length){
		   
		   for(int i = 0;i<length;i++){
			   target[i] = src[i+start];
		   }
	   }
	
	   /**
	    * 将源数组拷贝到目标数组，从目标的tarStart开始
	    * @param src
	    * @param target
	    * @param tarStart
	    */
	   public static void copyByteArray(byte[] src,byte[] target,int tarStart){
		   
		   for(int i = 0;i<src.length;i++){
			   target[i+tarStart] = src[i];
		   }
	   }
	   
	   public static byte[] getBytes(short data)
	    {
	        byte[] bytes = new byte[2];
	        bytes[0] = (byte) (data & 0xff);
	        bytes[1] = (byte) ((data & 0xff00) >> 8);
	        return bytes;
	    }

	    public static byte[] getBytes(char data)
	    {
	        byte[] bytes = new byte[2];
	        bytes[0] = (byte) (data);
	        bytes[1] = (byte) (data >> 8);
	        return bytes;
	    }

	    public static byte[] getBytes(int data)
	    {
	        byte[] bytes = new byte[4];
	        bytes[0] = (byte) (data & 0xff);
	        bytes[1] = (byte) ((data & 0xff00) >> 8);
	        bytes[2] = (byte) ((data & 0xff0000) >> 16);
	        bytes[3] = (byte) ((data & 0xff000000) >> 24);
	        return bytes;
	    }

	    public static byte[] getBytes(long data)
	    {
	        byte[] bytes = new byte[8];
	        bytes[0] = (byte) (data & 0xff);
	        bytes[1] = (byte) ((data >> 8) & 0xff);
	        bytes[2] = (byte) ((data >> 16) & 0xff);
	        bytes[3] = (byte) ((data >> 24) & 0xff);
	        bytes[4] = (byte) ((data >> 32) & 0xff);
	        bytes[5] = (byte) ((data >> 40) & 0xff);
	        bytes[6] = (byte) ((data >> 48) & 0xff);
	        bytes[7] = (byte) ((data >> 56) & 0xff);
	        return bytes;
	    }

	    public static byte[] getBytes(float data)
	    {
	        int intBits = Float.floatToIntBits(data);
	        return getBytes(intBits);
	    }

	    public static byte[] getBytes(double data)
	    {
	        long intBits = Double.doubleToLongBits(data);
	        return getBytes(intBits);
	    }

	    public static byte[] getBytes(String data, String charsetName)
	    {
	        Charset charset = Charset.forName(charsetName);
	        return data.getBytes(charset);
	    }

	    public static byte[] getBytes(String data)
	    {
	        return getBytes(data, "GBK");
	    }

	    
	    public static short getShort(byte[] bytes)
	    {
	        return (short) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
	    }
	    
	    public static short getShort(byte b)
	    {
	        return (short) ((0xff & b ) | (0xff00 & (0x00 << 8)));
	    }
   
	    
	    public static char getChar(byte[] bytes)
	    {
	        return (char) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
	    }

	    public static int getInt(byte[] bytes)
	    {
	    	if(bytes.length==1){

	    		return (0xff & bytes[0]);
	    	}
	    	if(bytes.length==2){

	    		return (0xff & bytes[0]) | (0xff00 & (bytes[1] << 8));
	    	}
	    	if(bytes.length==3){

	    		return (0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)) | (0xff0000 & (bytes[2] << 16));
	    	}
	    	if(bytes.length==4){

	    		return (0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)) | (0xff0000 & (bytes[2] << 16)) | (0xff000000 & (bytes[3] << 24));
	    	}
	        return 0;
	    }
	    public static int getInt2(byte[] bytes)
	    {
	    	if(bytes.length==1){

	    		return (0xff & bytes[0]);
	    	}
	    	if(bytes.length==2){

	    		return (0xff & bytes[1]) | (0xff00 & (bytes[0] << 8));
	    	}
	    	if(bytes.length==3){

	    		return (0xff & bytes[2]) | (0xff00 & (bytes[1] << 8)) | (0xff0000 & (bytes[0] << 16));
	    	}
	    	if(bytes.length==4){

	    		return (0xff & bytes[3]) | (0xff00 & (bytes[2] << 8)) | (0xff0000 & (bytes[1] << 16)) | (0xff000000 & (bytes[0] << 24));
	    	}
	        return 0;
	    }

	    public static int getUIntByByte(byte b)
	    {
	        return (0xff & b | 0x0);
	    }	    
	    
	    public static long getLong(byte[] bytes)
	    {
	        return(0xffL & (long)bytes[0]) | (0xff00L & ((long)bytes[1] << 8)) | (0xff0000L & ((long)bytes[2] << 16)) | (0xff000000L & ((long)bytes[3] << 24))
	         | (0xff00000000L & ((long)bytes[4] << 32)) | (0xff0000000000L & ((long)bytes[5] << 40)) | (0xff000000000000L & ((long)bytes[6] << 48)) | (0xff00000000000000L & ((long)bytes[7] << 56));
	    }
	    
	    public static long getLongBy4Bytes(byte[] bytes)
	    {
	        return(0xffL & (long)bytes[0]) | (0xff00L & ((long)bytes[1] << 8)) | (0xff0000L & ((long)bytes[2] << 16)) | (0xff000000L & ((long)bytes[3] << 24));
	    }
	    
	    public static long getLongBy4BytesR(byte[] bytes) 
	    {
	        //return(0xffL & (long)bytes[3]) | (0xff00L & ((long)bytes[2] << 8)) | (0xff0000L & ((long)bytes[1] << 16)) | (0xff000000L & ((long)bytes[0] << 24));
	    	String hexstr = ByteUtil.getHexString(bytes);
	    	hexstr = hexstr.replace(" ", "");
	    	if('f' == hexstr.charAt(0) || 'F' == hexstr.charAt(0)){
	    		hexstr = "FFFFFFFF"+hexstr;
	    	}
	    	BigInteger bi = new BigInteger(hexstr,16);
	    	return bi.longValue();
	    }
	    
	    public static float getFloat(byte[] bytes)
	    {
	        return Float.intBitsToFloat(getInt(bytes));
	    }

	    public static double getDouble(byte[] bytes)
	    {
	        long l = getLong(bytes);
	        System.out.println(l);
	        return Double.longBitsToDouble(l);
	    }

	    public static String getString(byte[] bytes, String charsetName)
	    {
	        return new String(bytes, Charset.forName(charsetName));
	    }
	    
	    public static String getString(byte bytes)
	    {
	        return getString(bytes,"GBK");
	    }	    
	    
	    public static String getString(byte bytes, String charsetName)
	    {
	        return new String(new byte[]{bytes}, Charset.forName(charsetName));
	    }
	    public static String getHexString(byte[] bytes){
	    	if(bytes!=null && bytes.length>0){
	    		return getHexString(bytes,bytes.length);
	    	}else{
	    		return "";
	    	}
	    }
	    public static String getHexString(byte[] bytes,int length){
	    	StringBuffer sb = new StringBuffer(" ");
	    	
	    	for(int i = 0;i<length;i++){
    			sb.append(String.format("%02x ", bytes[i]).toUpperCase());
	    	}
	    	return sb.toString();
	    }

	    public static String getString(byte[] bytes)
	    {
	        return getString(bytes, "GBK");
	    }
	    
	    public static byte[] hexStr2ByteArray(String hexString) {  
	        if (hexString==null || hexString.length()==0)  
	            throw new IllegalArgumentException("this hexString must not be empty");  
	      
	        hexString = hexString.toLowerCase();  
	        final byte[] byteArray = new byte[hexString.length() / 2];  
	        int k = 0;  
	        for (int i = 0; i < byteArray.length; i++) {  
	            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);  
	            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);  
	            byteArray[i] = (byte) (high << 4 | low);  
	            k += 2;  
	        }  
	        return byteArray;  
	    } 	    
 
	    /**
	     * 异或校验，返回校验位
	     * @param b
	     * @return
	     * @throws ServiceException 
	     */
	    public static byte getCheckBit(byte[] b) throws ServiceException{
	    	if(b==null || b.length==0){
	    		throw new ServiceException("getCheckBit参数为空");
	    	}	    	
	    	return getCheckBit(b,b.length);
	    }
	    
	    /**
	     * 
	     * @param b
	     * @param len 参加校验位的长度
	     * @return
	     * @throws ServiceException
	     */
	    public static byte getCheckBit(byte[] b,int len) throws ServiceException{
	    	if(b==null || b.length==0){
	    		throw new ServiceException("getCheckBit参数为空");
	    	}
	    	if(len>b.length){
	    		len = b.length;
	    	}
	    	byte checkbit = 0x00;
	    	for(int i = 0;i<len;i++){
	    		checkbit^=b[i];
	    	}
	    	return checkbit;
	    }
	    
	    /**
	     * 
	     * @param b
	     * @param len 参加校验位的长度
	     * @return
	     * @throws ServiceException
	     */
	    public static byte getCheckBit(byte[] b,int startIndex,int len) throws ServiceException{
	    	if(b==null || b.length==0){
	    		throw new ServiceException("getCheckBit参数为空");
	    	}
	    	if(startIndex>b.length){
	    		throw new ServiceException("数组查找，起始位置大于数组长度");
	    	}
	    	
	    	if(len>b.length){
	    		len = b.length;
	    	}
	    	byte checkbit = 0x00;
	    	for(int i = startIndex;i<startIndex+len;i++){
	    		checkbit^=b[i];
	    	}
	    	return checkbit;
	    }
	 
	    public static void main(String[] args) throws ServiceException
	    {
			byte[] aa = "queryDate".getBytes();
			
			System.out.println(ByteUtil.getHexString(aa));
	    }
	    
	    /**
	     * 利用 {@link java.nio.ByteBuffer}实现byte[]转long
	     * @param input
	     * @param offset 
	     * @param littleEndian 输入数组是否小端模式
	     * @return
	     */
	    public static long bytesToLong(byte[] input, boolean littleEndian) { 
	        // 将byte[] 封装为 ByteBuffer 
	        ByteBuffer buffer = ByteBuffer.wrap(input,0,8);
	        if(littleEndian){
	            // ByteBuffer.order(ByteOrder) 方法指定字节序,即大小端模式(BIG_ENDIAN/LITTLE_ENDIAN)
	            // ByteBuffer 默认为大端(BIG_ENDIAN)模式 
	            buffer.order(ByteOrder.LITTLE_ENDIAN);
	        }
	        return buffer.getLong();  
	    }
	    
	    /**
	     * 只真对摄像头传过来的16进制数据为负值时需要补位
	     * @param input
	     * @return
	     */
	    public static long hexbytes2Long(byte[] input){
	    	String hexstr = ByteUtil.getHexString(input);
	    	hexstr = hexstr.replace(" ", "");
	    	if('f' == hexstr.charAt(0) || 'F' == hexstr.charAt(0)){
	    		hexstr = "FFFFFFFF"+hexstr;
	    	}
	    	BigInteger bi = new BigInteger(hexstr,16);
	    	return bi.longValue();
	    }
	    
	    public static byte[] str2Byte(String str,String charsetName){
	        byte[] ba = null;
	        try {
	            ba = str.getBytes(charsetName);            
	            char[] ca = "0123456789abcdef".toCharArray();
	            StringBuffer sb;
	            for (byte b : ba) {
	                sb = new StringBuffer();
	                int bi = (b & 0xf0) >> 4;
	                sb.append(ca[bi]);
	                int bi2 = b & 0x0f;
	                sb.append(ca[bi2]);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ba;
	    }
	    
	    /**
	     * 长整型转换为byte数组,并指定位数,不足位数补0
	     * @param value
	     * @param bytesize
	     * @return
	     */
	    public static byte[] long2byte(long value,int bytesize){
	    	//System.out.println(value);
	    	String valueHex = Long.toHexString(value);
	    	int bs = bytesize*2;
	    	if(valueHex.length() < bs){
	    		int length = valueHex.length();
	    		for(int i = 0; i< bs - length ; i ++){
	    			valueHex = "0"+valueHex;
	    		}
	    	}else{
	    		//超过最大位数
	    	}
	    	//System.out.println(valueHex);
	    	return hexStr2ByteArray(valueHex);
	    }
	    
	    /**
	     * 压缩bcd码
	     * @param bcdstr
	     * @return
	     */
	    public static String bcd2str(String bcdstr){
	    	StringBuilder result = new StringBuilder();
			int bcdsize = bcdstr.length();
			int mod = bcdsize%4;
			StringBuilder cbit = new StringBuilder();
			if(mod > 0){
				for(int i = 0; i <4 - mod ; i++){
					cbit.append("0");
				}
			}
			bcdstr = cbit.append(bcdstr).toString();
			for(int i = 0; i< bcdstr.length()/4; i++){
				String str = bcdstr.substring(i*4, (i+1)*4);
				result.append(Integer.valueOf(str,2).toString());
			}
			return result.toString();
		}
		 public static String binary(byte[] bytes, int radix){    
		        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数    
		  } 
}
