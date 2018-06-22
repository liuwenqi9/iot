package com.afs.tupeasy.sync;

public class TimeoutThread implements Runnable{
	private String messageId;
	private long timeout_milliscond;
	public TimeoutThread(String messageId,long timeout_milliscond) {
		this.messageId = messageId;
		this.timeout_milliscond = timeout_milliscond;
	}
	@Override
	public void run() {
		waitTimeout();
	}
	
	private void waitTimeout(){
		try {
			Thread.sleep(timeout_milliscond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SyncCallBack sync = SyncManager.getSyncCallBackObject(messageId);
		if(sync!=null){
			sync.setMessage(null);
			sync.syncFinish(); 
	    }
	}
}
