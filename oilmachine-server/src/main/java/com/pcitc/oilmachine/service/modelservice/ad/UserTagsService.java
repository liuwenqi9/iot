package com.pcitc.oilmachine.service.modelservice.ad;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.certificate.BusinessException;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.UserTagsMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.form.MobileResultInfo;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.UserTags;
import com.pcitc.oilmachine.model.UserTagsExample;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.view.GridData;


@Service
public class UserTagsService extends BaseService {

	@Resource
	private UserTagsMapper userTagsMapper;
	
	@Resource
	private RelationMapper relationMapper;
	/**
	 * 查询列表
	 * 
	 * @param userTags
	 */
	public GridData queryUserTagsListPage(UserTags userTags) {
		GridData gridData = new GridData();
		UserTagsExample example = new UserTagsExample();
		Map<String, Object> condition = BeanUtil.objectToMap(userTags);
		example.createCriteria().andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		int total = userTagsMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = userTags.getLength();
		int start = userTags.getStart();
		gridData.setLength(length);
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		List<UserTags> selectUserTagsPageList = relationMapper.selectUserTagsPageList(condition);
		gridData.setData(selectUserTagsPageList);
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
					UserTags userTags = new UserTags();
					userTags.setUsertagsid(id);
					userTags.setUpdatetime(date);
					userTags.setUpdateuser(userid);
					userTags.setStatus((byte)1);
					userTagsMapper.updateByPrimaryKeySelective(userTags);
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
	 * 保存
	 * 
	 * @param userTags
	 * @return 
	 */
	public void save(UserTags userTags, UserInfo userinfo) {
		String userid = userinfo.getUserid();
		// 获得主键
		String classId = UUID.randomUUID().toString();
		classId = classId.replace("-", "");
		userTags.setUsertagsid(classId);
		Date date = new Date();
		userTags.setCreatedate(date);
		userTags.setUpdatetime(date);
		userTags.setSorts(Constant.DEFAULT_VALUE_LONG);
		userTags.setStatus(Constant.DEFAULT_VALUE_BYTE);
		userTags.setCreator(userid);
		userTags.setUpdateuser(userid);
		// 保存数据
		checkDbSuccess(userTagsMapper.insert(userTags));
	}

	/**
	 * 更新
	 * 
	 * @param userTags
	 * @return
	 */
	public void edit(UserTags userTags,UserInfo userinfo) {
		userTags.setUpdatetime(new Date());
		userTags.setUpdateuser(userinfo.getUserid());
		checkDbSuccess(userTagsMapper.updateByPrimaryKeySelective(userTags));
	}

	/**
	 * 主键查询
	 * 
	 * @param usertagsid
	 *            主键ID
	 * @return UserTags
	 */
	public UserTags getUserTagsById(String usertagsid) {
		return userTagsMapper.selectByPrimaryKey(usertagsid);
	}
	
	/**
	 * 根据用户获取推荐商品信息
	 * @param userids
	 * @return
	 * @throws Exception
	 */
	public MobileResultInfo getUserProductInfo(String userid) throws Exception{
		MobileResultInfo result = new MobileResultInfo();
		result.setFunName("getUserProductInfo");
		try {
				if(StringUtils.isBlank(userid)){
					throw new BusinessException("参数错误：userid");
				}
				JSONArray jsonArrData = new JSONArray();
				if(userid.equals("5fead6141ab8481b9c1cf739e09a27c9")){//张自志
					//根据用户id查询推荐商品信息List
					JSONObject item = new JSONObject();
					item.put("PluID", "10152832");
					item.put("PluCode", "8307100010152832");
					item.put("PluAbbrName", "天祥高山堂/椴树蜂蜜胶瓶/850g");	
					item.put("Unit", "瓶");	
					item.put("Spec", "850g");	
					jsonArrData.add(item);
				}else if(userid.equals("18acd06b9a4c4b67a2e285c3ceb5b227")){//郑建维
					//根据用户id查询推荐商品信息List
					JSONObject item = new JSONObject();
					item.put("PluID", "10152800");
					item.put("PluCode", "8307020010152800");
					item.put("PluAbbrName", "贵茶/特级上等绿宝石烟条装/3g");	
					item.put("Unit", "盒");	
					item.put("Spec", "3g");	
					jsonArrData.add(item);
				}else if(userid.equals("ceeb2c19e6524dcbb8dd5e5ec837ea45")){//刘健权
					//根据用户id查询推荐商品信息List
					JSONObject item = new JSONObject();
					item.put("PluID", "10152794");
					item.put("PluCode", "8307020010152794");
					item.put("PluAbbrName", "贵茶/极品条装/105g");	
					item.put("Unit", "盒");	
					item.put("Spec", "105g");	
					jsonArrData.add(item);
				}else{
					//根据用户id查询推荐商品信息List
					JSONObject item = new JSONObject();
					item.put("PluID", "10151507");
					item.put("PluCode", "8305060010151507");
					item.put("PluAbbrName", "江南每食/多味花生(烤肉)/58g");	
					item.put("Unit", "袋");	
					item.put("Spec", "58g");
					jsonArrData.add(item);
				}
			result.setCode(0);
			result.setSuccess(jsonArrData.toJSONString());
		} catch(JSONException e){
			result.setError("数据格式不正确");
		}catch(BusinessException e){
			result.setError(e.getMessage());
		}
		return result;
	}
}
