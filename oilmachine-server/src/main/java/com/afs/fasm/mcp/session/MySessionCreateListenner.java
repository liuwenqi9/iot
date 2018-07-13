package com.afs.fasm.mcp.session;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionCreateListenner;

public class MySessionCreateListenner implements SessionCreateListenner {
	private static Logger log = LogManager.getLogger(MySessionCreateListenner.class.getName());
	@Override
	public void onSessionCreate(Session session) {
		log.info("onSessionCreate:"+session.getClientId());
	}

}
