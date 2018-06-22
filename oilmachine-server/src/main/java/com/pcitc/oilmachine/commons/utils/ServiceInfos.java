package com.pcitc.oilmachine.commons.utils;

 
 
/**
 * 检索类型对象路经
 * @author QDS
 *
 */ 
public class ServiceInfos {   
	@SuppressWarnings("unchecked")
	public static   Class   stringclass; 
	public static boolean serviceClass(String classUrl) throws ClassNotFoundException{
		boolean result=false;
		 try { 
			stringclass=Class.forName(classUrl) ;
			result=true;
		  } catch (Exception e) { 
			e.printStackTrace();
		  } 
		 
		 return result;
	}
}
