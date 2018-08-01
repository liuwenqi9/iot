package com.afs.fasm.mcp.mq;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afs.base.mq.MessageHandler;
import com.afs.base.util.MySpringContextUtil;
import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.model.DeviceFault;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.NozzleStatus;
import com.pcitc.oilmachine.service.mobile.CommonService;
import com.rabbitmq.client.BasicProperties;

public class DownMessageConsumer implements MessageHandler {
	
	private static Logger log = LoggerFactory.getLogger(DownMessageConsumer.class);
	private static Map<String,Devices> oildeviceMap = new ConcurrentHashMap<String,Devices>();

	/**
	 * 1：油枪状态
	 * 2：设备故障
	 */
	@Override
	public boolean handleMessage(byte[] message, BasicProperties prop) {
		CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
		String messageContent = "";
		try {
			JSONObject messages = JSONObject.parseObject(new String(message,"utf-8"));
			Integer messagetype = messages.getInteger("type");
			String result = messages.getString("message");
			JSONObject resultJson = JSONObject.parseObject(result);
			String oildeviceid = resultJson.getString("oildeviceid");
			messageContent = resultJson.getString("messageContent");
			Devices devices = oildeviceMap.get(oildeviceid);
			if(devices == null){
				devices = commonService.findDeviceByConnid(oildeviceid,Constant.OILMACH_CODE);
				if(devices == null){
					commonService.saveDeviceConnectError(oildeviceid, null,"当前设备没有备案导致车牌数据未存储");
					Session camerasession = SessionManager.getSession(oildeviceid);
					camerasession.setReceivedata(1);//设置拒绝接收该相机数据
					return false;
				}
				oildeviceMap.put(oildeviceid, devices);
			}
			if(messagetype == 1){
				JSONArray nozzlestatusArray = JSONObject.parseArray(messageContent);
				for(Object obj : nozzlestatusArray){
					JSONObject nozzlestatu = (JSONObject)obj;
					byte nozzleno = nozzlestatu.getByteValue("nozzleno");
					byte nozzlestatus = nozzlestatu.getByteValue("nozzlestatus");
					Long vtot = nozzlestatu.getLong("vtot");
					NozzleStatus nozzleStatus = new NozzleStatus();
					nozzleStatus.setNodecode(devices.getNodecode());
					nozzleStatus.setNodetag(devices.getNodetag());
					nozzleStatus.setTenantid(devices.getTenantid());
					nozzleStatus.setNozzleno(nozzleno);
					nozzleStatus.setNozzlestatus(nozzlestatus);
					nozzleStatus.setDeviceconnid(oildeviceid);
					nozzleStatus.setVtot(vtot);
					commonService.saveOrupdateNozzleStatus(nozzleStatus, oildeviceid);
				}
			}else if(messagetype == 2){
				JSONArray  oilfaultArray = JSONObject.parseArray(messageContent);
				for(Object obj : oilfaultArray){
					JSONObject oilfault = (JSONObject)obj;
					byte faultType = oilfault.getByteValue("faultType");
					byte codeno = oilfault.getByteValue("codeno");
					DeviceFault deviceFault = new DeviceFault();
					deviceFault.setNodecode(devices.getNodecode());
					deviceFault.setNodetag(devices.getNodetag());
					deviceFault.setTenantid(devices.getTenantid());
					deviceFault.setFaulttypecode(faultType);
					deviceFault.setFaulttypename("测试");
					deviceFault.setCodeno(codeno);
					deviceFault.setDeviceconnid(oildeviceid);
					commonService.saveOrupdateDeviceFault(deviceFault, oildeviceid);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonService.saveLog(Constant.logmodule_oilm, Constant.logtype_error, "DownMessageConsumer.handleMessage", "保存加油机故障码及油枪状态异常", messageContent, StringUtils.getErrorInfoFromException(e));
		}
		return true;
	}

}
