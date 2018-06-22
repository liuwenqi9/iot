package com.pcitc.oilmachine.commons.utils;
/**
 * 通用字符串处理工具类
 * @author 刘潇
 * 2012-2-3
 */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils extends org.apache.commons.lang.StringUtils {
	
	public static Logger log = LoggerFactory.getLogger(StringUtils.class);

	private static char[] chars = 
	{
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};

	private static char[] upperChars = 
	{
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};

	private static int charsLen = chars.length;
	private static int upperCharsLen = upperChars.length;

	public static String longToString(long n) {
		StringBuffer sb = new StringBuffer();
		while (n != 0) {
			sb.insert(0, chars[(int)(n % charsLen)]);
			n /= charsLen;
		}
		return sb.toString();
	}

	public static String longToUpperString(long n) {
		StringBuffer sb = new StringBuffer();
		while (n != 0) {
			sb.insert(0, upperChars[(int)(n % upperCharsLen)]);
			n /= upperCharsLen;
		}
		return sb.toString();
	}

	public static String format(Object value, int length, boolean alignRight, char fill) {
		String v = toString(value);
		StringBuffer result = new StringBuffer(v);
		int len = length - v.getBytes().length;
		for (int i = 0; i < len; i++) {
			if (alignRight) {
				result.insert(0, fill);
			}
			else {
				result.append(fill);
			}
		}
		return result.toString();
	}
	
	public static String format(Object value, int length, boolean alignRight) {
		return format(value, length, alignRight, ' ');
	}
    
	public static String format(Object value, int length, char fill) {
		return format(value, length, false, fill);
	}

	public static String format(Object value, int length) {
		return format(value, length, false, ' ');
	}

	public static String toString(Object str) {
		return str == null ? "" : str.toString();
	}

	public static String insert(String str, int index, String substring) {
		return str.substring(0, index) + substring + str.substring(index);
	}

	public static boolean isCode(String str) {
		return Pattern.compile("[a-zA-Z][a-zA-Z0-9]*").matcher(str).matches();
	}

	
	/*判断该字符串是不是数字
	 *@author:王传圣
	 *updateDate:  2011-11-04
	 *@param String str
	 *@return boolean
	 */
	public static boolean isNumeric(String str){
		
		for (int i = 0; i < str.length(); i++){
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		}
		return true;
	}
	
	/**
	 * 比较数字是否连续
	 * @param preNum 前一数字
	 * @param errorStr 异常输出文字
	 * @return true后一数字比前一数字大1
	 */
	public static boolean compNum(String preNum,String nextNum,String errorStr){
		boolean flag = false;
		try {
			if(StringUtils.isNotBlank(preNum) && StringUtils.isNotBlank(nextNum)){
				if(StringUtils.isNumeric(preNum) && StringUtils.isNumeric(nextNum) && Integer.parseInt(nextNum)>Integer.parseInt(preNum)){
					int dif = Integer.parseInt(nextNum)-Integer.parseInt(preNum);
					if(dif==1)
						flag = true;
				}
			}
		} catch (NumberFormatException e) {
			log.error(errorStr,e);
		}
		return flag;
	}

	
	
	/**
	 * 一个字符串中指定字符串出现的次数
	 * @param string
	 * @param subs
	 * @return
	 */
	 public static int subCount(String string, String subs){
	        int count = 0;
	        String temp = string;
	        while(temp.indexOf(subs)!=-1){//当temp中无subs子串时返回-1
	            count++;
	            temp = temp.substring(temp.indexOf(subs)+subs.length());//将第一次匹配后的剩下的字符串赋值给tenp
	        }
	        return count;
	    }

	
	/**
	 * 格式化整数不足补0
	 * @param num 
	 * @param maxlen 位数
	 * @return
	 */
	public static String formatNum(String num,Integer maxlen){
		if(StringUtils.isBlank(num)){
			String ret = "";
			for(int i=0;i<maxlen;i++){
				ret += "0";
			}
			return ret;
		}
		int len = num.length();
		if(len < maxlen){
	  		for(int i = 0; i < maxlen-len; i++){
				num = "0" + num;
			}
		}else if(len > maxlen){
			num = num.substring(num.length()-maxlen-1,num.length()-1);
		}
		return num;
	}

	  /** 随机数。 */
    private static int serial = 0;

    /** 随机数最大值。 */
    private static final int MAX_SERIAL = 999;

    /** 随机数长度。 */
    private static final int SEQUENCE_LENTH = 12;

	public static synchronized String makeUUID() {
        StringBuffer ret = new StringBuffer();
        SimpleDateFormat dfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        dfDate.setLenient(false);
        ret.append(dfDate.format((new GregorianCalendar()).getTime()));

        DecimalFormat dfNum = new DecimalFormat("000");
        ret.append(dfNum.format(serial++));
        if (serial > MAX_SERIAL) {
            serial = 0;
        }
        UUID uuid = UUID.randomUUID();
        ret.append(uuid.toString().replace("-", "").subSequence(0, SEQUENCE_LENTH));

        return ret.toString();
    }

    public static synchronized String selfMakeUUID() {
        String s = UUID.randomUUID().toString();
        String value = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23)
                + s.substring(24);
        return value;
    }

    public static boolean isEmptyOrNull(String str) {
        boolean isEmptyOrNull = true;
        if (str != null && str.length() != 0) {
            isEmptyOrNull = false;
        }
        return isEmptyOrNull;
    }
    public static String indexOfString(String str) {
    	String rresult="";
		int result=str.indexOf("distinct");
		if(result>=0){
			String res=str.trim();
			String rlt=res.substring(8,res.length());
			rresult=rlt;
		}else{
			rresult=str;
		}
		return rresult;
    }
  
    //获得汉字的长度
    public static int getChineseCount(String s) throws Exception{
		
		char c;
		int chineseCount=0;   
		//判断是否为空
		if(!"".equals("")){
			//进行统一编码
			s=new String(s.getBytes(),"GBK");   
		}
		for(int i=0;i<s.length();i++){
			c=s.charAt(i);  
			//调用方法进行判断是否是汉字 
			if(isChineseChar(c)){
				chineseCount++;                 
			}
		}
		return chineseCount;                   
	}
    
    //判断是否是一个汉字
	public static boolean isChineseChar(char c) throws Exception{		
		return String.valueOf(c).getBytes("GBK").length>1;//汉字的字节数大于1
	}	
	
	//获得汉字的长度
    public static int getStringLength(String s) throws Exception{
		
    	int length = getChineseCount(s) + s.length();
		return length;                   
	}
    
    //获得指定长度
    public static String getBlankString(int length) throws Exception{
		
    	StringBuffer buffer = new StringBuffer();
    	for(int i=0;i<length;i++){
    		buffer.append(" ");
    	}
    	
		return buffer.toString();                   
	}
    
    public static String replaceStr(String str){
    	if(str != null){
    		str = str.replace(" ", "");
        	str = str.replace("\"","");
        	str = str.replace("\n", "");
    	}
    	return str;
    }
    
    /** 
     * 判断文件是否为图片<br> 
     * <br> 
     * @param pInput 文件名<br> 
     * @param pImgeFlag 判断具体文件类型<br> 
     * @return 检查后的结果<br> 
     * @throws Exception 
     */  
    public static boolean isPicture(String  pInput){  
     // 文件名称为空的场合  
     if(StringUtils.isBlank(pInput)){  
      // 返回不和合法  
      return false;  
     }  
     // 获得文件后缀名  
     String tmpName = pInput.substring(pInput.lastIndexOf(".") + 1,  
                                 pInput.length());  
     // 声明图片后缀名数组  
     String imgeArray [] = {"bmp","gif","jpe","jpeg","jpg","png","ico"};  
     // 遍历名称数组  
     for(int i = 0; i<imgeArray.length;i++){  
      // 判断单个类型文件的场合  
	      if( imgeArray [i].equals(tmpName.toLowerCase())){  
	    	  return true;
	      }  
     }  
     return false;  
    }
    
    public static int checkImg(String ...args){
		int count = 0;
		for(String str : args){
			if(StringUtils.isNotBlank(str)){
				boolean isPicture = StringUtils.isPicture(str);
				if(!isPicture){
					count ++;
				}
			}
		}
		return count;
	}
    
    public static String getErrorInfoFromException(Exception e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String exception = "\r\n" + sw.toString() + "\r\n";
            sw.close();
            pw.close();
            return exception;
        } catch (Exception e2) {
            return "ErrorInfoFromException";
        }
    }
    
    public static  String GenerationEVerifyMessageCode(int codeCount){
		StringBuffer randomCode = new StringBuffer();
		// 创建一个随机数生成器类      
		Random random = new Random();
		char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		// 随机产生codeCount数字的验证码 
		
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字 
			String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			// 将产生的四个随机数组合在一起。      
			randomCode.append(strRand);
		}
		return randomCode.toString();
	}
    
    /**
     * 
     * @param amount
     * @return
     */
    public static Long multiplication(String amount1 ,String amount2){
    	BigDecimal a1 = new BigDecimal(amount1); 
    	BigDecimal a2 = new BigDecimal(amount2); 
    	return a1.multiply(a2).longValue();
    }
    
    public static String bytesToHexString(byte[] src) {  
        StringBuilder stringBuilder = new StringBuilder("");  
        if (src == null || src.length <= 0) {  
            return null;  
        }  
        for (int i = 0; i < src.length; i++) {  
            int v = src[i] & 0xFF;  
            String hv = Integer.toHexString(v);  
            if (hv.length() < 2) {  
                stringBuilder.append(0);  
            }  
            stringBuilder.append(hv);  
        }  
        return stringBuilder.toString();  
    }
    
    /** 16进制中的字符集 */  
    private static final String HEX_CHAR = "0123456789ABCDEF";  
      
    /** 16进制中的字符集对应的字节数组 */  
    private static final byte[] HEX_STRING_BYTE = HEX_CHAR.getBytes();  
      
    /** 
     * 10进制字节数组转换为16进制字节数组 
     *  
     * byte用二进制表示占用8位，16进制的每个字符需要用4位二进制位来表示，则可以把每个byte 
     * 转换成两个相应的16进制字符，即把byte的高4位和低4位分别转换成相应的16进制字符，再取对应16进制字符的字节 
     *  
     * @param b 10进制字节数组 
     * @return 16进制字节数组 
     */  
    public static byte[] byte2hex(byte[] b) {  
        int length = b.length;  
        byte[] b2 = new byte[length << 1];  
        int pos;  
        for(int i=0; i<length; i++) {  
            pos = 2*i;  
            b2[pos] = HEX_STRING_BYTE[(b[i] & 0xf0) >> 4];  
            b2[pos+1] = HEX_STRING_BYTE[b[i] & 0x0f];  
        }  
        return b2;  
    }  
      
    /** 
     * 16进制字节数组转换为10进制字节数组 
     *  
     * 两个16进制字节对应一个10进制字节，则将第一个16进制字节对应成16进制字符表中的位置(0~15)并向左移动4位， 
     * 再与第二个16进制字节对应成16进制字符表中的位置(0~15)进行或运算，则得到对应的10进制字节 
     * @param b 10进制字节数组 
     * @return 16进制字节数组 
     */  
    public static byte[] hex2byte(byte[] b) {  
        if(b.length%2 != 0) {  
            throw new IllegalArgumentException("byte array length is not even!");  
        }  
          
        int length = b.length >> 1;  
        byte[] b2 = new byte[length];  
        int pos;  
        for(int i=0; i<length; i++) {  
            pos = i << 1;  
            b2[i] = (byte) (HEX_CHAR.indexOf( b[pos] ) << 4 | HEX_CHAR.indexOf( b[pos+1] ) );  
        }  
        return b2;  
    }  
      
    /** 
     * 将16进制字节数组转成10进制字符串 
     * @param b 16进制字节数组 
     * @return 10进制字符串 
     */  
    public static String hex2Str(byte[] b) {  
        return new String(hex2byte(b));  
    }  
      
    /** 
     * 将10进制字节数组转成16进制字符串 
     * @param b 10进制字节数组 
     * @return 16进制字符串 
     */  
    public static String byte2HexStr(byte[] b) {  
        return Integer.toHexString(Integer.parseInt(new String(b)));  
    }
    
    
    public static void main(String[] args) {
		byte[] array = new byte[4];
    	/*array[0] = (byte)0xFF;
    	array[1] = (byte)0xFF;
    	array[2] = (byte)0xFF;
    	array[3] = (byte)0x88;*/
		/*array[0] = (byte)0x00;
    	array[1] = (byte)0x00;
    	array[2] = (byte)0x00;
    	array[3] = (byte)0xCA;
    	System.out.println(ByteUtil.hexbytes2Long(array));*/
		System.out.println(makeUUID());
	}
    
}