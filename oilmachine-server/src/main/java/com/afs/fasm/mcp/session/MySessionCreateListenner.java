package com.afs.fasm.mcp.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionCreateListenner;

public class MySessionCreateListenner implements SessionCreateListenner {
	private static Logger log = LoggerFactory.getLogger(MySessionCreateListenner.class);
	@Override
	public void onSessionCreate(Session session) {
		log.info("onSessionCreate:"+session.getClientId());
	}

}
