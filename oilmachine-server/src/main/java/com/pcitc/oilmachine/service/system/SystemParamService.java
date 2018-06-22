package com.pcitc.oilmachine.service.system;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("systemParamService")
public class SystemParamService {

	@Value("${ncmi_service_url}")
	public String ncmiserviceUrl;
	@Value("${wma_service_url}")
	public String wmaserviceUrl;
	@Value("${queueName}")
	public String queueName;
}
