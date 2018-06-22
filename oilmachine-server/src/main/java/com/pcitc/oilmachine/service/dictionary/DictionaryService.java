package com.pcitc.oilmachine.service.dictionary;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.DictionaryMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.Dictionary;
import com.pcitc.oilmachine.model.DictionaryExample;
import com.pcitc.oilmachine.model.DictionaryExample.Criteria;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.view.GridData;


@Service
public class DictionaryService extends BaseService {

	@Resource
	private DictionaryMapper dictionaryMapper;
	
	@Resource
	private RelationMapper relationMapper;
	
	@Resource
	private DictionaryDataService dictionaryDataService;
	
	/**
	 * 查询列表
	 * 
	 * @param dictionary
	 */
	public GridData queryDictionaryListPage(Dictionary dictionary) {
		GridData gridData = new GridData();
		DictionaryExample example = new DictionaryExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(dictionary);
		if(StringUtils.isNotBlank(dictionary.getDicName())){
			createCriteria.andDicNameLike(dictionary.getDicName());
			condition.put("dicname", dictionary.getDicName());
		}
		if(StringUtils.isNotBlank(dictionary.getDicCode())){
			createCriteria.andDicCodeEqualTo(dictionary.getDicCode());
			condition.put("diccode", dictionary.getDicCode());
		}
		if(StringUtils.isNotBlank(dictionary.getTenantid())){
			createCriteria.andTenantidEqualTo(dictionary.getTenantid());
			condition.put("tenantid", dictionary.getTenantid());
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		int total = dictionaryMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = dictionary.getLength();
		int start = dictionary.getStart();
		gridData.setLength(length);
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		List<Dictionary> list = relationMapper.selectDictionaryPageList(condition);
		gridData.setData(list);
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
					Dictionary dictionary = new Dictionary();
					dictionary.setDictionaryid(id);
					dictionary.setUpdatetime(date);
					dictionary.setUpdateuser(userid);
					dictionary.setStatus((byte)1);
					//先 删除redis
					this.deleteRedis(id, userinfo);
					//后删除数据
					checkDbSuccess(dictionaryMapper.updateByPrimaryKeySelective(dictionary));
				}
		}
	}
	
	/**
	 * 保存
	 * 
	 * @param dictionary
	 * @return 
	 * @throws Exception 
	 */
	public void save(Dictionary dictionary, UserInfo userinfo) throws Exception {
			String dicCode = dictionary.getDicCode();
			DictionaryExample example = new DictionaryExample();
			example.createCriteria().andDicCodeEqualTo(dicCode).andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
			List<Dictionary> selectByExample = dictionaryMapper.selectByExample(example);
			if(selectByExample != null && selectByExample.size() != 0){
				throw new Exception("该编码已存在！");
			}else{
				// 获得主键
				String classId = UUID.randomUUID().toString();
				classId = classId.replace("-", "");
				dictionary.setDictionaryid(classId);
				Date date = new Date();
				dictionary.setCreatedate(date);
				dictionary.setUpdatetime(date);
				dictionary.setStatus(Constant.DEFAULT_VALUE_BYTE);
				dictionary.setSorts(Constant.DEFAULT_VALUE_BYTE);
				dictionary.setTenantid(userinfo.getTenantid());
				String userid = userinfo.getUserid();
				dictionary.setCreator(userid);
				dictionary.setUpdateuser(userid);
				// 保存数据
				checkDbSuccess(dictionaryMapper.insert(dictionary));
			}
	}

	/**
	 * 更新
	 * 
	 * @param dictionary
	 * @return
	 */
	public void edit(Dictionary dictionary,UserInfo userinfo) {
		dictionary.setUpdatetime(new Date());
		dictionary.setUpdateuser(userinfo.getUserid());
		checkDbSuccess(dictionaryMapper.updateByPrimaryKeySelective(dictionary));
		this.refreshRedis(dictionary.getDictionaryid(), userinfo);
	}

	/**
	 * 主键查询
	 * 
	 * @param dictionaryid
	 *            主键ID
	 * @return Dictionary
	 */
	public Dictionary findById(String dictionaryid) {
		return dictionaryMapper.selectByPrimaryKey(dictionaryid);
	}

	/**
	 * 刷新dictionaryid下redis缓存
	 */
	public void refreshRedis(String dictionaryid, UserInfo userinfo){
		Dictionary findById = this.findById(dictionaryid);
		if(1 == findById.getIscache()){//更新
			dictionaryDataService.refreshRedisAll(findById, userinfo);
		}else{//删除
			dictionaryDataService.deleteRedisAll(findById, userinfo);
		}
	}
	
	/**
	 * 删除dictionaryid下所有redis
	 * @param dictionaryid
	 * @param userinfo
	 */
	public void deleteRedis(String dictionaryid, UserInfo userinfo){
		Dictionary findById = this.findById(dictionaryid);
		dictionaryDataService.deleteRedisAll(findById, userinfo);
	}

	/**
	 * 查询对象列表
	 * @param dictionary		条件
	 * @return
	 */
	public List<Dictionary> findDictionaryList(Dictionary dictionary){
		DictionaryExample example = new DictionaryExample();
		this.addWhere(dictionary, example);
		return dictionaryMapper.selectByExample(example);
	}

	/**
	 * 添加条件
	 * @param dictionary
	 * @param createCriteria
	 */
	private void addWhere(Dictionary dictionary, DictionaryExample example) {
		Criteria createCriteria = example.createCriteria();
		if(StringUtils.isNotBlank(dictionary.getDictionaryid())){
			createCriteria.andDictionaryidEqualTo(dictionary.getDictionaryid());
		}
		if(StringUtils.isNotBlank(dictionary.getDicCode())){
			createCriteria.andDicCodeEqualTo(dictionary.getDicCode());
		}
		if(StringUtils.isNotBlank(dictionary.getDicName())){
			createCriteria.andDicNameLike(dictionary.getDicName());
		}
		if(StringUtils.isNotBlank(dictionary.getTenantid())){
			createCriteria.andTenantidEqualTo(dictionary.getTenantid());
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
	}
	
}
