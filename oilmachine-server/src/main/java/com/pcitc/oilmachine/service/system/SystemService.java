package com.pcitc.oilmachine.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.afs.base.util.MySpringContextUtil;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.form.SystemLog;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.UserLoginfo;
import com.pcitc.oilmachine.service.hsf.SharedClient;
import com.pcitc.oilmachine.service.mobile.CommonService;
import com.pcitc.oilmachine.service.modelservice.UserLoginfoService;
import com.pcitc.oilmachine.view.GridData;
import com.pcitc.saas.api.NcmiService;

@Service
public class SystemService {
	
	/**
	 * @author xianlin.sun
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public String userLoginValidate(String username, String password) throws Exception{
		//用户统一认证
		SharedClient sharedClient = (SharedClient)MySpringContextUtil.getBean("sharedClient");
		NcmiService ncmiservice = sharedClient.getNcmiService();
		JSONObject json1 = new JSONObject();
		json1.put("userName", username);
		json1.put("passWord", password);
		return ncmiservice.userLoginValidate(json1.toJSONString());
	}
	
	/**
	 * @author xianlin.sun
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	public String createMenu(UserInfo userInfo) throws Exception{
		SharedClient sharedClient = (SharedClient)MySpringContextUtil.getBean("sharedClient");
		NcmiService ncmiservice = sharedClient.getNcmiService();
		JSONObject json1 = new JSONObject();
		json1.put("tenantId", userInfo.getTenantid());
		json1.put("menuStore", Constant.Menu_Store);
		json1.put("userId", userInfo.getUserid());
		return ncmiservice.getAllFunctionMenu(json1.toJSONString());
	}
	
	/**
	 * 用户登录信息
	 * @param userLoginInfo
	 * @return
	 * @throws PTPECAppException 
	 */
	public GridData getuserLoginList(UserLoginfo userLoginfo, int userloginstatus) throws PTPECAppException{
		UserLoginfoService userLoginfoService = (UserLoginfoService) MySpringContextUtil.getBean("userLoginfoService");
		GridData queryUserLoginfoListPage = userLoginfoService.queryUserLoginfoListPage(userLoginfo,userloginstatus);
		return queryUserLoginfoListPage;
		
	}
	
	
	/**
	 * 异常信息
	 * @param userLoginInfo
	 * @return
	 * @throws PTPECAppException 
	 */
	public GridData getSystemErrormsgList(SystemLog systemLog) throws PTPECAppException{
		GridData gridData = new GridData();
		CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
		
		Map<String,Object> resultMap = commonService.getSystemErrormsgFromEs(systemLog);
		Integer total = (Integer)resultMap.get("totalHits");
		if (total == null || total < 1) {
			return gridData;
		}
		List<SystemLog> systemErrormsgFromEs  = (List<SystemLog>)resultMap.get("items");
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = systemLog.getLength();
		int start = systemLog.getStart();
		gridData.setLength(length);
		gridData.setStart(start);
		gridData.setData(systemErrormsgFromEs);
		return gridData;
	}

	/**
	 * 查询用户登录详细信息
	 * @param id
	 * @return
	 */
	public UserLoginfo findById(String id) {
		UserLoginfoService userLoginfoService = (UserLoginfoService) MySpringContextUtil.getBean("userLoginfoService");
		UserLoginfo user = userLoginfoService.findById(id);
		return user;
	}

}
