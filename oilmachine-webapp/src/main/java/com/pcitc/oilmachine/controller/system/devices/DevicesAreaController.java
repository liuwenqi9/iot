package com.pcitc.oilmachine.controller.system.devices;

import java.util.ArrayList;
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
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.CameraDevicesArea;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.DevicesArea;
import com.pcitc.oilmachine.service.modelservice.devices.DevicesAreaService;
import com.pcitc.oilmachine.service.modelservice.devices.DevicesService;
import com.pcitc.oilmachine.view.GridData;


/**
 * 设备区域维护控制器
 * 
 * @author xianlin.sun
 * @ClassName :DevicesAreaController
 * @Version 版本
 * @date 2018年3月30日 上午10:54:18
 */
@Controller
@RequestMapping("/devicesarea")
public class DevicesAreaController extends BaseAction {

	@Resource
	private DevicesAreaService devicesAreaService;
	
	@Resource
	private DevicesService devicesService;
	
	/**
	 * 跳转列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/devicesareaPage")
	public String devicesareaPage() {
		return "view/devices/devicesarealist";
	}
	
	
	/**
	 * 跳转摄像机绑定加油机及安全加油位列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/cameradevicesareaPage")
	public String cameradevicesareaPage() {
		return "view/devices/cameradevicesarealist";
	}

	/**
	 * 跳转添加页面
	 * 
	 * @return
	 * @throws PTPECAppException 
	 */
	@RequestMapping(value = "/addPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView addPage(String oilid) throws PTPECAppException {
		ModelAndView modelAndView = new ModelAndView("view/devices/devicesareainfo");
		if(StringUtils.isNotBlank(oilid)){
			Devices findById = devicesService.findById(oilid);
			modelAndView.addObject("areanum", findById.getDeviceareanum());
			
			List<DevicesArea> list = devicesAreaService.findAreanumListByDevicesids(oilid,Constant.OILMACH_CODE);
			if(list != null){
				List<Byte> relist = new ArrayList<Byte>();
				for (DevicesArea devicesArea2 : list) {
					Byte areacode = devicesArea2.getAreacode();
					if(areacode != 0){
						relist.add(areacode);
					}
				}
				modelAndView.addObject("areacodelist", relist);
			}
		}
		return modelAndView;
	}
	
	
	/**
	 * 跳转编辑页面
	 * 
	 * @param devicesArea
	 * @return
	 * @throws PTPECAppException 
	 */
	@RequestMapping(value = "/editPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView editPage(DevicesArea devicesArea) throws PTPECAppException {
		String devicesareaid = devicesArea.getDevicesareaid();
		ModelAndView modelAndView = new ModelAndView("view/devices/devicesareainfo");
		if (StringUtils.isNotBlank(devicesareaid)) {
			DevicesArea bean = devicesAreaService.findById(devicesareaid);
			modelAndView.addObject("DevicesArea", bean);
		}
		String devicesid = devicesArea.getOilid();//devicesArea.getDevicesid();
		if(StringUtils.isNotBlank(devicesid)){
			Devices findById = devicesService.findById(devicesid);
			modelAndView.addObject("areanum", findById.getDeviceareanum());
			
			List<DevicesArea> list = devicesAreaService.findAreanumListByDevicesids(devicesid,Constant.OILMACH_CODE);
			if(list != null){
				List<Byte> relist = new ArrayList<Byte>();
				for (DevicesArea devicesArea2 : list) {
					Byte areacode = devicesArea2.getAreacode();
					if(areacode != 0){
						relist.add(areacode);
					}
				}
				modelAndView.addObject("areacodelist", relist);
			}
		}
		return modelAndView;
	}

	/**
	 * 列表
	 * 
	 * @param devicesArea      查询条件对象
	 */
	@ResponseBody
	@RequestMapping(value = "/devicesareaList", produces = {"application/text;charset=UTF-8" })
	public String devicesareaList(DevicesArea devicesArea) {
		GridData gridData = null;
		try {
			gridData = devicesAreaService.queryDevicesAreaListPage(devicesArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeGridData(gridData);
	}
	
	/**
	 * 跳转摄像机与油机及加油位绑定页面
	 * 
	 * @return
	 * @throws PTPECAppException 
	 */
	@RequestMapping(value = "/cameraAddPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView cameraAddPage(String devicesId) throws PTPECAppException {
		ModelAndView modelAndView = new ModelAndView("view/devices/cameradevicesareainfo");
		if(StringUtils.isNotBlank(devicesId)){
			Devices devices = devicesService.findById(devicesId);//获取点击的摄像机对象信息
			//根据摄像机设备id查询区域表，得到油机id逗号拼接返回
//			String oilids  = devicesAreaService.queryDevicesAreaByCameraId(devicesId);
			//摄像机绑定的油机
//			List<Devices> cameraAnddevicesList = devicesService.queryDevicesListInoilids(oilids);

			//根据租户id,网点编码,加油机编号001 查询当前网点下的所有加油机对象集合---------------
			List<Devices> findDevicesList = devicesService.findDevices(devices.getTenantid(), devices.getNodecode(), Constant.OILMACH_CODE);
			modelAndView.addObject("devicesList", JSON.toJSONString(findDevicesList));
			
			String ids = "";
			for (int i = 0; i < findDevicesList.size(); i++) {
				String devicesid = findDevicesList.get(i).getDevicesid();
				ids += devicesid + ",";
			}
			
			//查询已创建的区域编码列表
			List<DevicesArea> list = devicesAreaService.findAreanumListByDevicesids(ids,Constant.OILMACH_CODE);
			modelAndView.addObject("arealist", JSON.toJSONString(list));
		}
		return modelAndView;
	}

	/**
	 * 摄像机绑定安全加油位及对应xy数据
	 * 
	 * @param devicesAreaType 保存对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/cameraAdd", produces = {"application/text;charset=UTF-8" })
	public String cameraAdd(String deviceid,String devicetypecode,String devicesareaid,DevicesArea devicesAreaCamera) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			if(Constant.OILMACH_CODE.equals(devicetypecode)){
				devicesAreaCamera.setOilid(deviceid);
			}else if(Constant.CAMERA_CODE.equals(devicetypecode)){
				devicesAreaCamera.setCameraid(deviceid);
			}
			devicesAreaService.edit(devicesAreaCamera, userinfo);
			json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}

	/**
	 * 跳转摄像机绑定的加油位编辑页面 
	 * @param devicesArea
	 * @return
	 */
	@RequestMapping(value = "/cameraEditPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView cameraEditPage(DevicesArea devicesArea) {
		String devicesareaid = devicesArea.getDevicesareaid();
		ModelAndView modelAndView = new ModelAndView("view/devices/cameradevicesareaedit");
		if (StringUtils.isNotBlank(devicesareaid)) {
			DevicesArea bean = devicesAreaService.findById(devicesareaid);
			modelAndView.addObject("DevicesArea", bean);
		}
		return modelAndView;
	}
	
	/**
	 * 批量删除
	 * 
	 * @param ids 系统来源ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateCameraNull", produces = {"application/text;charset=UTF-8" })
	public String updateCameraNull(String ids) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			devicesAreaService.editCameraNull(ids,userinfo);
			json.put("status", true);
		}catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
	
	/**
	 * 查询摄像机所在网点 摄像头绑定的加油机及安全加油位
	 * 
	 * @param devicesArea      查询条件对象
	 */
	@ResponseBody
	@RequestMapping(value = "/cameradevicesareaList", produces = {"application/text;charset=UTF-8" })
	public String cameradevicesareaList(CameraDevicesArea devicesArea) {
		GridData gridData = null;
		try {
			gridData = devicesAreaService.queryCameraDevicesArea(devicesArea);
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
			devicesAreaService.delete(ids,userinfo);
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
	 * @param devicesAreaType 保存对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", produces = {"application/text;charset=UTF-8" })
	public String add(String deviceid,String devicetypecode,DevicesArea devicesAreaType) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			if(Constant.OILMACH_CODE.equals(devicetypecode)){
				devicesAreaType.setOilid(deviceid);
			}else if(Constant.CAMERA_CODE.equals(devicetypecode)){
				devicesAreaType.setCameraid(deviceid);
			}
			devicesAreaService.save(devicesAreaType, userinfo);
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
	 * @param devicesArea
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", produces = {"application/text;charset=UTF-8" })
	public String edit(DevicesArea devicesArea) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			devicesAreaService.edit(devicesArea,userinfo);
		    json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
	
}
