package com.pcitc.oilmachine.commons.utils;
public enum ExceptionCode {
	//参数校验错误代码
	PARAMS_IS_NOT_NULL("PARAMS_IS_NOT_NULL","参数不能为空！"),
	SYSSOURCE_IS_NOT_NULL("SYSSOURCE_IS_NOT_NULL","系统来源(syssource)不能为空！"),	
	INTERFACE_NO_POWER("INTERFACE_NO_POWER","不支持调用该接口！"),
	API_INVOKE_ERROR("API_INVOKE_ERROR","Etrade-API接口调用异常!"),
	
	CALLBACK_FAIL("CALLBACK_FAIL", "回调业务系统失败"),
	CALLBACK_ADDRESS_IS_NOT_EMPTY("CALLBACK_ADDRESS_IS_NOT_EMPTY", "回调地址为空"),
	
	//签名及签名校验
	SERVICE_NO_POWER("SERVICE_NO_POWER","无服务调用权限！"),
	SIGN_VERIFY_ERROR("SIGN_VERIFY_ERROR", "签名校验失败"), 
	SIGN_VERIFY_FAIL("SIGN_VERIFY_ERROR", "无效的签名"), 
	SIGN_ERROR("SIGN_ERROR", "签名错误"), 
	//加解密
	CIPHERTEXT_ILLEGAL("CIPHERTEXT_ILLEGAL", "非法的密文"), 
	KEY_INVALID("KEY_INVALID", "无效的秘钥"), 
	DECRYPTION_ERROR("DECRYPTION_ERROR", "解密数据时发生错误"), 
	ENCRYPT_DATA_NULL("ENCRYPT_DATA_NULL","加密数据不能为空！"),
	SYSKEY_NOT_NULL("SYSKEY_NOT_NULL", "通讯密钥获取异常"), 
	PUBLICKEY_NOT_NULL("PUBLICKEY_NOT_NULL","公钥不能为空"),
	PRIVATEKEY_NOT_NULL("PRIVATEKEY_NOT_NULL","私钥不能为空"),
	CREATE_PRIVATE_CERT("CREATE_PRIVATE_CERT","生成私钥证书失败！"),
	CREATE_PUBLIC_CERT("CREATE_PUBLIC_CERT","生成公钥证书失败！"),
	
	//系统异常
	SYSTEM_ERROR("SYSTEM_ERROR","系统异常！"),
	SYSTEM_DB_ERROR("SYSTEM_DB_ERROR","数据库操作异常！"),
	BEAN_TO_MAP_ERROR("BEAN_TO_MAP_ERROR","javabean转换map异常！"),
	SET_DEFAULT_ERROR("SET_DEFAULT_ERROR","设置默认值异常！");

	private final String code;
	private final String msg;
	
	ExceptionCode(String code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}