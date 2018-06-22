package com.afs.tupeasy.base;

import io.netty.channel.Channel;

import java.util.concurrent.CountDownLatch;

import com.afs.tupeasy.exception.CommunicationException;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;
import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionManager;
import com.afs.tupeasy.sync.SyncManager;
import com.afs.tupeasy.sync.TimeoutThread;
import com.afs.tupeasy.sync.SyncCallBack;

public class NettySendMessageServiceImpl implements NettySendMessageService {
	
	public NettySendMessageServiceImpl() {
	}
	
	@Override
	public AbstractMcpEasyMessage sendMessage(String clientId,AbstractMcpEasyMessage message,int timeout_milliscond)
			throws CommunicationException {
		Session session = SessionManager.getSession(clientId);
		if(session==null){
			throw new CommunicationException(clientId +" is not online");
		} 
		if(message.getId()==null || message.getId().length()==0){
			throw new CommunicationException("messageid can not null");
		} 
		
		CountDownLatch waitResponseLatch = new CountDownLatch(1);
		SyncCallBack callback = new SyncCallBack();
		callback.setCountDownLatch(waitResponseLatch);
		SyncManager.addSyncCallBackObject(message.getId(), callback);
		try {
			Channel channel = SessionManager.getSession(clientId).getChannel();
			if(channel==null){
				throw new CommunicationException("not found session:"+clientId);
			}
			channel.writeAndFlush(message).await();
		} catch (InterruptedException e1) {
			throw new CommunicationException(e1.getMessage());
		}
		try {
			TimeoutThread smtt = new TimeoutThread(message.getId(),timeout_milliscond);
			Thread t = new Thread(smtt);
			t.start();
			waitResponseLatch.await();
			SyncCallBack callback2 = SyncManager.getSyncCallBackObject(message.getId());
			SyncManager.removeSyncCallBackObject(message.getId());
			return callback2.getMessage();
		} catch (InterruptedException e) {
			throw new CommunicationException(e.getMessage());
		}
	}

	@Override
	public  void  sendMessageNoWaitResponse(String clientId,AbstractMcpEasyMessage message)
			throws CommunicationException {
			Session session = SessionManager.getSession(clientId);
			if(session==null){
				throw new CommunicationException(clientId +" is not online");
			} 
			
			synchronized(this) {
				try {
					Channel channel = SessionManager.getSession(clientId).getChannel();
					if(channel==null){
						throw new CommunicationException("not found session:"+clientId);
					}
					channel.writeAndFlush(message).await();
				} catch (InterruptedException e1) {
					throw new CommunicationException(e1.getMessage());
				}
			}
	}

	@Override
	public void disConnect(String clientId) throws CommunicationException {
			Channel channel = SessionManager.getSession(clientId).getChannel();
			if(channel==null){
				throw new CommunicationException("not found session:"+clientId);
			}
			channel.disconnect();
	}
}
