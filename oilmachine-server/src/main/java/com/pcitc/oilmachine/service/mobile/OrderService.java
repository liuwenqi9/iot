package com.pcitc.oilmachine.service.mobile;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.certificate.BusinessException;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.form.MobileResultInfo;

@Service
public class OrderService {
	
	@Resource
	private CommonService commonService;
	
	/**
	 * 
	 * @param data
	 * @param funName
	 * @param ip
	 * @return
	 */
	public MobileResultInfo execute(String data, String funName,String ip){
		MobileResultInfo result = new MobileResultInfo();
		try {
			if (StringUtils.isBlank(funName)) {
				result.setError(Constant.MOBILE_FUN_ERROR);
			}else if(funName.equals("getPosRecord")){
				result = getPosRecord(data,ip);
			}else if(funName.equals("getSellOrder")){
				result = getSellOrder(data,ip);
			}
		}catch (Exception e) {
			
		}
		return result;
	}

	/**
	 * 19、销售订单查询接口
	 * @param commonService
	 * @param data
	 * @param ip
	 * @return
	 */
	private MobileResultInfo getSellOrder(String data, String ip) {
		MobileResultInfo result = new MobileResultInfo();
		try{
			JSONObject jsondata = JSONObject.parseObject(data);
			String tenantid = jsondata.getString("tenantid");//租户ID
			String stncode = jsondata.getString("stncode");
			if(StringUtils.isBlank(tenantid)){
				throw new BusinessException("参数错误：tenantid");
			}
			if(StringUtils.isBlank(stncode)){
				throw new BusinessException("参数错误：stncode");
			}
			String deviceid = jsondata.getString("deviceid");
			String userid = jsondata.getString("userid");
			Integer nozzleno = jsondata.getInteger("nozzleno");
			Long bTime = jsondata.getLong("bTime");
			Long eTime = jsondata.getLong("eTime");
			Integer start = jsondata.getInteger("start");
			Integer end = jsondata.getInteger("end");
			String order = jsondata.getString("order");
			JSONObject orderJson = commonService.getSellOrder(tenantid,stncode,userid,deviceid,nozzleno,bTime,eTime,start,end,order);
			result.setCode(0);
			result.setSuccess(orderJson.toJSONString());
		}catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}

	/**
	 * 18、员工卡加油成交记录查询接口
	 * @param commonService
	 * @param data
	 * @param ip
	 * @return
	 * @throws PTPECAppException 
	 */
	private MobileResultInfo getPosRecord(String data, String ip) throws PTPECAppException {
		MobileResultInfo result = new MobileResultInfo();
		try{
			JSONObject jsondata = JSONObject.parseObject(data);
			String tenantid = jsondata.getString("tenantid");//租户ID
			String stncode = jsondata.getString("stncode");
			if(StringUtils.isBlank(tenantid)){
				throw new BusinessException("参数错误：tenantid");
			}
			if(StringUtils.isBlank(stncode)){
				throw new BusinessException("参数错误：stncode");
			}
			String deviceidconnid = jsondata.getString("deviceidconnid");
			Integer nozzleno = jsondata.getInteger("nozzleno");
			JSONArray orderJson = commonService.getPosRecord(tenantid,stncode,deviceidconnid,nozzleno);
			result.setCode(0);
			result.setSuccess(orderJson.toJSONString());
		}catch(JSONException e){
			result.setError("数据格式错误");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}

}
