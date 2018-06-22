package com.afs.base.constants;

public interface MessageTypeConstants {

	public final static byte carMessageIn = (byte)0x01;//摄像头数据上传
	public final static byte carheartIn = (byte)0x02; //摄像头心跳 
	
	public final static byte oildheartin = (byte)0x01;//油机心跳
	public final static byte oildcarmsg = (byte)0x02; //油机车牌
	
	public final static String camerapackagehead = "FAF055AA";//摄像头包头
	public final static String oildevicepackagehead = "FAF055AB";//加油机包头
}
