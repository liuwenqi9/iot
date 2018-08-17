package com.afs.tupeasy.session;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.EventExecutor;

public class MyChannelGroup extends DefaultChannelGroup{
	private static Logger log = LogManager.getLogger(MyChannelGroup.class.getName());
	private static List<ChannelOffLineListenner> channelOffLineList = new ArrayList<ChannelOffLineListenner>();
	
	public MyChannelGroup(EventExecutor executor) {
		super(executor);
	}
	
	@Override
	public boolean remove(Object o) {
		String channelId = "";
        Channel c = null;
        if (o instanceof ChannelId) {
        	channelId = ((ChannelId)o).asLongText();
        } else if (o instanceof Channel) {
            c = (Channel) o;
            channelId = c.id().asLongText();
        }
        log.info("MyChannelGroup remove：" +channelId);
        String clientId = SessionManager.getClientIdByChannelId(channelId);
		SessionManager.removeSession(clientId);
		
		for(ChannelOffLineListenner listenner:channelOffLineList){
			listenner.onChannelOff(clientId);
		}
		
		return super.remove(o);
	}
	
	@Override
	public boolean add(Channel channel) {
		return super.add(channel);
	}

	public static void addChannelOffLineListenner(ChannelOffLineListenner listenner){
		channelOffLineList.add(listenner);
	}
	
}
