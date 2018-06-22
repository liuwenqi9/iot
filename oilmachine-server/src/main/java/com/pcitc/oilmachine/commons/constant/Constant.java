package com.pcitc.oilmachine.commons.constant;


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
	public static final Byte DEFAULT_VALUE_BYTE 			= 0;	
	public static final Integer DEFAULT_VALUE_INTEGER 		= 0;
	public static final Long DEFAULT_VALUE_LONG 			= 0L;
	
	public static final String DEFAULT_SIGN_NAME			= "sysSign";
	public static final String DEFAULT_CHAR_SET				= "UTF-8";
	
	/**************获取session标识************/
	public static final String SESSION_KEY				= "sessionInfo";
	
	/**
	 * 方法名错误
	 */
	public static final String MOBILE_FUN_ERROR = "funerror";
	
	/***调用 elasticsearch接口相关参数  开始*/
	public static final String Index_userlogininfo = "iot_userlogininfo";
	public static final String Type_userlogininfo = "iot_userlogininfo";
	
	public static final String Index_systemlog = "iot_systemlog";
	public static final String Type_systemlog = "iot_systemlog";
	/***调用 elasticsearch接口相关参数  结束*/
	
	/***系统中所有发送mq消息时，每种mq消息均需对应一个code目的是为了发送失败时补发,非重要数据可不设置对应code码  开始*/
	public static final String MQ_SEND_gasFlow = "0001";
	/***调用 elasticsearch接口相关参数  结束*/
	
	/*************获取菜单所需来源标识menuStore***********/
	public static final String Menu_Store = "iot";
	/*************moduleName - 业务模块名称(上传oss)***********/
	public static final String OSS_moduleName = "iot";
	
	public static final String USER_SESSION_TIMEOUT							= "USER_SESSION_TIMEOUT";			//用户认证通过后 X 分钟超时
	public static final int USER_SESSION_TIMEOUT_DE							= 5;			//用户认证通过后 X 分钟超时
	public static final String CAR_STOP_TIMEOUT							= "CAR_STOP_TIMEOUT";			//车辆停在加油机位 X 分钟油机附近的该车牌信息被移除
	public static final int CAR_STOP_TIMEOUT_DE							= 8;
	public static final String CAR_MOVE_HEART_TIMEOUT							= "CAR_MOVE_HEART_TIMEOUT";			//车辆运动轨迹无更新 X 分钟后车牌信息自动移除
	public static final int CAR_MOVE_HEART_TIMEOUT_DE							= 5;	
	public static final String USER_GASCODE_TIMEOUT							= "USER_GASCODE_TIMEOUT";			//加油码使用有效期
	public static final int USER_GASCODE_TIMEOUT_DE						= 300;
	public static final String IOT_SIGNID_TIMEOUT 								= "IOT_SIGNID_TIMEOUT";			//
	public static final int IOT_SIGNID_TIMEOUT_DE 								= 1;			//
	
	public static final int ERROR_LOG_OIL							= 0;			//异常数据类型:油机上传数据
	public static final int ERROR_LOG_CAMERA						= 1;			//异常数据类型:摄像头上传数据
	public static final int ERROR_LOG_OILINTERFACE					= 2;			//异常数据类型:与油机app接口异常数据
	
	public static final String CAMERA_CODE					= "002";			//摄像头
	public static final String OILMACH_CODE					= "001";			//加油机
	public static final String SIGNIN_SECURITY_CODE				= "sMc2IdYJ30jEtVXiTjqGRw==";			//油机签到解密密钥
	public static final String SIGNIN_METHOD_NAME				= "signIn";			//油机签到接口名
	
	public static final String CREATE_ORDER				= "33";			//下单
	public static final String preAuth_SQ				= "30";			//预授权申请
	public static final String preAuth_QX				= "31";			//预授权取消
	public static final String preAuth_WC				= "32";			//预授权完成
	
	//***************电子钱包相关配置
	public static final String publicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgMVBqC+EYBI8b0ja tlhu3JeP1sw0QV0DKMijrLYbzIK7EpdrG/iXLRTLtTa+n/hdu4/KVf3Funm8 h2LZcqABruoZtvjlN63X8wboOseghakcSWwhuzyU/Iyvxhp4m2ySXgyqrkya CiqSYPKWcga1JlsUbDoNuKWi7RQ8SsOKKv6avmp/MENvzg+/ozp+3ujkTrK2 coL96SQkjZgJWqui0ZxB86z+KN1otu71AJ3GC5uqRUB1/pwj0tiimDmesd+r KrXlDsPGfAOGk172JWwaJTWQds5wqt5hIk3gEbuQsrkQUy/V8sIq5F3pRVSA 8dxYYSyw6FM46DeS13Zmyipp0wIDAQAB";
	public static final String ZFCJ_PUBLIC = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9MSORrYs3JDOW4N vNhw6TmKQv62Wkme7BeglUyNrukeOuWStSvrvWKKWHFYF3uKsBHC0It5k9wX b2pocVFpu6BYp2cqKSG6xrHOWIZIUsGcEM1rEqQ4KIQdvS0xyfrafnxG3a1h dDGJIhDYQEbqWTcuQLhWqEj7PugLVIsuvE8/SbXFXGwN59SiLoDYtXYzKhX3 T+R6ftNmdq7EpprP9oMsLUVZFJnJ3wJ+FND5OvBVSilvqkDU4+KlQCwvfYob A8XrlkpSzDa/ERLVMtUPk3RBUwYgKqRQbPaUledW0CFYlHlNb2cCq/0UCYpy /GVg5bqfJih8mYDjhZT/adzxbQIDAQAB";
	public static final String sysSource = "SYS_00096";
	public static final String ver = "V1";
	//public static final String EAPI_URL = "http://dev.eifs.ejoy.sinopec.com/api";
	public static final String EAPI_URL = "http://10.248.245.237:8080/api";
	//public static final String EAPI_URL = "http://10.177.9.157:9081/eifs/api";
	public static final String QC_FUNCTION = "/user/getAccountList";
	public static final String QU_FUNCTION = "/user/getCsrInfo";
	public static final String CP_FUNCTION = "/payment/creatPayOrder";
	public static final String SQ_FUNCTION = "/preAuthorization/preAuthorization";
	public static final String FS_FUNCTION = "/user/sendMobileCode";
	public static final String mchCode = "1523961772";
	public static final String appid = "19b65d2b8c8d403b8d941ad53e98861e";
	
	public static final String FACE_SIMILAR = "face_similarity";
	public static final String selfhelp = "03";//电子钱包 01-APP；02-非自助油机；03-自助油机
	public static final String smsCodeType = "2";//验证码类型 0:验证码 1:密码 2:加油码
	
	//日志类型
	public static final Integer logtype_general = 0;//0普通日志,1错误日志,2告警日志
	public static final Integer logtype_error = 1;
	public static final Integer logtype_warn = 2;
	public static final Integer logmodule_camera = 0;//0摄像头采集数据日志  1:用户认证日志  2:加油机采集数据日志..
	public static final Integer logmodule_userlog = 1;
	public static final Integer logmodule_oilm = 2;
	
	
	
}
