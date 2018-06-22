package com.afs.fasm.mcp.message;

import com.afs.base.constants.MessageTypeConstants;
import com.afs.tupeasy.message.MessageFactory;

public class MessageFactoryImpl implements MessageFactory {

	@Override
	public FasmAbstractMessage newMessage(String packageHead,byte messageType) {
		FasmAbstractMessage m = null;
		packageHead = packageHead.replace(" ", "").toUpperCase();
		if(MessageTypeConstants.camerapackagehead.equals(packageHead)){
			switch(messageType){
			case MessageTypeConstants.carMessageIn:
				m = new CarMessage();
				break;
			case MessageTypeConstants.carheartIn:
				m = new CarheartBeatMessage();
				break;
			}
	}else if(MessageTypeConstants.oildevicepackagehead.equals(packageHead)){
		switch(messageType){
		case MessageTypeConstants.oildcarmsg:
			m = new OildeviceCarMessage();
			break;
		case MessageTypeConstants.oildheartin:
			m = new OildeviceheartBeatMessage();
			break;
		}
	}
		return m;
	}
	

}
