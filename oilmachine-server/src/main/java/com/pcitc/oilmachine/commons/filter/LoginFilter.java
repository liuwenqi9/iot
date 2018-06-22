package com.pcitc.oilmachine.commons.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.form.UserInfo;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		//不进行过滤
		List<String> list = new ArrayList<String>();
		list.add("doLogin.do");
		list.add("mobile/HttpAppApi.do");
		list.add("mobile/esrcallback.do");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String requestUrl = request.getServletPath();
		if (requestUrl.indexOf("?") > -1) {
			requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
		}
		String contextPath = request.getContextPath();
		for (String noFilterUrl : list) {
			if (requestUrl.endsWith(noFilterUrl)) {
				chain.doFilter(request, response);
				return;
			}
		}
		UserInfo userinfo = (UserInfo) request.getSession().getAttribute(Constant.SESSION_KEY);
		if (null == userinfo) {
			response.sendRedirect(contextPath + "/login.jsp");
			return;
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
