package com.afs.fasm.mcp.mq;

import com.afs.base.mq.MessageReceiveService;
//import com.afs.base.util.MyIPv4Util;
public class DownMessageReceiveService extends MessageReceiveService {
	public void startDownMessageConsumer(){
		//String serverName = MyIPv4Util.getHostName();
		//this.setQueueName(serverName);
		super.run();
	}
}
