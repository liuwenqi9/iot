package com.pcitc.oilmachine.commons.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.pcitc.oilmachine.commons.exception.PTPECAppException;

/**
 * 通用日期处理工具类
 * @author 
 * 2012-2-3
 */
public class DateUtils {
	public static Date date = null;

	public static DateFormat dateFormat = null;

	public static Calendar calendar = null;

	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期
	 * @param format
	 *            String 格式
	 * @return Date 日期
	 */
	public static Date parseDate(String dateStr, String format) {
		try {
			dateFormat = new SimpleDateFormat(format);
			String dt = dateStr.replaceAll("-", "/");
			if ((!dt.equals("")) && (dt.length() < format.length())) {
				dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]",
						"0");
			}
			date = (Date) dateFormat.parse(dt);
		} catch (Exception e) {
		}
		return date;
	}
	
	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期：YYYY-MM-DD 格式
	 * @return Date
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy/MM/dd HH:mm:ss");
	}
	
	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期：YYYY-MM-DD 格式
	 * @return Date
	 */
	public static Date parseTDate(String dateStr) {
		return parseDate(dateStr, "yyyy/MM/dd HH:mm:ss");
	}
	
	/**
	 * 字符串转日期
	 * @param str 日期
	 * @param dateformat YYYY-MM-DD 格式
	 * @return Date
	 */
	public static Date StrToDate(String str,String dateformat) {
		   
	    SimpleDateFormat format = new SimpleDateFormat(dateformat);
	    Date date = null;
	    try {
	    	if(StringUtils.isNotBlank(str)&&!str.equals("")){
	    		date = format.parse(str);
	    	}
	    } catch (Exception e) {
	     e.printStackTrace();
	    }
	    return date;
	 }

	
	/**
	 * 功能描述：格式化输出日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return 返回字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				dateFormat = new SimpleDateFormat(format);
				result = dateFormat.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 功能描述：
	 * 
	 * @param date
	 *            Date 日期
	 * @return
	 */
	public static String format(Date date) {
		return format(date, "yyyy/MM/dd");
	}
	
	public static String formatString(Date date) {
		return format(date, "yyyyMMdd");
	}
	/**
	 * 钱邓水 
	 * 以时间命名
	 * @return
	 */
	public static String formatName() {
		Date date = new Date();
		return format(date, "yyyyMMddHHmmss");
	}
	/**
	 * 钱邓水 
	 * 获得当前系统时间
	 * @return
	 */
	public static Date getTime(){
		// 系统时间取得
		Date date = new Date();
		return date;
	}
	/**
	 * 功能描述：返回年份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 功能描述：返回月份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能描述：返回日份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能描述：返回小时
	 * 
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 功能描述：返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	/**
	 * 功能描述：返回字符型日期
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型日期 yyyy/MM/dd 格式
	 */
	public static String getDate(Date date) {
		return format(date, "yyyy/MM/dd");
	}

	/**
	 * 功能描述：返回字符型时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型时间 HH:mm:ss 格式
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	/**
	 * 功能描述：返回字符型日期时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型日期时间 yyyy/MM/dd HH:mm:ss 格式
	 */
	public static String getDateTime(Date date) {
		return format(date, "yyyy/MM/dd HH:mm:ss");
	}

	/**
	 * 功能描述：日期相加
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		calendar = Calendar.getInstance();
		long millis = getMillis(date) + ((long) day) * 24 * 3600 * 1000;
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	/**
	 * 功能描述：日期相减
	 * 
	 * @param date
	 *            Date 日期
	 * @param date1
	 *            Date 日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	/**
	 * 功能描述：取得指定月份的第一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String yyyy-MM-dd 格式
	 */
	public static String getMonthBegin(String strdate) {
		date = parseDate(strdate);
		return format(date, "yyyy-MM") + "-01";
	}

	/**
	 * 功能描述：取得指定月份的最后一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String getMonthEnd(String strdate) {
		date = parseDate(getMonthBegin(strdate));
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return formatDate(calendar.getTime());
	}

	/**
	 * 功能描述：常用的格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String formatDate(Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	/**
	 * 功能描述：以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return String 日期字符串
	 */
	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/** --------------发票项目使用日期工具类---------------*/
	
	/**
	 * @功能描述:将日期转换为字符串
	 * @param Date
	 * @return String
	 * @author 王传圣
	 */
	public static String parseDateToString(Date date)throws PTPECAppException{
		
		String timeString = null;
		try {
			if(null != date){
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				timeString = dateFormat.format(date);	
			}				
		} catch (Exception ex) {
			throw new PTPECAppException("将日期转换为字符串异常",ex.getCause(),ex.getStackTrace()[0].toString());
		}
		return timeString;	
	}
	
	/**
	 * @功能描述:将日期按照指定的格式转换为字符串
	 * @param Date
	 * @return String
	 * @author 王传圣
	 */
	public static String parseDateToString(Date date,String formatString)throws PTPECAppException{
		
		String timeString = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(formatString); 
			timeString = dateFormat.format(date);				
		} catch (Exception ex) {
			throw new PTPECAppException("将日期按照指定的格式转换为字符串异常",ex.getCause(),ex.getStackTrace()[0].toString());
		}
		return timeString;	
	}
	
	/**
	 * @功能描述:将日期加N个小时
	 * @param Date date,int n
	 * @return Date
	 * @author 王传圣
	 */
	public static Date DateAddHour(Date date,int n) throws Exception{
		
		Date dateTemp = null;
		Calendar Cal = Calendar.getInstance();    
		try {			
			Cal.setTime(date);
			Cal.add(Calendar.HOUR, n);   
			dateTemp = Cal.getTime();
			return dateTemp;
		} catch (Exception ex) {
			ex.getCause();
		}
		return dateTemp;		
	}
	
	/**
	 * @功能描述:将日期加N天
	 * @param Date date,int n
	 * @return Date
	 * @author 王传圣
	 */
	public static Date dateAddDay(Date date,int n) throws Exception{
		
		Date dateTemp = null;
		Calendar Cal = Calendar.getInstance();    
		try {			
			Cal.setTime(date);
			Cal.add(Calendar.DAY_OF_MONTH, n);   
			dateTemp = Cal.getTime();
			return dateTemp;
		} catch (Exception ex) {
			ex.getCause();
		}
		return dateTemp;		
	}
	
	/**
	 * @功能描述:将日期加N月
	 * @param Date date,int n
	 * @return Date
	 * @author 王传圣
	 */
	public static Date dateAddMonth(Date date,int n) throws Exception{
		
		Date dateTemp = null;
		Calendar Cal = Calendar.getInstance();    
		try {			
			Cal.setTime(date);
			Cal.add(Calendar.MONTH, n);   
			dateTemp = Cal.getTime();
			return dateTemp;
		} catch (Exception ex) {
			ex.getCause();
		}
		return dateTemp;		
	}
	
	/**
	 * @功能描述:将时间加N秒
	 * @param Date date,int n
	 * @return Date
	 * @author 王传圣
	 */
	public static Date dateAddSecond(Date date,int n) throws Exception{
		
		Date dateTemp = null;
		Calendar Cal = Calendar.getInstance();    
		try {			
			Cal.setTime(date);
			Cal.add(Calendar.SECOND, n);   
			dateTemp = Cal.getTime();
			return dateTemp;
		} catch (Exception ex) {
			ex.getCause();
		}
		return dateTemp;		
	}
	
	/**
	 * @功能描述:判断日期是星期几(1:星期日,2:星期一,以此类推)
	 * @param Date date
	 * @return Integer
	 * @author 王传圣
	 */
	public static Integer dateOfWeek(Date date) throws Exception{
		
		Integer result = null;
		
		try {	
			Calendar cal = Calendar.getInstance();    			
			cal.setTime(date);
			result = cal.get(Calendar.DAY_OF_WEEK);
		} catch (Exception ex) {
			ex.getCause();
		}
		
		return result;		
	}
		
	
	/**
	 * @功能描述:判断日期是星期几(1:星期日,2:星期一,以此类推)
	 * @param Date date
	 * @return Integer
	 * @author 王传圣
	 */
	public static Integer dateOfMonth(Date date) throws Exception{
		
		Integer result = null;
		
		try {	
			Calendar cal = Calendar.getInstance();    
			cal.setTime(date);
			result = cal.get(Calendar.DAY_OF_MONTH);
		} catch (Exception ex) {
			ex.getCause();
		}
		
		return result;		
	}
	
	/**
	 * @功能描述:将日期加N年
	 * @param Date date,int n
	 * @return Date
	 * @author 王传圣
	 */
	public static Date dateAddYear(Date date,int n) throws Exception{
		
		Date dateTemp = null;
		Calendar Cal = Calendar.getInstance();    
		try {			
			Cal.setTime(date);
			Cal.add(Calendar.YEAR, n);   
			dateTemp = Cal.getTime();
			return dateTemp;
		} catch (Exception ex) {
			ex.getCause();
		}
		return dateTemp;		
	}
	
	/**
	 * @功能描述:将字符串转换为日期
	 * @param String timeString,String formatString
	 * @return Date
	 * @author 王传圣
	 */
	public static Date parseStringToDate(String timeString,String formatString) throws Exception{
		
		Date date = null;
		try {
			if(null != timeString && !"".equals(timeString)){
				DateFormat format = new SimpleDateFormat(formatString); 			
				date = format.parse(timeString);
			}	
			return date;
		} catch (Exception ex) {
			ex.getCause();
		}
		return date;	
	}
	
	/**
	 * @功能描述:将字符串转换为日期
	 * @param String timeString,String formatString
	 * @return Date
	 * @author 王传圣
	 */
	public static Date parseStringToDate(String timeString) throws Exception{
		
		Date date = null;
		try {
			if(null != timeString && !"".equals(timeString)){
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 			
				date = format.parse(timeString);
			}	
			return date;
		} catch (Exception ex) {
			ex.getCause();
		}
		return date;	
	}
	
	/**
	 * @功能描述：设置时分秒
	 * @param Date date,int n
	 * @return Date
	 * @author 王传圣
	 */
	public static Date setDateTime(Date date,int hour,int minute,int second) throws Exception{
		
		Date dateTemp = null;
		Calendar Cal = Calendar.getInstance();    
		try {			
			Cal.setTime(date);
			Cal.set(Calendar.HOUR_OF_DAY, hour);
			Cal.set(Calendar.MINUTE, minute);
			Cal.set(Calendar.SECOND, second);   
			dateTemp = Cal.getTime();
			return dateTemp;
		} catch (Exception ex) {
			ex.getCause();
		}
		return dateTemp;		
	}
	/**
	 * 给日期减天数
	 * @param date
	 * @param days
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date subTimeByDay(java.util.Date date,int days) throws Exception
	{
		Calendar calendar=Calendar.getInstance();   
		 calendar.setTime(date);
		calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)-days);
		return calendar.getTime();
	}
	/**
	 * 给日期加天数
	 * @param date
	 * @param days
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date addTimeByDay(java.util.Date date,int days) throws Exception
	{
		Calendar calendar=Calendar.getInstance();   
		 calendar.setTime(date);
		calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+days);
		return calendar.getTime();
	}
	/**
	 * 给日期加分钟
	 * @param date
	 * @param minutes
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date addTimeByMinutes(java.util.Date date,int minutes) throws Exception
	{
		Calendar calendar=Calendar.getInstance();   
		 calendar.setTime(date);
		 calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+minutes);
		return calendar.getTime();
	}
	/**
	 * 添加秒
	 * @param date
	 * @param seconds
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date addTimeBySeconds(java.util.Date date,int seconds) throws Exception
	{
		Calendar calendar=Calendar.getInstance();   
		 calendar.setTime(date);
		 calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND)+seconds);
		return calendar.getTime();
	}
	public static java.util.Date nowTime() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datestr = sdf.format(java.util.Calendar.getInstance().getTime());
		
		return sdf.parse(datestr);
	}
	public static java.util.Date nowFullTime() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr = sdf.format(java.util.Calendar.getInstance().getTime());
		return sdf.parse(datestr);
	}
	public static java.util.Date nowFullTime(String format) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String datestr = sdf.format(java.util.Calendar.getInstance().getTime());
		return sdf.parse(datestr);
	}
	public static String convertDateStrToString(String datestr,String format) throws Exception
	{
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try
		{
			result = sdf.format(sdf.parse(datestr));
		}
		catch (Exception ex)
		{
			 sdf = new SimpleDateFormat("yyyy-MM-dd");
			result = sdf.format(sdf.parse(datestr));
		}
		return result;
	}
	public static String convertDateToString(java.util.Date date,String format) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static java.util.Date formatDateStr(String datestr) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.parse(datestr);
	}
	
	public static java.util.Date formatDateStr(String datestr,String format) throws Exception
	{
		java.util.Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try
		{
			result = sdf.parse(datestr);
		}
		catch (Exception ex)
		{
			 sdf = new SimpleDateFormat("yyyy-MM-dd");
			result = sdf.parse(datestr);
		}
		return result;
	}
	public static java.util.Date formatFullDateStr(String datestr) throws Exception
	{
		java.util.Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			result = sdf.parse(datestr);
		}
		catch (Exception ex)
		{
			 sdf = new SimpleDateFormat("yyyy-MM-dd");
			result = sdf.parse(datestr);
		}
		return result;
	}
	/**
	 * 得到小时，分的格式例如 02:32
	 */
	public static final String getFormatTime(java.util.Date date) {
		String Tempstr;
		int i;
		SimpleDateFormat mydate = new SimpleDateFormat(" MMM dd H mm ss,yyyy");
		Tempstr = "";

		mydate.applyPattern("H");
		i = Integer.parseInt(mydate.format(date));
		if (i < 10) {
			Tempstr = Tempstr + "0" + String.valueOf(i) + ":";
		} else {
			Tempstr = Tempstr + String.valueOf(i) + ":";
		}

		mydate.applyPattern("mm");
		i = Integer.parseInt(mydate.format(date));
		if (i < 10) {
			Tempstr = Tempstr + "0" + String.valueOf(i);
		} else {
			Tempstr = Tempstr + String.valueOf(i);
		}

		return Tempstr;
	}

	/**
	 * 得到小时的格式例如 02
	 */
	public static final String getFormatHour(java.util.Date date) {
		String Tempstr;
		int i;
		SimpleDateFormat mydate = new SimpleDateFormat(" MMM dd H mm ss,yyyy");
		Tempstr = "";

		mydate.applyPattern("H");
		i = Integer.parseInt(mydate.format(date));
		Tempstr = Tempstr + String.valueOf(i);
		return Tempstr;
	}

	/**
	 * 
	 * 得到小时的格式例如 02
	 */
	public static final String getFormatMinute(Date date) {

		String Tempstr;
		int i;
		SimpleDateFormat mydate = new SimpleDateFormat(" MMM dd H mm ss,yyyy");
		Tempstr = "";

		mydate.applyPattern("mm");
		i = Integer.parseInt(mydate.format(date));
		Tempstr = Tempstr + String.valueOf(i);
		return Tempstr;
	}
	/**
	 * 根据日期得到年份字符串
	 */
	public static final String getYearFromDate(Date date) {
		String Tempstr;
		int i;
		SimpleDateFormat mydate = new SimpleDateFormat(" MMM dd H mm ss,yyyy");
		Tempstr = "";
		mydate.applyPattern("yyyy");
		i = Integer.parseInt(mydate.format(date));
		Tempstr = Tempstr + String.valueOf(i);
		return Tempstr;
	}

	/**
	 * 根据日期得到月份字符串
	 */
	public static final String getMonthFromDate(Date date) {
		String Tempstr;
		int i;
		SimpleDateFormat mydate = new SimpleDateFormat(" MM dd H mm ss,yyyy");
		Tempstr = "";
		mydate.applyPattern("MM");
		i = Integer.parseInt(mydate.format(date));
		Tempstr = Tempstr + String.valueOf(i);
		return Tempstr;
	}

	/**
	 * 根据日期得到日期字符串
	 */
	public static final String getDayFromDate(Date date) {
		String Tempstr;
		int i;
		SimpleDateFormat mydate = new SimpleDateFormat(" MM dd H mm ss,yyyy");
		Tempstr = "";
		mydate.applyPattern("dd");
		i = Integer.parseInt(mydate.format(date));
		Tempstr = Tempstr + String.valueOf(i);
		return Tempstr;
	}

	/**
	 * 根据日期得到小时字符串
	 */
	public static final String getHourFromDate(Date date) {
		String Tempstr;
		int i;
		SimpleDateFormat mydate = new SimpleDateFormat(" MM dd H mm ss,yyyy");
		Tempstr = "";
		mydate.applyPattern("H");
		i = Integer.parseInt(mydate.format(date));
		Tempstr = Tempstr + String.valueOf(i);
		return Tempstr;
	}

	/**
	 * 用于只输入年月日生成long型的时间格式
	 **/
	public static final long getTimeLong(int yy, int mm, int dd) {
		calendar.clear();
		calendar.set(yy, mm - 1, dd, 0, 0, 0);
		return calendar.getTimeInMillis();

	}

	/**
	 * 用于输入年月日小时分生成long型的时间格式
	 **/
	public static final long getTimeLong(int yy, int mm, int dd, int h, int m) {
		calendar.clear();
		calendar.set(yy, mm - 1, dd, h, m, 0);
		return calendar.getTimeInMillis();
	}

	/**
	 * 用于只输入年，月生成long型的时间格式
	 **/
	public static final long getTimeLong(int yy, int mm) {
		calendar.clear();
		calendar.set(yy, mm - 1, 0, 0, 0, 0);
		return calendar.getTimeInMillis();
	}

	/**
	 * 根据输入的初始日期和新增的月份到新增月份后的总时间
	 **/
	public static final long getTotalTime(Date startTime, long month) {
		calendar.setTime(startTime);
		calendar.add(Calendar.MONTH, (int) month);
		return calendar.getTimeInMillis();
	}

	/**
	 * 用于输入年月日小时分秒生成long型的时间格式
	 **/
	public static final long getTimeLong(int yy, int mm, int dd, int h, int m,
			int sec) {
		calendar.clear();
		calendar.set(yy, mm - 1, dd, h, m, sec);
		return calendar.getTimeInMillis();
	}

	/**
	 * 根据输入一个时间得到和现在的时间差
	 **/
	public static final String getLeaveTime(long tagTime) {
		long nowTime = System.currentTimeMillis();
		long leaveTime = 0;
		if (nowTime > tagTime)
			leaveTime = (nowTime - tagTime) / 1000;
		else
			leaveTime = (tagTime - nowTime) / 1000;
		long date = 0;
		long hour = 0;
		long minute = 0;
		// int second = 0;

		long dateTime = 0;
		long hourTime = 0;
		// long minuteTime = 0;

		String strDate = "";
		String strHour = "";
		String strMinute = "";
		// String strSecond = "";

		date = leaveTime / 86400;
		dateTime = date * 86400;
		hour = (leaveTime - dateTime) / 3600;
		hourTime = hour * 3600;
		minute = (leaveTime - dateTime - hourTime) / 60;
		// minuteTime = minute*60;

		// second = leaveTime - dateTime - hourTime-minuteTime;

		if (date > 0)
			strDate = date + "天";
		if (hour > 0 || (minute > 0 && date > 0))
			strHour = hour + "小时";
		if (minute > 0)
			strMinute = minute + "分";
		// if(second>0)
		// strSecond = second+"秒";

		return strDate + strHour + strMinute;
	}
	/**
	 * 字符串转为java.sql.date
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static java.sql.Date toSQLDate(String dateStr, String format)
	{
		try
		{
			if (dateStr == null || dateStr.equals(""))
				return null;
			return new java.sql.Date(formatDateStr(dateStr,format).getTime());
		}
		catch(Exception ex)
		{return null;}
		
	}
	/**
     * 转换XML日期格式到日期格式
     * @param date
     */
	public static  Date convertXMLGregorianCalendarToDate(XMLGregorianCalendar date) {
        if(date == null)
        {
            return null;
        }
        GregorianCalendar ca =date.toGregorianCalendar();
        String format = "MM/dd/yyyy HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.format(ca.getTime());
        return toDate(formatter.format(ca.getTime()),format);
    }
	
	public static Date toDate(String date, String format)
	{
		try
		{
			return (new SimpleDateFormat(format)).parse(date);
		}
		catch (Exception ex)
		{
			return null;
		}
	}
	public static  XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date) {

        if(date == null)
        {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar gc = null;
        try {
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (DatatypeConfigurationException e) {
            System.out.println(" There are some error for convert java.util.Date to XMLGregorianCalendar");
        }
        
        return gc;
    }
	
	/**
	 * String time="Jun 24, 2013 05:13:41 PM";
	 * 转为 2013-6-24 05:13:41格式
	 * @param dataString
	 * @return
	 */
	 
	@SuppressWarnings("deprecation")
	public static String DateToString(String dataString){
		String time="";
		 String format = "yyyy-MM-dd HH:mm:ss";
         SimpleDateFormat formatter = new SimpleDateFormat(format);
         time=formatter.format(new  Date(dataString)); 
		return time;
	}
	/**
	 * String time="Jun 24, 2013 05:13:41 PM";
	 * 转为 2013-6-24 05:13:41格式
	 * @param dataString
	 * @return
	 */
	public static String DateToforString(String dataString){
		 String result="";  
         String[] yymmss_=dataString.split(",");
         String mm=yymmss_[0].substring(0, 3).trim();
         String ss=yymmss_[0].substring(3, yymmss_[0].toString().length()).trim();
         String yy_time=yymmss_[1].subSequence(0, 5).toString();
         String timedate=yymmss_[1].subSequence(5, yymmss_[1].toString().length()-3).toString();
       
         Map<String, String> map = new HashMap<String, String>();  
         map.put("Jan","1");  
         map.put("Feb","2");  
         map.put("Mar","3");
         map.put("Apr","4"); 
         
         map.put("May","5");  
         map.put("Jun","6");  
         map.put("Jul","7");
         map.put("Aug","8");
         
         map.put("Sep","9");  
         map.put("Oct","10");  
         map.put("Nov","11");
         map.put("Dec","12");
         result=yy_time+"-"+map.get(mm)+"-"+ss+timedate;
		return result;
	}
	
	public static String get3MonthBefor() {
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -2);// 得到前二个月
		cal.set(Calendar.DAY_OF_MONTH,1);// 得到前二个月第一天
		return sdf.format(cal.getTime());
	}
	
	/**
	 * 获取现在时间
	 * 
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	/**
	 * 获取现在时间
	 * 
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringCurrentTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	/*** 
     * 日期月份加一个月 
     * @param datetime 日期 
     * @return 2016-12-07 10:42 
     */  
    public static String addOneMonthFormat(String datetime) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = null;  
        try {  
            date = sdf.parse(datetime);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        Calendar cl = Calendar.getInstance();  
        cl.setTime(date);  
        cl.add(Calendar.MONTH, 1);  
        date = cl.getTime();  
        return sdf.format(date);  
    }
    /* 2个日期相差月数
     * @author cjh
     * @param  dateB dateE
     * @return 相差月数
     * @throws
     */
    public static int getMonthsBetweenTwoDate(String date1,String date2) throws Exception{
       /* String[] arg1 = dateB.split("-");
        String[] arg2 = dateE.split("-");
        int year1 = Integer.valueOf(arg1[0]);
        int year2 = Integer.valueOf(arg2[0]);
        int month1 = Integer.valueOf(arg1[1]);
        int month2 = Integer.valueOf(arg2[1]);

        int months=0;
        for (int i = year1; i <= year2; i++) {
            int monthCount = 12;
            int monthStart = 1;
            if (i == year1) {
                monthStart = month1;
                monthCount = 12-monthStart+1;
            } else if (i == year2) {
                monthCount = month2;
            }
            for(int j = 0; j < monthCount; j++){
                int temp = monthStart+j;
                if(temp >=10){
                    System.out.println(i+"-"+(monthStart+j));
                    months++;
                }else{
                    System.out.println(i+"-0"+(monthStart+j));
                    months++;
                }
            }
        }*/
    	 SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
         Calendar c = Calendar.getInstance();
         c.setTime(sdf.parse(date1));
         int year1 = c.get(Calendar.YEAR);
         int month1 = c.get(Calendar.MONTH);
          
         c.setTime(sdf.parse(date2));
         int year2 = c.get(Calendar.YEAR);
         int month2 = c.get(Calendar.MONTH);
          
         int result;
         if(year1 == year2) {
             result = month1 - month2;
         } else {
             result = 12*(year1 - year2) + month1 - month2;
         }
         return Math.abs(result);
    }
    
    /**201701121428
     * 日期格式校验:正确格式为2017-01-12
     * cjh
     */
    public  static boolean  validTimestamp(String str){
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	         try{
	                 Date date =  formatter.parse(str);
	                 return  str.equals(formatter.format(date));
	         }catch(Exception   e){
	               return   false;
	         }
	 }
   
    /**
     * 获取某年某月第一天
     * @param year
     * @param month
     * @return
     */
	public static String getFirstDayOfMonth(int year, int month) {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);

		cal.set(Calendar.MONTH, month - 1);

		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));

		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}
	 /**
     * 获取某年某月最后一天
     * @param year
     * @param month
     * @return
     */
	 public static String getLastDayOfMonth(int year, int month) {
		 
		  Calendar cal = Calendar.getInstance();
		 
		  cal.set(Calendar.YEAR, year);
		 
		  cal.set(Calendar.MONTH, month-1);
		 
		  cal.set(Calendar.DAY_OF_MONTH, 1);
		  int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		  cal.set(Calendar.DAY_OF_MONTH, value);
		 
		  return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		 
	 }
	 
	 /**
	  * 日期由long类型转换为date类型
	  * cjh-20170704
	  */
	 public static String getDateByLong(long value){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		java.util.Date dt = new Date(value);  
		String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
		return sDateTime;
	 }
	 
	 /** 
	 *cjh-20170704
     * 获取当年的最后一天 
     * @param year 
     * @return 
     */  
    public static Date getCurrYearLast(){  
        Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR);  
        return getYearLast(currentYear);  
    }  
    /** 
     * 获取某年最后一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getYearLast(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        Date currYearLast = calendar.getTime();  
        return currYearLast;  
    }  
    
    /**
	 * 功能描述：
	 * 
	 * @param date
	 *            Date 日期
	 * @return
	 */
	public static String formats(Date date) {
		return format(date, "yyyy-MM-dd");
	}
	
	/**
	 * https://zhidao.baidu.com/question/1893723379109508900.html
	 * cjh-20171026
	 * @param date 需要计算的日期
	 * @param day  需要添加的天数
	 * @return 返回添加后的日期
	 */
	public static String addOneDay(String date,int day){
		String resultDay="";
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");/*** 加一天*/
			Date dd = df.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dd);
			calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
			//System.out.println("增加一天之后：" + df.format(calendar.getTime()));
			resultDay = df.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultDay;
	}
	
	/**
	 * 2个字符串日期间隔天数
	 * cjh-20180109
	 * @return
	 */
	public static long internalBetweenDays(String startTime,String endTime){
		long day=0;
		try {
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");    
			java.util.Date beginDate= format.parse(startTime);    
			java.util.Date endDate= format.parse(endTime);    
			day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);    
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			return day;
		}
	}
	
	/*** 
	 * cjh-20180109
     * 日期加X天
     * @param datetime 日期 
     * @return 2016-12-07 10:42 
     */  
    public static String addDaysFormat(String datetime,int days) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = null;  
        try {  
            date = sdf.parse(datetime);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        Calendar cl = Calendar.getInstance();  
        cl.setTime(date);  
        cl.add(Calendar.DAY_OF_MONTH, days);  
        date = cl.getTime();  
        return sdf.format(date);  
    }
    /*** 
	 * cjh-20180109
     * 日期减X天
     * @param datetime 日期 
     * @return 2016-12-07 10:42 
     */  
    public static String subducDaysFormat(String datetime,int days) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = null;  
        try {  
            date = sdf.parse(datetime);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        Calendar cl = Calendar.getInstance();  
        cl.setTime(date);  
        cl.add(Calendar.DAY_OF_MONTH, -days);  
        date = cl.getTime();  
        return sdf.format(date);  
    }
    
    /**
     * 2个字符串日期相差多少小时数
     * cjh-20180109
     * @param args
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public static Map hoursBetweenTwoStringDate(String endTime,String startTime){
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	long intervalTime =0;
    	Map map=new HashMap();
    	try {
    		Date d1 = df.parse(endTime);
		    Date d2 = df.parse(startTime);
		    long diff = d1.getTime() - d2.getTime();
		    long day=diff/(24*60*60*1000);
		    long hour=(diff/(60*60*1000)-day*24);
		    long min=((diff/(60*1000))-day*24*60-hour*60);
		    intervalTime=(diff/1000-day*24*60*60-hour*60*60-min*60);
		    if(day==0){
		    	map.put("completeTime", ""+hour+"小时"+min+"分");
		    }else{
		    	map.put("completeTime", ""+day+"天"+hour+"小时"+min+"分");
		    }
		    map.put("intervalTime", day*24+hour);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return map;
    }
    
    
    
    /**
     * 登录后页面右边首页预警信息使用
     * cjh-20180109--根据传入的值转换成从当前日期之前的几天合并成一个字符串
     * @param invoicingAlertDay
     * @return
     */
    public static String getInvoicingAlertDayString(int invoicingAlertDay) {
		StringBuilder invoicingAlertDayString = new StringBuilder();
		for(int i=0;i<invoicingAlertDay;i++){
			invoicingAlertDayString.append(subducDaysFormat(getStringDate(),i)+",");
		}
		return invoicingAlertDayString.toString();
	}
    
    /**
	 * 获得本天的开始时间，即2018-01-10 00:00:00
	 * @return Date
	 */
	public static Date getCurrentDayStartTime() {
		// 日期格式化格式
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		try {
			now = shortSdf.parse(shortSdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本天的结束时间，即2018-01-10 23:59:59
	 * @return Date
	 */
	public static Date getCurrentDayEndTime() {
		// 日期格式化格式
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		try {
			now = longSdf.parse(shortSdf.format(now) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
    
	/**
	 * 获得当前时间的前一天同一时间
	 * @return Date
	 */
	public static String getCurrentTimeOfYesterday(Date date) throws Exception{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -1);//+1今天的时间加一天
		date = calendar.getTime();
		return parseDateToString(date);
	}
    
    
    public static void main(String[] args) throws Exception{
   	/* SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
     String str = sdf.format(formatDateStr("2017-09-13")); 
     Map map=hoursBetweenTwoStringDate("2018-01-10 10:47:53","2018-01-09 02:47:38");
     
     Calendar calendar = Calendar.getInstance();
	 calendar.setTime(new Date());
	 calendar.add(Calendar.DAY_OF_MONTH, -1);//+1今天的时间加一天
	 date = calendar.getTime();*
	 System.out.println(parseDateToString(date));
     */
    //1504195200000  1506787199000
   	//System.out.println(DateUtils.formatDateStr("2017-09-13 00:00:00", "yyyy-MM-dd HH:mm:ss").getTime());
   	//System.out.println(DateUtils.formatDateStr("2017-09-13 23:59:59", "yyyy-MM-dd HH:mm:ss").getTime());
   	//System.out.println("==="+getDateByLong(1513613776000L)); 
   	//System.out.println(getDateByLong(1514735999999L)); 
   	
   	System.out.println(getDateByLong(1514649600000L));
   	System.out.println(getDateByLong(1516031999000L)); 
   	//System.out.println( Long.parseLong("2017-12-07 00:00:00"));
   	//System.out.println( Long.parseLong("2017-12-07 23:59:59"));
   	
   	//System.out.println(DateUtils.formatDateStr("2017-12-20 00:00:00", "yyyy-MM-dd HH:mm:ss").getTime());
   	//System.out.println(DateUtils.formatDateStr("2017-12-20 23:59:59", "yyyy-MM-dd HH:mm:ss").getTime());
   	/*System.out.println(getDateByLong(1508940190640L)); 
   	System.out.println(getDateByLong(1504799999000L)); 
   	Calendar cal=Calendar.getInstance();
   	//System.out.println(Calendar.DATE);//5
   	cal.add(Calendar.DATE,-1);
   	Date time=cal.getTime();
   	System.out.println(time);
   	System.out.println(new Date());*/
   	
   	//System.out.println(DateUtils.dateAddDay(new Date(),-3));
   	
	}

	
  
}
