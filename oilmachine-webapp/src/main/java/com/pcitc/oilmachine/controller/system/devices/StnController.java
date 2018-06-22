package com.pcitc.oilmachine.controller.system.devices;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcitc.oilmachine.controller.BaseAction;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.service.modelservice.devices.DevicesService;
import com.pcitc.oilmachine.view.GridData;


/**
 * 设备类型维护控制器
 * 
 * @author xianlin.sun
 * @ClassName :StnController
 * @Version 版本
 * @date 2018年3月21日 上午11:25:56
 */
@Controller
@RequestMapping("/stn")
public class StnController extends BaseAction {

	@Resource
	private DevicesService devicesService;
	
	/**
	 * 跳转列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/stnPage")
	public String stnPage() {
		return "view/devices/stnlist";
	}

	/**
	 * 列表
	 * 
	 * @param stn      查询条件对象
	 */
	@ResponseBody
	@RequestMapping(value = "/stnList", produces = {"application/text;charset=UTF-8" })
	public String stnList(int start, int length,String stnname,String stncode) {
		GridData gridData = null;
		try {
			UserInfo userInfo = this.getUserInfo();
			gridData = devicesService.queryStnList(start, length, userInfo,stnname,stncode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeGridData(gridData );
	}

	
}
