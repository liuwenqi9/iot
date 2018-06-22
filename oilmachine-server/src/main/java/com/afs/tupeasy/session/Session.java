package com.afs.tupeasy.session;

import io.netty.channel.Channel;
import java.io.Serializable;
import java.util.Date;

public class Session
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String clientId;
  private String serverNamme;
  private String passwd;
  private int heartBeatInterval = 0;
  private Date loginTime;
  private transient Channel channel;
  private String deviceTypeCode;//设备类型编码
  private int receivedata = 0;//是否接收数据 0 是 1 否

  public void printlnSession()
  {
    System.out.println("clientId:" + this.clientId + ",passwd:" + this.passwd + ",heartBeatInterval:" + this.heartBeatInterval + ",ServerName:" + this.serverNamme);
  }

  public String getPasswd() {
    return this.passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public int getHeartBeatInterval() {
    return this.heartBeatInterval;
  }

  public void setHeartBeatInterval(int heartBeatInterval) {
    this.heartBeatInterval = heartBeatInterval;
  }

  public Channel getChannel() {
    return this.channel;
  }

  public void setChannel(Channel channel) {
    this.channel = channel;
  }

  public Date getLoginTime() {
    return this.loginTime;
  }

  public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
  }
  public String getServerNamme() {
    return this.serverNamme;
  }

  public void setServerNamme(String serverNamme) {
    this.serverNamme = serverNamme;
  }

  public String getClientId() {
    return this.clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

public int getReceivedata() {
	return receivedata;
}

public void setReceivedata(int receivedata) {
	this.receivedata = receivedata;
}

public String getDeviceTypeCode() {
	return deviceTypeCode;
}

public void setDeviceTypeCode(String deviceTypeCode) {
	this.deviceTypeCode = deviceTypeCode;
}

}