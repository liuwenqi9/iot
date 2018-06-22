package com.afs.tupeasy.util;

public class IntStepGen {
	private static int step = 1;
	
	public static synchronized  int getNextInt(){
		if(step==Integer.MAX_VALUE){
			return 1;
		}
		return step++;
	}
	
	public static synchronized  String getNextIntAsString(){
		
		
		
		if(step==Integer.MAX_VALUE){
			return "1";
		}
		return step+++"";
	}
	
	
	public static void main(String[] args) {
		System.out.println(IntStepGen.getNextInt());
		System.out.println(IntStepGen.getNextInt());
		System.out.println(IntStepGen.getNextIntAsString());
	}
}
