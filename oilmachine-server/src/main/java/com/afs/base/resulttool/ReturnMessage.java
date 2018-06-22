package com.afs.base.resulttool;

/**
 * @author  zhang
 */
public class ReturnMessage {
	
	public final static int SUCCES=1;
	public final static int FAILURE=0;
	
	//执行结果的状态代码
	/**
	 * @uml.property  name="status"
	 */
	private int status;
	
	//提示给用户的消息
	/**
	 * @uml.property  name="msg"
	 */
	private String msg;
	
	//返回的数据
	/**
	 * @uml.property  name="data"
	 */
	private Object data ;
	
	private Object data2 ;
	private Object data3 ;
	private Object data4 ;
	private int pageTotal;

	public int getPageTotal() {
		return pageTotal;
	}


	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * @return
	 * @uml.property  name="msg"
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 * @uml.property  name="msg"
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return
	 * @uml.property  name="data"
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 * @uml.property  name="data"
	 */
	public void setData(Object data) {
		this.data = data;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Object getData2() {
		return data2;
	}


	public void setData2(Object data2) {
		this.data2 = data2;
	}


	public Object getData3() {
		return data3;
	}


	public void setData3(Object data3) {
		this.data3 = data3;
	}


	public Object getData4() {
		return data4;
	}


	public void setData4(Object data4) {
		this.data4 = data4;
	}

}
