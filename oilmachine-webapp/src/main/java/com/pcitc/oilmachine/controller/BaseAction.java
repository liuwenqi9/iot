package com.pcitc.oilmachine.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.view.GridData;

public class BaseAction {
	/**
	 * 返回JSON格式，并格式化时间
	 * @author 王少亭
	 * @param obj
	 * @return
	 * 2017年4月12日下午4:16:00
	 */
	protected String toJSONFormat(Object obj){
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		return JSON.toJSONString(obj,SerializerFeature.WriteDateUseDateFormat);
	}
	
	
	protected String writeGridData(GridData gridData){
		if(gridData.getRecordsTotal() == 0)
			gridData.setData(new ArrayList<>());
		return toJSONFormat(gridData);
	}
	
	protected UserInfo getUserInfo() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		return (UserInfo) request.getSession().getAttribute(Constant.SESSION_KEY);
	}
	
}
