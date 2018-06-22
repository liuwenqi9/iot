package com.afs.fasm.mcp.decoder;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.afs.base.util.MySpringContextUtil;
import com.afs.tupeasy.message.Message;
import com.afs.tupeasy.message.MessageFactory;
import com.pcitc.oilmachine.commons.utils.ByteUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class FasmServerMessageDecoder  extends LengthFieldBasedFrameDecoder{
	//private static Logger log = LoggerFactory.getLogger(FasmServerMessageDecoder.class);
	private static final int HEADER_SIZE = 9;  
	
	public FasmServerMessageDecoder() {
		this(102400,5,4,0,0);
	}
	
	public FasmServerMessageDecoder(int maxFrameLength, int lengthFieldOffset,
			int lengthFieldLength) {
		super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
	}
	
	/** 
     *  
     * @param maxFrameLength 解码时，处理每个帧数据的最大长度 
     * @param lengthFieldOffset 该帧数据中，存放该帧数据的长度的数据的起始位置 
     * @param lengthFieldLength 记录该帧数据长度的字段本身的长度 
     * @param lengthAdjustment 修改帧数据长度字段中定义的值，可以为负数 
     * @param initialBytesToStrip 解析的时候需要跳过的字节数 
     * @param failFast 为true，当frame长度超过maxFrameLength时立即报TooLongFrameException异常，为false，读取完整个帧再报异常 
     */ 
	public FasmServerMessageDecoder(
            int maxFrameLength,
            int lengthFieldOffset, int lengthFieldLength,
            int lengthAdjustment, int initialBytesToStrip){
		super(maxFrameLength,lengthFieldOffset,  lengthFieldLength,lengthAdjustment,  initialBytesToStrip,true);
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in)
			throws Exception {
		byte messageType = 0;
		try{
			if(in == null || in.readableBytes() < HEADER_SIZE){
				return null; 
			}
			ByteBuf frame = (ByteBuf)super.decode(ctx, in);
			if(frame==null){
				return null;
			}
			frame.markReaderIndex();
			byte[] packageheadbyte = new byte[4];
			frame.readBytes(packageheadbyte);
			String packagehead = ByteUtil.getHexString(packageheadbyte);
			messageType = frame.readByte();
			frame.resetReaderIndex();
			
			
			MessageFactory messageFactory = (MessageFactory) MySpringContextUtil.getBean("messageFactory");
			Message message = messageFactory.newMessage(packagehead,messageType);
			message.decode(frame);
			return message;
		}catch(Exception t){
			t.printStackTrace();
			throw t;
		}
	}
}
