package com.pcitc.oilmachine.commons.exception;
public enum ExceptionCode {
	//参数校验错误代码
	PARAMS_IS_NOT_NULL("PARAMS_IS_NOT_NULL","参数不能为空！"),
	SYSSOURCE_IS_NOT_NULL("SYSSOURCE_IS_NOT_NULL","系统来源(syssource)不能为空！"),
	ACCOUNTID_NUM_NOT_NULL("ACCOUNTID_NUM_NOT_NULL","获取账户ID数量(num)不能为空！"),
	INTERFACE_NO_POWER("INTERFACE_NO_POWER","不支持调用该接口！"),
	ACCOUNT_IS_NOT_NULL("ACCOUNT_IS_NOT_NULL","帐号(accountid)不能为空！"),
	USERID_IS_NOT_NULL("USERID_IS_NOT_NULL","用户ID(userid)不能为空！"),
	ACCOUNT_TYPE_NOT_NULL("ACCOUNT_TYPE_NOT_NULL","账户类型(accounttype)不能为空！"),
	VERSION_NOT_NULL("VERSION_NOT_NULL","版本号(version)不能为空!"),
	CUSTOM_DATA_ERROR("CUSTOM_DATA_ERROR","自定义数据包(customdata)格式不正确！"),
	ORDERNO_NOT_NULL("ORDERNO_NOT_NULL","交易单号(orderno)不能为空！"),
	ORDERNO_REPEAT("ORDERNO_REPEAT","交易单号(orderno)重复!"),
	ORIGORDERNO_NOT_NULL("ORIGORDERNO_NOT_NULL","原交易单号(origorderno)不能为空！"),
	LIST_NOT_NULL("LIST_NOT_NULL","批量开户账户信息(list)不能为空！"),
	LIST_FORMAT_ERROR("LIST_FORMAT_ERROR","批量开户账户信息(list)格式错误！"),
	//签名、加密错误代码
	SERVICE_NO_POWER("SERVICE_NO_POWER","无服务调用权限！"),
	SYSSIGN_NOT_NULL("SYSSIGN_NOT_NULL","通讯签名(sysSign)不能为空！"),
	SYSKEY_NOT_NULL("SYSKEY_NOT_NULL","通讯密钥获取异常！"),
	SYSSIGN_UNLAWFUL("SYSSIGN_UNLAWFUL","通讯签名错误，数据不合法不！"),
	ENCRYPT_AES_KEY_ERROR("ENCRYPT_AES_KEY_ERROR","加密AES密钥错误！"),
	ENCRYPT_AES_KEY_NULL("ENCRYPT_AES_KEY_NULL","加密AES密钥不能为空！"),
	ENCRYPT_RETURN_DATA_ERROR("ENCRYPT_RETURN_DATA_ERROR","加密返回明文信息错误！"),
	SIGN_STR_ERROR("SIGN_STR_ERROR","生成待签名字符串错误！"),
	SIGN_ERROR("SIGN_ERROR","签名错误！"),
	DECRYPT_AES_KEY_ERROR("DECRYPT_AES_KEY_ERROR","解密AES密钥错误！"),
	PUBLICKEY_NOT_NULL("SYSSIGN_UNLAWFUL","公钥不能为空！"),
	ENCRYPT_DATA_NULL("ENCRYPT_DATA_NULL","加密数据不能为空！"),
	DECRYPT_DATA_ERROR("DECRYPT_DATA_ERROR","解密加密数据错误！"),
	SIGN_FAIL("SIGN_FAIL","验证签名失败，数据来源不合法！"),
	CREATE_PRIVATE_CERT("CREATE_PRIVATE_CERT","生成私钥证书失败！"),
	CREATE_PUBLIC_CERT("CREATE_PUBLIC_CERT","生成公钥证书失败！"),
	//系统异常
	SYSTEM_ERROR("SYSTEM_ERROR","系统异常！"),
	SYSTEM_DB_ERROR("SYSTEM_DB_ERROR","数据库操作异常！"),
	BEAN_TO_MAP_ERROR("BEAN_TO_MAP_ERROR","javabean转换map异常！"),
	//业务异常
	QUERY_ACCOUNT_IS_NULL("QUERY_ACCOUNT_IS_NULL","查询账户不存在！"),
	QUERY_ACCOUNTFLOW_IS_NULL("QUERY_ACCOUNTFLOW_IS_NULL","没有要查询的账务流水！"),
	QUERY_ORIGFLOW_IS_NULL("QUERY_ORIGFLOW_IS_NULL","没有原流水信息！"),
	ORIGFLOW_NO_REFUND("ORIGFLOW_NO_REFUND","原流水业务类型不支持退款"),
	NOT_ENOUGH_REFUND("NOT_ENOUGH_REFUND","退还积分超过总支付积分"),
	BATCH_QUANTITY_ERROR("BATCH_QUANTITY_ERROR","批量开户数量超过上限！"),
	NOT_ENOUGH_SCORE("NOT_ENOUGH_SCORE","积分不足！"),
	USER_NOT_EXIST("USER_NOT_EXIST","用户不存在"),
	USER_PASSWORD_ERROR("USER_PASSWORD_ERROR","用户名或密码不正确"),
	USER_FREEZE("USER_FREEZE","用户已被停用");
		
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