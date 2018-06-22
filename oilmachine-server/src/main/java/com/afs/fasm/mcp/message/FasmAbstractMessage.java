package com.afs.fasm.mcp.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afs.tupeasy.exception.CommunicationException;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;
import com.pcitc.oilmachine.commons.utils.ByteUtil;

import io.netty.buffer.ByteBuf;


public class FasmAbstractMessage extends AbstractMcpEasyMessage {
	private static Logger log = LoggerFactory.getLogger(FasmAbstractMessage.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int headLength = 2;   //序列号域到命令码域的长度
	//包头和包尾总共20
	public final int tailLength = 1;   //最后一个校验位
	
	private long messageLength;  //长度
	
	private byte checkbit;      //异或校验 1字节
	private boolean checkbitOk = true;
	
	private String heartmsg ;
	
	@Override
	public void validateMessage() throws CommunicationException {
/*		if(this.getEquipId()==null || this.getEquipId().length()==0||this.getEquipId().length()!=11){
			throw new CommunicationException("设备id不能为空");
		}
		if(this.getEquipId().length()!=11){
			throw new CommunicationException("设备id长度为11位");
		}*/
	}

	public void decodeHead(ByteBuf in){
		in.markReaderIndex();//标记当前的readIndex的位置
		int len = in.readableBytes();
		byte[] bbb = new byte[len];
		in.readBytes(bbb);
		in.resetReaderIndex();
		this.heartmsg = ByteUtil.getHexString(bbb);
		//log.info("receive:"+ByteUtil.getHexString(bbb));
		byte[] packageheadbyte = new byte[4];
		in.readBytes(packageheadbyte);
		this.setPackageHead(packageheadbyte);//包头
		this.setMessageType(in.readByte());
		byte[] lengthbyte = new byte[4];
		in.readBytes(lengthbyte);
		this.setMessageLength(ByteUtil.getLongBy4BytesR(lengthbyte));
	}
	
	public void decodeTail(ByteBuf in) throws CommunicationException{
		this.checkbit = in.readByte();
/*		if(in.hasArray()){
			byte[] context = in.array();
			byte checkbit_t = ByteUtil.getCheckBit(context,context.length-1);
			if(this.checkbit == checkbit_t){
				this.setCheckbitOk(true);
			}
		}*/
	}
	
	public void encoderHead(ByteBuf out)throws CommunicationException{
		out.writeBytes(out);

	}
	
	public void encoderTail(ByteBuf out) throws CommunicationException{
		byte checkBit = 0x00;
		
		out.markReaderIndex();
		
		int len1 = out.readableBytes();
		byte[] checkArray = new byte[len1];
		out.readBytes(checkArray);
		for(int i = 5;i<checkArray.length-1;i++){
			checkBit += checkBit;
		}
		
		out.writeByte(this.checkbit);
		out.resetReaderIndex();
		
		out.markReaderIndex();
		int len = out.readableBytes();
		byte[] bbb = new byte[len];
		out.readBytes(bbb);
		out.resetReaderIndex();
		log.info("send:"+ByteUtil.getHexString(bbb));
	}
	
	@Override
	public void printlnMsg() {
		
	}


	public long getMessageLength() {
		return messageLength;
	}

	public void setMessageLength(long messageLength) {
		this.messageLength = messageLength;
	}


	@Override
	public void decode(ByteBuf in) throws CommunicationException {
	}

	@Override
	public void encode(ByteBuf out) throws CommunicationException {
	}



	public int getTailLength() {
		return tailLength;
	}

	@Override
	public boolean isCheckbitOk() throws CommunicationException {
		// TODO Auto-generated method stub
		return checkbitOk;
	}

	public String getHeartmsg() {
		return heartmsg;
	}

	public void setHeartmsg(String heartmsg) {
		this.heartmsg = heartmsg;
	}
}
