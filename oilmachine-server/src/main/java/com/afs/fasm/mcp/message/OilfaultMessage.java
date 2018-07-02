package com.afs.fasm.mcp.message;

import com.afs.base.constants.MessageTypeConstants;
import com.afs.tupeasy.exception.CommunicationException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.utils.ByteUtil;

import io.netty.buffer.ByteBuf;

/**
 * 加油机心跳
 * @author zhang
 *
 */
public class OilfaultMessage extends FasmAbstractMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageContent;
	private long oildeviceid;
	private int faultSize;
	
	public OilfaultMessage() {
		this.setMessageType(MessageTypeConstants.oildheartin);
	}
	
	@Override
	public void decode(ByteBuf in) throws CommunicationException {
		super.decodeHead(in);
		byte[] oildeviceByte = new byte[4];
		in.readBytes(oildeviceByte);
		oildeviceid = ByteUtil.getLongBy4BytesR(oildeviceByte);
		//解析相关字段
		byte faultSizeByte = in.readByte();
		faultSize = ByteUtil.getUIntByByte(faultSizeByte);
		JSONArray faultarray = new JSONArray();
		for(int i = 0; i<faultSize; i++){
			byte faultTypeByte = in.readByte();
			byte codenoByte = in.readByte();
			JSONObject fault = new JSONObject();
			Integer faultType = ByteUtil.getUIntByByte(faultTypeByte);
			Integer codeno = ByteUtil.getUIntByByte(codenoByte);
			fault.put("faultType", faultType);
			fault.put("codeno", codeno);
			faultarray.add(fault);
		}
		messageContent = faultarray.toJSONString();
	}
	
	
	public String getMessageContent(){
		return messageContent;
	}
	

	public long getOildeviceid() {
		return oildeviceid;
	}

	
}
