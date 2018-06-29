package com.afs.fasm.mcp.message;

import com.afs.base.constants.MessageTypeConstants;
import com.afs.tupeasy.exception.CommunicationException;
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
	}
	
	
	public String getMessageContent(){
		return messageContent;
	}
	

	public long getOildeviceid() {
		return oildeviceid;
	}

	
}
