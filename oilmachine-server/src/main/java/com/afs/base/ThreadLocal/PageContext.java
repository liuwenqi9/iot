package com.afs.base.ThreadLocal;

public class PageContext {
	private static final ThreadLocal<ThreadLocalObject> contextHolder = new ThreadLocal<ThreadLocalObject>();
	
    public static void setPage(ThreadLocalObject tlo) {   
        contextHolder.set(tlo);   
    }   
  
    public static ThreadLocalObject getPage() {   
        return (ThreadLocalObject) contextHolder.get();   
    }   
  
    public static void clearDbType() {   
        contextHolder.remove();   
    } 	
}
