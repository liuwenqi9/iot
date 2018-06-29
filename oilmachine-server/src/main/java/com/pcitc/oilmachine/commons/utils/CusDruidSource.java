package com.pcitc.oilmachine.commons.utils;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
@SuppressWarnings("all")
public class CusDruidSource extends DruidDataSource{
	@Override
	public void setUsername(String username) {
		try {
			username = ConfigTools.decrypt(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.setUsername(username);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(ConfigTools.encrypt("oilmachinetest"));
	}
	
}
