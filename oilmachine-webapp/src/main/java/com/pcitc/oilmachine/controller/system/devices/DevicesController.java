package com.pcitc.oilmachine.controller.system.devices;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.controller.BaseAction;
import com.pcitc.oilmachine.enums.DictionaryEnum;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.DevicesArea;
import com.pcitc.oilmachine.model.DictionaryData;
import com.pcitc.oilmachine.model.NozzleStatus;
import com.pcitc.oilmachine.service.dictionary.DictionaryDataService;
import com.pcitc.oilmachine.service.modelservice.devices.DevicesAreaService;
import com.pcitc.oilmachine.service.modelservice.devices.DevicesService;
import com.pcitc.oilmachine.service.modelservice.devices.NozzleStatusService;
import com.pcitc.oilmachine.view.GridData;


/**
 * 设备类型维护控制器
 * 
 * @author xianlin.sun
 * @ClassName :DevicesController
 * @Version 版本
 * @date 2018年3月21日 上午11:25:56
 */
@Controller
@RequestMapping("/devices")
public class DevicesController extends BaseAction {

	@Resource
	private DevicesService devicesService;
	@Resource
	private DictionaryDataService dictionaryDataService;
	@Resource
	private NozzleStatusService nozzleStatusService;
	@Resource
	private DevicesAreaService devicesAreaService;
	
	@ResponseBody
	@RequestMapping(value = "/nozzleAdd", produces = {"application/text;charset=UTF-8" })
	public String nozzleAdd(String deviceid,String areacode,String nozzleno) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			if(StringUtils.isNotBlank(deviceid)){
				Devices devices = devicesService.findById(deviceid);
				NozzleStatus ns = new NozzleStatus();
				ns.setNodecode(devices.getNodecode());
				ns.setNodetag(devices.getNodetag());
				ns.setTenantid(devices.getTenantid());
				ns.setDeviceconnid(devices.getConnid());
				ns.setNozzleno(Byte.valueOf(nozzleno));
				ns.setAreacode(Byte.valueOf(areacode));
				nozzleStatusService.saveOrupdate(ns, userinfo.getUsername());
			}
			json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
	
	@RequestMapping(value = "/nozzleinfo", produces = {"application/text;charset=UTF-8" })
	public ModelAndView nozzleinfo(String devicesId) throws PTPECAppException {
		ModelAndView modelAndView = new ModelAndView("view/devices/nozzleinfo");
		if(StringUtils.isNotBlank(devicesId)){
			Devices devices = devicesService.findById(devicesId);//获取点击的摄像机对象信息
			
			//查询已创建的区域编码列表
			List<DevicesArea> list = devicesAreaService.findAreanumListByDevicesids(devices.getDevicesid(),Constant.OILMACH_CODE);
			modelAndView.addObject("arealist", JSON.toJSONString(list));
		}
		return modelAndView;
	}
	
	@RequestMapping("/nozzlePage")
	public String nozzlePage(){
		return "view/devices/nozzleList";
	}
	
	/**
	 * 跳转列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/devicesPage")
	public String devicesPage() {
		return "view/devices/deviceslist";
	}

	/**
	 * 跳转添加页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView addPage(String stncode) {
		UserInfo userInfo = this.getUserInfo();
		ModelAndView modelAndView = new ModelAndView("view/devices/devicesinfo");
		try {
			String buInfo = devicesService.getBuInfo(userInfo.getTenantid());
			JSONObject parseObject = JSONObject.parseObject(buInfo, JSONObject.class);
			modelAndView.addObject("buInfo", parseObject.get("msg"));
			modelAndView.addObject("success", parseObject.get("success"));
			List<DictionaryData> dataListByDiccode = dictionaryDataService.getDataListByDiccode(DictionaryEnum.DEVICESTYPE, userInfo.getTenantid());
			modelAndView.addObject("DevicesTypeList", JSON.toJSONString(dataListByDiccode));
			//获取连接信息
			List<Object> keySet = devicesService.findConnidSet(stncode,null);
			modelAndView.addObject("keySet", JSON.toJSONString(keySet));
		} catch (Exception e) {
			modelAndView.addObject("buInfo", e.getMessage());
			modelAndView.addObject("success", false);
			e.printStackTrace();
		}
		return modelAndView;
	}

	/**
	 * 跳转编辑页面
	 * 
	 * @param devices
	 * @return
	 */
	@RequestMapping(value = "/editPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView editPage(Devices devices) {
		String devicesid = devices.getDevicesid();
		ModelAndView modelAndView = new ModelAndView("view/devices/devicesinfo");
		if (StringUtils.isNotBlank(devicesid)) {
			Devices bean = devicesService.findById(devicesid);
			modelAndView.addObject("Devices", bean);
		}
		try {
			UserInfo userInfo = this.getUserInfo();
			String buInfo = devicesService.getBuInfo(userInfo.getTenantid());
			JSONObject parseObject = JSONObject.parseObject(buInfo, JSONObject.class);
			modelAndView.addObject("buInfo", parseObject.get("msg"));
			modelAndView.addObject("success", parseObject.get("success"));
			List<DictionaryData> dataListByDiccode = dictionaryDataService.getDataListByDiccode(DictionaryEnum.DEVICESTYPE, userInfo.getTenantid());
			modelAndView.addObject("DevicesTypeList", JSON.toJSONString(dataListByDiccode));
			//获取连接信息
			List<Object> keySet = devicesService.findConnidSet(devices.getNodecode(),devices.getDevicestypecode());
			modelAndView.addObject("keySet", JSON.toJSONString(keySet));
		} catch (Exception e) {
			modelAndView.addObject("buInfo", e.getMessage());
			modelAndView.addObject("success", false);
			e.printStackTrace();
		}
		return modelAndView;
	}

	/**
	 * 列表
	 * 
	 * @param devices      查询条件对象
	 * @param stncode      网点编码
	 */
	@ResponseBody
	@RequestMapping(value = "/devicesList", produces = {"application/text;charset=UTF-8" })
	public String devicesList(Devices devices, String stncode) {
		GridData gridData = null;
		try {
			gridData = devicesService.queryDevicesListPage(devices, stncode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeGridData(gridData);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids 系统来源ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", produces = {"application/text;charset=UTF-8" })
	public String delete(String ids) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			devicesService.delete(ids,userinfo);
			json.put("status", true);
		}catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}

	/**
	 * 新增
	 * 
	 * @param devices 保存对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", produces = {"application/text;charset=UTF-8" })
	public String add(Devices devices) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			devicesService.save(devices, userinfo);
			json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}

	/**
	 * 修改
	 * 
	 * @param devices
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", produces = {"application/text;charset=UTF-8" })
	public String edit(Devices devices) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			devicesService.edit(devices,userinfo);
		    json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
	
	/**
	 * 跳转车辆列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/vehiclePage")
	public String vehiclePage() {
		return "view/devices/vehiclelist";
	}
	
	/**
	 * 当前车辆列表
	 * 
	 * @param stnCode      网点编码
	 * @param connid      连接id
	 */
	@ResponseBody
	@RequestMapping(value = "/vehicleList", produces = {"application/text;charset=UTF-8" })
	public String vehicleList(String stnCode, String connid,String devicetypecode) {
		UserInfo userInfo = this.getUserInfo();
		GridData gridData = null;
		try {
			gridData = devicesService.findVehicleListPage(stnCode, connid, userInfo,devicetypecode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeGridData(gridData);
	}
	
	@ResponseBody
	@RequestMapping(value = "/clearVehicles", produces = {"application/text;charset=UTF-8" })
	public String clearVehicles(String oilconnid,String carnum,String stnCode){
		JSONObject json = new JSONObject();
		UserInfo userInfo = this.getUserInfo();
		try {
			devicesService.clearVehicles(userInfo.getTenantid(),oilconnid,carnum,stnCode);
		    json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
}
