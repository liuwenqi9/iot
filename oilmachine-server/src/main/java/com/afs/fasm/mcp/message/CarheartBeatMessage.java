package com.afs.fasm.mcp.message;

import com.afs.base.constants.MessageTypeConstants;
import com.afs.tupeasy.exception.CommunicationException;
import io.netty.buffer.ByteBuf;

/**
 * 车辆信息上传报文
 * @author zhang
 *
 */
public class CarheartBeatMessage extends FasmAbstractMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long cameraid;
	
	public CarheartBeatMessage() {
		this.setMessageType(MessageTypeConstants.carheartIn);
	}
	
	@Override
	public void decode(ByteBuf in) throws CommunicationException {
		super.decodeHead(in);
	}
	
	@Override
	public void encode(ByteBuf out) throws CommunicationException {
		if(super.getPackageHead() != null){
			out.writeBytes(super.getPackageHead());
		}else{
			out.writeByte((byte)0xFA);
			out.writeByte((byte)0xF0);
			out.writeByte((byte)0x55);
			out.writeByte((byte)0xAA);
		}
		out.writeByte((byte)0x02);
		out.writeByte((byte)0x00);
		out.writeByte((byte)0x00);
		out.writeByte((byte)0x00);
		out.writeByte((byte)0x00);
	}
	
	public long getCameraid() {
		return cameraid;
	}
}
