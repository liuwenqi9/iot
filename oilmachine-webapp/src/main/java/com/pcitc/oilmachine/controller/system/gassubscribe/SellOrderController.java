package com.pcitc.oilmachine.controller.system.gassubscribe;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pcitc.oilmachine.controller.BaseAction;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.SellDiscounts;
import com.pcitc.oilmachine.model.SellOrder;
import com.pcitc.oilmachine.model.SellOrderView;
import com.pcitc.oilmachine.model.SellProduct;
import com.pcitc.oilmachine.service.modelservice.order.SellDiscountsService;
import com.pcitc.oilmachine.service.modelservice.order.SellOrderService;
import com.pcitc.oilmachine.service.modelservice.order.SellProductService;
import com.pcitc.oilmachine.view.GridData;

@Controller
@RequestMapping("/sellorder")
public class SellOrderController extends BaseAction{

	@Resource
	private SellOrderService sellOrderService;
	
	@Resource
	private SellProductService sellProductService;
	
	@Resource
	private SellDiscountsService sellDiscountsService;
	
	
	@RequestMapping("/sellOrderListPage")
	public String gasOrderListPage(){
		return "view/gassubscribe/sellorderlist";
	}
	
	/**
	 * 订单显示
	 * @param sellorder
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sellorderlist")
	public String gasorderlist(SellOrderView sellorder){
		GridData gridData = null;
		UserInfo userInfo = this.getUserInfo();
		try{
			gridData = sellOrderService.getSellOrderPageList(sellorder, userInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return writeGridData(gridData);
	}
	
	/**
	 * 跳转添加页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addPage", produces = {"application/text;charset=UTF-8" })
	public ModelAndView addPage(SellOrder sellorder) {
		ModelAndView modelAndView = new ModelAndView("view/gassubscribe/sellorderdetailslist");
		return modelAndView;
	}
	
	/**
	 * 根据销售订单流水号查询商品信息
	 * @param sellorder
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sellProductlist")
	public String sellProductlist(SellProduct sellProduct){
		GridData gridData = null;
		try{
			gridData = sellProductService.getSellProductPageList(sellProduct);
		}catch(Exception e){
			e.printStackTrace();
		}
		return writeGridData(gridData);
	}
	
	/**
	 * 根据订单流水号查询优惠信息
	 * @param selldiscounts
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sellDiscountslist")
	public String sellDiscountslist(SellDiscounts selldiscounts){
		GridData gridData = null;
		try{
			gridData = sellDiscountsService.getSellDiscountsPageList(selldiscounts);
		}catch(Exception e){
			e.printStackTrace();
		}
		return writeGridData(gridData);
	}
}
