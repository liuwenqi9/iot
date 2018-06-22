package com.afs.base.resulttool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  zhang
 */
public class DataGridList {
	
	public DataGridList(){
		this.status = "0";
	}
	
	/**
	 * @uml.property  name="total"
	 */
	private int total;
	/**
	 * @uml.property  name="rows"
	 */
	private List rows = new ArrayList();
	

	/**
	 * 0失败，1成功
	 */
	private String status;
	
	private Object otherObject1;
	private Object otherObject2;
	private Object otherObject3;
	
	
	//提示给用户的消息
	/**
	 * @uml.property  name="msg"
	 */
	private String msg;
	
	/**
	 * @return
	 * @uml.property  name="total"
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total
	 * @uml.property  name="total"
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return
	 * @uml.property  name="rows"
	 */
	public List getRows() {
		return rows;
	}
	/**
	 * @param rows
	 * @uml.property  name="rows"
	 */
	public void setRows(List rows) {
		if(rows!=null){
			this.rows = rows;
		}
	}
	/**
	 * @return
	 * @uml.property  name="status"
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status
	 * @uml.property  name="status"
	 */
	public void setStatus(String status) {
		this.status = status;
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

	public Object getOtherObject1() {
		return otherObject1;
	}
	public void setOtherObject1(Object otherObject1) {
		this.otherObject1 = otherObject1;
	}
	public Object getOtherObject2() {
		return otherObject2;
	}
	public void setOtherObject2(Object otherObject2) {
		this.otherObject2 = otherObject2;
	}
	public Object getOtherObject3() {
		return otherObject3;
	}
	public void setOtherObject3(Object otherObject3) {
		this.otherObject3 = otherObject3;
	}
	
}
