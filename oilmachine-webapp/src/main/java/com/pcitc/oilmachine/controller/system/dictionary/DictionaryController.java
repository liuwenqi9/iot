package com.pcitc.oilmachine.controller.system.dictionary;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.controller.BaseAction;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.Dictionary;
import com.pcitc.oilmachine.service.dictionary.DictionaryService;
import com.pcitc.oilmachine.view.GridData;


/**
 * 字典表维护控制器
 * 
 * @author xianlin.sun
 * @ClassName :DictionaryController
 * @Version 版本
 * @date 2018年4月2日 下午2:51:45
 */
@Controller
@RequestMapping("/dictionary")
public class DictionaryController extends BaseAction {

	@Resource
	private DictionaryService dictionaryService;
	
	
	/**
	 * 跳转列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/dictionaryPage")
	public String dictionaryPage() {
		return "view/dictionary/dictionarylist";
	}

	/**
	 * 跳转添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "view/dictionary/dictionaryinfo";
	}

	/**
	 * 跳转编辑页面
	 * 
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/editPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView editPage(Dictionary dictionary) {
		String dictionaryid = dictionary.getDictionaryid();
		ModelAndView modelAndView = new ModelAndView("view/dictionary/dictionaryinfo");
		if (StringUtils.isNotBlank(dictionaryid)) {
			Dictionary bean = dictionaryService.findById(dictionaryid);
			modelAndView.addObject("Dictionary", bean);
		}
		return modelAndView;
	}

	/**
	 * 列表
	 * 
	 * @param dictionary      查询条件对象
	 */
	@ResponseBody
	@RequestMapping(value = "/dictionaryList", produces = {"application/text;charset=UTF-8" })
	public String dictionaryList(Dictionary dictionary) {
		GridData gridData = new GridData();
		try {
			gridData = dictionaryService.queryDictionaryListPage(dictionary);
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
			dictionaryService.delete(ids,userinfo);
			json.put("status", true);
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
	 * @param dictionary 保存对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", produces = {"application/text;charset=UTF-8" })
	public String add(Dictionary dictionary) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			dictionaryService.save(dictionary, userinfo);
			json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}

	/**
	 * 修改
	 * 
	 * @param dictionary
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", produces = {"application/text;charset=UTF-8" })
	public String edit(Dictionary dictionary) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			dictionaryService.edit(dictionary,userinfo);
		    json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
	
}
