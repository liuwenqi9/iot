package com.pcitc.oilmachine.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.caucho.hessian.server.HessianServlet;

/**
 * 本地化的HessianServlet，用于服务务器方法调用前的校验
 * 
 * @author sjh
 * 
 */
public class MHessianServlet extends HessianServlet {
	private static final long serialVersionUID = 1620619522783394602L;

	@Override
	public void service(ServletRequest request, ServletResponse response)throws IOException, ServletException
	{
		//System.out.println("服务器方法调用前");
		// 在service方法中可以将request强转成HttpServletRequest，就可以获取很多信息
		//HttpServletRequest req = (HttpServletRequest) request;
		//String path = req.getContextPath();
		//String basePath = req.getScheme() + "://" + req.getServerName() + ":"+ req.getServerPort() + path + "/";
		// 1.获取客户端请求路径
		//String requestURI = req.getRequestURI();
		//System.out.println(basePath);
		//2获取客户机发出请求时的完整URL:--request.getRequestURL()-------
		//http://localhost:8080/myservlet/RequestMethodColligate.html
		//String requestURL= req.getRequestURL().toString();
		//System.out.println(req.getRemoteAddr()+"===="+req.getRemotePort()+"----:"+requestURL);
		//System.out.println(requestURI);
		//System.out.println(getRemoteHost(req));
		// 2.获取客户端参数信息,获取tocken
//		Enumeration<String> parameterNames = req.getParameterNames();
//		if (null != parameterNames) {
//			while (parameterNames.hasMoreElements()) {
//				String paramterValue = req.getParameter(parameterNames.nextElement());
//				System.out.println(paramterValue);
//			}
//		}
		// 3.会话管理 ...
		super.service(request, response);
		//System.out.println("服务器方法调用后");
	}
    /**
     * 得到客户端的ip
     * @param request
     * @return
     */
	public String getRemoteHost(javax.servlet.http.HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	  }
}
