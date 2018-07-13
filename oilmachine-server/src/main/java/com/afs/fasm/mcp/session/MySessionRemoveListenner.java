package com.afs.fasm.mcp.session;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionRemoveListenner;

public class MySessionRemoveListenner implements SessionRemoveListenner {
	private static Logger log = LogManager.getLogger(MySessionRemoveListenner.class.getName());
	@Override
	public void onSessionRemove(Session session) {
		log.info("onSessionRemove:"+session.getClientId());
	}

}
