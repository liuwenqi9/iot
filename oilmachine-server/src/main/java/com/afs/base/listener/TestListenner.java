package com.afs.base.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class TestListenner
 *
 */
public class TestListenner implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public TestListenner() {
        System.out.println("-------TestListenner---------");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se) {
    	System.out.println("-------sessionCreated---------");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se) {
    	System.out.println("-------sessionDestroyed---------");
    }
	
}
