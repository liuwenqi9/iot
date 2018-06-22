package com.pcitc.oilmachine.service.modelservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.MqSendExceptionMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.model.MqSendException;
import com.pcitc.oilmachine.model.MqSendExceptionExample;
import com.pcitc.oilmachine.model.MqSendExceptionExample.Criteria;
import com.pcitc.oilmachine.service.mq.MQClientSenderService;
import com.pcitc.oilmachine.view.GridData;

@Service
public class MqSendExceptionService {
	
	@Resource
	private MqSendExceptionMapper mqSendExceptionMapper;
	
	@Resource
	private RelationMapper gasRelationMapper;
	
	@Resource
	private MQClientSenderService mqClientSenderService;

	public void insert(String gasOrderid, String tenantid,
			String userid, String json, String errorInfoFromException,String methodname) {
		MqSendException mse = new MqSendException();
		mse.setMqsendexceptionid(StringUtils.makeUUID());
		mse.setForeignkeyid(gasOrderid);
		mse.setTenantid(tenantid);
		mse.setUserid(userid);
		mse.setSendmsg(json);
		mse.setExmsg(errorInfoFromException);
		mse.setMethodname(methodname);
		mse.setTypecode(Constant.MQ_SEND_gasFlow);
		Date date = new Date();
		mse.setCreatedate(date);
		mse.setUpdatetime(date);
		mse.setCreator("admin");
		mse.setUpdateuser("admin");
		mse.setSorts((byte)0);
		mse.setStatus((byte)0);
		mqSendExceptionMapper.insert(mse);
	}
	
	public GridData getMqSendException(MqSendException mqSendException) {
		GridData gridData = new GridData();
		mqSendException.setStatus((byte) 0);
		MqSendExceptionExample example = new MqSendExceptionExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(mqSendException);
		//查询条件
		String foreignkeyid = mqSendException.getForeignkeyid();
		String typecode = mqSendException.getTypecode();
		if(foreignkeyid != null && foreignkeyid != ""){
			createCriteria.andForeignkeyidEqualTo(foreignkeyid);
			condition.put("foreignkeyid", foreignkeyid);
		}
		if(typecode != null && typecode != ""){
			createCriteria.andTypecodeEqualTo(typecode);
			condition.put("typecode", typecode);
		}
		createCriteria.andStatusEqualTo((byte)0);
		int dictionaryTotal = mqSendExceptionMapper.countByExample(example);
		if (dictionaryTotal < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(dictionaryTotal);
		gridData.setRecordsTotal(dictionaryTotal);
		int length = mqSendException.getLength();
		gridData.setLength(length);
		int start = mqSendException.getStart();
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		// 查询
		List<MqSendException> list = gasRelationMapper.selectMqSendExceptionPageList(condition);
		gridData.setData(list);
		return gridData;
	}

	public JSONObject reSendMq(String mqsendexceptionid){
		JSONObject json = new JSONObject();
		MqSendException bean = mqSendExceptionMapper.selectByPrimaryKey(mqsendexceptionid);
		Class stringclass = MQClientSenderService.class;
		json.put("status", true);
		/*try {
			Method method = stringclass.getMethod(bean.getMethodname(), String.class, String.class, String.class, String.class);
			method.invoke(stringclass.newInstance(), bean.getSendmsg(), bean.getForeignkeyid(),bean.getUserid(),bean.getTenantid());
			json.put("status", true);
		} catch (IllegalAccessException e) {
			json.put("status", false);
			json.put("msg", "您请求的服务被执行时出现异常，请联系管理人员检查！");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			json.put("status", false);
			json.put("msg", "您请求的服务无法接收规范的参数，请联系管理人员检查！");
			e.printStackTrace();
		} catch (InstantiationException e) {
			json.put("status", false);
			json.put("msg", "您请求的服务是一个接口或是一个抽象类，您没有权限访问！");
			e.printStackTrace();
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", "您请求的服务初始时发生异常，请联系管理人员检查！");
			e.printStackTrace();
		}*/
		return json;
	}

	public MqSendException findById(String mqsendexceptionid) {
		return mqSendExceptionMapper.selectByPrimaryKey(mqsendexceptionid);
	}
}
