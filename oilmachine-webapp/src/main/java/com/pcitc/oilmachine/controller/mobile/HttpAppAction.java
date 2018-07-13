package com.pcitc.oilmachine.controller.mobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.certificate.BusinessException;
import com.pcitc.oilmachine.commons.certificate.SDKUtil;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.constant.ResultConstant;
import com.pcitc.oilmachine.commons.utils.AESUtil;
import com.pcitc.oilmachine.commons.utils.DateUtils;
import com.pcitc.oilmachine.commons.utils.JsonEncryptUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.controller.BaseAction;
import com.pcitc.oilmachine.form.MobileDataInfo;
import com.pcitc.oilmachine.form.MobileResultInfo;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.service.mobile.OrderService;
import com.pcitc.oilmachine.service.mobile.UserAuthenticationService;
import com.pcitc.oilmachine.service.modelservice.devices.DevicesService;
import com.pcitc.oilmachine.service.modelservice.order.PreAuthorizationService;
 

/**
 * @author zizhi.zhang
 * HTTPCrmService.java
 * 主服务入口
 * 仅接受POST请求
 */
@Controller
@RequestMapping("/mobile")
public class HttpAppAction extends BaseAction {
	static JSONObject gson = new JSONObject();
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private static String basePath = "";
	private static String publicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgMVBqC+EYBI8b0ja tlhu3JeP1sw0QV0DKMijrLYbzIK7EpdrG/iXLRTLtTa+n/hdu4/KVf3Funm8 h2LZcqABruoZtvjlN63X8wboOseghakcSWwhuzyU/Iyvxhp4m2ySXgyqrkya CiqSYPKWcga1JlsUbDoNuKWi7RQ8SsOKKv6avmp/MENvzg+/ozp+3ujkTrK2 coL96SQkjZgJWqui0ZxB86z+KN1otu71AJ3GC5uqRUB1/pwj0tiimDmesd+r KrXlDsPGfAOGk172JWwaJTWQds5wqt5hIk3gEbuQsrkQUy/V8sIq5F3pRVSA 8dxYYSyw6FM46DeS13Zmyipp0wIDAQAB";

	@Resource
	private DevicesService devicesService;
	@Resource
	private PreAuthorizationService preAuthorizationService;
	@Resource
	private UserAuthenticationService userAuthenticationService;
	@Resource
	private OrderService orderService;
	private static Logger log = LogManager.getLogger(HttpAppAction.class.getName());
	
	/**
	 * 手机调用接口
	 * @throws IOException 
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@ResponseBody
	@RequestMapping("/HttpAppApi")
	public void HttpAppApi(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String ip = getIpAddr(request);
		if(StringUtils.isBlank(basePath)){
			String path = request.getContextPath(); 
			basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		}
		//读取请求数据
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));  
		String line = null;  
		StringBuilder strBuff = new StringBuilder();
		while((line = br.readLine())!=null){  
			strBuff.append(line);
		}  
		if(StringUtils.isBlank(strBuff.toString())){
			response.setCharacterEncoding("utf-8");  
			MobileResultInfo mri = new MobileResultInfo();
			mri.setError("请求数据为空");
	  	    response.getWriter().write(JSONObject.toJSONString(mri));
	  	    return;
		}
		String result=null;
		try{ 
		    //整理返回数据
		    result =execute(gson.parseObject(strBuff.toString(), MobileDataInfo.class),ip);
         }catch(Exception e){
			log.error(e);
		}
		if(result==null){
			result = "";
		}
		//编辑文本状态并写入缓存区中
		response.setCharacterEncoding("utf-8");
  	    response.getWriter().write(result);
	}
	
	/**
	 * 手机调用接口
	 * @throws IOException 
	 * @throws ServletException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/esrcallback", method = RequestMethod.POST)
	public void esrcallback(HttpServletRequest request, HttpServletResponse response) throws IOException{
		JSONObject result = new JSONObject();
		log.info("预授权回调==================");
		result.put("success", true);
		JSONObject rObject = null;
		try {
			String requestBody = request.getParameter("jsonData");
			rObject = JSONObject.parseObject(requestBody);
			String code = rObject.getString("code");
			
			boolean nerify = JsonEncryptUtil.verifySign(rObject, "sign", publicKey, "", null);
			if(nerify){
				// 解密数据
				String sysKey = rObject.getString("sysKey");// 临时秘钥
				String data = rObject.getString("data");// 加密数据包
				String decryDate = JsonEncryptUtil.decryDate(sysKey, publicKey, data);
				JSONObject dObject = JSON.parseObject(decryDate);
				String mchCode = dObject.getString("mchCode");//商户号
				String sysUserCode = dObject.getString("sysUserCode");//会员编号
				String orderid = dObject.getString("orderid");//流水号
				String btradeNo = dObject.getString("btradeNo");//业务订单号
				String accId = dObject.getString("accId");//交易账号
				String tradeType = dObject.getString("tradeType");//交易类型 30-预授权 32-预授权完成
				String dealresult = dObject.getString("traflag");//处理结果 00-成功；11-失败
				if(!"0000".equals(code)){
					dealresult = dObject.getString("msg");
				}
				if("30".equals(tradeType) || "31".equals(tradeType)|| "32".equals(tradeType)){
					preAuthorizationService.updateCallBackMsg(mchCode,sysUserCode,orderid,btradeNo,accId,tradeType,dealresult);
				}else{
					result.put("success", false);
					result.put("msg", "不支持的回调类型");
				}
				log.info("返回解密结果：--------"+decryDate);
			}
		} catch (Exception e) {
			log.error("回调失败:"+rObject.toJSONString());
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		//编辑文本状态并写入缓存区中
		response.setCharacterEncoding("utf-8");
  	    response.getWriter().write(result.toJSONString());
	}
	/**
	 * string to json
	 * @param param
	 * @return
	 */
	@SuppressWarnings("static-access")
	private static String getResult(final Object srb){
		return gson.toJSONString(srb);
	}
	/**
	 * 接收手机发送信息 并处理执行类方法
	 * @param scb
	 * @return
	 * @throws ClassNotFoundException 
	 */ 
	private String execute(MobileDataInfo scb,String ip) throws ClassNotFoundException {
		MobileResultInfo srb = new MobileResultInfo();
		Devices devices = null;
		String funname = "";
		if(StringUtils.isNotBlank(scb.getFunName())){
			funname = scb.getFunName();
			String[] fn = funname.split(",");
			if(fn.length == 2){
				log.info(" REV >>:"+DateUtils.formatName()+">>"+JSONObject.toJSONString(scb));
				try {
					if("orderService".equals(fn[0])){
						srb = orderService.execute(scb.getData(), fn[1],ip);
					}else{
						srb.setErrorcode(ResultConstant.ERROR_SERVICE_NOTFOUND);
					}
				}catch(Exception e) {
					srb.setErrorcode(ResultConstant.ERROR_UNKNOWN);
				} 
				return getResult(srb);
			}else{
				try {
					JSONObject assistData = null;
					if(Constant.SIGNIN_METHOD_NAME.equals(scb.getFunName())){
						scb = SDKUtil.securityCReceiveMsg(scb, Constant.SIGNIN_SECURITY_CODE);
						assistData = JSONObject.parseObject(scb.getAssistdata());
						JSONObject data = JSONObject.parseObject(scb.getData());
						devices = new Devices();
						devices.setTenantid(assistData.getString("tenantId"));
						devices.setConnid(data.getString("deviceid"));
						devices.setNodecode(data.getString("stncode"));
					}else{
						//根据signid获取对应公钥
						if(StringUtils.isNotBlank(scb.getSignid())){
							devices = devicesService.findDevicesbySignid(scb.getSignid());
							if(devices == null){
								throw new BusinessException("访问非法");
							}
							//解密
							scb = SDKUtil.securityCReceiveMsg(scb, scb.getRandomcode(), devices.getPrivatekey());
						}else{
							throw new BusinessException("访问非法");
						}
						assistData = JSONObject.parseObject(scb.getAssistdata());
					}
					
					log.info(" REV >>:"+DateUtils.formatName()+">>"+JSONObject.toJSONString(scb));
					try {
						if("com.pcitc.oilmachine.service.mobile.UserAuthenticationService".equals(assistData.getString("serviceCode"))){
							srb = userAuthenticationService.execute(scb.getData(), scb.getFunName(),ip,devices);
						}else{
							srb.setError("您请求的服务不存在");
						}
					}catch (Exception e) {
						srb.setError("您请求的服务初始时发生异常，请联系管理人员检查！");
					}
				}catch(BusinessException e){
					srb.setError(e.getMessage());
					srb.setErrorcode(0);
				}catch(Exception e) {
					srb.setError("未知错误:请联系开发人员");
				} 
				srb.setFunName(funname);
				log.info(" RETURN >>:"+DateUtils.formatName()+">>"+JSONObject.toJSONString(srb));
				try{
					if(Constant.SIGNIN_METHOD_NAME.equals(scb.getFunName())){
						return SDKUtil.securityCReturnMsg(srb, Constant.SIGNIN_SECURITY_CODE);
					}else{
						if(devices != null){
							String randomcode = StringUtils.GenerationEVerifyMessageCode(22);
							randomcode = AESUtil.getSecretKeyStr(randomcode);
							return SDKUtil.securityCReturnMsg(srb, randomcode, devices.getPublickey());
						}
						return getResult(srb);
					}
				}catch(Exception e){
					return getResult(srb);
				}
			}
			
		}else{
			srb.setError("您请求的服务不存在");
			return getResult(srb);
		}
	}
	public static String getBasePath() {
		return basePath;
	}
	
	public String getIpAddr(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
}
