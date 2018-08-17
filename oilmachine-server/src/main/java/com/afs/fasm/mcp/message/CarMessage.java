package com.afs.fasm.mcp.message;

import com.afs.base.constants.MessageTypeConstants;
import com.afs.tupeasy.exception.CommunicationException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.utils.ByteUtil;
import com.pcitc.oilmachine.enums.VehicleEnum;

import io.netty.buffer.ByteBuf;

/**
 * 车辆信息上传报文
 * @author zhang
 *
 */
public class CarMessage extends FasmAbstractMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageContent;
	private long timestamp;
	private long cameraid;
	private long carsize;
	
	public CarMessage() {
		this.setMessageType(MessageTypeConstants.carMessageIn);
	}
	
	@Override
	public void decode(ByteBuf in) throws CommunicationException {
		super.decodeHead(in);
		byte[] timestamp0 = new byte[4];
		byte[] timestamp1 = new byte[4];
		in.readBytes(timestamp0);
		in.readBytes(timestamp1);
		long a = ByteUtil.getLongBy4BytesR(timestamp0);
		long b = ByteUtil.getLongBy4BytesR(timestamp1);
		timestamp = a*1000 + b;
		byte[] cameraidbyte = new byte[4];
		in.readBytes(cameraidbyte);
		cameraid = ByteUtil.getLongBy4BytesR(cameraidbyte);
		byte[] carsizebyte = new byte[4];
		in.readBytes(carsizebyte);
		carsize = ByteUtil.getLongBy4BytesR(carsizebyte);
		JSONArray cararray = new JSONArray();
		for(long i = 0; i< carsize; i++){
			JSONObject json = new JSONObject();
			byte[] caridbyte = new byte[4];
			in.readBytes(caridbyte);
			//long carid = ByteUtil.getLongBy4BytesR(caridbyte);
			byte[] carnumbyte = new byte[16];
			in.readBytes(carnumbyte);
			String carnum = ByteUtil.getString(carnumbyte, "GB2312");
			carnum = carnum.trim().toUpperCase();
			byte carcolorbyte = in.readByte();
			int carcolor = ByteUtil.getUIntByByte(carcolorbyte);
			byte cartypebyte = in.readByte();
			int cartype = ByteUtil.getUIntByByte(cartypebyte);
			byte[] leftbyte = new byte[4];
			in.readBytes(leftbyte);
			long left = ByteUtil.getLongBy4BytesR(leftbyte);
			byte[] topbyte = new byte[4];
			in.readBytes(topbyte);
			long top = ByteUtil.getLongBy4BytesR(topbyte);
			byte[] rightbyte = new byte[4];
			in.readBytes(rightbyte);
			long right = ByteUtil.getLongBy4BytesR(rightbyte);
			byte[] bottombyte = new byte[4];
			in.readBytes(bottombyte);
			long bottom = ByteUtil.getLongBy4BytesR(bottombyte);
			byte carstatusbyte = in.readByte();
			int carstatus = ByteUtil.getUIntByByte(carstatusbyte);
			json.put(VehicleEnum.CARNUM.toString(), carnum);
			json.put(VehicleEnum.CARCOLOR.toString(), carcolor);
			json.put(VehicleEnum.CARTYPE.toString(), cartype);
			json.put(VehicleEnum.LEFT.toString(), left);
			json.put(VehicleEnum.TOP.toString(), top);
			json.put(VehicleEnum.RIGHT.toString(), right);
			json.put(VehicleEnum.BOTTOM.toString(), bottom);
			json.put(VehicleEnum.CARSTATUS.toString(), carstatus);
			json.put(VehicleEnum.CAMERAID.toString(), cameraid);
			cararray.add(json);
		}
		//in.resetReaderIndex();
		messageContent = cararray.toJSONString();
		//System.out.println("解析后的数据:"+messageContent);
	}
	
	public String getMessageContent(){
		return messageContent;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public long getCameraid() {
		return cameraid;
	}

	public long getCarsize() {
		return carsize;
	}
	
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public void setCameraid(long cameraid) {
		this.cameraid = cameraid;
	}

	public void setCarsize(long carsize) {
		this.carsize = carsize;
	}
	
}
