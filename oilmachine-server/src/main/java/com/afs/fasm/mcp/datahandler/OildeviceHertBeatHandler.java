package com.afs.fasm.mcp.datahandler;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import com.afs.base.util.MySpringContextUtil;
import com.afs.fasm.mcp.message.OildeviceheartBeatMessage;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;
import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionManager;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.form.Vehicle;
import com.pcitc.oilmachine.service.mobile.CommonService;

public class OildeviceHertBeatHandler extends CommonMessageHandler {
	private static Logger log = LoggerFactory.getLogger(OildeviceHertBeatHandler.class);
	@Override
	public AbstractMcpEasyMessage handlerMessage(AbstractMcpEasyMessage message,
			ChannelHandlerContext ctx) {
		Channel ch = ctx.channel();
		OildeviceheartBeatMessage odh = (OildeviceheartBeatMessage) message;
		String oilconnid = String.valueOf(odh.getOildeviceid());
		Session session = SessionManager.getSession(String.valueOf(odh.getOildeviceid()));
		if(session == null){
			session = new Session();
			session.setLoginTime(new Date());
			session.setClientId(oilconnid);
			session.setChannel(ch);
			session.setDeviceTypeCode(Constant.OILMACH_CODE);
			SessionManager.addSession(String.valueOf(odh.getOildeviceid()), session, ch);
		}else{
			if(session.getChannel() == null){
				session.setChannel(ch);
			}
			if(session.getChannel() != ch){
				session.getChannel().close();
				session.setChannel(ch);
			}
			session.setChannel(ch);
			if(!SessionManager.channelGroup.contains(ch)){
				SessionManager.channelGroup.add(ch);
			}
		}
		//根据加油机找摄像头,并获取当前摄像头下的所有车牌 
		CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
		//根据加油机,找到其绑定的所有的车辆信息
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		try {
			vehicles = commonService.getCurrentVehicles(oilconnid);
		} catch (PTPECAppException e) {
			e.printStackTrace();
		}
		log.info(String.valueOf(odh.getOildeviceid())+":"+JSONObject.toJSONString(vehicles));
		commonService.sendCarNumToOilDevice(vehicles, String.valueOf(odh.getOildeviceid()));
		return message;
	}
}
