package com.afs.tupeasy.session;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.afs.base.mq.MQException;
import com.afs.base.mq.MessageSendService;
import com.afs.base.util.MyIPv4Util;

/**
 * 服务器启动后，向MQ报告自己服务器的名称
 * @author zhang
 *
 */

@Component
public class HostName {
	private static Logger log = LoggerFactory.getLogger(HostName.class);
	public static String hostName;
	
	@Resource
	private MessageSendService fasmSendToMQService;
	
    @PostConstruct 
	public void startHost(){
		hostName = MyIPv4Util.getHostName();
		
		try {
			int cnt = fasmSendToMQService.sendMessage(hostName.getBytes(),"serverName");
			if(cnt==1){
				log.info("向消息路由中心报告成功");
			}else{
				log.error("向消息路由中心报告失败");
			}
		} catch (MQException e) {
			e.printStackTrace();
		}
	}

	public MessageSendService getFasmSendToMQService() {
		return fasmSendToMQService;
	}

	public void setFasmSendToMQService(MessageSendService fasmSendToMQService) {
		this.fasmSendToMQService = fasmSendToMQService;
	}
	
}
