package com.pcitc.oilmachine.commons.utils;


public class Constant {
	
	/*************返回状态***********/
	public static final int SUCCESSED 						= 1;			//成功
	public static final int FAILED							= 0;			//失败
	
	public static final String SUCCESS						= "SUCCESS";
	public static final String SUCCESS_MSG					= "成功";
	public static final String FAIL							= "FAIL";
	
	public static final String RESULT_CODE					= "0000";
	public static final String RESULT_MSG					= "OK";
	
	/**************默认值************/
	public static final Integer DEFAULT_VALUE_ZERO_INTEGER	= 0;
	public static final Integer DEFAULT_VALUE_ONE_INTEGER	= 1;
	
	
	public static final Long DEFAULT_VALUE_LONG 			= 0L;
	public static final Byte DEFAULT_VALUE_ZERO_BYTE 		= 0;
	public static final Byte DEFAULT_VALUE_ONE_BYTE			= 1;
	
	public static final String DEFAULT_SIGN_NAME			= "sysSign";
	public static final String DEFAULT_CHAR_SET				= "UTF-8";
	
	public static final String ADMIN						= "admin";
	
	public static final Integer YES 							= 1;
	public static final Integer NO 								= 0;
	
	//交易类型
	public static final String TRADETYPE_CHG             = "10";  //充值
	public static final String TRADETYPE_CHGREFUND       = "12";  //充值退款
	public static final String TRADETYPE_PAY             = "20";  //支付
	public static final String TRADETYPE_PAYREFUND       = "22";  //支付退款
	//交易状态
	public static final String TRADEFLAG_SUCCESS         = "00";  //成功
	public static final String TRADEFLAG_WAITPROCESS     = "01";  //待处理
	public static final String TRADEFLAG_PROCESSING      = "02";  //处理中
	public static final String TRADEFLAG_CLOSED          = "03";  //已预授权完成
	public static final String TRADEFLAG_PREAUTHFINISHED = "05";  //已预授权完成
	public static final String TRADEFLAG_PREAUTHCANCEL   = "06";  //已预授权取消
	public static final String TRADEFLAG_REFUND          = "07";  //已退款
	public static final String TRADEFLAG_FAIL            = "11";  //失败
	//账户标识
	public static final String ACCMARK_BASICBALANCE      = "1";   //基本账户
	public static final String ACCMARK_FROZENBALANCE     = "2";   //基本账户冻结账户
	public static final String ACCMARK_PREFBALANCE       = "3";   //赠送账户
	public static final String ACCMARK_FROZENPREFBALANCE = "4";   //赠送账户冻结账户
	//动账类型
	public static final String DYNAMICTYPE_IN            = "1";   //转入
	public static final String DYNAMICTYPE_OUT           = "2";   //转出


	
}
