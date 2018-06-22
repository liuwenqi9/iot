package com.pcitc.oilmachine.service.mobile;


import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.ParseException;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.pcitc.oilmachine.form.SystemLog;
import com.afs.base.util.MySpringContextUtil;
import com.afs.fasm.mcp.message.OildeviceCarMessage;
import com.afs.tupeasy.base.NettySendMessageService;
import com.afs.tupeasy.exception.CommunicationException;
import com.afs.tupeasy.util.IntStepGen;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.utils.ByteUtil;
import com.pcitc.oilmachine.commons.certificate.BusinessException;
import com.pcitc.oilmachine.commons.certificate.EncryptUtil;
import com.pcitc.oilmachine.commons.certificate.OILKeyPair;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.redis.RedisService;
import com.pcitc.oilmachine.commons.utils.DateUtils;
import com.pcitc.oilmachine.commons.utils.HttpKit;
import com.pcitc.oilmachine.commons.utils.InMatrix;
import com.pcitc.oilmachine.commons.utils.JsonEncryptUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.enums.DictionaryEnum;
import com.pcitc.oilmachine.enums.VehicleEnum;
import com.pcitc.oilmachine.form.EaccountInfo;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.form.Vehicle;
import com.pcitc.oilmachine.model.AdInfo;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.DevicesArea;
import com.pcitc.oilmachine.model.DictionaryData;
import com.pcitc.oilmachine.model.PosRecord;
import com.pcitc.oilmachine.model.PreAuthorization;
import com.pcitc.oilmachine.model.SellDiscounts;
import com.pcitc.oilmachine.model.SellOrder;
import com.pcitc.oilmachine.model.UserLoginfo;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.service.dictionary.DictionaryDataService;
import com.pcitc.oilmachine.service.hsf.SharedClient;
import com.pcitc.oilmachine.service.modelservice.ad.AdInfoService;
import com.pcitc.oilmachine.service.modelservice.devices.DevicesAreaService;
import com.pcitc.oilmachine.service.modelservice.devices.DevicesService;
import com.pcitc.oilmachine.service.modelservice.order.PosRecordService;
import com.pcitc.oilmachine.service.modelservice.order.PreAuthorizationService;
import com.pcitc.oilmachine.service.modelservice.order.SellDiscountsService;
import com.pcitc.oilmachine.service.modelservice.order.SellOrderService;
import com.pcitc.oilmachine.service.modelservice.order.SellProductService;
import com.pcitc.oilmachine.service.mq.MQClientSenderService;
import com.pcitc.saas.api.NcmiService;
import com.pcitc.saas.api.WmaService;
import com.pcitc.saas.util.DESEncrypt;
import com.pcitc.oilmachine.service.modelservice.UserLoginfoService;

@Service
public class CommonService extends BaseService{
	
	@Resource
	private PreAuthorizationService preAuthorizationService;
	@Resource
	private SellOrderService sellOrderService;
	@Resource
	private SellProductService sellProductService;
	@Resource
	private DevicesService devicesService;
	@Resource
	private DevicesAreaService devicesAreaService;
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Resource
	private RedisService<String,String> redisService;
	@Resource
	private AdInfoService adInfoService;
	@Resource
	private MQClientSenderService mqSenderService;
	@Resource
	private UserLoginfoService userLoginfoService;
	@Resource
	private SellDiscountsService sellDiscountsService;
	@Resource
	private SharedClient sharedClient;
	@Resource
	private PosRecordService posRecordService;
	
	private static Logger log = LoggerFactory.getLogger(CommonService.class);
	
	
	/**
	 * 获取加油流水号
	 * 生成规则:?
	 * tenantid租户ID 不同的租户可能存在不同的生成规则
	 * @return
	 */
	public String getSaleno(String connid,String screencode,String oilcode){
		StringBuffer ret = new StringBuffer();
        SimpleDateFormat dfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        dfDate.setLenient(false);
        ret.append(connid);
        ret.append(screencode);
        ret.append(oilcode);
        ret.append(dfDate.format((new GregorianCalendar()).getTime()));
		return ret.toString();
	}
	
	/**
	 * 根据用户ID || 手机号 || 身份证号 || 车牌号 获取用户信息
	 * @param tenantid
	 * @param userids
	 * @param phones
	 * @param certnums
	 * @param vehicles
	 * @param drivernums
	 * @return
	 * @throws Exception
	 */
	public List<UserInfo> getUserinfo(String tenantid,String userids,String phones,String certnums,List<Vehicle> vehicles,String drivernums) throws Exception{
			if(vehicles!= null){
				StringBuilder vehiclenos = new StringBuilder();
				for(Vehicle vehicle : vehicles){
					vehiclenos.append("'"+vehicle.getCarnum()+"',");
				}
				drivernums = vehiclenos.substring(0, vehiclenos.length() - 1);
			}
			
			SharedClient sharedClient = (SharedClient)MySpringContextUtil.getBean("sharedClient");
			NcmiService ncmiservice = sharedClient.getNcmiService();
			List<UserInfo> userinfos = new ArrayList<UserInfo>();
			JSONObject json = new JSONObject();
			json.put("tenantid", tenantid);
			json.put("userids", userids);
			json.put("phones", phones);
			json.put("certnums", certnums);
			json.put("drivernums", drivernums);
			String userinfoFromNcmi = "";
			try {
				userinfoFromNcmi = ncmiservice.getUserInfoByParams(json.toJSONString());
			} catch (Exception e) {
				throw new PTPECAppException("调用会员系统获取用户信息异常:"+e.getMessage(),e);
			}
			JSONObject parseObject = JSONObject.parseObject(userinfoFromNcmi,JSONObject.class);
			Integer code = parseObject.getInteger("code");
			if(code == 0){
				String userStr = parseObject.getString("success");
				JSONArray array = JSONArray.parseArray(userStr);
				for(int i = 0; i<array.size(); i++){
					JSONObject jsonobject = array.getJSONObject(i);
					String userid = jsonobject.getString("userid");
					String username = jsonobject.getString("username");
					String mobilephone = jsonobject.getString("mobilephone");
					String certtype = jsonobject.getString("certtype");
					String certnum = jsonobject.getString("certnum");
					String sex = jsonobject.getString("sex");
					String carnum = jsonobject.getString("carnum");
					String memcardnum = jsonobject.getString("memcardnum");
					String  preamount = jsonobject.getString("preamount");
					String  accid = jsonobject.getString("accid");
					String  oiltypecode = jsonobject.getString("oiltypecode");
					UserInfo userinfo = new UserInfo();
					userinfo.setUserid(userid);
					userinfo.setUsername(username);
					userinfo.setMobilephone(mobilephone);
					userinfo.setCerttype(certtype);
					userinfo.setCertnum(certnum);
					if(StringUtils.isNotBlank(carnum)){
						userinfo.setCarnum(carnum.toUpperCase());
					}
					userinfo.setSex(sex);
					userinfo.setMemcardnum(memcardnum);
					userinfo.setPreamount(Long.parseLong(preamount));
					userinfo.setGasaccid(accid);
					//获取用户的人脸模版图片
					JSONObject userjson = getUserInfoFromEifs(memcardnum, tenantid);
					if(userjson != null){
						userinfo.setIsVeriFace(userjson.getInteger("isVeriFace"));
						userinfo.setIsFreePwd(userjson.getInteger("isFreePwd"));
						userinfo.setFreeAmount(userjson.getLong("freeAmount"));
					}
					userinfo.setTenantid(tenantid);
					userinfo.setOiltypecode(oiltypecode);
					userinfos.add(userinfo);
				}
			}else{
				String error = parseObject.getString("error");
				throw new PTPECAppException("调用会员系统获取用户信息异常:"+error);
			}
			return userinfos;
	}
	
	/**
	 * 验证码发送接口
	 * @param phoneNo 手机号
	 * @param code    验证码
	 * @param tenantid 租户ID
	 * @return
	 * @throws Exception
	 */
	public String sendMobilecode(String phoneNo,String code,String tenantid) throws Exception{
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("phoneNo", phoneNo);
		jsonParam.put("tenantId", tenantid);
		jsonParam.put("code", code);
		
		SharedClient sharedClient = (SharedClient)MySpringContextUtil.getBean("sharedClient");
		// 访问配置的Servlet路径
		// 使用Hessian工厂获得接口的具体实现类
		WmaService wmaService = sharedClient.getWmaService();
		String jsonP = DESEncrypt.encrypt(jsonParam.toJSONString(), "7KbweYVruDBix691Rib5CfTrP3OiPk");//
		String jsonR = "";
		try {
			jsonR = wmaService.sendMobilecode(jsonP);
		} catch (Exception e) {
			throw new PTPECAppException("会员平台*发送验证码失败:"+e.getMessage(),e);
		}
		jsonR = DESEncrypt.decrypt(jsonR, "7KbweYVruDBix691Rib5CfTrP3OiPk");
		return jsonR;
	}
	
	/**
	 * 根据会员编号,租户ID 从电子钱包系统获取用户信息
	 * @param memcardnum
	 * @param tenantid
	 * @return
	 * @throws Exception
	 */
	public JSONObject getUserInfoFromEifs(String memcardnum,String tenantid) throws Exception{
		String url = Constant.EAPI_URL + Constant.QU_FUNCTION;
		JSONObject json = new JSONObject();
		json.put("ver", Constant.ver);//接口版本
		json.put("sysSource", Constant.sysSource);
		// 数据包
		JSONObject datajson = new JSONObject();
		datajson.put("mchCode", Constant.mchCode);// 商户号tenantid
		datajson.put("sysUserCode", memcardnum);
		json.put("data", datajson.toString());//数据包
		
		// 加密数据
		String sign = JsonEncryptUtil.encryptDate(json, "data", "sysKey", Constant.publicKey);
		json.put("sign", sign);//签名
		String result = "";
		try {
			result = HttpKit.httpClientPost(url, JSON.toJSONString(json), false);
		} catch (Exception e) {
			throw new PTPECAppException("调用电子钱包获取用户信息异常："+e.getMessage(),e);
		}
		// 校验签名解密数据
		JSONObject rObject = JSON.parseObject(result);
		boolean nerify = JsonEncryptUtil.verifySign(rObject, "sign", Constant.publicKey, "", null);
		JSONObject resultJson = null;
		if(nerify){
			String code = rObject.getString("code");
			if(!"0000".equals(code)){
				throw new Exception("*"+rObject.getString("msg")+"*");
			}
			// 解密数据
			String sysKey = rObject.getString("sysKey");// 临时秘钥
			String data = rObject.getString("data");// 加密数据包
			String decryDate = JsonEncryptUtil.decryDate(sysKey, Constant.publicKey, data);
			JSONObject dObject = JSON.parseObject(decryDate);
			String resultList = dObject.getString("resultList");
			JSONArray parseArray = JSONObject.parseArray(resultList);
			if(parseArray.size() == 1){
				resultJson = (JSONObject)parseArray.get(0);
			}
		}
		return resultJson;
	}
	
	/**
	 * 根据租户,会员编号获取会电子账户信息
	 * @param memcardnum
	 * @param tenantid
	 * @return
	 * @throws Exception
	 */
	public EaccountInfo getEwaccount(String tenantid,String memcardnum,String accid) throws Exception{
		String url = Constant.EAPI_URL + Constant.QC_FUNCTION;
		JSONObject json = new JSONObject();
		json.put("ver", Constant.ver);//接口版本
		json.put("sysSource", Constant.sysSource);
		// 数据包
		JSONObject datajson = new JSONObject();
		datajson.put("mchCode", Constant.mchCode);// 商户号tenantid
		datajson.put("sysUserCode", memcardnum);
		json.put("data", datajson.toString());//数据包
		
		// 加密数据
		String sign = JsonEncryptUtil.encryptDate(json, "data", "sysKey", Constant.publicKey);
		json.put("sign", sign);//签名
		String result;
		try {
			result = HttpKit.httpClientPost(url, JSON.toJSONString(json), false);
		} catch (Exception e) {
			throw new PTPECAppException("调用电子账户获取账户信息异常："+e.getMessage(),e);
		}
		// 校验签名解密数据
		JSONObject rObject = JSON.parseObject(result);
		boolean nerify = JsonEncryptUtil.verifySign(rObject, "sign", Constant.publicKey, "", null);
		JSONObject eaJson = null;
		if(nerify){
			String code = rObject.getString("code");
			if(!"0000".equals(code)){
				throw new BusinessException("*"+rObject.getString("msg")+"*");
			}
				// 解密数据
				String sysKey = rObject.getString("sysKey");// 临时秘钥
				String data = rObject.getString("data");// 加密数据包
				String decryDate = JsonEncryptUtil.decryDate(sysKey, Constant.publicKey, data);
				JSONObject dObject = JSON.parseObject(decryDate);
				String resultList = dObject.getString("resultList");
				JSONArray parseArray = JSONArray.parseArray(resultList);
				for(Object obj : parseArray){
					JSONObject eaobj = (JSONObject)obj;
					if(accid.equals(eaobj.getString("accId"))){
						eaJson = eaobj;
					}
				}
		}
		if(eaJson != null){
			EaccountInfo ea = new EaccountInfo();
			Long amount = eaJson.getLong("amount");
			ea.setAmount(amount);
			ea.setUseableamount(eaJson.getLong("frozeAmount"));
			ea.setAccountid(accid);
			return ea;
		}else{
			return null;
		}
		
	}
	
	/**
	 * 电子账户支付下单接口
	 * @param btradeNo
	 * @param memcardnum
	 * @param userLoginInfo
	 * @param amount
	 * @param devices
	 * @return
	 * @throws Exception
	 */
	public String createPayOrder(String btradeNo,String memcardnum,UserLoginfo userLoginInfo,Long amount,Devices devices,String selfhelp) throws Exception  {
		String url = Constant.EAPI_URL + Constant.CP_FUNCTION;
		// 数据包
		JSONObject object = new JSONObject();
		JSONObject data = new JSONObject();
		
		data.put("mchCode", Constant.mchCode);
		data.put("productDes", "油品");
		data.put("btradeNo", btradeNo+Constant.CREATE_ORDER);
		data.put("goodsCodes", userLoginInfo.getOilcode());
		data.put("goodsType", "1");
		data.put("amount", amount);
		data.put("tradeType", "30");
		data.put("tradeMean", "01");
		data.put("sysUserCode", memcardnum);
		data.put("appId", Constant.appid);
		data.put("nodeNo", userLoginInfo.getStncode());
		data.put("deviceType", selfhelp);
		data.put("deviceId", devices.getConnid());
		data.put("attach", devices.getConnid());
		
		object.put("sysSource", Constant.sysSource);
		object.put("ver", Constant.ver);
		object.put("data", data.toJSONString());
		
		// 加密数据
		String sign = JsonEncryptUtil.encryptDate(object, "data", "sysKey", Constant.publicKey);
		object.put("sign", sign);//签名
		String result = "";
		try {
			result = HttpKit.httpClientPost(url, JSON.toJSONString(object), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PTPECAppException(e);
		}
		// 校验签名解密数据
		JSONObject rObject = JSON.parseObject(result);
		boolean nerify = JsonEncryptUtil.verifySign(rObject, "sign", Constant.publicKey, "", null);
		String approveId = "";
		if(nerify){
			// 解密数据code
			String code = rObject.getString("code");
			if(!"0000".equals(code)){
				log.info("**************电子账户下单接口:未加密数据:**"+data.toJSONString());
				log.info("**************电子账户下单接口:加密后数据:**"+JSON.toJSONString(object));
				throw new BusinessException("*"+rObject.getString("msg")+"*");
			}
			String sysKey = rObject.getString("sysKey");// 临时秘钥
			String datas = rObject.getString("data");// 加密数据包
			String decryDate =JsonEncryptUtil.decryDate(sysKey, Constant.ZFCJ_PUBLIC, datas);
			JSONObject dObject = JSON.parseObject(decryDate);
			approveId = dObject.getString("approveId");
		}
		return approveId;
	}
	
	/**
	 * type 30=申请；
	 * 调用预授权接口
	 * selfhelp 电子钱包
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws Exception
	 */
	public PreAuthorization ntranpreAuthorizationSQ(UserInfo userinfo,String saleno,EaccountInfo eaccountInfo,String password,Devices devices,UserLoginfo userLoginInfo,String selfhelp,String passwordtype) throws Exception{
		PreAuthorization preAuthorization = null;
		Long preamount = userinfo.getPreamount();
		Long amount = eaccountInfo.getAmount();
		if(amount < preamount){
			preamount = amount;
		}
		//下单
		String approveId = createPayOrder(saleno,userinfo.getMemcardnum(),userLoginInfo,preamount,devices,selfhelp);
		String url =Constant. EAPI_URL + Constant.SQ_FUNCTION;
		// 数据包
		JSONObject object = new JSONObject();
		JSONObject data = new JSONObject();
		
		data.put("btradeNo", saleno+Constant.preAuth_SQ);
		data.put("accId", eaccountInfo.getAccountid());
		data.put("type", "30");
		data.put("verificationType", passwordtype);
		if("1".equals(passwordtype)){
			data.put("tradingPwd", password);
		}else if("2".equals(passwordtype)){
			data.put("faceImg", password);
		}else if("3".equals(passwordtype)){
			data.put("verificationCode", password);
			data.put("codeParity", devices.getNodecode());
		}else{
			data.put("verificationType", "1");
		}
		data.put("deviceType", "02");
		data.put("deviceId", devices.getConnid());
		data.put("appId", Constant.appid);
		data.put("approveId", approveId);
		data.put("nodeNo", devices.getNodecode());
		object.put("sysSource", Constant.sysSource);
		object.put("ver", Constant.ver);
		object.put("data", data.toJSONString());
		// 加密数据
		String sign = JsonEncryptUtil.encryptDate(object, "data", "sysKey", Constant.publicKey);
		object.put("sign", sign);//签名
		String result = "";
		try{
			result = HttpKit.httpClientPost(url, JSON.toJSONString(object), false);
		}catch(Exception e){
			throw new PTPECAppException("电子账户预授权申请接口异常："+e.getMessage(),e);
		}
		// 校验签名解密数据
		JSONObject rObject = JSON.parseObject(result);
		boolean nerify = JsonEncryptUtil.verifySign(rObject, "sign", Constant.publicKey, "", null);
		if(nerify){
			// 解密数据
			String code = rObject.getString("code");// 临时秘钥
			if(!"0000".equals(code)){
				log.info("**************电子账户预授权申请接口:未加密数据:**"+data.toJSONString());
				log.info("**************电子账户预授权申请接口:加密后数据:**"+JSON.toJSONString(object));
				throw new BusinessException("*"+rObject.getString("msg")+"*");
			}
			//保存预授权申请单的相关信息
			preAuthorization = preAuthorizationService.savepreAuthorization(userinfo.getUserid(),userinfo.getMemcardnum(),saleno,approveId,eaccountInfo.getAccountid(),devices.getTenantid(),preamount);
		}
		return preAuthorization;
	}
	
	/**
	 * 31=取消
	 * 调用预授权接口
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws Exception
	 */
	public void ntranpreAuthorizationQX(String userid,String accountid,String saleno,Devices devices){
		try {
			PreAuthorization preAuthorization = preAuthorizationService.findPreAuthorization(devices.getTenantid(),userid,saleno);
			if(preAuthorization == null){
				return;
			}
			String url = Constant.EAPI_URL + Constant.SQ_FUNCTION;
			// 数据包
			JSONObject object = new JSONObject();
			JSONObject data = new JSONObject();
			data.put("btradeNo", saleno+Constant.preAuth_QX);
			data.put("accId", accountid);
			data.put("type", "31");
			data.put("deviceType", "02");
			data.put("deviceId", devices.getConnid());
			data.put("appId", Constant.appid);
			data.put("approveId", preAuthorization.getApproveid());
			data.put("orgbtradeNo", saleno+Constant.preAuth_SQ);//原业务订单号
			data.put("nodeNo", devices.getNodecode());
			object.put("sysSource", Constant.sysSource);
			object.put("ver", Constant.ver);
			object.put("data", data.toJSONString());
			// 加密数据
			String sign = JsonEncryptUtil.encryptDate(object, "data", "sysKey", Constant.publicKey);
			object.put("sign", sign);//签名
			String result = "";
			try{
				result = HttpKit.httpClientPost(url, JSON.toJSONString(object), false);
			}catch(Exception e){
				e.printStackTrace();
				throw new PTPECAppException(e);
			}
			// 校验签名解密数据
			JSONObject rObject = JSON.parseObject(result);
			boolean nerify = JsonEncryptUtil.verifySign(rObject, "sign", Constant.publicKey, "", null);
			if(nerify){
				// 解密数据
				String code = rObject.getString("code");// 临时秘钥
				if(!"0000".equals(code)){
					log.info("**************电子账户预授权取消接口:未加密数据:**"+data.toJSONString());
					log.info("**************电子账户预授权取消接口:加密后数据:**"+JSON.toJSONString(object));
					throw new BusinessException("*"+rObject.getString("msg")+"*");
				}
			}
		} catch (PTPECAppException e) {
			e.printStackTrace();
			System.err.print("预授权取消失败");
		}
	}
	
	/**
	 * 32=完成
	 * 调用预授权接口
	 * @throws PTPECAppException 
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws Exception
	 */
	public void ntranpreAuthorizationWC(String userid,String accountid,String saleno,Devices devices,long amount) throws PTPECAppException{
			PreAuthorization preAuthorization = preAuthorizationService.findPreAuthorization(devices.getTenantid(),userid,saleno);
			if(preAuthorization == null){
				return;
			}
			String url = Constant.EAPI_URL + Constant.SQ_FUNCTION;
			// 数据包
			JSONObject object = new JSONObject();
			JSONObject data = new JSONObject();
			data.put("btradeNo", saleno+Constant.preAuth_WC);
			data.put("accId", accountid);
			data.put("type", "32");
			data.put("deviceType", "02");
			data.put("deviceId", devices.getConnid());
			data.put("appId", Constant.appid);
			data.put("approveId", preAuthorization.getApproveid());
			data.put("orgbtradeNo", saleno+Constant.preAuth_SQ);//原业务订单号
			data.put("nodeNo", devices.getNodecode());
			data.put("actAmount", amount);
			data.put("nodeNo", devices.getNodecode());
			object.put("sysSource", Constant.sysSource);
			object.put("ver", Constant.ver);
			object.put("data", data.toJSONString());
			// 加密数据
			String sign = JsonEncryptUtil.encryptDate(object, "data", "sysKey", Constant.publicKey);
			object.put("sign", sign);//签名
			String result = "";
			try{
				result = HttpKit.httpClientPost(url, JSON.toJSONString(object), false);
			}catch(Exception e){
				saveUserAuthenticationError("ntranpreAuthorizationWC","预授权完成异常", data.toJSONString(), StringUtils.getErrorInfoFromException(e));
			}
			// 校验签名解密数据
			JSONObject rObject = JSON.parseObject(result);
			boolean nerify = JsonEncryptUtil.verifySign(rObject, "sign", Constant.publicKey, "", null);
			if(nerify){
				// 解密数据
				String code = rObject.getString("code");// 临时秘钥
				if(!"0000".equals(code)){
					saveUserAuthenticationError("ntranpreAuthorizationWC","预授权完成异常", data.toJSONString(), rObject.getString("msg"));
				}
			}
	}
	
	/**
	 * 查询预授权回调结果
	 * @param userid
	 * @param accountid
	 * @param approveId
	 * @param devices
	 * @throws PTPECAppException 
	 */
	public PreAuthorization findPreAuthorization(String userid,String accountid,String saleno,Devices devices) throws PTPECAppException{
		return preAuthorizationService.findPreAuthorization(devices.getTenantid(),userid,saleno);
	}
	
	/**
	 * 保存订单相关信息
	 * @param userLoginInfo
	 * @param devices
	 * @param amount
	 * @param liter
	 * @return
	 * @throws PTPECAppException 
	 */
	public SellOrder saveSaleOrder(UserLoginfo userLoginInfo,
			Devices devices, String amount, String liter,String accountid,String saleno,String transdata) throws PTPECAppException{
		//0:获取优惠信息
		//1：生成加油流水
		SellOrder sellOrder = sellOrderService.querySellOrder(devices.getTenantid(),userLoginInfo.getUserid(),accountid,saleno);
		if(sellOrder == null){
			Long total = StringUtils.multiplication(amount, "100");
			//生成优惠信息
			boolean hasdiscounts = true;
			long discountsamount = 0;
			String gist = "";
			if( 1000<= total&& total < 2000){
				discountsamount = 100;
				gist = "满10元减1元";
			}else if(2000<=total&& total<3000){
				discountsamount = 200;
				gist = "满20元减2元";
			}else if(3000<=total&& total<4000){
				discountsamount = 300;
				gist = "满30元减3元";
			}else{
				discountsamount = 500;
				gist = "满40元减5元";
			}
			SellDiscounts selldiscounts = new SellDiscounts();
			selldiscounts.setDiscountsamount(discountsamount);
			if(hasdiscounts){
				selldiscounts.setTenantid(userLoginInfo.getTenantid());
				selldiscounts.setUserid(userLoginInfo.getUserid());
				selldiscounts.setSaleno(saleno);
				selldiscounts.setDiscountsbody((byte)0);
				selldiscounts.setDiscountstype((byte)1);//满减
				selldiscounts.setGist(gist);//依据  优惠规则ID
				selldiscounts = sellDiscountsService.saveSelDiscounts(selldiscounts,userLoginInfo);
			}
			sellOrder = sellOrderService.saveSellOrder(userLoginInfo,devices,total,saleno,selldiscounts);
			insertPosRecord(transdata, devices,userLoginInfo.getUserid(),sellOrder.getSaleno());
			//预授权完成
			ntranpreAuthorizationWC(userLoginInfo.getUserid(), accountid, saleno, devices,sellOrder.getSstotal());
			//2:生成订单商品数据
			sellProductService.saveSellProduct(userLoginInfo,sellOrder,liter,selldiscounts);
		}
		//3:记录订单优惠信息
		return sellOrder;
	}
	
	/**
	 * 是否需要弹出密码框
	 *isfreepwd 1=开启；0=关闭，默认0
	 * @param userinfo
	 * @param eaccountinfo
	 * @return
	 */
	public String isneedPassWord(UserInfo userinfo){
		System.out.println(JSONObject.toJSONString(userinfo));
		int isfreepwd = userinfo.getIsFreePwd();
		if(1 == isfreepwd){
			return "1";
		}
		return "0";
	}
	
	/**
	 * bit7-bit5 表示默认类型
		bit0 人脸 0 不支持 1支持
		bit1 密码 0 不支持 1支持
		bit2 验证码 0 不支持1支持
		比如二进制：
		001 00111 默认人脸 支持三种方式
		010 00111 默认密码 支持三种方式
		011 00111 默认验证码 支持三种方式
		001 00011 默认人脸 支持 人脸和密码
	 * @param userinfo
	 * @return
	 */
	public String getPwtype(UserInfo userinfo){
		int isVeriFace = userinfo.getIsVeriFace();//0未开通；1已开通
		if(isVeriFace == 1){
			return "00100111";
			//return "01000110";
		}else{
			return "01000110";
		}
	}
	
	/**
	 * 根据摄像头连接ID获取摄像头的基础信息
	 * @param cameraid
	 * @return
	 * @throws PTPECAppException 
	 */
	public Devices findCameraByConnid(String cameraid) throws PTPECAppException{
		Devices devices = devicesService.findByConnid(cameraid, Constant.CAMERA_CODE);//获取摄像头的基础数据
		return devices;
	}
	
	/**
	 * 查看当前网点下的所有的油机设备
	 * @param tenantid
	 * @param stncode
	 * @return
	 */
	public List<Devices> findOilmachinebyStncode(String tenantid,String stncode){
		List<Devices> oildevices = devicesService.findDevices(tenantid,stncode, Constant.OILMACH_CODE);
		return oildevices;
	}
	
	public List<Devices> findOilmachinebyCamera(Devices devices) throws PTPECAppException{
		List<Devices> oildevices = devicesService.queryDeviceBybondarea(devices);
		return oildevices;
	}
	
	/**
	 * 发送验证码
	 * @param carnum
	 * @param memcardnum  可为空
	 * @param devices
	 * @return
	 */
	public boolean sendMobilecode(String carnum,String memcardnum,String phoneno,Devices devices){
		boolean sendresult = true;
		try {
			sendVerificationCode(memcardnum, devices);
			String msg = "【中石化北分】赠送您一张优惠券(低于10元减1元),当前油站使用有效,快来使用吧~";
			sendMobilecode(phoneno, msg, devices.getTenantid());
			log.info("*************车辆首次进站发送验证码成功**");
		}catch (Exception e) {
			e.printStackTrace();
			sendresult = false;
		}
		return sendresult;
	}
	
	/**       
	 * 调用电子钱包发送短信
	 * @author chengyu.fan
	 * @param userinfo
	 * @param devices
	 */
	public void sendVerificationCode(String memcardnum ,Devices devices){
		try {
			String url =Constant.EAPI_URL + Constant.FS_FUNCTION;
			// 数据包
			JSONObject object = new JSONObject();
			JSONObject data = new JSONObject();
			data.put("sysUserCode", memcardnum);
			data.put("mchCode", Constant.mchCode );//商户号
			data.put("codeParity", devices.getNodecode());
			data.put("smsCodeType", Constant.smsCodeType);//验证码类型 0:验证码 1:密码 2:加油码

			object.put("sysSource", Constant.sysSource);
			object.put("ver", Constant.ver);
			object.put("data", data.toJSONString());
			// 加密数据
			String sign = JsonEncryptUtil.encryptDate(object, "data", "sysKey", Constant.publicKey);
			object.put("sign", sign);//签名
			String result = "";
			try{
				result = HttpKit.httpClientPost(url, JSON.toJSONString(object), false);
			}catch(Exception e){
				e.printStackTrace();
				throw new PTPECAppException("电子钱包:**"+Constant.FS_FUNCTION+"**"+e.getMessage());
			}
			// 校验签名解密数据
			JSONObject rObject = JSON.parseObject(result);
			boolean nerify = JsonEncryptUtil.verifySign(rObject, "sign", Constant.publicKey, "", null);
			if(nerify){
				// 解密数据
				String code = rObject.getString("code");// 临时秘钥
				if(!"0000".equals(code)){
					log.info("**************电子账户发送验证码接口:未加密数据:**"+data.toJSONString());
					log.info("**************电子账户发送验证码接口:加密后数据:**"+JSON.toJSONString(object));
					throw new PTPECAppException("电子钱包:**"+Constant.FS_FUNCTION+"**"+rObject.getString("msg"));
				}
			}
		} catch (PTPECAppException e) {
			e.printStackTrace();
			log.error("**************电子账户发送验证码失败");
		}
	}
	
	/**
	 * 获取字典信息
	 * @param dcode
	 * @param datacode
	 * @param tenantid
	 * @return
	 * @throws PTPECAppException
	 */
	public DictionaryData getDataByDoubleCode(DictionaryEnum dcode,String datacode, String tenantid) throws PTPECAppException{
		try {
			DictionaryDataService dictionaryDataService = (DictionaryDataService) MySpringContextUtil.getBean("dictionaryDataService");
			return dictionaryDataService.getDataByDoubleCode(dcode, datacode, tenantid);
		} catch (Exception e) {
			throw new PTPECAppException("获取字典信息异常:",e);
		}
	}
	
	/**
	 * 记录摄像头传过来的未处理成功的车牌数据
	 * @param cameraid
	 * @param carnum
	 */
	public void saveDeviceConnectError(String connectid,String carnum,String msg){
		SystemLog loginfo = new SystemLog();
		loginfo.setLogmodule(0);
		loginfo.setLogtype(1);
		JSONObject logmsg = new JSONObject();
		logmsg.put("connectid", connectid);
		logmsg.put("carnum", carnum);
		logmsg.put("msg", msg);
		loginfo.setLogmsg(logmsg.toJSONString());
		mqSenderService.ntranAddUserLoginToes(loginfo);
	}
	

	/**
	 * 根据预约码获取缓存的车牌信息
	 * @param tenantid
	 * @param stncode
	 * @param gascode
	 * @return
	 * @throws PTPECAppException 
	 */
	public Map<String,String> getVehicleCacheByGascode(String tenantid,String stncode,String gascode) throws PTPECAppException{
		Map<String,String> map = new HashMap<String,String>();
		try {
			BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(tenantid+stncode+gascode);
			String carNum = hashOpertions.get("carNum");
			String needpassword = hashOpertions.get("needpassword");
			if(StringUtils.isBlank(carNum)){
				throw new BusinessException("加油码已过期");
			}
			//stringRedisTemplate.delete(stncode+gascode);
			
			map.put("carNum", carNum);
			map.put("needpassword", needpassword);
		} catch (Exception e) {
			throw new PTPECAppException("从缓存根据预约码获取对应车牌信息异常:"+e.getMessage(),e);
		}
		return map;
	}
	

	
	/**
	 * 获取与油机绑定的车牌数据
	 * @param deviceid 必填
	 * @param stncode 必填
	 * 			connid  设备连接ID(摄像头)
	 * @param screencode  非必填
	 * @return
	 * @throws Exception 
	 */
	public List<Vehicle> getbondsVehicle(String tenantid,String connid){
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(tenantid+connid);
		String carnums = hashOpertions.get("carnums");
		System.out.println(carnums+":getbondsVehicle");
		if(StringUtils.isNotBlank(carnums)){
			String[] carnumarr = carnums.split("&");
			for(String carnum : carnumarr){
				//1:从缓存中获取最新的车牌行驶信息
				Vehicle vehicle = getVehiclefromcache(carnum);
				if(vehicle == null){
					if(carnums.contains(carnum+"&")){
						carnums = carnums.replace(carnum+"&", "");
					}else{
						carnums = carnums.replace(carnum, "");
					}
					continue;
				}
				if("1".equals(vehicle.getGasstatus())){
					continue;
				}
				vehicles.add(vehicle);
			}
			hashOpertions.put("carnums", carnums);
		}
		return vehicles;
		
	}
	
	public String getBoundScreenCode(String screencode){
		if("1".equals(screencode)){
			return "2";
		}else if("2".equals(screencode)){
			return "1";
		}else if("3".equals(screencode)){
			return "4";
		}else if("4".equals(screencode)){
			return "3";
		}
		return null;
	}
	
	/**
	 * BinaryString 二进制字符串
	 * 如0011  代表  1号屏 2 号屏显示  3,4号屏不显示
	 * @param screencode 屏幕号
	 * @return
	 */
	public String carnumShowOnScreen(String screencode){
		if("1".equals(screencode)){
			return "0011";
		}else if("2".equals(screencode)){
			return "0011";
		}else if("3".equals(screencode)){
			return "1100";
		}else if("4".equals(screencode)){
			return "1100";
		}
		return null;
	}
	
	/**
	 * 从缓存中获取车辆信息
	 * @param carnum
	 * @return
	 */
	public Vehicle getVehiclefromcache(String carnum){
		Vehicle vehicle = null;
		BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(carnum);
		String carnumCache = hashOpertions.get(VehicleEnum.CARNUM.toString());
		if(StringUtils.isBlank(carnumCache)){
			return vehicle;
		}
		vehicle = new Vehicle();
		String useableamount = hashOpertions.get("useableamount");
		String needpassword = hashOpertions.get("needpassword");
		String pwtype = hashOpertions.get("pwtype");
		String oiltypecode = hashOpertions.get("oiltypecode");
		String gasstatus = hashOpertions.get("gasstatus");
		vehicle.setCarnum(carnumCache);
		vehicle.setUseableamount(useableamount);
		vehicle.setNeedpassword(needpassword);
		vehicle.setPwtype(pwtype);
		vehicle.setOiltypecode(oiltypecode);
		vehicle.setGasstatus(gasstatus);
		return vehicle;
	}
	
	/**
	 * 将当前车牌集合发送给加油机
	 * @param vehicles
	 * @throws CommunicationException 
	 */
	public void sendCarNumToOilDevice(List<Vehicle> vehicles,String connid){
		try {
			NettySendMessageService sendService = (NettySendMessageService)MySpringContextUtil.getBean("nettySendService");
			OildeviceCarMessage msg = new OildeviceCarMessage();
			msg.setId(IntStepGen.getNextIntAsString());
			msg.setOildeviceid(Long.parseLong(connid));
			msg.setVehicles(vehicles);
			sendService.sendMessageNoWaitResponse(connid, msg);
		} catch (Exception e) {
			e.printStackTrace();
			saveDeviceConnectError(String.valueOf(connid), JSONObject.toJSONString(vehicles),"当前油机的车牌数据未下发成功");
		}
	}
	
	
	/**
	 * 获取系统异常日志
	 * @param systemLog
	 * @return
	 * @throws PTPECAppException
	 */
	public Map<String,Object> getSystemErrormsgFromEs(SystemLog systemLog) throws PTPECAppException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<SystemLog> systemLogs = new ArrayList<SystemLog>();
		try {
			NcmiService ncmiservice = sharedClient.getNcmiService();
			JSONObject jsonP = new JSONObject();
			jsonP.put("index", Constant.Index_systemlog);
			jsonP.put("type", Constant.Type_systemlog);
			jsonP.put("start", systemLog.getStart());
			jsonP.put("limit", systemLog.getLength());
			JSONObject mustparams = new JSONObject();
			if(systemLog.getLogtype() != null){
				mustparams.put("logtype",systemLog.getLogtype());
			}
			if(systemLog.getLogmodule() != null){
				mustparams.put("logmodule",systemLog.getLogmodule());
			}
			jsonP.put("mustparams", mustparams);
			JSONObject jsonSort = new JSONObject();
			jsonSort.put("fieldname", "createdate");
			jsonSort.put("sort", "desc");
			jsonP.put("sortparam", jsonSort);
			String result = ncmiservice.queryFromElasticsearchSR(jsonP.toJSONString());
			JSONObject jsonresult = JSONObject.parseObject(result);
			String success = jsonresult.getString("status");
			if("SUCCESS".equals(success)){
				JSONObject msg = jsonresult.getJSONObject("msg");
				resultMap.put("totalHits", msg.get("totalHits"));
				JSONArray jsonarray = msg.getJSONArray("hits");
				for(Object obj : jsonarray){
					JSONObject userobject = (JSONObject)obj;
					String systemLogStr = userobject.getString("source");
					SystemLog sl = JSONObject.parseObject(systemLogStr, SystemLog.class);
					systemLogs.add(sl);
				}
				
			}
			resultMap.put("items", systemLogs);
			return resultMap;
		} catch (Exception e) {
			throw new PTPECAppException("获取系统异常日志异常",e);
		}
	}
	
	/**
	 * 根据租户id查询广告基本信息
	 * @param tenantid
	 * @return
	 */
	public List<AdInfo> selectAdInfoList(String tenantid) {
		return adInfoService.queryListByTenantid(tenantid);
	}
	
	/**
	 * 更新车辆加油状态
	 * @param carnum
	 * @param status 0:未加油  1:加油中
	 * @return
	 * @throws Exception 
	 */
	public boolean updateVehicleGasStatus(String carnum,String status){
		boolean result = true;
		try {
			BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(carnum);
			if(StringUtils.isNotBlank(hashOpertions.get(VehicleEnum.CARNUM.toString()))){
				//更新状态
				hashOpertions.put(VehicleEnum.GASSTATUS.toString(), status);
				if("1".equals(status)){
					Date expireDate = DateUtils.addTimeByMinutes(new Date(), 10);
					hashOpertions.expireAt(expireDate);
				}else if("0".equals(status)){
					DictionaryData dd = getDataByDoubleCode(DictionaryEnum.TIMEOUT, Constant.CAR_MOVE_HEART_TIMEOUT, "f652e66ac0714627aa66c58471455680");
					Date expireDate = null;
					if(dd != null){
						expireDate = DateUtils.addTimeByMinutes(new Date(), Integer.parseInt(dd.getItemValue()));
					}else{
						expireDate = DateUtils.addTimeByMinutes(new Date(), Constant.CAR_MOVE_HEART_TIMEOUT_DE);
					}
					hashOpertions.expireAt(expireDate);
				}
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean destorySession(String sign,String userid,String tenantid,String carnum,String gasStatus) throws BusinessException{
		BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps("session:"+userid+tenantid);
		String loginLogid = hashOpertions.get(userid);
		if(StringUtils.isNotBlank(loginLogid)){
			if(StringUtils.isBlank(loginLogid)){
				throw new BusinessException("用户未登陆");
			}
			String sessionid = hashOpertions.get("sessionid");
			if(!sign.equals(sessionid)){
				throw new BusinessException("调用不合法");
			}
			stringRedisTemplate.delete("session:"+userid+tenantid);
		}
		//updateVehicleGasStatus
		updateVehicleGasStatus(carnum, gasStatus);//设置当前车牌为非加油状态
		return true;
	}
	
	public boolean userIsLogin(UserInfo userInfo,UserLoginfo userLoginfo,Devices devices) throws PTPECAppException{
		boolean canlogin = false;
		if(userInfo == null){
			return canlogin;
		}
		BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps("session:"+userInfo.getUserid()+devices.getTenantid());
		String loginLogid = hashOpertions.get(userInfo.getUserid());
		UserLoginfo userLoginfoTemp = userLoginfoService.getuserLoginInfo(userInfo.getUserid(),devices.getTenantid());
		if(StringUtils.isNotBlank(loginLogid)){
			//可能已经登陆了
			if(userLoginfoTemp != null){
				if(devices.getConnid().equals(userLoginfoTemp.getDeviceconnid())&& userLoginfo.getAreacode().equals(userLoginfoTemp.getAreacode())){
					//在同一台设备上,可以登陆
					canlogin = true;
				}
			}
		}else{
			canlogin = true;
		}
		return canlogin;
	}
	
	/**
	 * 用户已登陆不需要更新最近访问时间时返回null
	 * 其它情况返回用户登陆信息
	 * accessType  0：预约单加油
	 * 			   1：人脸识别加油
	 * 			   2：车辆识别加油
	 * @return
	 * @throws Exception 
	 */
	public UserLoginfo createUserAccessSession(UserInfo userInfo,UserLoginfo userLoginfo,Vehicle vehicleTemp,Devices devices) throws Exception{
		if(userInfo == null){
			return null;
		}
		EaccountInfo eaccountInfo = userInfo.getEaccountInfo();
		if(eaccountInfo == null){
			return null;
		}
		BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps("session:"+userInfo.getUserid()+userLoginfo.getTenantid());
		UserLoginfo userLoginfoTemp = userLoginfoService.getuserLoginInfo(userInfo.getUserid(),userLoginfo.getTenantid());
		String loginLogid = hashOpertions.get(userInfo.getUserid());
		if(StringUtils.isNotBlank(loginLogid)){
			if(userLoginfoTemp != null){
				if(!(devices.getConnid().equals(userLoginfoTemp.getDeviceconnid())&& userLoginfo.getAreacode().equals(userLoginfoTemp.getAreacode()))){
					//不是在同一台设备上
					return null;
				}
			}
		}
		if(userLoginfoTemp == null){
			userLoginfoTemp = userLoginfo;
			userLoginfoTemp.setUserid(userInfo.getUserid());
			userLoginfoTemp.setUsername(userInfo.getUsername());
			userLoginfoTemp.setCreator(userInfo.getUsername());
			userLoginfoTemp.setUpdateuser(userInfo.getUsername());
		}else{
			userLoginfoTemp.setStncode(devices.getNodecode());
			userLoginfoTemp.setTenantid(devices.getTenantid());
			userLoginfoTemp.setDeviceconnid(devices.getConnid());
			userLoginfoTemp.setAreacode(userLoginfo.getAreacode());
			userLoginfoTemp.setCarnum(userLoginfo.getCarnum());
			userLoginfoTemp.setIp(userLoginfo.getIp());
			userLoginfoTemp.setOilcode(userLoginfo.getOilcode());
			userLoginfoTemp.setOilno(userLoginfo.getOilno());
			userLoginfoTemp.setPrice(userLoginfo.getPrice());
			userLoginfoTemp.setNozzleno(userLoginfo.getNozzleno());
			userLoginfoTemp.setAreacode(userLoginfo.getAreacode());
			userLoginfoTemp.setSaleno(userLoginfo.getSaleno());
		}
		//存储加油时电子账户环境信息
		userLoginfoTemp.setAccountid(eaccountInfo.getAccountid());
		userLoginfoTemp.setAmount(eaccountInfo.getAmount());
		userLoginfoTemp.setAvoidamount(eaccountInfo.getAvoidamount());
		userLoginfoTemp.setUseableamount(eaccountInfo.getUseableamount());
		userLoginfoTemp.setFreepword(isneedPassWord(userInfo));
		//存储车牌数据
		if(StringUtils.isNotBlank(vehicleTemp.getLeft())){
			userLoginfoTemp.setCleft(Long.parseLong(vehicleTemp.getLeft()));
			userLoginfoTemp.setCtop(Long.parseLong(vehicleTemp.getTop()));
			userLoginfoTemp.setCright(Long.parseLong(vehicleTemp.getRight()));
			userLoginfoTemp.setCbottom(Long.parseLong(vehicleTemp.getBottom()));
		}
		userLoginfoTemp.setCameraid(vehicleTemp.getCameraid());
		userLoginfoService.saveorUpdateUserLoginfo(userLoginfoTemp);
		hashOpertions.put(userInfo.getUserid(), userLoginfoTemp.getId());
		String sessionid = StringUtils.makeUUID();
		hashOpertions.put("sessionid", sessionid);
		userLoginfoTemp.setSessionid(sessionid);
		DictionaryData dd = getDataByDoubleCode(DictionaryEnum.TIMEOUT, Constant.USER_SESSION_TIMEOUT, userLoginfo.getTenantid());
		Date expireDate = null;
		if(dd != null){
			expireDate = DateUtils.addTimeByMinutes(new Date(), Integer.parseInt(dd.getItemValue()));
		}else{
			expireDate = DateUtils.addTimeByMinutes(new Date(), Constant.USER_SESSION_TIMEOUT_DE);
		}
		hashOpertions.expireAt(expireDate);
		updateVehicleGasStatus(userLoginfoTemp.getCarnum(), "1");//设置当前车牌为加油状态
		return userLoginfoTemp;
	}
	
	public UserLoginfo getuserLoginInfo(String userid,String tenantid) throws PTPECAppException{
		return userLoginfoService.getuserLoginInfo(userid,tenantid);
	}
	
	
	/**
	 * 更新用户session
	 * @param userid
	 * @param tenantid
	 * @param sign
	 * @return
	 * @throws Exception
	 */
	public UserLoginfo updateUserAccessSession(String userid,String tenantid,String sign) throws Exception{
		UserLoginfo userLoginfo = null;
		BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps("session:"+userid+tenantid);
		String loginLogid = hashOpertions.get(userid);
		if(StringUtils.isNotBlank(loginLogid)){
			String sessionid = hashOpertions.get("sessionid");
			//已登陆更新最后过期时间
			userLoginfo = userLoginfoService.getuserLoginInfo(userid,tenantid);
			if(sign.equals(sessionid)){//sign 不相等不能变更session失效日期
				userLoginfo.setStep("0");
				userLoginfo.setUpdateuser(userid);
				userLoginfoService.saveorUpdateUserLoginfo(userLoginfo);
				DictionaryData dd = getDataByDoubleCode(DictionaryEnum.TIMEOUT, Constant.USER_SESSION_TIMEOUT, userLoginfo.getTenantid());
				Date expireDate = null;
				if(dd != null){
					expireDate = DateUtils.addTimeByMinutes(new Date(), Integer.parseInt(dd.getItemValue()));
				}else{
					expireDate = DateUtils.addTimeByMinutes(new Date(), Constant.USER_SESSION_TIMEOUT_DE);
				}
				hashOpertions.expireAt(expireDate);
				userLoginfo.setSessionid(sessionid);
			}else{
				userLoginfo = null;
			}
		}
		return userLoginfo;
	}
	
	public UserLoginfo updateUserLoginfo(UserLoginfo userLoginfo) throws PTPECAppException{
		return userLoginfoService.saveorUpdateUserLoginfo(userLoginfo);
	}
	
	public String covertUsername(String username,String sex){
		if(StringUtils.isNotBlank(username)){
			if(username.length() >= 11){
				//是电话号码
				String temp = username.substring(0,3) +"****"+ username.substring(username.length() - 4,username.length());
				username = temp;
			}else{
				String temp = username.substring(0, 1);
				if(username.length() == 2){
					username = temp + "*";
				}else{
					temp += "*"+username.substring(username.length() - 1);
					username = temp;
				}
			}
			
		}
		return username;
	}
	
	/**
	 * 根据ID获取所对应的安全区域
	 * @param ids
	 * @param deviceTypeCode
	 * @return
	 * @throws PTPECAppException 
	 */
	public List<DevicesArea> findAreanumListByDevicesids(String ids,String deviceTypeCode) throws PTPECAppException{
		return devicesAreaService.findAreanumListByDevicesids(ids, deviceTypeCode);
	}
	
	/**
	 * 根据
	 * @param oilids
	 * @return
	 * @throws PTPECAppException 
	 */
	public List<Devices> queryDevicesListByIds(List<String> oilids) throws PTPECAppException {
		return devicesService.queryDevicesListByIds(oilids);
	}
	
	/**
	 * 获取当前油机下的所有已绑定的车牌信息
	 * @param oilconnid
	 * @return
	 * @throws PTPECAppException 
	 */
	public List<Vehicle> getCurrentVehicles(String oilconnid) throws PTPECAppException{
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		Devices oildevice = devicesService.findByConnid(oilconnid, Constant.OILMACH_CODE);
		if(oildevice == null){
			return vehicles;
		}
		List<DevicesArea> das = findAreanumListByDevicesids(oildevice.getDevicesid(), Constant.OILMACH_CODE);
		if(das == null || das.size() == 0){
			return vehicles;
		}
		//根据加油位找到所有的摄像头
		List<String> ids = new ArrayList<String>();
		for(DevicesArea da : das){
			ids.add(da.getCameraid());
		}
		List<Devices> cameras = queryDevicesListByIds(ids);
		if(cameras == null || cameras.size() == 0){
			return vehicles;
		}
		//获取摄像头下所有的车牌集合
		for(DevicesArea da : das){
			for(Devices cameradevice : cameras){
				BoundHashOperations<String, String, String> cameraOpertions = stringRedisTemplate.boundHashOps(cameradevice.getTenantid()+cameradevice.getConnid());
				String carnums = cameraOpertions.get("carnums");
				if(StringUtils.isNotBlank(carnums)){
					String[] carnumarr = carnums.split("&");
					for(String carnum : carnumarr){
						BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(carnum);
						String carnumcache = hashOpertions.get(VehicleEnum.CARNUM.toString());
						if(StringUtils.isBlank(carnumcache)){
							if(carnums.contains(carnum+"&")){
								carnums = carnums.replace(carnum+"&", "");
							}else{
								carnums = carnums.replace(carnum, "");
							}
						}else{
							String gasstatus = hashOpertions.get(VehicleEnum.GASSTATUS.toString());
							System.out.println(gasstatus);
							/*if("1".equals(gasstatus)){
								continue;
							}*/
							//获取该车牌的坐标信息并与当前加油位的坐标计算
							long left = Long.valueOf(hashOpertions.get(VehicleEnum.LEFT.toString()));
							long top = Long.valueOf(hashOpertions.get(VehicleEnum.TOP.toString()));
							long right = Long.valueOf(hashOpertions.get(VehicleEnum.RIGHT.toString()));
							long bottom = Long.valueOf(hashOpertions.get(VehicleEnum.BOTTOM.toString()));
							//计算坐标
							BigDecimal cm = new BigDecimal("100"); 
							byte areacode = da.getAreacode();
							long lefttopx = da.getLefttopx().multiply(cm).longValue();
							long lefttopy = da.getLefttopy().multiply(cm).longValue();
							long rightbottomx = da.getRightbottomx().multiply(cm).longValue();
							long rightbottomy = da.getRightbottomy().multiply(cm).longValue();
							boolean rate = InMatrix.inside(left, top, right, bottom, lefttopx, lefttopy, rightbottomx, rightbottomy);
							if(rate){
								//获取当前车牌的所有用户信息
								Vehicle vehicle = new Vehicle();
								String showcode = carnumShowOnScreen(String.valueOf(areacode));
								String needpassword = hashOpertions.get("needpassword");
								String pwtype = hashOpertions.get("pwtype");
								String oiltypecode = hashOpertions.get("oiltypecode");//油品型号
								vehicle.setAreacode(showcode);
								vehicle.setNeedpassword(needpassword);
								vehicle.setPwtype(pwtype);
								vehicle.setOiltypecode(oiltypecode);
								vehicle.setCarnum(carnumcache);
								vehicles.add(vehicle);
							}
						}
					}
					cameraOpertions.put("carnums", carnums);
				}
			}
		}
		return vehicles;
	}
	
	/**
	 * 保存加油机成交记录(包括加油机上班下班，油价变更，非电子支付的加油记录)
	 * @param transdata
	 * @return
	 * @throws PTPECAppException 
	 */
	public PosRecord insertPosRecord(String transdata,Devices devices,String userid,String saleno) throws PTPECAppException{
		PosRecord posRecord = new PosRecord();
		posRecord.setTenantid(devices.getTenantid());
		if(StringUtils.isBlank(userid)){
			userid = "0";
			posRecord.setUpdateuser(devices.getConnid());
			posRecord.setCreator(devices.getConnid());
		}else{
			posRecord.setUpdateuser(userid);
			posRecord.setCreator(userid);
		}
		posRecord.setDeviceconnid(devices.getConnid());
		posRecord.setUserid(userid);
		posRecord.setSaleno(saleno);
		//解析成交记录
		byte[] posrecordbyte  = Base64.decode(transdata);
		byte[] posttc = new byte[4];
		System.arraycopy(posrecordbyte, 0, posttc, 0, 4);
		posRecord.setPosttc(ByteUtil.getLongBy4BytesR(posttc));
		
		byte[] ttype = new byte[1];
		System.arraycopy(posrecordbyte, 4, ttype, 0, 1);
		posRecord.setTtype(ByteUtil.binary(ttype, 2));
		
		byte[] time = new byte[7];
		System.arraycopy(posrecordbyte, 5, time, 0, 7);
		String bintime = ByteUtil.binary(time, 2);
		String timestr = ByteUtil.bcd2str(bintime);
		posRecord.setTime(Long.parseLong(timestr));
		
		byte[] asn = new byte[10];
		System.arraycopy(posrecordbyte, 12, asn, 0, 10);
		String binasn = ByteUtil.binary(asn, 2);
		String binasnstr = ByteUtil.bcd2str(binasn);
		posRecord.setAsn(Long.parseLong(binasnstr));
		
		byte[] bal = new byte[4];
		System.arraycopy(posrecordbyte, 22, bal, 0, 4);
		posRecord.setBal(ByteUtil.getLongBy4BytesR(bal));
		
		byte[] amn = new byte[3];
		System.arraycopy(posrecordbyte, 26, amn, 0, 3);
		posRecord.setAmn(ByteUtil.getLongBy4BytesR(amn));
		
		byte[] ctc = new byte[2];
		System.arraycopy(posrecordbyte, 29, ctc, 0, 2);
		System.out.println("ctc:"+ByteUtil.getLongBy4BytesR(ctc));
		posRecord.setCtc(ByteUtil.getLongBy4BytesR(ctc));
		
		byte[] tac = new byte[4];
		System.arraycopy(posrecordbyte, 31, tac, 0, 4);
		posRecord.setTac(ByteUtil.getLongBy4BytesR(tac));
		
		byte[] gmac = new byte[4];
		System.arraycopy(posrecordbyte, 35, gmac, 0, 4);
		posRecord.setGmac(ByteUtil.getLongBy4BytesR(gmac));
		
		byte[] psamtac = new byte[4];
		System.arraycopy(posrecordbyte, 39, psamtac, 0, 4);
		posRecord.setPsamtac(ByteUtil.getLongBy4BytesR(psamtac));
		
		byte[] psamasn = new byte[10];
		System.arraycopy(posrecordbyte, 43, psamasn, 0, 10);
		String binpsamasn = ByteUtil.binary(psamasn, 2);
		String binpsamasnstr = ByteUtil.bcd2str(binpsamasn);
		posRecord.setPsamasn(binpsamasnstr);
		
		byte[] psamtid = new byte[6];
		System.arraycopy(posrecordbyte, 53, psamtid, 0, 6);
		posRecord.setPsamtid(ByteUtil.getLongBy4BytesR(psamtid));
		
		byte[] psamttc = new byte[4];
		System.arraycopy(posrecordbyte, 59, psamttc, 0, 4);
		posRecord.setPsamttc(ByteUtil.getLongBy4BytesR(psamttc));
		
		byte[] ds = new byte[1];
		System.arraycopy(posrecordbyte, 63, ds, 0, 1);
		posRecord.setDs(ByteUtil.getLongBy4BytesR(ds));
		
		byte[] unit = new byte[1];
		System.arraycopy(posrecordbyte, 64, unit, 0, 1);
		posRecord.setUnit(ByteUtil.binary(unit, 2));
		
		byte[] ctype = new byte[1];
		System.arraycopy(posrecordbyte, 65, ctype, 0, 1);
		posRecord.setCtype(ByteUtil.binary(ctype, 2));
		
		byte[] ver = new byte[1];
		System.arraycopy(posrecordbyte, 66, ver, 0, 1);
		posRecord.setVer(ByteUtil.binary(ver, 2));
		
		byte[] nzn = new byte[1];
		System.arraycopy(posrecordbyte, 67, nzn, 0, 1);
		posRecord.setNzn(ByteUtil.getLongBy4BytesR(nzn));
		
		byte[] gcode = new byte[2];
		System.arraycopy(posrecordbyte, 68, gcode, 0, 2);
		String bingcode = ByteUtil.binary(gcode, 2);
		String bingcodestr = ByteUtil.bcd2str(bingcode);
		posRecord.setGcode(bingcodestr);
		
		byte[] vol = new byte[3];
		System.arraycopy(posrecordbyte, 70, vol, 0, 3);
		posRecord.setVol(ByteUtil.getLongBy4BytesR(vol));
		
		byte[] prc = new byte[2];
		System.arraycopy(posrecordbyte, 73, prc, 0, 2);
		posRecord.setPrc(ByteUtil.getLongBy4BytesR(prc));
		
		byte[] emp = new byte[1];
		System.arraycopy(posrecordbyte, 75, emp, 0, 1);
		posRecord.setEmp(ByteUtil.getLongBy4BytesR(emp));
		
		byte[] vtot = new byte[4];
		System.arraycopy(posrecordbyte, 76, vtot, 0, 4);
		posRecord.setVtot(ByteUtil.getLongBy4BytesR(vtot));
		
		byte[] rfu = new byte[10];
		System.arraycopy(posrecordbyte, 80, rfu, 0, 10);
		posRecord.setRfu(ByteUtil.getLongBy4BytesR(tac));
		
		byte[] tmac = new byte[4];
		System.arraycopy(posrecordbyte, 91, tmac, 0, 4);
		posRecord.setTmac(ByteUtil.getLongBy4BytesR(tmac));
		posRecord = posRecordService.insertPosRecord(posRecord);
		return posRecord;
	}
	
	
	/**
	 * 记录用户加油环节出现的异常信息
	 * @param cameraid
	 * @param carnum
	 */
	public void saveUserAuthenticationError(String methodname,String remark,String data,String msg){
		SystemLog loginfo = new SystemLog();
		loginfo.setLogmodule(Constant.logmodule_userlog);
		loginfo.setLogtype(Constant.logtype_error);
		loginfo.setRemark(remark);
		JSONObject logmsg = new JSONObject();
		logmsg.put("methodname", methodname);
		logmsg.put("data", data);
		logmsg.put("msg", msg);
		loginfo.setLogmsg(logmsg.toJSONString());
		mqSenderService.ntranAddUserLoginToes(loginfo);
	}
	
	/**
	 * 为签到的油机生成通信密钥
	 * @param publickey 油机端公钥
	 * @param devices   油机相关信息
	 * @return
	 * @throws PTPECAppException 
	 * @throws NoSuchAlgorithmException 
	 */
	public JSONObject createOilMachinePublickey(String publickey,Devices devices) throws PTPECAppException, NoSuchAlgorithmException{
		OILKeyPair keyPair = EncryptUtil.getKeyPair();
		//签到时，入口未校验设备，改为此处校验设备
		devices = devicesService.finddevices(devices.getTenantid(), devices.getNodecode(), devices.getConnid(), Constant.OILMACH_CODE);
		if(devices == null){
			throw new BusinessException("设备非法");
		}
		devices.setPrivatekey(keyPair.getBase64PrivateKey());
		devices.setPublickey(publickey);
		devicesService.updateDevice(devices, "admin");
		String signid = saveDeviceSignid(devices.getTenantid(), devices.getNodecode(), devices.getConnid());
		JSONObject resu = new JSONObject();
		resu.put("signid", signid);
		resu.put("publickey", keyPair.getBase64PublicKey());
		return resu;
	}
	
	private String saveDeviceSignid(String tenantid,String stncode,String connid) throws PTPECAppException{
		try {
			String signid = StringUtils.makeUUID();
			BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(signid);
			hashOpertions.put("stncode", stncode);
			hashOpertions.put("connid", connid);
			hashOpertions.put("tenantid", tenantid);
			DictionaryData dd =getDataByDoubleCode(DictionaryEnum.TIMEOUT, Constant.IOT_SIGNID_TIMEOUT, tenantid);
			Date expireDate = null;
			if(dd != null){
				expireDate = DateUtils.addDate(new Date(), Integer.parseInt(dd.getItemValue()));
			}else{
				expireDate = DateUtils.addDate(new Date(), Constant.IOT_SIGNID_TIMEOUT_DE);
			}
			hashOpertions.expireAt(expireDate);
			return signid;
		}catch(Exception e){
			throw new PTPECAppException("创建设备通信签名异常:"+e.getMessage(),e);
		}
		
	}
	
	/**
	 * 预授权申，申请后创建登录信息
	 * @param userinfo
	 * @param saleno
	 * @param password
	 * @param devices
	 * @param userLoginfo
	 * @param selfhelp
	 * @param passwordtype
	 * @param vehicleTemp
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> ntranpreCreateSession(UserInfo userinfo,String saleno,String password,Devices devices,UserLoginfo userLoginfo,String selfhelp,String passwordtype,Vehicle vehicleTemp) throws Exception{
		PreAuthorization pa = ntranpreAuthorizationSQ(userinfo,saleno, userinfo.getEaccountInfo(),password,devices,userLoginfo,selfhelp,passwordtype);
		if(pa != null){
			userLoginfo = createUserAccessSession(userinfo,userLoginfo,vehicleTemp,devices);
			if(userLoginfo == null){
				throw new Exception("用户已登陆");
			}
		}else{
			throw new Exception("预授权申请失败");
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("pre", pa);
		result.put("uli", userLoginfo);
		return result;
	}
}
