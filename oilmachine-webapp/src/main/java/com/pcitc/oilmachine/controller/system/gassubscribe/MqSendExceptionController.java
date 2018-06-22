package com.pcitc.oilmachine.controller.system.gassubscribe;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.controller.BaseAction;
import com.pcitc.oilmachine.model.MqSendException;
import com.pcitc.oilmachine.service.modelservice.MqSendExceptionService;
import com.pcitc.oilmachine.view.GridData;

@Controller
@RequestMapping("/mqsendexception")
public class MqSendExceptionController extends BaseAction{

	@Resource
	private MqSendExceptionService mqSendExceptionService;
	
	@RequestMapping("/mqSendExceptionListPage")
	public String mqSendExceptionListPage(){
		return "view/gassubscribe/mqsendexception";
	}
	
	@ResponseBody
	@RequestMapping("/mqsendexceptionList")
	public String mqsendexceptionList(MqSendException mqSendException){
		GridData gridData = null;
		try{
			gridData = mqSendExceptionService.getMqSendException(mqSendException);
		}catch(Exception e){
			e.printStackTrace();
		}
		return writeGridData(gridData);
	}
	
	@ResponseBody
	@RequestMapping("/reSendMq")
	public void reSendMq(HttpServletRequest request, HttpServletResponse response){
		String mqsendexceptionid = request.getParameter("mqsendexceptionid");
		JSONObject json = new JSONObject();
		try{
			mqSendExceptionService.reSendMq(mqsendexceptionid);
			json.put("status", true);
			json.put("msg", "");
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", false);
			json.put("msg", e.getMessage());
		}
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping("/findById")
	public void findById(HttpServletRequest request, HttpServletResponse response){
		String mqsendexceptionid = request.getParameter("mqsendexceptionid");
		JSONObject json = new JSONObject();
		try{
			MqSendException findById = mqSendExceptionService.findById(mqsendexceptionid);
			json.put("status", true);
			json.put("msg", findById.getExmsg());
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", false);
			json.put("msg", e.getMessage());
		}
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
