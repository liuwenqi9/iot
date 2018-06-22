package com.afs.fasm.mcp.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionRemoveListenner;

public class MySessionRemoveListenner implements SessionRemoveListenner {
	private static Logger log = LoggerFactory.getLogger(MySessionRemoveListenner.class);
	@Override
	public void onSessionRemove(Session session) {
		log.info("onSessionRemove:"+session.getClientId());
	}

}
