package com.afs.tupeasy.sync;

import java.util.concurrent.CountDownLatch;

import com.afs.tupeasy.message.AbstractMcpEasyMessage;

public class SyncCallBack {
	private CountDownLatch countDownLatch;
	private AbstractMcpEasyMessage message; // 响应消息

	public AbstractMcpEasyMessage getMessage() {
		return message;
	}

	public void setMessage(AbstractMcpEasyMessage message) {
		this.message = message;
	}

	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	
	public void syncFinish() {
		this.countDownLatch.countDown();
	}

	public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}
}
