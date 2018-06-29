package com.afs.base.constants;

public interface MessageTypeConstants {

	public final static byte carMessageIn = (byte)0x01;//摄像头数据上传
	public final static byte carheartIn = (byte)0x02; //摄像头心跳 
	
	public final static byte oildheartin = (byte)0x01;//油机心跳
	public final static byte oildcarmsg = (byte)0x02; //油机车牌下发
	public final static byte oilNozzleStatus = (byte)0x03; //油枪状态，油枪泵码数上传命令
	public final static byte oilfaultMsg = (byte)0x04; //故障码上传命令
	
	public final static String camerapackagehead = "FAF055AA";//摄像头包头
	public final static String oildevicepackagehead = "FAF055AB";//加油机包头
}
