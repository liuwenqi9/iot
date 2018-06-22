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
public class OildeviceheartBeatMessage extends FasmAbstractMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageContent;
	private long oildeviceid;
	
	public OildeviceheartBeatMessage() {
		this.setMessageType(MessageTypeConstants.oildheartin);
	}
	
	@Override
	public void decode(ByteBuf in) throws CommunicationException {
		super.decodeHead(in);
		byte[] oildeviceByte = new byte[4];
		in.readBytes(oildeviceByte);
		oildeviceid = ByteUtil.getLongBy4BytesR(oildeviceByte);
	}
	
	@Override
	public void encode(ByteBuf out) throws CommunicationException {
		/*if(super.getPackageHead() != null){
			out.writeBytes(super.getPackageHead());
		}else{
			out.writeByte((byte)0xFA);
			out.writeByte((byte)0xF0);
			out.writeByte((byte)0x55);
			out.writeByte((byte)0xAB);
		}
		out.writeByte((byte)0x01);
		out.writeByte((byte)0x00);
		out.writeByte((byte)0x00);
		out.writeByte((byte)0x00);
		out.writeByte((byte)0x04);
		byte[] args = ByteUtil.hexStr2ByteArray(Long.toHexString(oildeviceid));
		out.writeBytes(args);*/
	}
	
	public String getMessageContent(){
		return messageContent;
	}
	

	public long getOildeviceid() {
		return oildeviceid;
	}

	
}
