package com.afs.fasm.mcp.message;

import java.util.List;

import com.afs.base.constants.MessageTypeConstants;
import com.afs.tupeasy.exception.CommunicationException;
import com.pcitc.oilmachine.commons.utils.ByteUtil;
import com.pcitc.oilmachine.commons.utils.DateUtils;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.form.Vehicle;

import io.netty.buffer.ByteBuf;

/**
 * 车辆信息上传报文
 * @author zhang
 *
 */
public class OildeviceCarMessage extends FasmAbstractMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long oildeviceid;
	private List<Vehicle> vehicles;
	
	public OildeviceCarMessage() {
		this.setMessageType(MessageTypeConstants.oildcarmsg);
	}
	
	@Override
	public void decode(ByteBuf in) throws CommunicationException {
	}
	
	@Override
	public void encode(ByteBuf out) throws CommunicationException {
		if(super.getPackageHead() != null){
			out.writeBytes(super.getPackageHead());
		}else{
			out.writeByte((byte)0xFA);
			out.writeByte((byte)0xF0);
			out.writeByte((byte)0x55);
			out.writeByte((byte)0xAB);
		}
		out.writeByte(MessageTypeConstants.oildcarmsg);
		
		List<Vehicle> vehiclesTemp  = getVehicles();
		if(vehiclesTemp == null || vehiclesTemp.size() <= 0){
			int carblength = 12;
			out.writeBytes(ByteUtil.long2byte(carblength,4));//长度
			String datestr = DateUtils.formatName();
			long timestamp = Long.parseLong(datestr.substring(4,datestr.length()));
			out.writeBytes(ByteUtil.long2byte(timestamp,4));//时间戳
			out.writeBytes(ByteUtil.long2byte(getOildeviceid(),4));//设备ID
			out.writeBytes(ByteUtil.long2byte(0,4));//车辆数量
		}else{
			int carnumSize = vehiclesTemp.size();//车牌数量
			int carblength = 12+carnumSize*23;
			out.writeBytes(ByteUtil.long2byte(carblength,4));//长度
			
			String datestr = DateUtils.formatName();
			long timestamp = Long.parseLong(datestr.substring(4,datestr.length()));
			out.writeBytes(ByteUtil.long2byte(timestamp,4));//时间戳
			
			out.writeBytes(ByteUtil.long2byte(getOildeviceid(),4));//设备ID
			
			out.writeBytes(ByteUtil.long2byte(carnumSize,4));//车辆数量
			for(Vehicle vehicle : vehiclesTemp){
				//写入车牌
				String carnum = vehicle.getCarnum();
				byte[] carbyte = ByteUtil.str2Byte(carnum, "GB2312");
				int carbytelength = 16;
				if(carbyte.length < carbytelength ){
					out.writeBytes(carbyte);
					for(int i = 0;i<(carbytelength - carbyte.length);i++ ){
						out.writeByte((byte)0x00);
					}
				}else if(carbyte.length == carbytelength){
					out.writeBytes(carbyte);
				}
				String pwtype = vehicle.getPwtype();
				if(StringUtils.isBlank(pwtype)){
					pwtype = "01000110";
				}
				int pt = Integer.valueOf(pwtype,2);
				out.writeBytes(ByteUtil.long2byte(pt,1));//写入密码认证类型
				
				String needPassword = vehicle.getNeedpassword();
				if(StringUtils.isBlank(needPassword)){
					needPassword = "0";
				}
				int np = Integer.parseInt(needPassword);
				out.writeBytes(ByteUtil.long2byte(np,1));//是否需要密码
				
				String screencode = vehicle.getAreacode();
				if(StringUtils.isBlank(screencode)){
					screencode = "1111";
				}
				int sc = Integer.valueOf(screencode,2);
				out.writeBytes(ByteUtil.long2byte(sc,1));//屏幕号
				//油品型号
				String oiltypecode = vehicle.getOiltypecode();
				if(StringUtils.isBlank(oiltypecode)){
					oiltypecode = "92";
				}
				int oc = Integer.parseInt(oiltypecode);
				out.writeBytes(ByteUtil.long2byte(oc,4));
			}
		}
		
	}

	public long getOildeviceid() {
		return oildeviceid;
	}

	public void setOildeviceid(long oildeviceid) {
		this.oildeviceid = oildeviceid;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
