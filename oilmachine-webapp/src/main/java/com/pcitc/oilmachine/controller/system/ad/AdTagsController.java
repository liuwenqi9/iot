package com.pcitc.oilmachine.controller.system.ad;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.exception.BusinessException;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.controller.BaseAction;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.AdTags;
import com.pcitc.oilmachine.service.modelservice.ad.AdTagsService;
import com.pcitc.oilmachine.view.GridData;


/**
 * 广告标签控制器
 * 
 * @author xianlin.sun
 * @ClassName :AdTagsController
 * @Version 版本
 * @date 2018年3月14日 上午11:11:47
 */
@Controller
@RequestMapping("/adtags")
public class AdTagsController extends BaseAction {

	@Resource
	private AdTagsService adTagsService;
	
	
	/**
	 * 跳转列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/adTagsPage")
	public ModelAndView adTagsPage(String adinfoid) {
		ModelAndView modelAndView = new ModelAndView("view/ad/adinfo/adtags");//adtagsinfo
		modelAndView.addObject("adinfoid", adinfoid);
		return modelAndView;
	}

	/**
	 * 跳转添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "view/ad/adinfo/tagsinfo";
	}

	/**
	 * 跳转编辑页面
	 * 
	 * @param adInfoId
	 * @return
	 */
	@RequestMapping(value = "/editPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView editPage(AdTags adTags) {
		String adtagsid = adTags.getAdtagsid();
		ModelAndView modelAndView = new ModelAndView("view/ad/adinfo/tagsinfo");
		if (StringUtils.isNotBlank(adtagsid)) {
			AdTags adInfoById = adTagsService.getTagsInfoById(adtagsid);
			modelAndView.addObject("adInfo", adInfoById);
		}
		return modelAndView;
	}

	/**
	 * 列表
	 * 
	 * @param adTags      查询条件对象
	 */
	@ResponseBody
	@RequestMapping(value = "/adtagsList", produces = {"application/text;charset=UTF-8" })
	public String adtagsList(AdTags adTags, String adinfoid) {
		GridData gridData = null;
		try {
			gridData = adTagsService.queryAdTagsListPage(adTags, adinfoid);
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
			adTagsService.delete(ids,userinfo);
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
	 * 新增标签
	 * 
	 * @param adTags 保存对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addtags", produces = {"application/text;charset=UTF-8" })
	public String addtags(AdTags adTags, String adinfoid) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			if(StringUtils.isNotBlank(adinfoid) && StringUtils.isNotBlank(adTags.getAdtagcode()) && StringUtils.isNotBlank(adTags.getTagname())){
				adTagsService.save(adTags, userinfo, adinfoid);
				json.put("status", true);
			}else{
				json.put("status", false);
				json.put("msg", "参数不能为空！");
			}
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}

	/**
	 * 修改标签
	 * 
	 * @param adTags
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", produces = {"application/text;charset=UTF-8" })
	public String edit(AdTags adTags) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			adTagsService.edit(adTags,userinfo);
		    json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllTagsList", produces = {"application/text;charset=UTF-8" })
	public String getAllTagsList() {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			List<AdTags> value = adTagsService.queryAllTagsList(userinfo);
		    json.put("status", true);
		    json.put("msg", value);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return json.toJSONString();
	}

}
