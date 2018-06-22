package com.pcitc.oilmachine.service.mobile;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.afs.base.util.MySpringContextUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.certificate.BusinessException;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.service.mobile.CommonService;
import com.pcitc.oilmachine.form.EaccountInfo;
import com.pcitc.oilmachine.form.MobileResultInfo;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.form.Vehicle;
import com.pcitc.oilmachine.model.AdInfo;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.PreAuthorization;
import com.pcitc.oilmachine.model.SellOrder;
import com.pcitc.oilmachine.model.UserLoginfo;
/**
 * 用户通过加油机使用支付宝，微信，电子钱包支付服务类
 * @author zizhi.zhang
 *
 */
public class UserAuthenticationService{
	
	
	public MobileResultInfo execute(String data, String funName,String ip,Devices devices) {
		MobileResultInfo result = new MobileResultInfo();
		CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
		try {
			if (StringUtils.isBlank(funName)) {
				result.setError(Constant.MOBILE_FUN_ERROR);
			}
			//0油机签到接口
			else if(funName.equals("signIn")){
				result = signIn(commonService,data,ip,devices);
			}
			//1 车牌识别认证接口
			else if(funName.equals("vehicleAccess")){
				result = vehicleAccess(commonService,data,ip,devices);
			}
			
			//2、清除用户认证信息
			else if(funName.equals("clearAccessUserinfo")){
				result = clearAccessUserinfo(commonService,data,ip,devices);
			}
			
			//3 获取用户认证信息
			else if(funName.equals("getLoginUserinfo")){
				result = getLoginUserinfo(commonService,data,ip,devices);
			}
			//4 加油完成结算接口
			else if(funName.equals("gasSuccess")){
				result = gasSuccess(commonService,data,ip,devices);
			}
			//5获取广告播放列表接口
			else if(funName.equals("getAdInfoList")){
				result = getAdInfoList(commonService,data,ip,devices);
			}
			
			//6获取车牌信息
			else if(funName.equals("getVehicleNOs")){
				result = getVehicleNOs(commonService,data,ip,devices);
			}
			
			//7获取车牌信息
			else if(funName.equals("getVehicleNOsByphone")){
				result = getVehicleNOsByphone(commonService,data,ip,devices);
			}
			
			//8获取推荐商品信息
			else if(funName.equals("getUserProductInfo")){
				result = getUserProductInfo(commonService,data,ip,devices);
			}
			
			//9获取用户待提货单
			else if(funName.equals("getUserBillOfLading")){
				result = getUserBillOfLading(commonService,data,ip,devices);
			}
			
			//10获取用户提货单明细
			else if(funName.equals("getDetailByVoucherno")){
				result = getDetailByVoucherno(commonService,data,ip,devices);
			}
			//11上传加油机成交记录
			else if(funName.equals("uploadPosRecord")){
				result = uploadPosRecord(commonService,data,ip,devices);
			}
			result.setFunName(funName);
		}catch (Exception e) {
			commonService.saveUserAuthenticationError(funName,null, null, StringUtils.getErrorInfoFromException(e));
			result.setFunName(funName);
			String resultMsg = e.getMessage();
			if(StringUtils.isBlank(resultMsg) || "NULL".equals(resultMsg.toUpperCase()) || !resultMsg.contains("*")){
				result.setError("亲，程序马上崩溃了，请稍候再试...");
			}else{
				result.setError(resultMsg);
			}
			
		}
		return result;
	}
	
	/**
	 * 油机设备签到接口
	 * 作用:交换通信公钥,生成油机通信签名,签名有效期 (1天,可在数据字典中修改);签名失效时需重新交换公钥
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 */
	private MobileResultInfo signIn(CommonService commonService,String data, String ip,Devices devices) throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		try {
			JSONObject jsondata = JSONObject.parseObject(data);
			String publickey = jsondata.getString("publickey");//油机公钥
			if(StringUtils.isBlank(publickey)){
				throw new BusinessException("参数错误：publickey");
			}
			if(StringUtils.isBlank(devices.getTenantid())){
				throw new BusinessException("参数错误：tenantid");
			}
			if(StringUtils.isBlank(devices.getNodecode())){
				throw new BusinessException("参数错误：stncode");
			}
			if(StringUtils.isBlank(devices.getConnid())){
				throw new BusinessException("参数错误：deviceid");
			}
			JSONObject resu = commonService.createOilMachinePublickey(publickey, devices);
			result.setCode(0);
			result.setSuccess(resu.toJSONString());
		}catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}

	

	/**
	 * 车牌认证
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 */
	private MobileResultInfo vehicleAccess(CommonService commonService,String data,String ip,Devices devices) throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		UserLoginfo userLoginfo = null;
		String carNum = "";
		try{
			JSONObject jsondata = JSONObject.parseObject(data);
			carNum = jsondata.getString("carNum");
			String passwordtype = jsondata.getString("pwtype");
			String password = jsondata.getString("password");
			String oilcode = jsondata.getString("oilcode");//油品编码
			String price = jsondata.getString("price");//油品价格
			String oilno = jsondata.getString("oilno");//油品名称
			String nozzleno = jsondata.getString("nozzleno");//枪号
			String screencode = jsondata.getString("screencode");//屏幕号
			if(StringUtils.isBlank(carNum)){
				throw new BusinessException("参数错误：carNum");
			}
			if(StringUtils.isBlank(oilcode)){
				throw new BusinessException("参数错误：oilcode");
			}
			if(StringUtils.isBlank(price)){
				throw new BusinessException("参数错误：price");
			}
			if(StringUtils.isBlank(nozzleno)){
				throw new BusinessException("参数错误：nozzleno");
			}
			if(StringUtils.isBlank(screencode)){
				throw new BusinessException("参数错误：screencode");
			}
			Vehicle vehicleTemp = null;
			List<Vehicle> vehicles = commonService.getCurrentVehicles(devices.getConnid());
			String selfhelp = "";
			if(vehicles.size()>0){
				for(Vehicle vehicle : vehicles){
					if(carNum.equals(vehicle.getCarnum())){
						vehicleTemp = vehicle;
						break;
					}
				}
			}
			if(vehicleTemp == null){
				selfhelp = Constant.selfhelp;
				vehicleTemp = new Vehicle();
				vehicleTemp.setCarnum(carNum);
				vehicleTemp.setOiltypecode(oilcode);
				vehicleTemp.setAreacode(screencode);
			}
			List<UserInfo> userinfos = commonService.getUserinfo(devices.getTenantid(),null, null, null,null, carNum);
			if(userinfos.size() == 0){
				throw new BusinessException("用户信息不存在");
			}
			UserInfo userinfo = userinfos.get(0);
			//获取账户信息
			EaccountInfo eaccountInfo = commonService.getEwaccount(devices.getTenantid(), userinfo.getMemcardnum(),userinfo.getGasaccid());
			if(eaccountInfo.getAmount() == 0){
				throw new BusinessException("账户余额不足");
			}
			userinfo.setEaccountInfo(eaccountInfo);
			userLoginfo = new UserLoginfo();
			userLoginfo.setStncode(devices.getNodecode());
			userLoginfo.setTenantid(devices.getTenantid());
			userLoginfo.setDeviceconnid(devices.getConnid());
			userLoginfo.setAreacode(screencode);
			userLoginfo.setCarnum(carNum);
			userLoginfo.setIp(ip);
			userLoginfo.setOilcode(oilcode);
			userLoginfo.setOilno(oilno);
			userLoginfo.setPrice(StringUtils.multiplication(price, "100"));
			userLoginfo.setNozzleno(nozzleno);
			String saleno = commonService.getSaleno(devices.getConnid(),screencode,oilcode);
			userLoginfo.setSaleno(saleno);
			boolean canlogin = commonService.userIsLogin(userinfo, userLoginfo, devices);
			PreAuthorization pa = null;
			if(canlogin){
				//预授权申请
				Map<String,Object> resultMap = commonService.ntranpreCreateSession(userinfo, saleno, password, devices, userLoginfo, selfhelp, passwordtype, vehicleTemp);
				pa = (PreAuthorization)resultMap.get("pre");
				userLoginfo = (UserLoginfo)resultMap.get("uli");
			}else{
				result.setErrorcode(2);
				result.setError("用户已登陆");
				return result;
			}
			JSONObject resu = new JSONObject();
			resu.put("sign", userLoginfo.getSessionid());
			resu.put("userid", userinfo.getUserid());
			String username = userinfo.getUsername();
			username = commonService.covertUsername(username,userinfo.getSex());
			resu.put("username", username);
			resu.put("carnum", carNum);
			resu.put("accountid", String.valueOf(eaccountInfo.getAccountid()));
			resu.put("saleno", saleno);
			resu.put("amount", String.valueOf((double)eaccountInfo.getAmount()/100));
			resu.put("useableamount", String.valueOf((double)pa.getPreamount()/100));
			result.setUserid(userinfo.getUserid());
			result.setCode(0);
			result.setSuccess(resu.toJSONString());
		}catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}catch(PTPECAppException e){
			if(userLoginfo != null && StringUtils.isNotBlank(userLoginfo.getSessionid())){
				commonService.destorySession(userLoginfo.getSessionid(), userLoginfo.getUserid(), devices.getTenantid(),carNum,"0");
			}
			throw e;
		}
		return result;
	}
	
	
	/**
	 * 获取用户信息
	 * 作用:获取用户基础信息,加油机可能存在用户认证后没有加油,忘记退出的可能,用户提枪加油前调用该接口确认用户的登陆状态
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 */
	private MobileResultInfo getLoginUserinfo(CommonService commonService,String data,String ip,Devices devices)  throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		UserLoginfo userLoginInfo = null;
		try{
			JSONObject jsondata = JSONObject.parseObject(data);
			String sign = jsondata.getString("sign");//签名
			String userid = jsondata.getString("userid");
			String accountid = jsondata.getString("accountid");
			String saleno = jsondata.getString("saleno");
			if(StringUtils.isBlank(sign)){
				throw new BusinessException("参数错误：sign");
			}
			if(StringUtils.isBlank(userid)){
				throw new BusinessException("参数错误：userid");
			}
			if(StringUtils.isBlank(accountid)){
				throw new BusinessException("参数错误：accountid");
			}
			if(StringUtils.isBlank(saleno)){
				throw new BusinessException("参数错误：saleno");
			}
			//预授权申请结果
			PreAuthorization preAuthorization = null;
			for(int i = 0; i< 3; i++){
				preAuthorization = commonService.findPreAuthorization(userid,accountid,saleno,devices);
				if(StringUtils.isNotBlank(preAuthorization.getSqresult())){
					break;
				}
			}
			if(StringUtils.isBlank(preAuthorization.getSqresult())){
				result.setErrorcode(3);
				result.setError("预授权未返回结果");
				return result;
			}
			if("11".equals(preAuthorization.getSqresult())){
				result.setErrorcode(4);
				result.setError(preAuthorization.getSqresult());
				return result;
			}
			userLoginInfo = commonService.updateUserAccessSession(userid,devices.getTenantid(),sign);
			if(userLoginInfo == null){
				result.setErrorcode(1);
				result.setError("用户会话超时");
				return result;
			}else{
				JSONObject resu = new JSONObject();
				resu.put("userid", userLoginInfo.getUserid());
				resu.put("username", userLoginInfo.getUsername());
				resu.put("carnum", userLoginInfo.getCarnum());
				result.setUserid(userLoginInfo.getUserid());
				result.setCode(0);
				result.setSuccess(resu.toJSONString());
			}
		}catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
		
	}
	
	/**
	 * 加油完成，生成加油流水
	 *   清除用记认证信息
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 */
	private MobileResultInfo gasSuccess(CommonService commonService,String data,String ip,Devices devices) throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		UserLoginfo userLoginInfo = null;
		try{
			JSONObject jsondata = JSONObject.parseObject(data);
			String sign = jsondata.getString("sign");//签名
			String userid = jsondata.getString("userid");
			String accountid = jsondata.getString("accountid");
			String saleno = jsondata.getString("saleno");
			String amount = jsondata.getString("amount");
			String liter = jsondata.getString("liter");
			String transdata = jsondata.getString("transdata");
			if(StringUtils.isBlank(sign)){
				throw new BusinessException("参数错误：sign");
			}
			if(StringUtils.isBlank(userid)){
				throw new BusinessException("参数错误：userid");
			}
			if(StringUtils.isBlank(amount)){
				throw new BusinessException("参数错误：amount");
			}
			if(StringUtils.isBlank(liter)){
				throw new BusinessException("参数错误：liter");
			}
			if(StringUtils.isBlank(accountid)){
				throw new BusinessException("参数错误：accountid");
			}
			if(StringUtils.isBlank(saleno)){
				throw new BusinessException("参数错误：saleno");
			}
			if(StringUtils.isBlank(transdata)){
				throw new BusinessException("参数错误：transdata");
			}
			userLoginInfo = commonService.getuserLoginInfo(userid,devices.getTenantid());
			if(userLoginInfo == null){
				throw new BusinessException("系统异常:用户认证数据缺失,请联系运维");
			}
			if(!"0".equals(userLoginInfo.getStep())){
				throw new BusinessException("加油前请先确认用户认证是否超时");
			}
			//生成相关流水信息
			JSONObject outer = new JSONObject();
			String gasstatus = "";
			if("0.00".equals(liter)){
				outer.put("gasorderid", saleno);//加油流水ID
				outer.put("paytotal", "0");//实付款
				outer.put("yhtotal", "0");//优惠金额
				outer.put("litle", "0");//加油升数
				gasstatus = "0";
			}else{
				SellOrder sellOrder = commonService.saveSaleOrder(userLoginInfo, devices, amount, liter,accountid,saleno,transdata);
				outer.put("gasorderid", sellOrder.getSaleno());//加油流水ID
				outer.put("paytotal", String.valueOf((double)sellOrder.getSstotal()/100));//实付款
				outer.put("yhtotal", String.valueOf((double)sellOrder.getYhtotal()/100));//优惠金额
				outer.put("litle", String.valueOf(liter));//加油升数
				gasstatus = "1";
			}
			
			result.setUserid(userLoginInfo.getUserid());
			result.setCode(0);
			result.setSuccess(outer.toJSONString());
			//销毁用户登陆信息
			commonService.destorySession(sign, userid, devices.getTenantid(),userLoginInfo.getCarnum(),gasstatus);
			userLoginInfo.setStatus((byte)1);
			commonService.updateUserLoginfo(userLoginInfo);
		}catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 根据用户信息获取广告播放列表
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 */
	private MobileResultInfo getAdInfoList(CommonService commonService,String data, String ip,Devices devices) throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		try {
			JSONObject jsondata = JSONObject.parseObject(data);
			String userid = jsondata.getString("userid");//用户信息
			if(StringUtils.isBlank(userid)){
				throw new BusinessException("参数错误：userid");
			}
			if(StringUtils.isBlank(devices.getTenantid())){
				throw new BusinessException("参数错误：tenantid");
			}
			List<AdInfo> selectAdInfoList =  commonService.selectAdInfoList(devices.getTenantid());//根据sorts顺序查询广告基本信息
			JSONArray jsonArrData = new JSONArray();
			if(selectAdInfoList.size() > 0){
				for(AdInfo adinfo : selectAdInfoList){
					JSONObject item = new JSONObject();
					item.put("adname", adinfo.getAdname());
					item.put("sorts", adinfo.getSorts());	
					jsonArrData.add(item);
				}
			}
			result.setUserid(userid);
			result.setCode(0);
			result.setSuccess(jsonArrData.toJSONString());
		} catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 上传加油机成交记录
	 * 加油机成交记录包括 加油机上下班，油价变更等等，详情参见《加油机与PC机通讯数据接口协议试行稿V1.1》
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 * @throws PTPECAppException 
	 */
	private MobileResultInfo uploadPosRecord(CommonService commonService,String data, String ip,Devices devices) throws PTPECAppException {
		MobileResultInfo result = new MobileResultInfo();
		try {
			JSONObject jsondata = JSONObject.parseObject(data);
			String transdata = jsondata.getString("transdata");
			if(StringUtils.isBlank(transdata)){
				throw new BusinessException("参数错误：transdata");
			}
			commonService.insertPosRecord(transdata,devices,null,null);
			result.setCode(0);
			result.setSuccess("SUCCESS");
		} catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}

	
	/**
	 * 认证用户点击退出
	* @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 */
	private MobileResultInfo clearAccessUserinfo(CommonService commonService,String data,String ip,Devices devices) throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		try {
			JSONObject jsondata = JSONObject.parseObject(data);
			String sign = jsondata.getString("sign");//签名
			String userid = jsondata.getString("userid");
			if(StringUtils.isBlank(sign)){
				throw new BusinessException("参数错误：sign");
			}
			if(StringUtils.isBlank(userid)){
				throw new BusinessException("参数错误：userid");
			}
			//清除用户认证信息接口，增加预授权取消接口 5-22
			UserLoginfo userLoginInfo = commonService.getuserLoginInfo(userid,devices.getTenantid());
			if(userLoginInfo != null){
				commonService.ntranpreAuthorizationQX(userid,userLoginInfo.getAccountid(),userLoginInfo.getSaleno(), devices);
			}
			commonService.destorySession(sign, userid, devices.getTenantid(),userLoginInfo.getCarnum(),"0");
			result.setCode(0);
			result.setUserid(userid);
		} catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 获取与用户所使用油机设备绑定的的车牌数据
	 * (车牌数据由摄像头上传至中心,车辆停止时,根据车辆的停止坐标与油机加油位绑定)
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 */
	private MobileResultInfo getVehicleNOs(CommonService commonService,String data,String ip,Devices devices)  throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		try {
			JSONArray jsonArrData = new JSONArray();
			//获取加油机的基础信息,判断当前油机是否自助
			List<Vehicle> vehicles = commonService.getCurrentVehicles(devices.getConnid());
			for(Vehicle vehicle : vehicles){
				JSONObject item = new JSONObject();
				item.put("vehicleNO", vehicle.getCarnum());
				item.put("freepword", vehicle.getNeedpassword());
				item.put("pwtype", Integer.valueOf(vehicle.getPwtype(),2).toString());//支持的密码类型
				item.put("scode", Integer.valueOf("1111",2).toString());
				item.put("oilcode", vehicle.getOiltypecode());
				jsonArrData.add(item);
			}
			result.setCode(0);
			result.setSuccess(jsonArrData.toJSONString());
		} catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 根据手机号获取用户车牌号列表
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 * @throws Exception
	 */
	private MobileResultInfo getVehicleNOsByphone(CommonService commonService,String data,String ip,Devices devices)   throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		try {
			JSONObject jsondata = JSONObject.parseObject(data);
			String phoneno = jsondata.getString("phoneno");//签名
			if(StringUtils.isBlank(phoneno)){
				throw new BusinessException("参数错误：phoneno");
			}
			JSONArray jsonArrData = new JSONArray();
			//获取加油机的基础信息,判断当前油机是否自助
			List<String> connids = new ArrayList<String>();
			connids.add(devices.getConnid());
			List<UserInfo> userinfos =  commonService.getUserinfo(devices.getTenantid(), null, phoneno, null, null, null);
			EaccountInfo eaccountInfo = null;
			if(userinfos.size()>0){
				eaccountInfo = commonService.getEwaccount(devices.getTenantid(), userinfos.get(0).getMemcardnum(),userinfos.get(0).getGasaccid());
			}
			 
			if(eaccountInfo != null){
				for(UserInfo userinfo : userinfos){
					JSONObject item = new JSONObject();
					item.put("vehicleNO", userinfo.getCarnum());
					item.put("freepword", "0");
					item.put("pwtype",Integer.valueOf(commonService.getPwtype(userinfo),2).toString());//支持的密码类型
					item.put("scode", Integer.valueOf("1111",2).toString());
					item.put("oilcode", userinfo.getOiltypecode());
					jsonArrData.add(item);
				}
				result.setCode(0);
				result.setSuccess(jsonArrData.toJSONString());
			}else{
				result.setError("请开通电子钱包");
			}
			
		} catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 根据用户获取推荐商品信息
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 * @throws Exception
	 */
	public MobileResultInfo getUserProductInfo(CommonService commonService,String data,String ip,Devices devices) throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		try {
				JSONObject jsondata = JSONObject.parseObject(data);
				String userid = jsondata.getString("userid");
				if(StringUtils.isBlank(userid)){
					throw new BusinessException("参数错误：userid");
				}
				JSONArray jsonArrData = new JSONArray();
				if(userid.equals("5fead6141ab8481b9c1cf739e09a27c9")){//张自志
					//根据用户id查询推荐商品信息List
					JSONObject item = new JSONObject();
					item.put("pluid", "10152832");
					item.put("pluCode", "8307100010152832");
					item.put("pluAbbrName", "天祥高山堂/椴树蜂蜜胶瓶/850g");	
					item.put("unit", "瓶");	
					item.put("spec", "850g");	
					jsonArrData.add(item);
					
					/*JSONObject item1 = new JSONObject();
					item1.put("pluid", "10151507");
					item1.put("pluCode", "8305060010151507");
					item1.put("pluAbbrName", "江南每食/多味花生(烤肉)/58g");	
					item1.put("unit", "袋");	
					item1.put("spec", "58g");
					jsonArrData.add(item1);*/
					
				}else if(userid.equals("18acd06b9a4c4b67a2e285c3ceb5b227")){//郑建维
					//根据用户id查询推荐商品信息List
					/*JSONObject item = new JSONObject();
					item.put("pluid", "10152800");
					item.put("pluCode", "8307020010152800");
					item.put("pluAbbrName", "贵茶/特级上等绿宝石烟条装/3g");	
					item.put("unit", "盒");	
					item.put("spec", "3g");	
					jsonArrData.add(item);*/
					
					JSONObject item1 = new JSONObject();
					item1.put("pluid", "10151507");
					item1.put("pluCode", "8305060010151507");
					item1.put("pluAbbrName", "江南每食/多味花生(烤肉)/58g");	
					item1.put("unit", "袋");	
					item1.put("spec", "58g");
					jsonArrData.add(item1);
					
				}else if(userid.equals("ceeb2c19e6524dcbb8dd5e5ec837ea45")){//刘健权
					//根据用户id查询推荐商品信息List
					JSONObject item = new JSONObject();
					item.put("pluid", "10152794");
					item.put("pluCode", "8307020010152794");
					item.put("pluAbbrName", "贵茶/极品条装/105g");	
					item.put("unit", "盒");	
					item.put("spec", "105g");	
					jsonArrData.add(item);
					
					/*JSONObject item1 = new JSONObject();
					item1.put("pluid", "10151507");
					item1.put("pluCode", "8305060010151507");
					item1.put("pluAbbrName", "江南每食/多味花生(烤肉)/58g");	
					item1.put("unit", "袋");	
					item1.put("spec", "58g");
					jsonArrData.add(item1);*/
				}else{
					//根据用户id查询推荐商品信息List
					JSONObject item = new JSONObject();
					item.put("pluid", "10152800");
					item.put("pluCode", "8307020010152800");
					item.put("pluAbbrName", "贵茶/特级上等绿宝石烟条装/3g");	
					item.put("unit", "盒");	
					item.put("spec", "3g");	
					jsonArrData.add(item);
				}
				result.setUserid(userid);	
				result.setCode(0);
				result.setSuccess(jsonArrData.toJSONString());
		} catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 根据用户获取用户待提货单列表
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 * @throws Exception
	 */
	public MobileResultInfo getUserBillOfLading(CommonService commonService,String data,String ip,Devices devices) throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		try {
				JSONObject jsondata = JSONObject.parseObject(data);
				String userid = jsondata.getString("userid");
				if(StringUtils.isBlank(userid)){
					throw new BusinessException("参数错误：userid");
				}
				if(StringUtils.isBlank(devices.getTenantid())){
					throw new BusinessException("参数错误：tenantid");
				}
				if(StringUtils.isBlank(devices.getNodecode())){
					throw new BusinessException("参数错误：stncode");
				}
				JSONArray jsonArrData = new JSONArray();
				if(userid.equals("5fead6141ab8481b9c1cf739e09a27c9")){
					//根据用户id 租户id 网点编码查询用户待提货单
					JSONObject item1 = new JSONObject();
					item1.put("voucherno", "20180528144318106959");
					jsonArrData.add(item1);
				}
			result.setUserid(userid);		
			result.setCode(0);
			result.setSuccess(jsonArrData.toJSONString());
		} catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 根据提货单号获取订单详情
	 * @param data 关键数据字段,字段中的数据为json格式字符串
	 * @param ip       调用方IP
	 * @param devices  设备
	 * @return
	 * @throws Exception
	 */
	public MobileResultInfo getDetailByVoucherno(CommonService commonService,String data,String ip,Devices devices) throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		try {
				JSONObject jsondata = JSONObject.parseObject(data);
				String userid = jsondata.getString("userid");
				if(StringUtils.isBlank(userid)){
					throw new BusinessException("参数错误：userid");
				}
				JSONArray jsonArrData = new JSONArray();
				JSONObject item3 = new JSONObject();
					//根据提货单号查询提货单详情
					if(userid.equals("5fead6141ab8481b9c1cf739e09a27c9")){
						JSONObject item1 = new JSONObject();
						item1.put("goodsName", "红牛");
						item1.put("goodsID", "541");
						item1.put("price", 8.00);
						item1.put("quantity", 2.00);
						item1.put("amount", 16.00);
						jsonArrData.add(item1);
						
						JSONObject item2 = new JSONObject();
						item2.put("goodsName", "乐百氏矿泉水");
						item2.put("goodsID", "542");
						item2.put("price", 2.00);
						item2.put("quantity", 2.00);
						item2.put("amount", 4.00);
						jsonArrData.add(item2);
						
						item3.put("billNo", "0001");
						item3.put("venderID", "0001");
						item3.put("totleAmount", 20.00);
						item3.put("totleQuantity", 4.00);
						item3.put("data", jsonArrData);
					}else if(userid.equals("18acd06b9a4c4b67a2e285c3ceb5b227")){
						JSONObject item1 = new JSONObject();
						item1.put("goodsName", "康师傅冰红茶");
						item1.put("goodsID", "543");
						item1.put("price", 4.00);
						item1.put("quantity", 2.00);
						item1.put("amount", 8.00);
						jsonArrData.add(item1);
						
						JSONObject item2 = new JSONObject();
						item2.put("goodsName", "康师傅绿茶");
						item2.put("goodsID", "544");
						item2.put("price", 4.00);
						item2.put("quantity", 1.00);
						item2.put("amount", 4.00);
						jsonArrData.add(item2);
						
						item3.put("billNo", "0002");
						item3.put("venderID", "0002");
						item3.put("totleAmount", 12.00);
						item3.put("totleQuantity", 3.00);
						item3.put("data", jsonArrData);
					}else if(userid.equals("ceeb2c19e6524dcbb8dd5e5ec837ea45")){
						JSONObject item1 = new JSONObject();
						item1.put("goodsName", "脉动");
						item1.put("goodsID", "545");
						item1.put("price", 5.00);
						item1.put("quantity", 2.00);
						item1.put("amount", 10.00);
						jsonArrData.add(item1);
						
						JSONObject item2 = new JSONObject();
						item2.put("goodsName", "果粒橙");
						item2.put("goodsID", "546");
						item2.put("price", 4.00);
						item2.put("quantity", 2.00);
						item2.put("amount", 8.00);
						jsonArrData.add(item2);
						
						item3.put("billNo", "0003");
						item3.put("venderID", "0003");
						item3.put("totleAmount", 18.00);
						item3.put("totleQuantity", 4.00);
						item3.put("data", jsonArrData);
					}else{
						JSONObject item1 = new JSONObject();
						item1.put("goodsName", "雪碧");
						item1.put("goodsID", "547");
						item1.put("price", 4.00);
						item1.put("quantity", 1.00);
						item1.put("amount", 4.00);
						jsonArrData.add(item1);
						
						JSONObject item2 = new JSONObject();
						item2.put("goodsName", "可口可乐");
						item2.put("goodsID", "548");
						item2.put("price", 4.00);
						item2.put("quantity", 3.00);
						item2.put("amount", 8.00);
						jsonArrData.add(item2);
						
						item3.put("billNo", "0004");
						item3.put("venderID", "0004");
						item3.put("totleAmount", 16.00);
						item3.put("totleQuantity", 3.00);
						item3.put("data", jsonArrData);
					}
			result.setUserid(userid);		
			result.setCode(0);
			result.setSuccess(item3.toJSONString());
		} catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}
	
}
