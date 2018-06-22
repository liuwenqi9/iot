package com.pcitc.oilmachine.service.hsf;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.caucho.hessian.client.HessianProxyFactory;
import com.pcitc.oilmachine.service.system.SystemParamService;
import com.pcitc.saas.api.NcmiService;
import com.pcitc.saas.api.WmaService;


@Component("sharedClient")
public class SharedClient {
	
	@Resource
	private SystemParamService systemParamService;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public NcmiService getNcmiService() throws Exception{
		HessianProxyFactory factory = new HessianProxyFactory();
		// 使用Hessian工厂获得接口的具体实现类
		NcmiService ncmiService = (NcmiService)factory.create(NcmiService.class, systemParamService.ncmiserviceUrl);
		factory.setOverloadEnabled(true); 
		return ncmiService;
	}
	
	public WmaService getWmaService() throws Exception{
		HessianProxyFactory factory = new HessianProxyFactory();
		// 使用Hessian工厂获得接口的具体实现类
		WmaService wmaService = (WmaService)factory.create(WmaService.class, systemParamService.wmaserviceUrl);
		factory.setOverloadEnabled(true); 
		return wmaService;
	}
}
