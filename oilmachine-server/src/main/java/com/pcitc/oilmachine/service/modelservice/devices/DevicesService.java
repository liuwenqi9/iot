package com.pcitc.oilmachine.service.modelservice.devices;

import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.afs.base.util.MySpringContextUtil;
import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionManager;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.redis.RedisService;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.DevicesMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.enums.DictionaryEnum;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.form.Vehicle;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.DevicesArea;
import com.pcitc.oilmachine.model.DevicesExample;
import com.pcitc.oilmachine.model.DevicesExample.Criteria;
import com.pcitc.oilmachine.model.DictionaryData;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.service.dictionary.DictionaryDataService;
import com.pcitc.oilmachine.service.hsf.SharedClient;
import com.pcitc.oilmachine.service.mobile.CommonService;
import com.pcitc.oilmachine.view.GridData;
import com.pcitc.saas.api.NcmiService;


@Service
public class DevicesService extends BaseService {

	@Resource
	private DevicesMapper devicesMapper;
	
	@Resource
	private RelationMapper relationMapper;
	
	@Resource
	private DictionaryDataService dictionaryDataService;
	@Resource
	private RedisService<String,String> redisService;
	@Resource
	private DevicesAreaService devicesAreaService;
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Resource
	private CommonService commonService;
	
	/**
	 * 查询列表
	 * 
	 * @param devices
	 * @param stncode  not null else if you query Data set value equals "1" 不能为空，如果查询所有数据，请设置为"1"
	 */
	public GridData queryDevicesListPage(Devices devices, String stncode) {
		GridData gridData = new GridData();
		DevicesExample example = new DevicesExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(devices);
		if(StringUtils.isNotBlank(stncode) || "1".equals(stncode)){
			createCriteria.andNodecodeEqualTo(stncode);
			condition.put("stncode", stncode);
		}else{
			return gridData;
		}
		//查询条件
		if(StringUtils.isNotBlank(devices.getNodetag())){
			createCriteria.andNodetagLike(devices.getNodetag());
			condition.put("nodetag", devices.getNodetag());
		}
		if(StringUtils.isNotBlank(devices.getTenantid())){
			createCriteria.andTenantidEqualTo(devices.getTenantid());
			condition.put("TENANTID", devices.getTenantid());
		}
		if(StringUtils.isNotBlank(devices.getDevicestypename())){
			createCriteria.andDevicestypenameEqualTo(devices.getDevicestypename());
			condition.put("devicestypename", devices.getDevicestypename());
		}
		if(StringUtils.isNotBlank(devices.getBuname())){
			createCriteria.andBunameLike(devices.getBuname());
			condition.put("BUNAME", devices.getBuname());
		}
		if(StringUtils.isNotBlank(devices.getConname())){
			createCriteria.andConnameLike(devices.getConname());
			condition.put("conname", devices.getConname());
		}
		if(devices.getConnstatus() != null){
			createCriteria.andConnstatusEqualTo(devices.getConnstatus());
			condition.put("connstatus", devices.getConnstatus());
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		condition.put("status", Constant.DEFAULT_VALUE_BYTE);
		int total = devicesMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = devices.getLength();
		int start = devices.getStart();
		if(length != 0){
			gridData.setLength(length);
			condition.put("limit", length);
		}
		gridData.setStart(start);
		condition.put("start", start);
		
		List<Devices> selectDevicesPageList = relationMapper.selectDevicesPageList(condition);
		//查询当前摄像头或油机是否正常连接
		checkSessionByConnid(selectDevicesPageList);
		gridData.setData(selectDevicesPageList);
		return gridData;
	}

	/**
	 * 检查当前摄像机session或者channel不存在则失效
	 * @param selectDevicesPageList
	 */
	private void checkSessionByConnid(List<Devices> selectDevicesPageList) {
		if(selectDevicesPageList.size()>0){
			for (int i = 0; i < selectDevicesPageList.size(); i++) {
				String devicestypecode = selectDevicesPageList.get(i).getDevicestypecode();
				//判断摄像头或油机是否连接  session有值并且channel有值不处理，否则状态set为1前台显示失效  
				if( Constant.OILMACH_CODE.equals(devicestypecode)){
					String connid = selectDevicesPageList.get(i).getConnid();
					Session session = SessionManager.getSession(connid);
					if(session != null){
						Channel channel = session.getChannel();
						if(channel == null ){
							selectDevicesPageList.get(i).setConnstatus((byte)1);
						}
					}else{
						selectDevicesPageList.get(i).setConnstatus((byte)1);
					}
				}else if(Constant.CAMERA_CODE.equals(devicestypecode)){
					String connid = selectDevicesPageList.get(i).getConnid();
					Session session = SessionManager.getSession(connid);
					if(session != null){
						long datatime = session.getDatetime();
						long now = System.currentTimeMillis();
						if(datatime + 360000 <= now){//摄像头连接通道的最后修改时间如果大于30分钟，则认为已失效
							selectDevicesPageList.get(i).setConnstatus((byte)1);
						}
					}else{
						selectDevicesPageList.get(i).setConnstatus((byte)1);
					}
				}
			}
		}
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
					Devices devices = new Devices();
					devices.setDevicesid(id);
					devices.setUpdatetime(date);
					devices.setUpdateuser(userid);
					devices.setStatus((byte)1);
					checkDbSuccess(devicesMapper.updateByPrimaryKeySelective(devices));
				}
		}
	}
	
	/**
	 * 保存
	 * 
	 * @param devices
	 * @return 
	 * @throws Exception 
	 */
	public void save(Devices devices, UserInfo userinfo) throws Exception {
		//==============连接信息id判重
		String conname = devices.getConname();
		String[] split = conname.split(",");
		if(StringUtils.isNotBlank(split[0])){//input
			devices.setConname(split[0]);
		}else{//select
			devices.setConname(split[1]);
			String cid = split[1].substring(split[1].lastIndexOf('_')+1, split[1].length());
			devices.setConnid(cid);
		}
		Boolean boo = validateConnidExist(devices);
		if(boo){
			throw new Exception("该连接ID已存在！");
		}
		devices.setConnstatus((byte) 0);
		//==============
		String bucode = devices.getBucode();
		String businessInfo = this.getBusinessInfo(null, bucode);
		JSONObject parseObject = JSONObject.parseObject(businessInfo, JSONObject.class);
		Boolean success = parseObject.getBoolean("success");
		if(success){
			String devicestypecode = devices.getDevicestypecode();
			DictionaryData dataByDoubleCode = dictionaryDataService.getDataByDoubleCode(DictionaryEnum.DEVICESTYPE, devicestypecode, userinfo.getTenantid());
			if(dataByDoubleCode != null){
				devices.setDevicestypename(dataByDoubleCode.getItemValue());
				JSONObject msg = parseObject.getJSONObject("msg");
				String buid = msg.getString("buid");
				String buname = msg.getString("buname");
				devices.setBuid(buid);
				devices.setBuname(buname);
				// 获得主键
				String classId = UUID.randomUUID().toString();
				classId = classId.replace("-", "");
				devices.setDevicesid(classId);
				devices.setTenantid(userinfo.getTenantid());
				if(devices.getSelfservice() == null){
					devices.setSelfservice((byte) 0);
				}
				if(devices.getDeviceareanum() == null){
					devices.setDeviceareanum((byte) 0);
				}
				Date date = new Date();
				devices.setCreatedate(date);
				devices.setUpdatetime(date);
				devices.setStatus(Constant.DEFAULT_VALUE_BYTE);
				devices.setSorts(Constant.DEFAULT_VALUE_LONG);
				String userid = userinfo.getUserid();
				devices.setCreator(userid);
				devices.setUpdateuser(userid);
				if(devices.getReceivedata() == null){
					devices.setReceivedata("0");
				}
				// 保存数据
				checkDbSuccess(devicesMapper.insert(devices));
				
			}else{
				throw new Exception("设备类型信息获取失败！设备类型编码："+devicestypecode);
			}
		}else{
			System.err.println("商户接口返回信息："+parseObject.toJSONString());
			throw new Exception(parseObject.getString("msg"));
		}
	}

	/**
	 * 新增、修改时，connid判重
	 * @param devicesid
	 * @param connid
	 * @return
	 */
	private Boolean validateConnidExist(Devices devices) {
		if(StringUtils.isNotBlank(devices.getDevicesid())){
			Devices findById = this.findById(devices.getDevicesid());
			if(devices.getConnid().equalsIgnoreCase(findById.getConnid())){
				return false;
			}
		}
		DevicesExample example = new DevicesExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andNodecodeEqualTo(devices.getNodecode());
		createCriteria.andDevicestypecodeEqualTo(devices.getDevicestypecode());
		createCriteria.andConnidEqualTo(devices.getConnid());
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		int count = devicesMapper.countByExample(example);
		if(count > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 更新设备信息
	 * @param devices
	 * @param username
	 * @throws Exception
	 */
	public void updateDevice(Devices devices,String username) throws PTPECAppException {
		try {
			devices.setUpdatetime(new Date());
			devices.setUpdateuser(username);
			devicesMapper.updateByPrimaryKey(devices);
		} catch (Exception e) {
			throw new PTPECAppException("更新设备信息异常:"+e.getMessage(),e);
		}
	}

	/**
	 * 更新
	 * 
	 * @param devices
	 * @return
	 * @throws Exception 
	 */
	public void edit(Devices devices,UserInfo userinfo) throws Exception {
		try {
			String conname = devices.getConname();
			String[] split = conname.split(",");
			if(StringUtils.isNotBlank(split[0])){//input
				devices.setConname(split[0]);
			}else{//select
				devices.setConname(split[1]);
				String cid = split[1].substring(split[1].lastIndexOf('_')+1, split[1].length());
				devices.setConnid(cid);
			}
			Boolean boo = validateConnidExist(devices);
			if(boo){
				throw new Exception("该连接ID已存在！");
			}
			DictionaryData dataByDoubleCode = dictionaryDataService.getDataByDoubleCode(DictionaryEnum.DEVICESTYPE, devices.getDevicestypecode(), userinfo.getTenantid());
			devices.setDevicestypename(dataByDoubleCode.getItemValue());
			devices.setUpdatetime(new Date());
			devices.setUpdateuser(userinfo.getUserid());
			if(devices.getSelfservice() == null){
				devices.setSelfservice((byte) 0);
			}
			if(devices.getDeviceareanum() == null){
				devices.setDeviceareanum((byte) 0);
			}
			checkDbSuccess(devicesMapper.updateByPrimaryKeySelective(devices));
			//是否接收数据
			Session session = SessionManager.getSession(devices.getConnid());
			if(session != null){
				session.setReceivedata(Integer.parseInt(devices.getReceivedata()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PTPECAppException("更新设备信息异常:"+e.getMessage(),e);
		}
	}

	/**
	 * 主键查询
	 * 
	 * @param devicesId
	 *            主键ID
	 * @return Devices
	 */
	public Devices findById(String devicesId) {
		return devicesMapper.selectByPrimaryKey(devicesId);
	}
	
	/**
	 * 获取网点分页信息
	 * @param start
	 * @param length
	 * @param userinfo
	 * @return
	 * @throws Exception
	 */
	private String findStnPageByTenantid(int start, int length, UserInfo userinfo,String stnname,String stncode) throws Exception{
		JSONObject json = new JSONObject();
		json.put("start", start);
		json.put("limit", length);
		json.put("tenantid", userinfo.getTenantid());
		if(StringUtils.isNotBlank(stncode)){
			json.put("stnCode", stncode);
		}
		if(StringUtils.isNotBlank(stnname)){
			json.put("stnName", stnname);
		}
		
		SharedClient sharedClient = (SharedClient)MySpringContextUtil.getBean("sharedClient");
		NcmiService ncmiservice = sharedClient.getNcmiService();
		String resultJson = ncmiservice.findStnInfoByPageAndTid(json.toJSONString());
		JSONObject parse = JSONObject.parseObject(resultJson, JSONObject.class);
		String status = parse.getString("status");
		String msg = parse.getString("msg");
		if("SUCCESS".equalsIgnoreCase(status)){
			return msg;
		}else{
			throw new Exception(msg);
		}
	}
	
	/*private String findStnPageByTenantid(int start, int length, UserInfo userinfo) throws Exception{
		JSONObject json = new JSONObject();
		json.put("tenantid", userinfo.getTenantid());
		json.put("orgid", userinfo.getOrgid());
		SharedClient sharedClient = (SharedClient)MySpringContextUtil.getBean("sharedClient");
		NcmiService ncmiservice = sharedClient.getNcmiService();
		String resultJson = ncmiservice.findStnInfos(json.toJSONString());
		JSONObject parse = JSONObject.parseObject(resultJson, JSONObject.class);
		String status = parse.getString("status");
		if("SUCCESS".equalsIgnoreCase(status)){
			String resultInfo = parse.getString("resultInfo");
			System.out.println(resultInfo);
			return resultInfo;
		}else{
			String msg = parse.getString("msg");
			throw new Exception(msg);
		}
	}*/
	
	/**
	 * 查询网点分页列表
	 * @param start
	 * @param length
	 * @param userinfo
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	public GridData queryStnList(int start, int length, UserInfo userinfo,String stnname,String stncode) throws Exception{
		GridData gridData = new GridData();
		String result = findStnPageByTenantid(start, length, userinfo,stnname,stncode);
		JSONObject parseObject = JSONObject.parseObject(result);
		Integer total = parseObject.getInteger("total");
		String rows = parseObject.getString("rows");
		if(total < 0){
			System.out.println("网点列表接口信息："+rows);
			return gridData;
		}
		List list = JSONObject.parseObject(rows, List.class);
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		gridData.setLength(length);
		gridData.setStart(start);
		gridData.setData(list);
		return gridData;
	}

	/**
	 * 获取商户列表
	 * @param tenantid
	 * @return
	 * @throws Exception
	 */
	public String getBuInfo(String tenantid) throws Exception{
		return this.getBusinessInfo(tenantid, null);
	}
	
	/**
	 * 根据设备连接ID获取设备信息
	 * @param connid
	 * @param devicestypecode
	 * @return
	 * @throws PTPECAppException
	 */
	public Devices findByConnid(String connid,String devicestypecode) throws PTPECAppException {
		try {
			DevicesExample example = new DevicesExample();
			example.createCriteria().andConnidEqualTo(connid).andDevicestypecodeEqualTo(devicestypecode).andStatusEqualTo((byte)0);
			List<Devices> devieceList = devicesMapper.selectByExample(example);
			if(devieceList.size()>0){
				return devieceList.get(0);
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new PTPECAppException("根据设备连接ID获取设备信息异常:"+e.getMessage(),e);
		}
	}
	
	public List<Devices> findDevices(String tenantid, String stncode,String devicestypecode){
		DevicesExample example = new DevicesExample();
		example.createCriteria().andTenantidEqualTo(tenantid).andNodecodeEqualTo(stncode).andDevicestypecodeEqualTo(devicestypecode).andStatusEqualTo((byte)0);
		return devicesMapper.selectByExample(example);
	}
	

	/**
	 * 
	 * @param stncode  网点编码 8位标准
	 * @param devicetypecode  设备类型编码
	 * @return
	 */
	public List<Object> findConnidSet(String stncode,String devicetypecode) {
		Map<String, Session> allSession = SessionManager.getAllSession();
		Set<String> keySet = allSession.keySet();
		List<Object> list = new ArrayList<Object>();
		for (String string : keySet) {
			Map<String, String> map = new HashMap<String, String>();
			Session session = allSession.get(string);
			String clientId = session.getClientId();
			String dtcode = session.getDeviceTypeCode();
			String stncodeforsession = clientId.substring(0, 8);//设备ID有可能是乱填的,导致位数不够
			if(stncode.equals(stncodeforsession)){
				if(StringUtils.isNotBlank(devicetypecode)){
					if(devicetypecode.equals(dtcode)){
						map.put("clientId", clientId);
						map.put("conntype", dtcode);
						list.add(map);
					}
				}else{
					map.put("clientId", clientId);
					map.put("conntype", dtcode);
					list.add(map);
				}
			}
		}
		return list;
	}

	/**
	 * 查询当前车辆分页列表
	 * @param stnCode
	 * @param connid
	 * @return
	 * @throws Exception 
	 */
	public GridData findVehicleListPage(String stnCode, String connid, UserInfo userInfo,String devicetypecode) throws Exception {
		GridData gridData = new GridData();
		int size = 0;
		List<Vehicle> currentVehicle = null;
		if(Constant.OILMACH_CODE.equals(devicetypecode)){
			//油机
			currentVehicle = this.getCurrentVehicle(userInfo.getTenantid(),stnCode, connid);
		}else{
			Devices cameraDevice = this.findByConnid(connid, Constant.CAMERA_CODE);
			if (cameraDevice != null) {
				// 摄像头,需要获取当前摄像头所管理的所有加油位,,这里的处理还有问题
				List<Devices> devicess = queryDeviceBybondarea(cameraDevice);
				List<Vehicle> temp = new ArrayList<Vehicle>();
				if (devicess.size() > 0) {
					for (Devices devices : devicess) {
						List<Vehicle> temp0 = this.getCurrentVehicle(userInfo.getTenantid(), stnCode,devices.getConnid());
						if (temp0 != null && temp0.size() > 0) {
							List<Vehicle> temp1 = new ArrayList<Vehicle>();
							for (Vehicle vehicle : temp0) {
								if (connid.equals(vehicle.getCameraid())) {
									vehicle.setOilconnid(devices.getConnid());
									temp1.add(vehicle);
								}
							}
							temp.addAll(temp1);
						}
					}
				}
				currentVehicle = temp;
			}
				
		}
			
		if(currentVehicle != null && currentVehicle.size() != 0){
			size = currentVehicle.size();
			//字典值转换
			changeVehicleValue(currentVehicle, userInfo);
		}else{
			currentVehicle = new ArrayList<>();
		}
		gridData.setRecordsFiltered(size);
		gridData.setRecordsTotal(size);
		gridData.setData(currentVehicle);
		return gridData;
	}
	
	private void changeVehicleValue(List<Vehicle> currentVehicle, UserInfo userInfo) throws Exception {
		if(currentVehicle != null && currentVehicle.size() != 0){
			for (Vehicle vehicle : currentVehicle) {
				String carcolor = vehicle.getCarcolor();
				if(StringUtils.isNotBlank(carcolor)){
					DictionaryData findDataObj = dictionaryDataService.getDataByDoubleCode(DictionaryEnum.CAR_COLOR, carcolor, userInfo.getTenantid());
					vehicle.setCarcolorname(findDataObj.getItemValue());
				}else{
					vehicle.setCarcolorname("未知");
				}
				String cartype = vehicle.getCartype();
				if(StringUtils.isNotBlank(cartype)){
					DictionaryData findDataObj2 = dictionaryDataService.getDataByDoubleCode(DictionaryEnum.CAR_SHAPE, cartype, userInfo.getTenantid());
					vehicle.setCartypename(findDataObj2.getItemValue());
				}else{
					vehicle.setCartypename("未知");
				}
			}
		}
	}

	/**
	 * 获取当前油机绑定的车辆信息
	 * @param stncode
	 * @param connid
	 * @return
	 * @throws Exception 
	 */
	public List<Vehicle> getCurrentVehicle(String tenatid,String stncode, String connid) throws Exception{
		List<Vehicle> hasnouser = commonService.getCurrentVehiclesHasnouser(connid,null);
		List<Vehicle> hasuser = commonService.getCurrentVehicles(connid);
		hasuser.addAll(hasnouser);
		return hasuser;
	}

	/**
	 * 根据网点编码查询当前网点所有连接信息
	 * @param nodecode
	 * @return
	 */
	public List<Devices> findDevicesBytnt(String tenantid,String nodecode,String deviceTypeCode) {
		DevicesExample example = new DevicesExample();
		example.createCriteria().andTenantidEqualTo(tenantid).andNodecodeEqualTo(nodecode).andDevicestypecodeEqualTo(deviceTypeCode).andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		 return devicesMapper.selectByExample(example);
	}

	public Devices finddevices(String tenantid, String stncode, String connid,String devicetypecode) throws PTPECAppException {
		Devices devices = null;
		try {
			DevicesExample example = new DevicesExample();
			example.createCriteria().andTenantidEqualTo(tenantid).andNodecodeEqualTo(stncode).andConnidEqualTo(connid).andDevicestypecodeEqualTo(devicetypecode).andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
			List<Devices>  devicesList = devicesMapper.selectByExample(example);
			if(devicesList.size()>0){
				devices = devicesList.get(0);
			}
		} catch (Exception e) {
			throw new PTPECAppException("获取设备信息异常:"+e.getMessage(),e);
		}
		 return devices;
	}
	
	/**
	 * 
	 * @param tenantid
	 * @param signid
	 * @return
	 */
	public Devices findDevicesbySignid(String signid){
		Devices devices = null;
		try {
			StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) MySpringContextUtil.getBean("stringRedisTemplate");
			BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(signid);
			String connid = hashOpertions.get("connid");
			if(StringUtils.isBlank(connid)){
				return null;
			}
			String stncode = hashOpertions.get("stncode");
			String tenantid = hashOpertions.get("tenantid");
			devices = finddevices(tenantid, stncode, connid,Constant.OILMACH_CODE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return devices;
	}

	/**
	 * 根据设备区域绑定摄像头的加油机id查询加油机设备集合
	 * @param cameraids
	 * @return
	 * @throws PTPECAppException 
	 */
	public List<Devices> queryDevicesListByIds(List<String> oilids) throws PTPECAppException {
		List<Devices> list = null;
		try {
			if(oilids.size() > 0){
				DevicesExample example = new DevicesExample();
				Criteria createCriteria = example.createCriteria();
				createCriteria.andDevicesidIn(oilids);
				createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
				list = devicesMapper.selectByExample(example);
			}
		} catch (Exception e) {
			throw new PTPECAppException("根据设备表ID获取设备信息异常:"+e.getMessage(),e);
		}
		return list;
	}

	/**
	 * 清除缓存的车辆信息
	 * @param oilconnid
	 * @param carnum
	 */
	public void clearVehicles(String tenantid, String oilconnid, String carnum,String stnCode) {
		try {
			if(StringUtils.isBlank(oilconnid) && StringUtils.isNotBlank(carnum)){
				stringRedisTemplate.delete(carnum);
			}else{
				redisService.hdel(tenantid+stnCode+oilconnid, carnum);
				//BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(carnum);
				stringRedisTemplate.delete(carnum);
			}
			//hashOpertions.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据iot_devicesarea 表的关连关系,查找对应的设备
	 * @param devices
	 * @return
	 * @throws PTPECAppException 
	 */
	public List<Devices> queryDeviceBybondarea(Devices devices) throws PTPECAppException{
		String devicetypecode = devices.getDevicestypecode();
		List<DevicesArea> das = devicesAreaService.findAreanumListByDevicesids(devices.getDevicesid(), devicetypecode);
		String oilMcode = Constant.OILMACH_CODE;
		String cameraCode = Constant.CAMERA_CODE;
		List<String> ids = new ArrayList<String>();
		List<Devices> devicesList = new ArrayList<Devices>();
		if(das.size()>0){
			if(oilMcode.equals(devicetypecode)){//根据油机找摄像头
				for(DevicesArea da : das){
					ids.add(da.getCameraid());
				}
				
			}else if(cameraCode.equals(devicetypecode)){//根据摄像头找油机
				for(DevicesArea da : das){
					ids.add(da.getOilid());
				}
			}
			devicesList = queryDevicesListByIds(ids);
		}
		
		return devicesList;
	}
	
}
