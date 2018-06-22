package com.afs.fasm.mcp.session;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.afs.tupeasy.session.MyChannelGroup;
import com.afs.tupeasy.session.SessionManager;

@Component
public class SessionListennerInit {
	@PostConstruct
	public void init(){
		SessionManager.addSessionCreateListenner(new MySessionCreateListenner());
		SessionManager.addSessionRemoveListenner(new MySessionRemoveListenner());
		MyChannelGroup.addChannelOffLineListenner(new MyChannelOffLineListenner());
	}
}
