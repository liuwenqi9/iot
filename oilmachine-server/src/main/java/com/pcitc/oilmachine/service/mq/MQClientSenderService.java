package com.pcitc.oilmachine.service.mq;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pcitc.oilmachine.form.SystemLog;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.form.UserLoginInfo;
import com.pcitc.oilmachine.service.modelservice.MqSendExceptionService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 信息发送给MQ
 * @author zizhi.zhang
 *
 */
@Component("mQClientSenderService")
public class MQClientSenderService{
	
	@Value("${mq_ip}")
	private String ip;
	
	@Value("${mq_port}")
	private String port;
	
	@Value("${mq_name}")
	private String username;
	
	@Value("${mq_pass}")
	private String password;
	
	@Value("${mq_ipordercenter}")
	private String ipordercenter;
	
	@Value("${mq_portordercenter}")
	private String portordercenter;
	
	@Value("${mq_nameordercenter}")
	private String usernameordercenter;
	
	@Value("${mq_passordercenter}")
	private String passwordordercenter;
	
	@Resource
	private MqSendExceptionService mqSendExceptionService;
	
	private ExecutorService executor;
	
	private static Logger log = LogManager.getLogger(MQClientSenderService.class.getName());

	@PostConstruct
	public void init() {
		executor = Executors.newFixedThreadPool(5);
	}
	
	/**
	 * 加油明细入会员营销平台
	 * @param json
	 */
	public void mqsendGasFlow(final String json,final String gasOrderid,final String userid,final String tenantid){
		try{
			Future<?> fresult = executor.submit(new Runnable(){  
                @Override  
                public void run() {  
                	try {  
                    	ConnectionFactory factory = new ConnectionFactory();
            			factory.setHost(ip);
            			factory.setPort(Integer.parseInt(port));
            			factory.setUsername(username);
            			factory.setPassword(password);
            			String queueName="bj_jy_nocard";
            			Connection connection = factory.newConnection();
            			Channel channel = connection.createChannel();
            			channel.queueDeclare(queueName, true, false, false, null);
            			channel.basicPublish(queueName, queueName, null, json.getBytes());
            			channel.close();
            			connection.close(); 
                    } catch (Exception e) {
                    	e.printStackTrace();
                    	//插入数据库失败时则记入文件
                    	mqSendExceptionService.insert(gasOrderid,tenantid,userid,json,StringUtils.getErrorInfoFromException(e),"mqsendGasFlow");
                    } 
                }});
			fresult.get(2000, TimeUnit.MILLISECONDS);
		}catch(Exception ex){
			ex.printStackTrace();
			//插入数据库失败时则记入文件
			try{
				mqSendExceptionService.insert(gasOrderid,tenantid,userid,json,"timeout:"+StringUtils.getErrorInfoFromException(ex),"mqsendGasFlow");
			}catch(Exception e){
				
			}
		}
	}
	/**
	 * 用户订单产生的环境信息保存
	 * @author zizhi.zhang
	 * @date 2017年12月14日 下午3:14:58
	 * @param um
	 */
	public void ntranAddUserLoginToes(final UserLoginInfo userLoginInfo){
		 try {  
         	ConnectionFactory factory = new ConnectionFactory();
 			factory.setHost(ip);
 			factory.setPort(Integer.parseInt(port));
 			factory.setUsername(username);
 			factory.setPassword(password);
 			String queueName="mem_es";
 			Connection connection = factory.newConnection();
 			Channel channel = connection.createChannel();
 			channel.queueDeclare(queueName, true, false, false, null);
 			JSONObject jop = new JSONObject();
 			jop.put("index", Constant.Index_userlogininfo);
 			jop.put("type", Constant.Type_userlogininfo);
 			if(StringUtils.isNotBlank(userLoginInfo.getUserLoginId())){
 				jop.put("id", userLoginInfo.getUserLoginId());
 			}
 			jop.put("document", userLoginInfo);
 			channel.basicPublish(queueName, queueName, null, JSONObject.toJSONBytes(jop));
 			channel.close();
 			connection.close(); 
         } catch (Exception e) {
         	e.printStackTrace();
         }
	}
	
	/**
	 * 
	 * @param errorlog
	 * @throws Exception 
	 */
	public void ntranAddUserLoginToes(SystemLog loginfo){
		 try { 
			loginfo.setCreatedate(new Date().getTime());
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(ip);
			factory.setPort(Integer.parseInt(port));
			factory.setUsername(username);
			factory.setPassword(password);
			String queueName="mem_es";
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(queueName, true, false, false, null);
			JSONObject jop = new JSONObject();
			jop.put("index", Constant.Index_systemlog);
			jop.put("type", Constant.Type_systemlog);
			jop.put("document", loginfo);
			channel.basicPublish(queueName, queueName, null, JSONObject.toJSONBytes(jop));
			channel.close();
			connection.close(); 
        } catch (Exception e) {
        	log.error(JSONObject.toJSONString(loginfo)+"==========================");
        	e.printStackTrace();
        }
	}

	//ordercenter
	public void ntranSendPosrecord(JSONObject jop) {
		try { 
			System.out.println(jop.toJSONString()+"＝＝＝＝＝＝＝＝＝＝＝成交记录＝＝＝＝＝＝＝＝");
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(ipordercenter);
			factory.setPort(Integer.parseInt(portordercenter));
			factory.setUsername(usernameordercenter);
			factory.setPassword(passwordordercenter);
			String queueName="orderinfo_oil";
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(queueName, true, false, false, null);
			channel.basicPublish(queueName, "orderinfo_oil", null, JSONObject.toJSONBytes(jop));
			channel.close();
			connection.close();
		} catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
