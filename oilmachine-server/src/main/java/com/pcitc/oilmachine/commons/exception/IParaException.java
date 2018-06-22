/**
 * 
 */
package com.pcitc.oilmachine.commons.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**由参数定义的Exception
 * @author 刘潇
 * 2011-7-12
 */
public interface IParaException {
	
	public int getCode();
	
	/**
	 * 占位符值列表
	 * @return 占位符值列表
	 */
	public Object[] getPlaceHolderValues();
	
	public String getMessage();
	public Throwable getCause();
	public void printStackTrace();
	public void printStackTrace(PrintStream s);
	public void printStackTrace(PrintWriter s);

}
