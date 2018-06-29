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
public class OilNozzleStatusMessage extends FasmAbstractMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageContent;
	private long oildeviceid;
	private int nozzleno;
	private int nozzlestatus;
	private long vtot;
	
	@Override
	public void decode(ByteBuf in) throws CommunicationException {
		super.decodeHead(in);
		byte[] oildeviceByte = new byte[4];
		in.readBytes(oildeviceByte);
		oildeviceid = ByteUtil.getLongBy4BytesR(oildeviceByte);
		byte nozzlenoByte = in.readByte();
		byte nozzlestatusByte = in.readByte();
		byte[] vtotByte = new byte[4];
		in.readBytes(vtotByte);
		nozzleno = ByteUtil.getUIntByByte(nozzlenoByte);
		nozzlestatus = ByteUtil.getUIntByByte(nozzlestatusByte);
		vtot = ByteUtil.getLongBy4BytesR(vtotByte);
	}
	
	
	
	public OilNozzleStatusMessage() {
		this.setMessageType(MessageTypeConstants.oildheartin);
	}
	
	public String getMessageContent(){
		return messageContent;
	}
	

	public long getOildeviceid() {
		return oildeviceid;
	}
	
	public int getNozzleno() {
		return nozzleno;
	}

	public int getNozzlestatus() {
		return nozzlestatus;
	}

	public long getVtot() {
		return vtot;
	}

	
}
