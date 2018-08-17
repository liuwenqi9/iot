package com.afs.tupeasy.session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class SessionManager {
	public static ChannelGroup channelGroup  = new MyChannelGroup(GlobalEventExecutor.INSTANCE); 
	private static Map<String,Session> sessions = new ConcurrentHashMap<String,Session>();
	private static Map<String,String> ChannelIdToClientIdList = new ConcurrentHashMap<String,String>();
	
	private static List<SessionCreateListenner> createListennerList = new ArrayList<SessionCreateListenner>();
	private static List<SessionRemoveListenner> removeListennerList = new ArrayList<SessionRemoveListenner>();
	
	
	public static Map<String,Session> getAllSession(){
		return sessions;
	}

	//session
	public static void addSession(String clientId,Session session,Channel channel){
		sessions.put(clientId, session);
		channelGroup.add(channel);
		ChannelIdToClientIdList.put(channel.id().asLongText(), clientId);
		try{
			for(SessionCreateListenner listenner:createListennerList){
				listenner.onSessionCreate(session);
			}
		}catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	public static String getClientIdByChannelId(String channelId){
		return ChannelIdToClientIdList.get(channelId);
	}
	
	public static Session getSession(String clientId){
		return sessions.get(clientId);
	}
	
	public static void removeSession(String clientId){
		try{
			for(SessionRemoveListenner listenner:removeListennerList){
				listenner.onSessionRemove(getSession(clientId));
			}
		}catch(Throwable t){
			t.printStackTrace();
		}
		sessions.remove(clientId);
	}
	
	public static void addSessionCreateListenner(SessionCreateListenner listenner){
		createListennerList.add(listenner);
	}
	
	public static void addSessionRemoveListenner(SessionRemoveListenner listenner){
		removeListennerList.add(listenner);
	}
}
