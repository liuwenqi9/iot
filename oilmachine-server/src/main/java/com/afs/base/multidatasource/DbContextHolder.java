package com.afs.base.multidatasource;

public class DbContextHolder {
	private static final ThreadLocal<Object> contextHolder = new ThreadLocal<Object>();   
	   
    public static void setDbType(String dbType) {   
        contextHolder.set(dbType);   
    }   
  
    public static String getDbType() {   
        return (String) contextHolder.get();   
    }   
  
    public static void clearDbType() {   
        contextHolder.remove();   
    }   
}
