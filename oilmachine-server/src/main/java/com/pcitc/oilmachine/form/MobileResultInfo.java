package com.pcitc.oilmachine.form;
/**  
 * 
 * 返回参数值使用
 */
public class MobileResultInfo {


		/**
		 * 0成功  
		 * 1无法处理
		 * 2网络异常，可先测试本地网络情况后在确定错误信息
		 * 默认为1
		 */
		private int code = 1;
		
		private String funName;//方法名  适应三盈app特殊要求
		private String userid;//用户ID   适应三盈app特殊要求
		private String randomcode;
		
		/**
		 * 失败的错误信息
		 */
		private String error;
		
		private int errorcode = -1; 
		
		/**
		 * 成功返回数据
		 */
		private String success;
		
		

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getSuccess() {
			return success;
		}

		public void setSuccess(String success) {
			this.success = success;
		}

		public int getErrorcode() {
			return errorcode;
		}

		public void setErrorcode(int errorcode) {
			this.errorcode = errorcode;
		}

		public String getFunName() {
			return funName;
		}

		public void setFunName(String funName) {
			this.funName = funName;
		}

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getRandomcode() {
			return randomcode;
		}

		public void setRandomcode(String randomcode) {
			this.randomcode = randomcode;
		}
	
}
