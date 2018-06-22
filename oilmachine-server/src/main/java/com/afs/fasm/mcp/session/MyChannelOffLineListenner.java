package com.afs.fasm.mcp.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afs.tupeasy.session.ChannelOffLineListenner;

public class MyChannelOffLineListenner implements ChannelOffLineListenner {
	private static Logger log = LoggerFactory.getLogger(MyChannelOffLineListenner.class);
	@Override
	public void onChannelOff(String equipId) {
		log.info("onChannelOff:"+equipId);
	}

}
