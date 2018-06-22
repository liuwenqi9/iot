package com.pcitc.oilmachine.service.modelservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.UserLoginfoMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.model.UserLoginfo;
import com.pcitc.oilmachine.model.UserLoginfoExample;
import com.pcitc.oilmachine.model.UserLoginfoExample.Criteria;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.view.GridData;

@Service
public class UserLoginfoService extends BaseService{

	@Resource
	private UserLoginfoMapper userLoginfoMapper;
	@Resource
	private RelationMapper relationMapper;
	
	/**
	 * 根据用户id查询用户认证的上下文信息
	 * @param userid
	 * @param tenantid
	 * @return
	 * @throws PTPECAppException
	 */
	public UserLoginfo getuserLoginInfo(String userid,String tenantid) throws PTPECAppException{
		try {
			UserLoginfoExample example = new UserLoginfoExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andUseridEqualTo(userid).andTenantidEqualTo(tenantid).andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
			List<UserLoginfo> ulis = userLoginfoMapper.selectByExample(example);
			if(ulis != null && ulis.size() == 1){
				return ulis.get(0);
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new PTPECAppException("查询用户登录信息异常:"+e.getMessage(),e);
		}
	}
	
	public UserLoginfo saveorUpdateUserLoginfo(UserLoginfo userLoginfo) throws PTPECAppException{
		try {
			if(StringUtils.isNotBlank(userLoginfo.getId())){
				userLoginfo.setUpdatetime(new Date());
				userLoginfoMapper.updateByPrimaryKey(userLoginfo);
			}else{
				userLoginfo.setId(StringUtils.makeUUID());
				userLoginfo.setCreatedate(new Date());
				userLoginfo.setUpdatetime(new Date());
				userLoginfo.setStatus((byte)0);
				userLoginfo.setSorts(0l);
				userLoginfoMapper.insert(userLoginfo);
			}
		} catch (Exception e) {
			throw new PTPECAppException("保存或更新用户登录信息异常:"+e.getMessage(),e);
		}
		return userLoginfo;
	}
	
	/**
	 * 
	 * @param userLoginfo
	 * @param userloginstatus  登陆状态  0:登陆中  1:已退出 
	 * @return
	 */
	public GridData queryUserLoginfoListPage(UserLoginfo userLoginfo,int userloginstatus) {
		GridData gridData = new GridData();
		UserLoginfoExample example = new UserLoginfoExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(userLoginfo);
		if(StringUtils.isNotBlank(userLoginfo.getStncode())){
			createCriteria.andStncodeEqualTo(userLoginfo.getStncode());
			condition.put("stncode", userLoginfo.getStncode());
		}
		//查询条件
		if(StringUtils.isNotBlank(userLoginfo.getStnname())){
			createCriteria.andStnnameLike(userLoginfo.getStnname());
			condition.put("stnname", userLoginfo.getStnname());
		}
		if(StringUtils.isNotBlank(userLoginfo.getTenantid())){
			createCriteria.andTenantidEqualTo(userLoginfo.getTenantid());
			condition.put("tenantid", userLoginfo.getTenantid());
		}
		if(StringUtils.isNotBlank(userLoginfo.getUsername())){
			createCriteria.andUsernameEqualTo(userLoginfo.getUsername());
			condition.put("userName", userLoginfo.getUsername());
		}
		if(StringUtils.isNotBlank(userLoginfo.getDeviceconnid())){
			createCriteria.andDeviceconnidEqualTo(userLoginfo.getDeviceconnid());
			condition.put("deviceconnid",userLoginfo.getDeviceconnid());
		}
		if(StringUtils.isNotBlank(userLoginfo.getOilcode())){
			createCriteria.andDeviceconnidEqualTo(userLoginfo.getOilcode());
			condition.put("oilcode", userLoginfo.getOilcode());
		}
		if(StringUtils.isNotBlank(userLoginfo.getCarnum())){
			createCriteria.andCarnumEqualTo(userLoginfo.getCarnum());
			condition.put("carnum", userLoginfo.getCarnum());
		}
		if(userLoginfo.getStatus() != null){//前台下拉框传值
			createCriteria.andStatusEqualTo(userLoginfo.getStatus());
			condition.put("status", userLoginfo.getStatus());
		}
		if(StringUtils.isNotBlank(userLoginfo.getSaleno())){
			createCriteria.andSalenoEqualTo(userLoginfo.getSaleno());
			condition.put("saleno", userLoginfo.getSaleno());
		}
//		if(userloginstatus == 0){//登陆中
//			createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
//			condition.put("status", Constant.DEFAULT_VALUE_BYTE);
//		}
//		if(userloginstatus == 1){//已退出
//			createCriteria.andStatusEqualTo((byte) 1);
//			condition.put("status", (byte) 1);
//		}
		int total = userLoginfoMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = userLoginfo.getLength();
		int start = userLoginfo.getStart();
		if(length != 0){
			gridData.setLength(length);
			condition.put("limit", length);
		}
		gridData.setStart(start);
		condition.put("start", start);
		
		List<UserLoginfo> selectDevicesPageList = relationMapper.selectUserlogininfoPageList(condition);
		//查询当前摄像头是否正常连接
		gridData.setData(selectDevicesPageList);
		return gridData;
	}

	/**
	 * 根据id查询用户登录信息
	 * @param id
	 * @return
	 */
	public UserLoginfo findById(String id) {
		return userLoginfoMapper.selectByPrimaryKey(id);
	}
}
