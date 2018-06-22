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
import com.pcitc.oilmachine.model.AdInfo;
import com.pcitc.oilmachine.service.modelservice.ad.AdInfoService;
import com.pcitc.oilmachine.view.GridData;


/**
 * 广告维护控制器
 * 
 * @author xianlin.sun
 * @ClassName :AdInfoController
 * @Version 版本
 * @date 2018年3月6日 上午10:02:23
 */
@Controller
@RequestMapping("/adinfo")
public class AdInfoController extends BaseAction {

	@Resource
	private AdInfoService adInfoService;
	
	
	/**
	 * 跳转广告列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/adinfoPage")
	public String adinfoPage() {
		return "view/ad/adinfo/adinfolist";
	}

	/**
	 * 跳转广告添加页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView addPage() {
		UserInfo userInfo = this.getUserInfo();
		ModelAndView modelAndView = new ModelAndView("view/ad/adinfo/adinfo");
		try {
			String buInfo = adInfoService.getBuInfo(userInfo.getTenantid());
			JSONObject parseObject = JSONObject.parseObject(buInfo, JSONObject.class);
			modelAndView.addObject("buInfo", parseObject.get("msg"));
			modelAndView.addObject("success", parseObject.get("success"));
		} catch (Exception e) {
			modelAndView.addObject("buInfo", e.getMessage());
			modelAndView.addObject("success", false);
			e.printStackTrace();
		}
		return modelAndView;
	}

	/**
	 * 跳转编辑页面
	 * 
	 * @param adInfoId
	 * @return
	 */
	@RequestMapping(value = "/editPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView editPage(AdInfo adInfo) {
		String adinfoid = adInfo.getAdinfoid();
		ModelAndView modelAndView = new ModelAndView("view/ad/adinfo/adinfo");
		if (StringUtils.isNotBlank(adinfoid)) {
			AdInfo adInfoById = adInfoService.getAdInfoById(adinfoid);
			modelAndView.addObject("adInfo", adInfoById);
			UserInfo userinfo = this.getUserInfo();
			try {
				String buInfo = adInfoService.getBuInfo(userinfo.getTenantid());
				JSONObject parseObject = JSONObject.parseObject(buInfo, JSONObject.class);
				modelAndView.addObject("buInfo", parseObject.get("msg"));
				modelAndView.addObject("success", parseObject.get("success"));
			} catch (Exception e) {
				modelAndView.addObject("buInfo", e.getMessage());
				modelAndView.addObject("success", false);
				e.printStackTrace();
			}
		}
		return modelAndView;
	}

	/**
	 * 广告列表
	 * 
	 * @param adInfo      查询条件对象
	 */
	@ResponseBody
	@RequestMapping(value = "/adinfoList", produces = {"application/text;charset=UTF-8" })
	public String adinfoList(AdInfo adInfo) {
		GridData gridData = null;
		try {
			gridData = adInfoService.queryAdInfoListPage(adInfo);
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
			adInfoService.delete(ids,userinfo);
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
	 * @param adInfo 保存对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", produces = {"application/text;charset=UTF-8" })
	public String add(AdInfo adInfo) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			adInfoService.save(adInfo, userinfo);
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
	 * @param adInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", produces = {"application/text;charset=UTF-8" })
	public String edit(AdInfo adInfo) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			adInfoService.edit(adInfo,userinfo);
		    json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
	
}
