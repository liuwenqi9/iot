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
public class OilNozzleStatusMessage extends FasmAbstractMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageContent;
	private long oildeviceid;
	private int nozzlesize;
	
	@Override
	public void decode(ByteBuf in) throws CommunicationException {
		super.decodeHead(in);
		byte[] oildeviceByte = new byte[4];
		in.readBytes(oildeviceByte);
		oildeviceid = ByteUtil.getLongBy4BytesR(oildeviceByte);
		byte nozzlesizeByte = in.readByte();
		nozzlesize = ByteUtil.getUIntByByte(nozzlesizeByte);
		JSONArray nozzlearray = new JSONArray();
		for(int i = 0; i<nozzlesize; i++){
			byte nozzlenoByte = in.readByte();
			byte nozzlestatusByte = in.readByte();
			byte[] vtotByte = new byte[4];
			in.readBytes(vtotByte);
			JSONObject nozzle = new JSONObject();
			Integer nozzleno = ByteUtil.getUIntByByte(nozzlenoByte);
			Integer nozzlestatus = ByteUtil.getUIntByByte(nozzlestatusByte);
			Long vtot = ByteUtil.getLongBy4BytesR(vtotByte);
			nozzle.put("nozzleno", nozzleno);
			nozzle.put("nozzlestatus", nozzlestatus);
			nozzle.put("vtot", vtot);
			nozzlearray.add(nozzle);
		}
		messageContent = nozzlearray.toJSONString();
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
	
	public int getNozzlesize() {
		return nozzlesize;
	}
}
