package com.pcitc.oilmachine.service.modelservice.ad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.AdInfoTagsMapper;
import com.pcitc.oilmachine.dao.AdTagsMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.AdInfo;
import com.pcitc.oilmachine.model.AdInfoTags;
import com.pcitc.oilmachine.model.AdInfoTagsExample;
import com.pcitc.oilmachine.model.AdTags;
import com.pcitc.oilmachine.model.AdTagsExample;
import com.pcitc.oilmachine.model.AdTagsExample.Criteria;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.view.GridData;


@Service
public class AdTagsService extends BaseService {

	@Resource
	private AdTagsMapper adTagsMapper;
	
	@Resource
	private AdInfoTagsMapper adInfoTagsMapper;
	
	@Resource
	private AdInfoService adInfoService;
	
	@Resource
	private RelationMapper relationMapper;
	
	/**
	 * 查询广告标签列表
	 * 
	 * @param adTags
	 * @param adinfoid 
	 * @throws Exception 
	 */
	public GridData queryAdTagsListPage(AdTags adTags, String adinfoid) throws Exception {
		GridData gridData = new GridData();
		
		List<String> list = new ArrayList<String>();
		AdInfoTagsExample example2 = new AdInfoTagsExample();
		com.pcitc.oilmachine.model.AdInfoTagsExample.Criteria createCriteria2 = example2.createCriteria();
		if(StringUtils.isNotBlank(adinfoid)){
			createCriteria2.andAdinfoidEqualTo(adinfoid);
			createCriteria2.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
			List<AdInfoTags> adinfotags = adInfoTagsMapper.selectByExample(example2);
			if(adinfotags != null && adinfotags.size() != 0){
				for (AdInfoTags adInfoTags2 : adinfotags) {
					list.add(adInfoTags2.getAdtagcode());
				}
				AdTagsExample example = new AdTagsExample();
				Criteria createCriteria = example.createCriteria();
				createCriteria.andAdtagcodeIn(list);
				Map<String, Object> condition = BeanUtil.objectToMap(adTags);
//				String subList = list.toString().substring(1, list.toString().indexOf("]"));
				String ids = "";//解决传入String时分割后的字符串('0002', ' 0005') 0005前面的空格
				for (int i = 0; i < list.size(); i++) {
					String string = list.get(i);
					ids += string +",";
				}
				if(ids != ""){
					ids = ids.substring(0, ids.length()-1);
				}
				condition.put("adtagcode", ids);
				if(StringUtils.isNotBlank(adTags.getTenantid())){
					createCriteria.andTenantidEqualTo(adTags.getTenantid());
					condition.put("tenantid", adTags.getTenantid());
				}
				createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
				int total = adTagsMapper.countByExample(example);
				if (total < 1) {
					return gridData;
				}
				gridData.setRecordsFiltered(total);
				gridData.setRecordsTotal(total);
				int length = adTags.getLength();
				int start = adTags.getStart();
				gridData.setLength(length);
				gridData.setStart(start);
				
				condition.put("start", start);
				condition.put("limit", length);
				List<AdTags> selectAdTagsPageList = relationMapper.selectAdTagsPageList(condition);
				gridData.setData(selectAdTagsPageList);
			}
		}
		return gridData;
	}

	/**
	 * 批量删除广告标签（逻辑删除）
	 * 
	 * @param ids
	 */
	public void delete(String ids, UserInfo userinfo) {
		if(StringUtils.isNotBlank(ids)){
				String[] arrayIds = ids.split(",");
				Date date = new Date();
				String userid = userinfo.getUserid();
				for (String id : arrayIds) {
					AdTags adTags = new AdTags();
					adTags.setAdtagsid(id);
					adTags.setUpdatetime(date);
					adTags.setUpdateuser(userid);
					adTags.setStatus((byte)1);
					adTagsMapper.updateByPrimaryKeySelective(adTags);
				}
		}
	}
	
	/**
	 * 保存标签 并 保存 广告标签关系表
	 * 
	 * @param adTags
	 * @param adinfoid 
	 * @return 
	 * @throws Exception 
	 */
	public void save(AdTags adTags, UserInfo userinfo, String adinfoid) throws Exception {
		//根据adtagcode判重
		String adtagcode = adTags.getAdtagcode();
		if(StringUtils.isNotBlank(adtagcode)){
			AdTagsExample example = new AdTagsExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andAdtagcodeEqualTo(adtagcode);
			createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
			int countByExample = adTagsMapper.countByExample(example);
			String tagname = adTags.getTagname();
			if(countByExample == 0){
				//新建标签 并保存 广告标签表
				String userid = userinfo.getUserid();
				// 获得主键
				String classId = UUID.randomUUID().toString();
				classId = classId.replace("-", "");
				adTags.setAdtagsid(classId);
				adTags.setTenantid(userinfo.getTenantid());
				Date date = new Date();
				adTags.setCreatedate(date);
				adTags.setUpdatetime(date);
				adTags.setSorts(Constant.DEFAULT_VALUE_LONG);
				adTags.setStatus(Constant.DEFAULT_VALUE_BYTE);
				adTags.setCreator(userid);
				adTags.setUpdateuser(userid);
				// 保存数据到iot_adtags
				checkDbSuccess(adTagsMapper.insert(adTags));
				//保存广告标签adtagcode tagname adinfoid
				saveAdTags(userinfo, adtagcode, tagname, adinfoid);
			}else{
				//
				List<AdTags> selectByExample = adTagsMapper.selectByExample(example);
				String tagname2 = selectByExample.get(0).getTagname();
				if(tagname2.equals(tagname)){
					//保存广告标签
					saveAdTags(userinfo, adtagcode, tagname, adinfoid);
				}else{
					throw new Exception("该标签编码已存在，请重新填写！");
				}
			}
		}else{
			throw new Exception("标签编码不能为空！");
		}
	}

	/**
	 * 更新广告标签
	 * 
	 * @param adTags
	 * @return
	 */
	public void edit(AdTags adTags,UserInfo userinfo) {
		adTags.setUpdatetime(new Date());
		adTags.setUpdateuser(userinfo.getUserid());
		checkDbSuccess(adTagsMapper.updateByPrimaryKeySelective(adTags));
	}

	/**
	 * 主键查询
	 * 
	 * @param adtagsid
	 *            主键ID
	 * @return AdTags
	 */
	public AdTags getTagsInfoById(String adtagsid) {
		return adTagsMapper.selectByPrimaryKey(adtagsid);
	}

	public List<AdTags> queryAllTagsList(UserInfo userinfo) {
		AdTagsExample example = new AdTagsExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTenantidEqualTo(userinfo.getTenantid());
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		return adTagsMapper.selectByExample(example);
	}
	
	/**
	 * 保存 广告标签 关系表
	 * @param userinfo
	 * @param adtagcode
	 * @param tagname
	 * @param adinfoid
	 */
	private void saveAdTags(UserInfo userinfo, String adtagcode, String tagname, String adinfoid) {
		AdInfoTagsExample example = new AdInfoTagsExample();
		com.pcitc.oilmachine.model.AdInfoTagsExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andAdtagcodeEqualTo(adtagcode);
		createCriteria.andAdinfoidEqualTo(adinfoid);
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		int countByExample = adInfoTagsMapper.countByExample(example);
		if(countByExample == 0){
			AdInfo adinfo = adInfoService.getAdInfoById(adinfoid);
			AdInfoTags adInfoTags = new AdInfoTags();
			adInfoTags.setTagname(tagname);
			adInfoTags.setAdname(adinfo.getAdname());
			adInfoTags.setAdinfoid(adinfoid);
			adInfoTags.setAdtagcode(adtagcode);
			// 获得主键
			String classId = UUID.randomUUID().toString();
			classId = classId.replace("-", "");
			adInfoTags.setAdinfotagsid(classId);
			adInfoTags.setTenantid(userinfo.getTenantid());
			Date date = new Date();
			adInfoTags.setCreatedate(date);
			adInfoTags.setUpdatetime(date);
			adInfoTags.setSorts(Constant.DEFAULT_VALUE_LONG);
			adInfoTags.setStatus(Constant.DEFAULT_VALUE_BYTE);
			String userid = userinfo.getUserid();
			adInfoTags.setCreator(userid);
			adInfoTags.setUpdateuser(userid);
			// 保存数据到iot_adinfotags
			checkDbSuccess(adInfoTagsMapper.insert(adInfoTags));
		}
	}
}
