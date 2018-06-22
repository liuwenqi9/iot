package com.afs.tupeasy.base;

/**
 * 业务继承这个类，返回数据处理handler
 * @author zhang
 *
 */
public interface DataHandlerFactory {
	public DataHandlerBase getDataHandler(String packageHead,byte messageType);
}
