package com.afs.fasm.mcp.datahandler;

import com.afs.base.constants.MessageTypeConstants;
import com.afs.tupeasy.base.DataHandlerBase;
import com.afs.tupeasy.base.DataHandlerFactory;


public class BusiMessageHandlerFactoryImpl implements DataHandlerFactory {

	@Override
	public DataHandlerBase getDataHandler(String packageHead,byte messageType) {
		DataHandlerBase m = null;
		packageHead = packageHead.replace(" ", "").toUpperCase();
		if(MessageTypeConstants.camerapackagehead.equals(packageHead)){
				switch(messageType){
				case MessageTypeConstants.carMessageIn:
					m = new CarMessageHandler();
					break;
				case MessageTypeConstants.carheartIn:
					m = new CarHertBeatHandler();
					break;
				default:
					m = new CommonMessageHandler();
				}
		}else if(MessageTypeConstants.oildevicepackagehead.equals(packageHead)){
				switch(messageType){
				case MessageTypeConstants.oildcarmsg:
					m = new OildeviceMessageHandler();
					break;
				case MessageTypeConstants.oildheartin:
					m = new OildeviceHertBeatHandler();
					break;
				case MessageTypeConstants.oilNozzleStatus:
					m = new OilNozzleStatusHandler();
					break;
				case MessageTypeConstants.oilfaultMsg:
					m = new OilfaultMsgHandler();
					break;
				default:
					m = new CommonMessageHandler();
				}
		}
		return m;
	}


}
