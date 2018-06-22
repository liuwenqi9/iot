package com.pcitc.oilmachine.service.modelservice.devices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.DevicesAreaMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.CameraDevicesArea;
import com.pcitc.oilmachine.model.DevicesArea;
import com.pcitc.oilmachine.model.DevicesAreaExample;
import com.pcitc.oilmachine.model.DevicesAreaExample.Criteria;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.view.GridData;


@Service
public class DevicesAreaService extends BaseService {

	@Resource
	private DevicesAreaMapper devicesAreaMapper;
	
	@Resource
	private RelationMapper relationMapper;
	
	
	/**
	 * 查询列表
	 * 
	 * @param devicesArea
	 */
	public GridData queryDevicesAreaListPage(DevicesArea devicesArea) {
		GridData gridData = new GridData();
		DevicesAreaExample example = new DevicesAreaExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(devicesArea);
		if(StringUtils.isNotBlank(devicesArea.getOilid())){
			createCriteria.andOilidEqualTo(devicesArea.getOilid());
			condition.put("oilid", devicesArea.getOilid());
		}else{
			return gridData;
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		condition.put("status", Constant.DEFAULT_VALUE_BYTE);
		int total = devicesAreaMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = devicesArea.getLength();
		int start = devicesArea.getStart();
		gridData.setLength(length);
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		List<DevicesArea> selectDevicesAreaPageList = relationMapper.selectDevicesAreaPageList(condition);
		gridData.setData(selectDevicesAreaPageList);
		return gridData;
	}

	/**
	 * 摄像机已绑定加油机及加油位列表
	 * 
	 * @param devicesArea
	 */
	public GridData queryCameraDevicesArea(CameraDevicesArea devicesArea) {
		GridData gridData = new GridData();
		DevicesAreaExample example = new DevicesAreaExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(devicesArea);
		if(StringUtils.isNotBlank(devicesArea.getCameraid())){
			createCriteria.andCameraidEqualTo(devicesArea.getCameraid());
			condition.put("cameraid", devicesArea.getCameraid());
		}else{
			return gridData;
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		condition.put("status", Constant.DEFAULT_VALUE_BYTE);
		int total = devicesAreaMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = devicesArea.getLength();
		int start = devicesArea.getStart();
		gridData.setLength(length);
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		List<CameraDevicesArea> selectCameraDevicesAreaList = relationMapper.selectCameraDevicesAreaList(condition);
		gridData.setData(selectCameraDevicesAreaList);
		return gridData;
	}

	/**
	 * 批量删除（逻辑删除）
	 * 
	 * @param ids
	 */
	public void delete(String ids, UserInfo userinfo) {
		if(StringUtils.isNotBlank(ids)){
				String[] arrayIds = ids.split(",");
				Date date = new Date();
				String userid = userinfo.getUserid();
				for (String id : arrayIds) {
					DevicesArea devicesArea = new DevicesArea();
					devicesArea.setDevicesareaid(id);
					devicesArea.setUpdatetime(date);
					devicesArea.setUpdateuser(userid);
					devicesArea.setStatus((byte)1);
					checkDbSuccess(devicesAreaMapper.updateByPrimaryKeySelective(devicesArea));
				}
		}
	}
	
	/**
	 * 保存
	 * 
	 * @param devicesArea
	 * @return 
	 */
	public void save(DevicesArea devicesArea, UserInfo userinfo) {
		// 获得主键
		String classId = StringUtils.makeUUID();
		devicesArea.setDevicesareaid(classId);
		Date date = new Date();
		devicesArea.setCreatedate(date);
		devicesArea.setUpdatetime(date);
		devicesArea.setStatus(Constant.DEFAULT_VALUE_BYTE);
		devicesArea.setSorts(Constant.DEFAULT_VALUE_LONG);
		String userid = userinfo.getUserid();
		devicesArea.setCreator(userid);
		devicesArea.setUpdateuser(userid);
		// 保存数据
		checkDbSuccess(devicesAreaMapper.insert(devicesArea));
	}

	/**
	 * 更新
	 * 
	 * @param devicesArea
	 * @return
	 */
	public void edit(DevicesArea devicesArea,UserInfo userinfo) {
		devicesArea.setUpdatetime(new Date());
		devicesArea.setUpdateuser(userinfo.getUserid());
		checkDbSuccess(devicesAreaMapper.updateByPrimaryKeySelective(devicesArea));
	}

	/**
	 * 主键查询
	 * 
	 * @param devicesAreaId
	 *            主键ID
	 * @return DevicesArea
	 */
	public DevicesArea findById(String devicesAreaId) {
		return devicesAreaMapper.selectByPrimaryKey(devicesAreaId);
	}

	/**
	 * 查询已创建的区域编码列表
	 * @param devicesids
	 * @return
	 * @throws PTPECAppException 
	 */
	public List<DevicesArea> findAreanumListByDevicesids(String ids,String deviceTypeCode) throws PTPECAppException {
		List<DevicesArea> list = null;
		try {
			if(StringUtils.isNotBlank(ids)){
				String[] split = ids.split(",");
				List<String> values = new ArrayList<String>();
				for (String devicesid : split) {
					values.add(devicesid);
				}
				DevicesAreaExample example = new DevicesAreaExample();
				Criteria createCriteria = example.createCriteria();
				if(Constant.CAMERA_CODE.equals(deviceTypeCode)){
					createCriteria.andCameraidIn(values);
				}else if(Constant.OILMACH_CODE.equals(deviceTypeCode)){
					createCriteria.andOilidIn(values);
				}
				
				createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
				list = devicesAreaMapper.selectByExample(example);
			}
		} catch (Exception e) {
			throw new PTPECAppException("获取设备所对应区域的异常:"+e.getMessage(),e);
		}
		return list;
	}
	
	/**
	 * 查询已创建的区域编码列表
	 * @param devicesids
	 * @return
	 */
	public List<DevicesArea> findAreanumListByoilids(String ids,String deviceTypeCode) {
		List<DevicesArea> list = null;
		if(StringUtils.isNotBlank(ids)){
			String[] split = ids.split(",");
			List<String> values = new ArrayList<String>();
			for (String oilid : split) {
				values.add(oilid);
			}
			DevicesAreaExample example = new DevicesAreaExample();
			Criteria createCriteria = example.createCriteria();
			if(Constant.CAMERA_CODE.equals(deviceTypeCode)){
				createCriteria.andCameraidIn(values);
			}else if(Constant.OILMACH_CODE.equals(deviceTypeCode)){
				createCriteria.andOilidIn(values);
			}
			
			createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
			list = devicesAreaMapper.selectByExample(example);
		}
		return list;
	}
	
	
	public List<DevicesArea> findDevicesAreaSByDevicesid(String devicesid,String deviceTypecode,String areacode) {
		DevicesAreaExample example = new DevicesAreaExample();
		Criteria createCriteria = example.createCriteria();
		if(Constant.OILMACH_CODE.equals(deviceTypecode)){
			createCriteria.andOilidEqualTo(devicesid);
		}else{
			createCriteria.andCameraidEqualTo(devicesid);
		}
		
		if(StringUtils.isNotBlank(areacode)){
			createCriteria.andAreacodeEqualTo(Byte.valueOf(areacode));
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		List<DevicesArea> list = devicesAreaMapper.selectByExample(example);
		return list;
	}

	/**
	 * 根据摄像机id查询区域表中油机id 并用逗号拼接返回
	 * @param devicesId
	 * @return
	 */
	public String queryDevicesAreaByCameraId(String devicesId) {
		DevicesAreaExample example = new DevicesAreaExample();
		example.createCriteria().andCameraidEqualTo(devicesId).andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		List<DevicesArea> selectByExample = devicesAreaMapper.selectByExample(example);
		String oilids = "" ;	
			if(selectByExample.size() > 0){
				  for (int i = 0; i < selectByExample.size(); i++) {
					  String oilid = selectByExample.get(i).getOilid();
					  oilids += oilid + ",";
				} 
			 }
		return oilids ;
	}

	/**
	 * 解绑摄像机与加油机及安全位的绑定
	 * @param ids
	 * @param userinfo
	 */
	public void editCameraNull(String ids, UserInfo userinfo) {
		if(!"".equals(ids) && null != ids){
			DevicesArea devicesArea = new DevicesArea();
			devicesArea.setDevicesareaid(ids);
			devicesArea.setCameraid("");
			devicesArea.setUpdatetime(new Date());
			devicesArea.setUpdateuser(userinfo.getUserid());
			checkDbSuccess(devicesAreaMapper.updateByPrimaryKeySelective(devicesArea));
		}
	}

}
