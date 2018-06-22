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
import com.pcitc.oilmachine.model.DictionaryData;
import com.pcitc.oilmachine.service.dictionary.DictionaryDataService;
import com.pcitc.oilmachine.view.GridData;


/**
 * 字典明细表维护控制器
 * 
 * @author xianlin.sun
 * @ClassName :DictionaryDataController
 * @Version 版本
 * @date 2018年4月2日 下午2:51:45
 */
@Controller
@RequestMapping("/dictionarydata")
public class DictionaryDataController extends BaseAction {

	@Resource
	private DictionaryDataService dictionaryDataService;
	
	
	/**
	 * 跳转列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/dictionarydataPage")
	public String dictionarydataPage() {
		return "view/dictionary/dictionarydatalist";
	}

	/**
	 * 跳转添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "view/dictionary/dictionarydatainfo";
	}

	/**
	 * 跳转编辑页面
	 * 
	 * @param dictionaryData
	 * @return
	 */
	@RequestMapping(value = "/editPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView editPage(DictionaryData dictionaryData) {
		String dictionarydataid = dictionaryData.getDictionarydataid();
		ModelAndView modelAndView = new ModelAndView("view/dictionary/dictionarydatainfo");
		if (StringUtils.isNotBlank(dictionarydataid)) {
			DictionaryData bean = dictionaryDataService.findById(dictionarydataid);
			modelAndView.addObject("DictionaryData", bean);
		}
		return modelAndView;
	}

	/**
	 * 列表
	 * 
	 * @param dictionaryData      查询条件对象
	 */
	@ResponseBody
	@RequestMapping(value = "/dictionarydataList", produces = {"application/text;charset=UTF-8" })
	public String dictionarydataList(DictionaryData dictionaryData) {
		GridData gridData = null;
		try {
			gridData = dictionaryDataService.queryDictionaryDataListPage(dictionaryData);
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
			dictionaryDataService.delete(ids,userinfo);
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
	 * @param dictionaryData 保存对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", produces = {"application/text;charset=UTF-8" })
	public String add(DictionaryData dictionaryData) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			dictionaryDataService.save(dictionaryData, userinfo);
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
	 * @param dictionaryData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", produces = {"application/text;charset=UTF-8" })
	public String edit(DictionaryData dictionaryData) {
		JSONObject json = new JSONObject();
		UserInfo userinfo = this.getUserInfo();
		try {
			dictionaryDataService.edit(dictionaryData,userinfo);
		    json.put("status", true);
		} catch (Exception e) {
			json.put("status", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
	}
	
}
