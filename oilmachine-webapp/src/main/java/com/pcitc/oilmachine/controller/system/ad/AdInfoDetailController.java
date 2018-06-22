package com.pcitc.oilmachine.controller.system.ad;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.exception.BusinessException;
import com.pcitc.oilmachine.controller.BaseAction;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.AdInfoDetail;
import com.pcitc.oilmachine.service.modelservice.ad.AdInfoDetailService;
import com.pcitc.oilmachine.view.GridData;


/**
 * 广告明细信息维护控制器
 * 
 * @author xianlin.sun
 * @ClassName :AdInfoController
 * @Version 版本
 * @date 2018年3月12日 上午10:24:25
 */
@Controller
@RequestMapping("/adinfodetail")
public class AdInfoDetailController extends BaseAction {

	@Resource
	private AdInfoDetailService adInfoDetailService;

	/**
	 * 跳转广告添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "view/ad/adinfo/adinfodetail";
	}

	/**
	 * 跳转编辑页面
	 * 
	 * @param adInfoId
	 * @return
	 */
	@RequestMapping(value = "/editPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView editPage(AdInfoDetail detail) {
		String adinfodetailid = detail.getAdinfodetailid();
		ModelAndView modelAndView = new ModelAndView("view/ad/adinfo/adinfodetail");
		if (StringUtils.isNotBlank(adinfodetailid)) {
			AdInfoDetail adInfoDetail = adInfoDetailService.getAdInfoById(adinfodetailid);
			modelAndView.addObject("adInfoDetail", adInfoDetail);
		}
		return modelAndView;
	}

	/**
	 * 广告明细信息列表
	 * 
	 * @param adInfoDetail      查询条件对象
	 */
	@ResponseBody
	@RequestMapping(value = "/adinfodetailList", produces = {"application/text;charset=UTF-8" })
	public String adinfodetailList(AdInfoDetail adInfoDetail) {
		GridData gridData = null;
		try {
			gridData = adInfoDetailService.queryAdInfoListPage(adInfoDetail);
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
			adInfoDetailService.delete(ids,userinfo);
			json.put("status", true);
		} catch (BusinessException ex) {
			json.put("status", false);
			json.put("msg", ex.getMsg());
			ex.printStackTrace();
		}catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
	
	/**
	 * 新增广告
	 * 
	 * @param adInfoDetail 保存对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add",method = RequestMethod.POST, produces = {"application/text;charset=UTF-8" })
	public String add(AdInfoDetail adInfoDetail, MultipartFile file_name) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			if(file_name != null){
				adInfoDetailService.save(adInfoDetail, userinfo,file_name);
				json.put("status", true);
			}else{
				json.put("status", false);
				json.put("msg", "上传文件不能为空！");
			}
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}

	/**
	 * 修改广告
	 * 
	 * @param adInfoDetail
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/edit",method = RequestMethod.POST, produces = {"application/text;charset=UTF-8" })
	public String edit(AdInfoDetail adInfoDetail, MultipartFile file_name) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			adInfoDetailService.edit(adInfoDetail,userinfo,file_name);
		    json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}

}
