package com.afs.fasm.mqconsumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;

import com.afs.base.constants.TimeFormatConstant;
import com.afs.base.mq.MessageHandler;
import com.afs.base.util.MyExceptionUtil;
import com.afs.fasm.mcp.message.FasmAbstractMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.rabbitmq.client.BasicProperties;

public class MessageToDBConsumer implements MessageHandler {
	private static Logger log = LoggerFactory.getLogger(MessageToDBConsumer.class);
   
   
   @Override
	public boolean handleMessage(byte[] message, BasicProperties prop) {
		
	   Gson gson =  new GsonBuilder().setDateFormat(TimeFormatConstant.YYYYMMDDHHMMSS).create();
	   String json = new  String(message);
	   log.info("json======"+json);
	   try{
		   FasmAbstractMessage famsg = gson.fromJson(json, FasmAbstractMessage.class);
		  
		   //工作状态,即注册命令,数据库中没有则插入,有则更新
		   if(famsg.getMessageType()==(byte)0x01){
			   //HeartbeatMessage msg = gson.fromJson(json,HeartbeatMessage.class);
			   //List<WorkStatusModel> list = null;//this.workStatusServiceImpl.findByProperty(WorkStatusModel.class, "equipId", msg.getUserId(), 1, null);
			   
			   /*if(list==null || list.size()==0){
				   WorkStatusModel model = msgToWorkStatusModel(msg);
				   this.workStatusServiceImpl.save(model);
			   }else{
				   WorkStatusModel model = list.get(0);
				   msgUpdateWorkStatusModel(msg,model);
				   this.workStatusServiceImpl.merge(model);
			   }*/
		   }
		   
	   }catch(DataIntegrityViolationException ex){
		   log.error(MyExceptionUtil.getStackTrace(ex));
		   return true;
	   }catch(JsonParseException jsonex){
		   log.error(MyExceptionUtil.getStackTrace(jsonex));
		   return true;
	   }
	   catch(Throwable t){
		   log.error(MyExceptionUtil.getStackTrace(t));
		   return false;
	   }
		
		return true;
	}
   
  /* private void msgUpdateWorkStatusModel(HeartbeatMessage msg,WorkStatusModel model){
	  // model.setEquipId(msg.getEquipId());
	   model.setDataReceiveTime(new Date());
	 //  model.setWorkStatus(msg.getOnoffStatus());
	   model.setMntTime(new Date());
   }*/
   
   /*private WorkStatusModel msgToWorkStatusModel(HeartbeatMessage msg){
	   WorkStatusModel model = new WorkStatusModel();
	   
	//   model.setEquipId(msg.getEquipId());
	   model.setDataReceiveTime(new Date());
	  // model.setWorkStatus(msg.getHeartResponse());
	   model.setCrtTime(new Date());
	   
	   return model;
   }*/
   

}
