package com.pcitc.oilmachine.controller.system.ad;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.exception.BusinessException;
import com.pcitc.oilmachine.controller.BaseAction;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.UserTags;
import com.pcitc.oilmachine.service.modelservice.ad.UserTagsService;
import com.pcitc.oilmachine.view.GridData;


/**
 * 用户特征控制器
 * 
 * @author xianlin.sun
 * @ClassName :UsertagsController
 * @Version 版本
 * @date 2018年3月16日 上午9:34:00
 */
@Controller
@RequestMapping("/usertags")
public class UsertagsController extends BaseAction {

	@Resource
	private UserTagsService userTagsService;
	
	
	/**
	 * 跳转列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/usertagsPage")
	public String usertagsPage() {
		return "view/ad/usertags/usertagslist";
	}

	/**
	 * 跳转添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "view/ad/usertags/usertagsinfo";
	}

	/**
	 * 跳转编辑页面
	 * 
	 * @param userTags
	 * @return
	 */
	@RequestMapping(value = "/editPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView editPage(UserTags userTags) {
		String usertagsid = userTags.getUsertagsid();
		ModelAndView modelAndView = new ModelAndView("view/ad/usertags/usertagsinfo");
		if (StringUtils.isNotBlank(usertagsid)) {
			UserTags bean = userTagsService.getUserTagsById(usertagsid);
			modelAndView.addObject("UserTags", bean);
		}
		return modelAndView;
	}

	/**
	 * 列表
	 * 
	 * @param userTags      查询条件对象
	 */
	@ResponseBody
	@RequestMapping(value = "/usertagsList", produces = {"application/text;charset=UTF-8" })
	public String usertagsList(UserTags userTags) {
		GridData gridData = null;
		try {
			gridData = userTagsService.queryUserTagsListPage(userTags);
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
			userTagsService.delete(ids,userinfo);
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
	 * 新增
	 * 
	 * @param userTags 保存对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", produces = {"application/text;charset=UTF-8" })
	public String add(UserTags userTags) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			userTagsService.save(userTags, userinfo);
			json.put("status", true);
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
	 * @param userTags
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", produces = {"application/text;charset=UTF-8" })
	public String edit(UserTags userTags) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			userTagsService.edit(userTags,userinfo);
		    json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
	
}
