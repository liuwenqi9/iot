package com.pcitc.oilmachine.service.modelservice.ad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.AdInfoDetailMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.AdInfoDetail;
import com.pcitc.oilmachine.model.AdInfoDetailExample;
import com.pcitc.oilmachine.model.AdInfoDetailExample.Criteria;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.service.oss.FileStoreConfigure;
import com.pcitc.oilmachine.service.oss.OssImgUtil;
import com.pcitc.oilmachine.service.oss.common.ConTentType;
import com.pcitc.oilmachine.view.GridData;


@Service
public class AdInfoDetailService extends BaseService {

	@Resource
	private AdInfoDetailMapper adInfoDetailMapper;
	
	@Resource
	private RelationMapper relationMapper;
	
	/**
	 * 查询广告明细信息列表
	 * 
	 * @param adInfoDetail
	 */
	public GridData queryAdInfoListPage(AdInfoDetail adInfoDetail) {
		GridData gridData = new GridData();
		AdInfoDetailExample example = new AdInfoDetailExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(adInfoDetail);
		if(StringUtils.isNotBlank(adInfoDetail.getAdinfoid())){
			createCriteria.andAdinfoidEqualTo(adInfoDetail.getAdinfoid());
			condition.put("adinfoid", adInfoDetail.getAdinfoid());
		}else{
			return gridData;
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		int total = adInfoDetailMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = adInfoDetail.getLength();
		int start = adInfoDetail.getStart();
		gridData.setLength(length);
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		//查询
		List<AdInfoDetail> selectAdInfoDetailPageList = relationMapper.selectAdInfoDetailPageList(condition);
		gridData.setData(selectAdInfoDetailPageList);
		return gridData;
	}
	
	/**
	 * 查询总列表
	 * @return
	 */
	public List<AdInfoDetail> findAdInfoDetailList(){
		AdInfoDetailExample example = new AdInfoDetailExample();
		example.createCriteria().andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		return adInfoDetailMapper.selectByExample(example);
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
					AdInfoDetail adInfoDetail = new AdInfoDetail();
					adInfoDetail.setAdinfodetailid(id);
					adInfoDetail.setUpdatetime(date);
					adInfoDetail.setUpdateuser(userid);
					adInfoDetail.setStatus((byte)1);
					this.deleteFileById(id);
					adInfoDetailMapper.updateByPrimaryKeySelective(adInfoDetail);
				}
		}
	}
	
	/**
	 * 保存广告
	 * 
	 * @param adInfoDetail
	 * @return 
	 * @throws PTPECAppException 
	 * @throws IOException 
	 */
	public void save(AdInfoDetail adInfoDetail, UserInfo userinfo, MultipartFile file_name) throws PTPECAppException, IOException {
		//上传oss文件
		String path = uploadToOSS(file_name);
		this.addPrefixAddress(adInfoDetail, path);
		// 获得主键
		String classId = UUID.randomUUID().toString();
		classId = classId.replace("-", "");
		adInfoDetail.setAdinfodetailid(classId);
		adInfoDetail.setTenantid(userinfo.getTenantid());
		Date date = new Date();
		adInfoDetail.setCreatedate(date);
		adInfoDetail.setUpdatetime(date);
		adInfoDetail.setStatus(Constant.DEFAULT_VALUE_BYTE);
		String userid = userinfo.getUserid();
		adInfoDetail.setCreator(userid);
		adInfoDetail.setUpdateuser(userid);
		// 保存数据到iot_adinfodetail
		checkDbSuccess(adInfoDetailMapper.insert(adInfoDetail));
	}

	/**
	 * 加图片地址前缀
	 * @param adInfoDetail
	 * @param path
	 * @throws IOException
	 * @throws PTPECAppException
	 */
	private void addPrefixAddress(AdInfoDetail adInfoDetail, String path) throws IOException, PTPECAppException {
		FileStoreConfigure fileStoreConfigure = new FileStoreConfigure();
		String ImgKey = fileStoreConfigure.getOssDomainName()+"/";
		adInfoDetail.setUrl(ImgKey+path);
	}

	/**
	 * 更新广告明细信息
	 * 
	 * @param adInfoDetail
	 * @return
	 * @throws PTPECAppException 
	 * @throws IOException 
	 */
	public void edit(AdInfoDetail adInfoDetail,UserInfo userinfo, MultipartFile file_name) throws IOException, PTPECAppException {
		if(file_name !=null){
			//先上传，后删除
			String path = uploadToOSS(file_name);
			this.addPrefixAddress(adInfoDetail, path);
			//删除
			this.deleteFileById(adInfoDetail.getAdinfodetailid());
		}
		adInfoDetail.setUpdatetime(new Date());
		adInfoDetail.setUpdateuser(userinfo.getUserid());
		checkDbSuccess(adInfoDetailMapper.updateByPrimaryKeySelective(adInfoDetail));
	}

	/**
	 * 主键查询
	 * 
	 * @param adInfoDetailId
	 *            主键ID
	 * @return AdInfoDetail
	 */
	public AdInfoDetail getAdInfoById(String adInfoDetailId) {
		return adInfoDetailMapper.selectByPrimaryKey(adInfoDetailId);
	}

	/**
	 * 获取商户列表信息
	 * @param tenantid
	 * @return
	 * @throws Exception
	 */
	public String getBuInfo(String tenantid) throws Exception{
		return this.getBusinessInfo(tenantid, null);
	}

	/**
	 * 上传oss
	 * @param file_name
	 * @return
	 * @throws IOException
	 * @throws PTPECAppException
	 */
	private String uploadToOSS(MultipartFile file_name) throws IOException, PTPECAppException{
		File file = this.multipartToFile(file_name);
		InputStream in = new FileInputStream(file);
		String path2 = OssImgUtil.uploadStreamToModule(Constant.OSS_moduleName, in, ".jpg", ConTentType.OSS_IMAGE);
		path2 = path2.replace("//", "/");
		System.out.println(path2);
		return path2;
	}
	
	/**
	 * 删除oss文件
	 * @param url
	 * @throws PTPECAppException
	 */
	private void deleteOSSFile(String url) throws PTPECAppException{
		if(url.indexOf(Constant.OSS_moduleName) != -1){
			url = url.substring(url.indexOf(Constant.OSS_moduleName));
		}
		System.out.println("url路径："+url);
		OssImgUtil.deleteFile(url);
	}
	
	/**
	 * 根据广告明细id删除oss文件
	 * @param id
	 * @throws PTPECAppException
	 */
	private void deleteFileById(String id) throws PTPECAppException{
		AdInfoDetail sele = adInfoDetailMapper.selectByPrimaryKey(id);
		this.deleteOSSFile(sele.getUrl());
	}

	/**
	 * 根据广告id删除广告明细信息
	 * @param adinfoid
	 * @param userinfo
	 * @throws PTPECAppException 
	 */
	public void deleteByAdinfoId(String adinfoid, UserInfo userinfo) throws PTPECAppException {
		AdInfoDetailExample example = new AdInfoDetailExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andAdinfoidEqualTo(adinfoid);
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		List<AdInfoDetail> selectByExample = adInfoDetailMapper.selectByExample(example);
		String ids = "";
		for (AdInfoDetail adInfoDetail : selectByExample) {
			ids += adInfoDetail.getAdinfodetailid() + ",";
		}
		ids.substring(0, ids.length()-1);
		this.delete(ids, userinfo);
	}

}
