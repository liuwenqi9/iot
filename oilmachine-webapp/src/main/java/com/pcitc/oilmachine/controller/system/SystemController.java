package com.pcitc.oilmachine.controller.system;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.controller.BaseAction;
import com.pcitc.oilmachine.form.SystemLog;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.Dictionary;
import com.pcitc.oilmachine.model.DictionaryData;
import com.pcitc.oilmachine.model.UserLoginfo;
import com.pcitc.oilmachine.service.dictionary.DictionaryDataService;
import com.pcitc.oilmachine.service.system.SystemService;
import com.pcitc.oilmachine.view.GridData;


/**
 * 系统页面控制器
 * @author zizhi.zhang
 *
 */
@Controller
@RequestMapping("/home")
public class SystemController extends BaseAction {

	private static Logger logger = LogManager.getLogger(SystemController.class);
	
	@Resource
	private SystemService systemService;
	
	@Resource
	private DictionaryDataService dictionaryDataService;

	/**
	 * 首页
	 * 
	 * @author zizhi.zhang
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public String index() throws Exception {
		return "view/index";
	}

	/**
	 * 内容页
	 * 
	 * @author zizhi.zhang
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/detailpage")
	public String detailpage() throws Exception {
		return "layout/detail";

	}
	
	@RequestMapping("/logOut")
	public String logOut(HttpServletRequest request) throws Exception{
		request.getSession().removeAttribute(Constant.SESSION_KEY);
		return "view/index";
	}

	/**
	 * 登陆
	 * @author xianlin.sun
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("/doLogin")
	public void doLogin(String username,String password,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json = new JSONObject();
		String returnmsg = "用户名或密码不能为空！";
		boolean ok = false;
		try {
			if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password) ){
				//用户统一认证
				String userLoginValidate = systemService.userLoginValidate(username,password);
				if(userLoginValidate != ""){
					JSONObject parseObject = JSONObject.parseObject(userLoginValidate, JSONObject.class);
					Boolean success = parseObject.getBoolean("success");
					if(success){
						Boolean msg = parseObject.getBoolean("msg");
						if(msg){
							//验证成功
							String usersInfo = parseObject.getString("usersInfo");
							JSONObject userinfo = JSONObject.parseObject(usersInfo);
							String userid = userinfo.getString("userid");
							String mobilephone = userinfo.getString("mobilephone");
							Integer usertype = userinfo.getInteger("usertype");
							String tenantId = userinfo.getString("tenantId");
							JSONObject orgInfo = userinfo.getJSONObject("orgInfo");
							String orgid = orgInfo.getString("orgid");
							UserInfo info = new UserInfo();
							info.setTenantid(tenantId);
							info.setUsername(username);
							info.setUserid(userid);
							info.setMobilephone(mobilephone);
							info.setIsadmin(usertype==1?true:false);
							info.setOrgid(orgid);
							request.getSession().setAttribute(Constant.SESSION_KEY, info);
							ok = true;
						}else{
							String error = parseObject.getString("error");
							returnmsg = error;
						}
					}else{
						returnmsg = "服务器请求失败，请联系管理员！";
					}
				}else{
					returnmsg = "服务器请求失败，请联系管理员！";
				}
			}
			if(ok){
				response.getWriter().write(json.toJSONString());
			}else{
				System.out.println(returnmsg);
				json.put("error", returnmsg);
				response.getWriter().write(json.toJSONString());
			}
		} catch (Exception e) {
			json.put("error", e.getMessage());
			response.getWriter().write(json.toJSONString());
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取菜单
	 * @author xianlin.sun
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("/createMenu")
	public String createMenu(){
		UserInfo userInfo = this.getUserInfo();
		JSONObject json = new JSONObject();
		try {
			String createMenu = systemService.createMenu(userInfo);
			System.out.println(createMenu);
			json.put("success", true);
			json.put("msg", createMenu);
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return toJSONFormat(json);
		
	}
	
	/**
	 * 跳转用户登录信息页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLoginInfoPage")
	public String userLoginInfoPage() throws Exception {
		return "view/system/userlogininfolist";
	}
	
	/**chengyu.fan
	 * 用户登录信息列表
	 * @param userLoginInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/userlogininfolist", produces = {"application/text;charset=UTF-8" })
	public String userlogininfolist(UserLoginfo  userLoginfo) {
		GridData gridData = null;
		int userloginstatus = 3;
//		UserInfo userInfo = this.getUserInfo();
//		userLoginfo.setTenantid(userInfo.getTenantid());
		try {
			gridData = systemService.getuserLoginList(userLoginfo,userloginstatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeGridData(gridData);
	}
	
	/**
	 * 查询用户登录详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/seeUserDetail", produces = {"application/text;charset=UTF-8" })
	public ModelAndView seeUserDetail(String id, UserLoginfo userLoginfo) {
		ModelAndView modelAndView = new ModelAndView("view/system/userloginfo");
		if (StringUtils.isNotBlank(id)) {
			UserLoginfo user = systemService.findById(id);
			modelAndView.addObject("user", user);
		}
		return modelAndView;
	}
	
	/**
	 * 跳转异常信息页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/systemErrormsgPage")
	public String systemErrormsgPage() throws Exception {
		return "view/system/systemErrormsglist";
	}
	
	
	/**
	 * 异常信息
	 * @param userLoginInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/systemErrormsglist", produces = {"application/text;charset=UTF-8" })
	public String systemErrormsglist(SystemLog systemLog) {
		GridData gridData = null;
		try {
			gridData = systemService.getSystemErrormsgList(systemLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeGridData(gridData);
	}
	
	/**
	 * 下拉框查询信息
	 * @param userLoginInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dictionaryloglist", produces = {"application/json;charset=UTF-8" })
	public String dictionaryloglist(Dictionary dictionary) {
		UserInfo userInfo = this.getUserInfo();
		String tenantid = userInfo.getTenantid();
		dictionary.setTenantid(tenantid);
		 List<DictionaryData> queryLogList = null;
		 JSONArray jsonArrData = new JSONArray();
		try {
			 queryLogList = dictionaryDataService.getLogListByDiccode(dictionary);
			 if(queryLogList.size() > 0){
				for(DictionaryData dictionaryData : queryLogList){
					JSONObject item = new JSONObject();
					item.put("itemCode", dictionaryData.getItemCode());
					item.put("itemValue", dictionaryData.getItemValue());	
					jsonArrData.add(item);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
         return jsonArrData.toJSONString();
	}
}
