package com.pcitc.oilmachine;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 通用日期处理工具类
 * @author 
 * 2012-2-3
 */
public class DateUtils {
	public static Date date = null;

	public static DateFormat dateFormat = null;

	public static Calendar calendar = Calendar.getInstance() ;

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
			date = (Date) dateFormat.parse(dateStr);
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
	/**
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

	
	/**
	 * @功能描述:将日期按照指定的格式转换为字符串
	 * @param Date
	 * @return String
	 * @author 王传圣
	 */
	public static String parseDateToString(Date date,String formatString)throws Exception{
		
		String timeString = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(formatString); 
			timeString = dateFormat.format(date);				
		} catch (Exception ex) {
			throw ex;
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
	public static java.util.Date nowFullTime(String format) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String datestr = sdf.format(java.util.Calendar.getInstance().getTime());
		return sdf.parse(datestr);
	}
	public static String convertDateToString(java.util.Date date,String format) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
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
	 * 获取指定日期下一天
	 */
	public static String getDateNextDay(String datePar){
		Calendar c = Calendar.getInstance(); 
		Date date=null; 
		try { 
		date = new SimpleDateFormat("yy-MM-dd").parse(datePar); 
		} catch (Exception e) { 
		e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day+1); 

		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
	}
	/**
	 * 获取上一天
	 * @param datePar
	 * @return
	 */
	public static String getDateBeforeDay(String datePar){
		Calendar c = Calendar.getInstance(); 
		Date date=null; 
		try {   
		date = new SimpleDateFormat("yy-MM-dd").parse(datePar); 
		} catch (Exception e) { 
		e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day-1); 

		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
	}
	public static void main(String[] args) throws Exception{

		
		Date date =  new Date();
		System.out.println(DateUtils.format(date, "yyyy-MM-dd a HH:mm:ss.S z"));
	}
}
