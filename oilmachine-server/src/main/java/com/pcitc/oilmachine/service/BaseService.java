package com.pcitc.oilmachine.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.afs.base.util.MySpringContextUtil;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.exception.BusinessException;
import com.pcitc.oilmachine.commons.exception.ExceptionCode;
import com.pcitc.oilmachine.service.hsf.SharedClient;
import com.pcitc.saas.api.NcmiService;



@Service
public abstract class BaseService {
	
	/**
	 * 校验参数
	 * 
	 * @author 王少亭
	 * @param o 需要校验的参数
	 * @param code 异常代码
	 * @param msg 异常描述 2017年2月15日下午12:41:55
	 */
	protected void notNull(Object o, String code, String msg, Logger logger) {
		if (o instanceof String) {
			if (o == null || "".equals(((String) o).trim())) {
				if (logger != null)
					logger.error("****code[" + code + "],msg[" + msg + "]****");
				throw new BusinessException(code, msg);
			}
		}else if(o instanceof List){
			if (o == null || ((List<?>)o).size() == 0) {
				if (logger != null)
					logger.error("****code[" + code + "],msg[" + msg + "]****");
				throw new BusinessException(code, msg);
			}
		}else {
			if (o == null) {
				if (logger != null)
					logger.error("****code[" + code + "],msg[" + msg + "]****");
				throw new BusinessException(code, msg);
			}
		}
	}

	protected void notNull(Object o, String code, String msg) {
		notNull(o, code, msg, null);
	}
	
	protected void checkDbSuccess(int num,Logger logger){
		if(num < 1){
			if(logger != null)
				logger.error("****code[" + ExceptionCode.SYSTEM_DB_ERROR.getCode() + "],msg[" + ExceptionCode.SYSTEM_DB_ERROR.getMsg() + "]****");
			throw new BusinessException(ExceptionCode.SYSTEM_DB_ERROR.getCode(), ExceptionCode.SYSTEM_DB_ERROR.getMsg());
		}
	}
	protected void checkDbSuccess(int num){
		checkDbSuccess(num,null);
	}

	@SuppressWarnings("unchecked")
	protected List<Object> getUsernameReturnList(String substring) throws Exception {
		SharedClient sharedClient = (SharedClient)MySpringContextUtil.getBean("sharedClient");
		NcmiService ncmiservice = sharedClient.getNcmiService();
		JSONObject json = new JSONObject();
		json.put("userids", substring);
		String userInfoByParams = ncmiservice.getUserInfoByParams(json.toJSONString());
		JSONObject parseObject = JSONObject.parseObject(userInfoByParams, JSONObject.class);
		Integer code = parseObject.getInteger("code");
		List<Object> returnList = new ArrayList<Object>();
		if(code == 0){
			String success = parseObject.getString("success");
			List<String> userinfoList = JSONObject.parseObject(success, List.class);
			returnList.add(userinfoList);
		}else{
			String msg = parseObject.getString("error");
			throw new Exception(msg);
		}
		return returnList;
	}
	
	/**
	 * 获取商户信息（单一条件查询，优先级 tenantid > bucode）
	 * @param tenantid
	 * @param bucode
	 * @return
	 * @throws Exception
	 */
	protected String getBusinessInfo(String tenantid, String bucode) throws Exception{
		SharedClient sharedClient = (SharedClient)MySpringContextUtil.getBean("sharedClient");
		NcmiService ncmiservice = sharedClient.getNcmiService();
		JSONObject json = new JSONObject();
		if(tenantid != null){
			json.put("tenantid", tenantid);
		}else{
			json.put("bucode", bucode);
		}
		return ncmiservice.getBuInfoList(json.toJSONString());
	}
	
	protected File multipartToFile(MultipartFile multfile) throws IOException {  
        CommonsMultipartFile cf = (CommonsMultipartFile)multfile;   
        //这个myfile是MultipartFile的  
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();  
        File file = fi.getStoreLocation();  
        //手动创建临时文件  
        if(file.length() < 2048){  
            File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +   
                    file.getName());  
            multfile.transferTo(tmpFile);  
            return tmpFile;  
        }  
        return file;  
    }
}
