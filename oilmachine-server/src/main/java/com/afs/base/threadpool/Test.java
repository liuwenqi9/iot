package com.afs.base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService  executor = Executors.newFixedThreadPool(15);
		         for(int i=0;i<200;i++){
		             MyTask myTask = new MyTask(i);
		             executor.execute(myTask);
		         }
		         executor.shutdown();

	}
}
	class MyTask implements Runnable {
	    private int taskNum;
	     
	    public MyTask(int num) {
	        this.taskNum = num;
	    }
	     
	    @Override
	    public void run() {
	        System.out.println("正在执行task "+taskNum);
	        try {
	            Thread.currentThread().sleep(4000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("task "+taskNum+"执行完毕");
	    }
	}

