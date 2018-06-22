package com.pcitc.oilmachine.service.dictionary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.afs.base.util.MySpringContextUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.DictionaryDataMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.enums.DictionaryEnum;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.Dictionary;
import com.pcitc.oilmachine.model.DictionaryData;
import com.pcitc.oilmachine.model.DictionaryDataExample;
import com.pcitc.oilmachine.model.DictionaryDataExample.Criteria;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.view.GridData;


@Service
public class DictionaryDataService extends BaseService {

	@Resource
	private DictionaryDataMapper dictionaryDataMapper;
	
	@Resource
	private DictionaryService dictionaryService;
	
	@Resource
	private RelationMapper relationMapper;
	
	/**
	 * 查询列表
	 * 
	 * @param dictionaryData
	 */
	public GridData queryDictionaryDataListPage(DictionaryData dictionaryData) {
		GridData gridData = new GridData();
		DictionaryDataExample example = new DictionaryDataExample();
		Criteria createCriteria = example.createCriteria();
		if(StringUtils.isBlank(dictionaryData.getDictId()) && !"1".equals(dictionaryData.getDictId())){
			return gridData;
		}
		Map<String, Object> condition = BeanUtil.objectToMap(dictionaryData);
		if(StringUtils.isNotBlank(dictionaryData.getItemCode())){
			createCriteria.andItemCodeEqualTo(dictionaryData.getItemCode());
			condition.put("itemcode", dictionaryData.getItemCode());
		}
		if(StringUtils.isNotBlank(dictionaryData.getItemName())){
			createCriteria.andItemNameLike(dictionaryData.getItemName());
			condition.put("itemname", dictionaryData.getItemName());
		}
		if(StringUtils.isNotBlank(dictionaryData.getDictId())){
			createCriteria.andDictIdEqualTo(dictionaryData.getDictId());
			condition.put("dictid", dictionaryData.getDictId());
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		int total = dictionaryDataMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = dictionaryData.getLength();
		int start = dictionaryData.getStart();
		gridData.setLength(length);
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		List<DictionaryData> list = relationMapper.selectDictionaryDataPageList(condition);
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
					DictionaryData dictionaryData = new DictionaryData();
					dictionaryData.setDictionarydataid(id);
					dictionaryData.setUpdatetime(date);
					dictionaryData.setUpdateuser(userid);
					dictionaryData.setStatus((byte)1);
					//先删除缓存
					DictionaryData findById = this.findById(id);
					Dictionary findById2 = dictionaryService.findById(findById.getDictId());
					this.deleteRedis(findById2.getDicCode(), findById, userinfo.getTenantid());
					//后删除数据
					checkDbSuccess(dictionaryDataMapper.updateByPrimaryKeySelective(dictionaryData));
				}
		}
	}
	
	/**
	 * 保存
	 * 
	 * @param dictionaryData
	 * @return 
	 * @throws Exception 
	 */
	public void save(DictionaryData dictionaryData, UserInfo userinfo) throws Exception {
		//code 判重
		Boolean boo = validateCodeExist(dictionaryData, dictionaryData.getItemCode());
		if(boo){//true 存在
			throw new Exception("该编码已存在！");
		}
		// 获得主键
		String classId = UUID.randomUUID().toString();
		classId = classId.replace("-", "");
		dictionaryData.setDictionarydataid(classId);
		Date date = new Date();
		dictionaryData.setCreatedate(date);
		dictionaryData.setUpdatetime(date);
		dictionaryData.setStatus(Constant.DEFAULT_VALUE_BYTE);
		dictionaryData.setSorts(Constant.DEFAULT_VALUE_BYTE);
		String userid = userinfo.getUserid();
		dictionaryData.setCreator(userid);
		dictionaryData.setUpdateuser(userid);
		// 保存数据
		checkDbSuccess(dictionaryDataMapper.insert(dictionaryData));
		//判断是否保存redis
		this.refreshRedis(dictionaryData, userinfo);
	}

	/**
	 * 新增、修改时，itemCode判重
	 * @param dictionarydataid
	 * @param itemCode
	 * @return
	 */
	private Boolean validateCodeExist(DictionaryData dictionaryData, String itemCode) {
		if(StringUtils.isNotBlank(dictionaryData.getDictionarydataid())){
			DictionaryData findById = this.findById(dictionaryData.getDictionarydataid());
			if(itemCode.equalsIgnoreCase(findById.getItemCode())){
				return false;
			}
		}
		DictionaryDataExample example = new DictionaryDataExample();
		example.createCriteria().andDictIdEqualTo(dictionaryData.getDictId()).andItemCodeEqualTo(itemCode).andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		int count = dictionaryDataMapper.countByExample(example);
		if(count > 0){
			return true;
		}
		return false;
	}

	/**
	 * 新增、修改后 执行 判断是否存入redis
	 * @param dictionaryData
	 * @param userinfo
	 */
	private void refreshRedis(DictionaryData dictionaryData, UserInfo userinfo) {
		Dictionary findById = dictionaryService.findById(dictionaryData.getDictId());
		if(1 == findById.getIscache()){
			this.saveToRedis(findById.getDicCode(), dictionaryData, userinfo.getTenantid());
		}else{
			this.deleteRedis(findById.getDicCode(), dictionaryData, userinfo.getTenantid());
		}
	}

	/**
	 * 更新
	 * 
	 * @param dictionaryData
	 * @return
	 * @throws Exception 
	 */
	public void edit(DictionaryData dictionaryData,UserInfo userinfo) throws Exception {
		//code 判重
		Boolean boo = validateCodeExist(dictionaryData, dictionaryData.getItemCode());
		if(boo){//true 存在
			throw new Exception("该编码已存在！");
		}
		dictionaryData.setUpdatetime(new Date());
		dictionaryData.setUpdateuser(userinfo.getUserid());
		checkDbSuccess(dictionaryDataMapper.updateByPrimaryKeySelective(dictionaryData));
		this.refreshRedis(dictionaryData, userinfo);
	}

	/**
	 * 主键查询
	 * 
	 * @param dictionarydataid
	 *            主键ID
	 * @return DictionaryData
	 */
	public DictionaryData findById(String dictionarydataid) {
		return dictionaryDataMapper.selectByPrimaryKey(dictionarydataid);
	}

	/**
	 * 保存至redis
	 * @param dicCode
	 * @param dictionaryData
	 * @param tenantid
	 */
	public void saveToRedis(String dicCode, DictionaryData dictionaryData, String tenantid) {
		StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) MySpringContextUtil.getBean("stringRedisTemplate");
		BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(dicCode+tenantid);
		hashOpertions.put(dictionaryData.getItemCode(), JSON.toJSONString(dictionaryData));
	}
	
	/**
	 * 删除redis
	 * @param dicCode
	 * @param dictionaryData
	 * @param tenantid
	 */
	public void deleteRedis(String dicCode, DictionaryData dictionaryData, String tenantid) {
		StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) MySpringContextUtil.getBean("stringRedisTemplate");
		BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(dicCode+tenantid);
		hashOpertions.delete(dictionaryData.getItemCode());
	}

	/**
	 * 更新dictionaryid下所有redis
	 * @param dictionary
	 * @param userinfo
	 */
	public void refreshRedisAll(Dictionary dictionary, UserInfo userinfo) {
		List<DictionaryData> list = this.findByDicid(dictionary.getDictionaryid());
		if(1 == dictionary.getIscache()){
			for (DictionaryData dictionaryData : list) {
				this.saveToRedis(dictionary.getDicCode(), dictionaryData, userinfo.getTenantid());
			}
		}else{
			for (DictionaryData dictionaryData : list) {
				this.deleteRedis(dictionary.getDicCode(), dictionaryData, userinfo.getTenantid());
			}
		}
	}

	/**
	 * 删除dictionaryid下所有redis
	 * @param dictionary
	 * @param userinfo
	 */
	public void deleteRedisAll(Dictionary dictionary, UserInfo userinfo) {
		List<DictionaryData> list = this.findByDicid(dictionary.getDictionaryid());
		for (DictionaryData dictionaryData : list) {
			this.deleteRedis(dictionary.getDicCode(), dictionaryData, userinfo.getTenantid());
		}
	}
	
	/**
	 * 根据字典id查询字典明细信息列表
	 * @param dictionaryid
	 * @return
	 */
	public List<DictionaryData> findByDicid(String dictionaryid) {
		DictionaryDataExample example = new DictionaryDataExample();
		example.createCriteria().andDictIdEqualTo(dictionaryid).andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		return dictionaryDataMapper.selectByExample(example);
	}

	/**
	 * 查询字典明细列表（先取缓存，缓存没值则取表）
	 * @param code				必传
	 * @param tenantid			必传
	 * @return
	 * @throws Exception
	 */
	public List<DictionaryData> getDataListByDiccode(DictionaryEnum code, String tenantid) throws Exception {
		if(StringUtils.isNotBlank(code.toString()) && StringUtils.isNotBlank(tenantid)){
			List<DictionaryData> list = new ArrayList<DictionaryData>();
			StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) MySpringContextUtil.getBean("stringRedisTemplate");
			BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(code+tenantid);
			Set<String> keys = hashOpertions.keys();
			if(keys != null && keys.size() != 0){
				for (String key : keys) {
					String value = hashOpertions.get(key);
					DictionaryData parseObject = JSONObject.parseObject(value, DictionaryData.class);
					list.add(parseObject);
				}
			}else{
				Dictionary dictionary = new Dictionary();
				dictionary.setTenantid(tenantid);
				dictionary.setDicCode(code.toString());
				List<Dictionary> dict = dictionaryService.findDictionaryList(dictionary);
				if(dict != null && dict.size() != 0){
					dictionary = dict.get(0);
					DictionaryDataExample example = new DictionaryDataExample();
					Criteria createCriteria = example.createCriteria();
					createCriteria.andDictIdEqualTo(dictionary.getDictionaryid());
					createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
					list = dictionaryDataMapper.selectByExample(example);
				}else{
					throw new Exception("查询失败：未查询到字典信息！");
				}
			}
			return list;
		}else{
			throw new Exception("查询失败：参数缺失！");
		}
	}

	/**
	 * 根据字典编码和明细编码 查询对象
	 * @param dcode			必传
	 * @param datacode		必传
	 * @param tenantid		必传
	 * @return
	 * @throws Exception
	 */
	public DictionaryData getDataByDoubleCode(DictionaryEnum dcode, String datacode, String tenantid) throws Exception{
		if(StringUtils.isNotBlank(dcode.toString()) && StringUtils.isNotBlank(datacode) && StringUtils.isNotBlank(tenantid)){
			StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) MySpringContextUtil.getBean("stringRedisTemplate");
			BoundHashOperations<String, String, String> hashOpertions = stringRedisTemplate.boundHashOps(dcode+tenantid);
			String string = hashOpertions.get(datacode);
			if(StringUtils.isNotBlank(string)){
					return JSONObject.parseObject(string, DictionaryData.class);
			}else{
				Dictionary dictionary = new Dictionary();
				dictionary.setTenantid(tenantid);
				dictionary.setDicCode(dcode.toString());
				List<Dictionary> dict = dictionaryService.findDictionaryList(dictionary);
				if(dict != null && dict.size() != 0){
					dictionary = dict.get(0);
					DictionaryDataExample example = new DictionaryDataExample();
					Criteria createCriteria = example.createCriteria();
					createCriteria.andDictIdEqualTo(dictionary.getDictionaryid());
					createCriteria.andItemCodeEqualTo(datacode);
					createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
					List<DictionaryData> selectByExample = dictionaryDataMapper.selectByExample(example);
					if(selectByExample != null && selectByExample.size() != 0){
						return selectByExample.get(0);
					}else{
						return null;
					}
				}else{
					return null;
				}
			}
		}else{
			throw new Exception("查询失败：参数缺失！");
		}
	}

		/**
		 * 根据日志编码查询的字典明细信息
		 * @param dictionary
		 * @return
		 * @throws Exception
		 */
		public List<DictionaryData> getLogListByDiccode(Dictionary dictionary) throws Exception {
			if(StringUtils.isNotBlank(dictionary.getDicCode()) && StringUtils.isNotBlank(dictionary.getTenantid())){
					List<DictionaryData> list = new ArrayList<DictionaryData>();
					List<Dictionary> dict = dictionaryService.findDictionaryList(dictionary);
					if(dict != null && dict.size() != 0){
						dictionary = dict.get(0);
						DictionaryDataExample example = new DictionaryDataExample();
						Criteria createCriteria = example.createCriteria();
						createCriteria.andDictIdEqualTo(dictionary.getDictionaryid());
						createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
						list = dictionaryDataMapper.selectByExample(example);
					}else{
						throw new Exception("查询失败：未查询到字典信息！");
					}
				return list;
			}else{
				throw new Exception("查询失败：参数缺失！");
			}
		}
}
