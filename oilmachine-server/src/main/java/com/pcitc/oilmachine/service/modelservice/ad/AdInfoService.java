package com.pcitc.oilmachine.service.modelservice.ad;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.AdInfoMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.AdInfo;
import com.pcitc.oilmachine.model.AdInfoExample;
import com.pcitc.oilmachine.model.AdInfoExample.Criteria;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.view.GridData;


@Service
public class AdInfoService extends BaseService {

	@Resource
	private AdInfoMapper adInfoMapper;
	
	@Resource
	private RelationMapper relationMapper;
	
	@Resource
	private AdInfoDetailService adInfoDetailService;
	
	/**
	 * 查询广告列表
	 * 
	 * @param adInfo
	 */
	public GridData queryAdInfoListPage(AdInfo adInfo) {
		GridData gridData = new GridData();
		AdInfoExample example = new AdInfoExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(adInfo);
		if(StringUtils.isNotBlank(adInfo.getAdname())){
			createCriteria.andAdnameLike(adInfo.getAdname());
			condition.put("adname", adInfo.getAdname());
		}
		if(StringUtils.isNotBlank(adInfo.getBuname())){
			createCriteria.andBunameLike(adInfo.getBuname());
			condition.put("buname", adInfo.getBuname());
		}
		if(adInfo.getIsuse() != null){
			createCriteria.andIsuseEqualTo(adInfo.getIsuse());
			condition.put("isUse", adInfo.getIsuse());
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		int total = adInfoMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = adInfo.getLength();
		int start = adInfo.getStart();
		gridData.setLength(length);
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		List<AdInfo> selectAdInfoPageList = relationMapper.selectAdInfoPageList(condition);
		gridData.setData(selectAdInfoPageList);
		return gridData;
	}

	/**
	 * 批量删除广告（逻辑删除）
	 * 
	 * @param ids
	 * @throws PTPECAppException 
	 */
	public void delete(String ids, UserInfo userinfo) throws PTPECAppException {
		if(StringUtils.isNotBlank(ids)){
				String[] arrayIds = ids.split(",");
				Date date = new Date();
				String userid = userinfo.getUserid();
				for (String id : arrayIds) {
					//删除明细
					adInfoDetailService.deleteByAdinfoId(id, userinfo);
					//删除广告
					AdInfo adInfo = new AdInfo();
					adInfo.setAdinfoid(id);
					adInfo.setUpdatetime(date);
					adInfo.setUpdateuser(userid);
					adInfo.setStatus((byte)1);
					adInfoMapper.updateByPrimaryKeySelective(adInfo);
				}
//				AdInfoExample example = new AdInfoExample();
//				List<String> list = Arrays.asList(arrayIds);
//				example.createCriteria().andAdinfoidIn(list);
//				example.createCriteria().andUpdateuserEqualTo(userinfo.getUsername());
				//删除iot_adinfo表数据
//				checkDbSuccess(adInfoMapper.deleteByExample(example));
		}
	}
	
	/**
	 * 保存广告
	 * 
	 * @param adInfo
	 * @return 
	 * @throws Exception 
	 */
	public void save(AdInfo adInfo, UserInfo userinfo) throws Exception {
		String bucode = adInfo.getBucode();
		String businessInfo = this.getBusinessInfo(null, bucode);
		JSONObject parseObject = JSONObject.parseObject(businessInfo, JSONObject.class);
		Boolean success = parseObject.getBoolean("success");
		if(success){
			JSONObject msg = parseObject.getJSONObject("msg");
			String buid = msg.getString("buid");
			String buname = msg.getString("buname");
			adInfo.setBuid(buid);
			adInfo.setBuname(buname);
			// 获得主键
			String classId = UUID.randomUUID().toString();
			classId = classId.replace("-", "");
			adInfo.setAdinfoid(classId);
			adInfo.setTenantid(userinfo.getTenantid());
			Date date = new Date();
			adInfo.setCreatedate(date);
			adInfo.setUpdatetime(date);
			adInfo.setStatus(Constant.DEFAULT_VALUE_BYTE);
			String userid = userinfo.getUserid();
			adInfo.setCreator(userid);
			adInfo.setUpdateuser(userid);
			adInfo.setIsuse((byte) 0);
			adInfo.setVersion((long) 0);
			// 保存数据到iot_adinfo
			checkDbSuccess(adInfoMapper.insert(adInfo));
		}else{
			System.err.println("商户接口返回信息："+parseObject.toJSONString());
			throw new Exception(parseObject.getString("msg"));
		}
	}

	/**
	 * 更新广告
	 * 
	 * @param adInfo
	 * @return
	 */
	public void edit(AdInfo adInfo,UserInfo userinfo) {
		adInfo.setUpdatetime(new Date());
		adInfo.setUpdateuser(userinfo.getUserid());
		checkDbSuccess(adInfoMapper.updateByPrimaryKeySelective(adInfo));
	}

	/**
	 * 主键查询
	 * 
	 * @param adInfoId
	 *            主键ID
	 * @return AdInfo
	 */
	public AdInfo getAdInfoById(String adInfoId) {
		return adInfoMapper.selectByPrimaryKey(adInfoId);
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
	 * 根据租户id查询广告基本信息
	 * @param tenantid
	 * @return
	 */
	public List<AdInfo> queryListByTenantid(String tenantid) {
		AdInfoExample example = new AdInfoExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTenantidEqualTo(tenantid);
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		createCriteria.andIsuseEqualTo((byte) 1);//0未发布,1已发布
		example.setOrderByClause("sorts");
		return adInfoMapper.selectByExample(example);
	}

}
