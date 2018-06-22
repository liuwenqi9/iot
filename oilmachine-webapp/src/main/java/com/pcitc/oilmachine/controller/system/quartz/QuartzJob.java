package com.pcitc.oilmachine.controller.system.quartz;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pcitc.oilmachine.service.modelservice.order.PreAuthorizationService;

public class QuartzJob {
	
	private static Logger log = LoggerFactory.getLogger(QuartzJob.class);
	
	
	@Resource
	private PreAuthorizationService preAuthorizationService;
	
	    /**
	     * @Description: 任务执行获取token
	     * @param
	     */
	    public void workForToken() {
	            //查询预授权申请成功的订单，但未完成加油的订单，取消预授权申请
	            preAuthorizationService.selectAndPreQX();
	            log.info("取消预授权申请任务调度执行完成");
	    }
	    
	    public static void main(String[] args) {
			new ClassPathXmlApplicationContext(new String[] { "classpath:spring/spring-quartz.xml" });
		}
}
