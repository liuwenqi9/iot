package com.pcitc.oilmachine.api;

public interface OilmachineService {
	
	/**
	 * 保存加油预约单
	 * 1：预约码被保存到redis中，24小时后过期
	 * 2：预约数据被存储到crm_gasSubscribe
	 * zizhi.zhang
	 * @param json
	 * @return
	 */
	public String createSubscribeOrder(String json);
	
	/**
	 * 查看用户是否已预约
	 * zizhi.zhang
	 * @param json
	 * @return
	 */
	public String getSubscribeOrder(String json);
	
	/**
	 * 预约码重置
	 * @param json
	 * @return
	 */
	public String resetSubscribeCode(String json);

	/**
	 * 预约单列表
	 * @param json
	 * @return
	 */
	public String findSuborderList(String json);
	
}
