package com.afs.fasm.mcp.datahandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import com.afs.base.util.MySpringContextUtil;
import com.afs.fasm.mcp.message.CarMessage;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;
import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.DateUtils;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.enums.DictionaryEnum;
import com.pcitc.oilmachine.enums.VehicleEnum;
import com.pcitc.oilmachine.form.EaccountInfo;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.DictionaryData;
import com.pcitc.oilmachine.service.mobile.CommonService;

public class CarMessageHandler extends CommonMessageHandler {
	private static Logger log = LoggerFactory.getLogger(CarMessageHandler.class);
	private static Map<Long,Devices> cameradevice = new ConcurrentHashMap<Long,Devices>();
	@Override
	public AbstractMcpEasyMessage handlerMessage(AbstractMcpEasyMessage message,
			ChannelHandlerContext ctx) {
		CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
		Channel ch = ctx.channel();
		CarMessage carMessage = (CarMessage) message;
		try {
			//1:处理摄像头连接
			Session session = SessionManager.getSession(String.valueOf(carMessage.getCameraid()));
			if(session == null){
				session = new Session();
				session.setLoginTime(new Date());
				session.setClientId(String.valueOf(carMessage.getCameraid()));
				session.setChannel(ch);
				session.setDeviceTypeCode(Constant.CAMERA_CODE);
				SessionManager.addSession(String.valueOf(carMessage.getCameraid()), session, ch);
			}else{
				if(session.getChannel() == null){
					session.setChannel(ch);
				}
				if(session.getChannel() != ch){
					session.getChannel().close();
					session.setChannel(ch);
				}
			}
			if(session.getReceivedata() != 0){
				return message;
			}
			
			String messagecontent = carMessage.getMessageContent();
			JSONArray array = JSONObject.parseArray(messagecontent);
			StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) MySpringContextUtil.getBean("stringRedisTemplate");
			Devices devices = cameradevice.get(carMessage.getCameraid());
			if(devices == null){
				devices = commonService.findDeviceByConnid(String.valueOf(carMessage.getCameraid()),Constant.CAMERA_CODE);
				if(devices == null){
					commonService.saveDeviceConnectError(String.valueOf(carMessage.getCameraid()), null,"当前设备没有备案导致车牌数据未存储");
					Session camerasession = SessionManager.getSession(String.valueOf(carMessage.getCameraid()));
					camerasession.setReceivedata(1);//设置拒绝接收该相机数据
					return message;
				}
				cameradevice.put(carMessage.getCameraid(), devices);
			}
			
			for(Object object : array){
				JSONObject json = (JSONObject)object;
				String carnum = json.getString(VehicleEnum.CARNUM.toString());
				long cameraid = json.getLongValue(VehicleEnum.CAMERAID.toString());
				//2:解析收到的数据
				if(StringUtils.isBlank(carnum)){
					log.info("**************摄像头0:"+cameraid+"当前数据未解析到车牌号**************");
					continue;
				}
				log.info("**************摄像头1:"+cameraid+"车牌号"+carnum+"**************");
				int status = json.getInteger(VehicleEnum.CARSTATUS.toString());
				int carcolor = json.getIntValue(VehicleEnum.CARCOLOR.toString());
				int cartype = json.getIntValue(VehicleEnum.CARTYPE.toString());
				long left = json.getLongValue(VehicleEnum.LEFT.toString());
				long top = json.getLongValue(VehicleEnum.TOP.toString());
				long right = json.getLongValue(VehicleEnum.RIGHT.toString());
				long bottom = json.getLongValue(VehicleEnum.BOTTOM.toString());
				BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(carnum);
				//保存最新数据
				hashOpertions.put(VehicleEnum.CARCOLOR.toString(), String.valueOf(carcolor));
				hashOpertions.put(VehicleEnum.CARTYPE.toString(), String.valueOf(cartype));
				hashOpertions.put(VehicleEnum.LEFT.toString(), String.valueOf(left));
				hashOpertions.put(VehicleEnum.TOP.toString(), String.valueOf(top));
				hashOpertions.put(VehicleEnum.RIGHT.toString(), String.valueOf(right));
				hashOpertions.put(VehicleEnum.BOTTOM.toString(), String.valueOf(bottom));
				hashOpertions.put(VehicleEnum.CARSTATUS.toString(), String.valueOf(status));
				hashOpertions.put(VehicleEnum.CAMERAID.toString(), String.valueOf(cameraid));
				hashOpertions.put(VehicleEnum.CARNUM.toString(), carnum);
				//4:获取车牌存入缓存的有效期
				DictionaryData dd = commonService.getDataByDoubleCode(DictionaryEnum.TIMEOUT, Constant.CAR_MOVE_HEART_TIMEOUT, "f652e66ac0714627aa66c58471455680");
				Date expireDate = null;
				if(dd != null){
					expireDate = DateUtils.addTimeByMinutes(new Date(), Integer.parseInt(dd.getItemValue()));
				}else{
					expireDate = DateUtils.addTimeByMinutes(new Date(), Constant.CAR_MOVE_HEART_TIMEOUT_DE);
				}
				//设置失效时间
				hashOpertions.expireAt(expireDate);
				//
				String userid = hashOpertions.get("userid");
				BoundHashOperations<String, String, String> cameraOpertions = stringRedisTemplate.boundHashOps(devices.getTenantid()+devices.getConnid());
				if(StringUtils.isNotBlank(userid) && "0".equals(userid)){//无会员 车牌数据,如果摄像头ID改变则绑到新的摄像头上，如果没有则不做处理
					String carnums = cameraOpertions.get("carnumsnouser");
					if(StringUtils.isNotBlank(carnums)){
						if(!carnums.contains(carnum)){
							carnums = carnums + "&"+carnum;
						}
					}else{
						carnums = carnum;
					}
					cameraOpertions.put("carnumsnouser", carnums);
				}else if(StringUtils.isNotBlank(userid) && !"0".equals(userid)){//绑定了会员的车牌数据
					String carnums = cameraOpertions.get("carnums");
					if(StringUtils.isNotBlank(carnums)){
						if(!carnums.contains(carnum)){
							carnums = carnums + "&"+carnum;
						}
					}else{
						carnums = carnum;
					}
					cameraOpertions.put("carnums", carnums);
				}else{//新识别到的车牌数据
					List<UserInfo> userinfos = commonService.getUserinfo(devices.getTenantid(),null, null, null, null,carnum);
					if(userinfos.size() == 1){////有会员 车牌数据
						UserInfo userinfo = userinfos.get(0);
						EaccountInfo eaccountinfo = commonService.getEwaccount(devices.getTenantid(),userinfo.getMemcardnum(),userinfo.getGasaccid());
						if(eaccountinfo == null){
							log.info("**************处理摄像头数据3:"+cameraid+"***车牌号:"+carnum+"未开通电子钱包**************");
							hashOpertions.put("userid", "0");
							String carnums = cameraOpertions.get("carnumsnouser");
							if(StringUtils.isNotBlank(carnums)){
								if(!carnums.contains(carnum)){
									carnums = carnums + "&"+carnum;
								}
							}else{
								carnums = carnum;
							}
							cameraOpertions.put("carnumsnouser", carnums);
						}else{
							//可认为是车辆首次进站
							//commonService.sendMobilecode(carnum, userinfo.getMemcardnum(), userinfo.getMobilephone(), devices);
							hashOpertions.put("userid", userinfo.getUserid());
							hashOpertions.put("username", userinfo.getUsername());
							hashOpertions.put("accountid", String.valueOf(eaccountinfo.getAccountid()));
							hashOpertions.put("amount", String.valueOf(eaccountinfo.getAmount()));
							hashOpertions.put("useableamount", String.valueOf(eaccountinfo.getUseableamount()));
							hashOpertions.put("needpassword", commonService.isneedPassWord(userinfo));
							hashOpertions.put("pwtype", commonService.getPwtype(userinfo));
							hashOpertions.put("oiltypecode", userinfo.getOiltypecode());//油品型号
							//记录当前摄像头下都有哪些车牌
							String carnums = cameraOpertions.get("carnums");
							if(StringUtils.isNotBlank(carnums)){
								if(!carnums.contains(carnum)){
									carnums = carnums + "&"+carnum;
								}
							}else{
								carnums = carnum;
							}
							cameraOpertions.put("carnums", carnums);
							log.info("**************处理摄像头数据4:"+cameraid+"***车牌号:"+carnum+"已绑定会员并且首次进站**************");
						}
					}else{
						hashOpertions.put("userid", "0");
						String carnums = cameraOpertions.get("carnumsnouser");
						if(StringUtils.isNotBlank(carnums)){
							if(!carnums.contains(carnum)){
								carnums = carnums + "&"+carnum;
							}
						}else{
							carnums = carnum;
						}
						cameraOpertions.put("carnumsnouser", carnums);
						log.info("**************处理摄像头数据2:"+cameraid+"***车牌号:"+carnum+"未绑定会员**************");
					}
				}
				System.out.println("摄像头："+carMessage.getCameraid()+",识别到的未绑定会员的车牌号数据集合："+cameraOpertions.get("carnumsnouser"));
				System.out.println("摄像头："+carMessage.getCameraid()+",识别到的绑定会员的车牌号数据集合："+cameraOpertions.get("carnums"));
			}
		} catch (Exception e) {
			commonService.saveDeviceConnectError(String.valueOf(carMessage.getCameraid()), null, JSONObject.toJSONString(carMessage));
		}
		return message;
	}
}
