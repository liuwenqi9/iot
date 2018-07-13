package com.pcitc.oilmachine.service.modelservice.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.afs.base.util.MySpringContextUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.SellOrderMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.form.UserInfo;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.PosRecord;
import com.pcitc.oilmachine.model.SellDiscounts;
import com.pcitc.oilmachine.model.SellOrder;
import com.pcitc.oilmachine.model.SellOrderExample;
import com.pcitc.oilmachine.model.SellOrderExample.Criteria;
import com.pcitc.oilmachine.model.SellOrderView;
import com.pcitc.oilmachine.model.UserLoginfo;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.service.mobile.CommonService;
import com.pcitc.oilmachine.view.GridData;

@Service
public class SellOrderService extends BaseService{

	@Resource
	private SellOrderMapper sellOrderMapper;
	
	@Resource
	private RelationMapper relationMapper;

	public SellOrder saveSellOrder(UserLoginfo userLoginInfo,
			Devices devices, Long total, String saleno,SellDiscounts selldiscounts) throws PTPECAppException {
		SellOrder sellOrder  = null;
		try {
			sellOrder = new SellOrder();
			sellOrder.setId(StringUtils.makeUUID());
			sellOrder.setTenantid(userLoginInfo.getTenantid());
			sellOrder.setUserid(userLoginInfo.getUserid());
			sellOrder.setCarnum(userLoginInfo.getCarnum());
			sellOrder.setStncode(userLoginInfo.getStncode());
			sellOrder.setStnname(userLoginInfo.getStnname());
			//获取预授申请单信息
			sellOrder.setSaleno(userLoginInfo.getSaleno());
			sellOrder.setOpetime(new Date());
			sellOrder.setDeviceid(devices.getConnid());
			sellOrder.setNozzleno(userLoginInfo.getNozzleno());
			sellOrder.setYhtotal(selldiscounts.getDiscountsamount());
			sellOrder.setYstotal(total);
			sellOrder.setSstotal(total - selldiscounts.getDiscountsamount());
			sellOrder.setPaytypecode("0001");
			sellOrder.setPaytypename("电子钱包");
			sellOrder.setAccountid(userLoginInfo.getAccountid());
			sellOrder.setStatus(Constant.DEFAULT_VALUE_BYTE);
			sellOrder.setSorts(Constant.DEFAULT_VALUE_LONG);
			sellOrder.setCreator(userLoginInfo.getUserid());
			sellOrder.setUpdateuser(userLoginInfo.getUserid());
			sellOrder.setUpdatetime(new Date());
			sellOrder.setCreatedate(new Date());
			sellOrderMapper.insert(sellOrder);
		} catch (Exception e) {
			throw new PTPECAppException("保存订单信息异常："+e.getMessage(),e);
		}
		//调用预授权完成接口
		return sellOrder;
	}
	
	public SellOrder saveSellOrder(PosRecord posRecord,String payway,String paywayname,long ystotal,String paycardno) throws PTPECAppException {
		SellOrder sellOrder  = null;
		try {
			sellOrder = new SellOrder();
			sellOrder.setId(StringUtils.makeUUID());
			sellOrder.setTenantid(posRecord.getTenantid());
			sellOrder.setUserid(posRecord.getUserid());
			String carnums = posRecord.getCarnums();
			JSONArray cararr = JSONObject.parseArray(carnums);
			if(cararr.size() == 1) {
				JSONObject car = (JSONObject)cararr.get(0);
				sellOrder.setCarnum(car.getString("carnum"));
			}
			
			sellOrder.setStncode(posRecord.getStncode());
			//sellOrder.setStnname(userLoginInfo.getStnname());
			//获取预授申请单信息
			sellOrder.setSaleno(posRecord.getSaleno());
			sellOrder.setOpetime(new Date());
			sellOrder.setDeviceid(posRecord.getDeviceconnid());
			sellOrder.setNozzleno(String.valueOf(posRecord.getNzn()));
			sellOrder.setYhtotal(0l);
			sellOrder.setYstotal(ystotal);
			sellOrder.setSstotal(ystotal);
			sellOrder.setPaytypecode(payway);
			sellOrder.setPaytypename(paywayname);
			sellOrder.setAccountid(paycardno);
			sellOrder.setStatus(Constant.DEFAULT_VALUE_BYTE);
			sellOrder.setSorts(Constant.DEFAULT_VALUE_LONG);
			sellOrder.setCreator("admin");
			sellOrder.setUpdateuser("admin");
			sellOrder.setUpdatetime(new Date());
			sellOrder.setCreatedate(new Date());
			sellOrderMapper.insert(sellOrder);
		} catch (Exception e) {
			throw new PTPECAppException("保存订单信息异常："+e.getMessage(),e);
		}
		//调用预授权完成接口
		return sellOrder;
	}

	/**
	 * 根据用户 及加油流水号查寻用户订单信息
	 * @param tenantid
	 * @param userid
	 * @param saleno
	 * @return
	 */
	public SellOrder querySellOrder(String tenantid, String userid,String accountid,
			String saleno) {
		SellOrderExample sqe = new SellOrderExample();
		sqe.createCriteria().andTenantidEqualTo(tenantid).andUseridEqualTo(userid).andAccountidEqualTo(accountid).andSalenoEqualTo(saleno).andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		List<SellOrder> sellOrders = sellOrderMapper.selectByExample(sqe);
		if(sellOrders.size() == 1){
			return sellOrders.get(0);
		}
		return null;
	}

	/**
	 * 查询加油明细默认租户id过滤
	 * @param sellorder
	 * @param userInfo 
	 * @return
	 */
	public GridData getSellOrderPageList(SellOrderView sellorder, UserInfo userInfo) {
		GridData gridData = new GridData();
		SellOrderExample example = new SellOrderExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(sellorder);
		if(StringUtils.isNotBlank(sellorder.getStncode())){
			createCriteria.andStncodeEqualTo(sellorder.getStncode());
			condition.put("stncode", sellorder.getStncode());
		}
		if(StringUtils.isNotBlank(sellorder.getSaleno())){
			createCriteria.andSalenoEqualTo(sellorder.getSaleno());
			condition.put("saleno", sellorder.getSaleno());
		}
		createCriteria.andTenantidEqualTo(userInfo.getTenantid());
		condition.put("tenantid", userInfo.getTenantid());
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		condition.put("status", Constant.DEFAULT_VALUE_BYTE);
		int total = sellOrderMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = sellorder.getLength();
		int start = sellorder.getStart();
		gridData.setLength(length);
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		List<SellOrderView> selectSellOrderList = relationMapper.selectSellOrderList(condition);
		
		//当前登陆用户的租户id只有一个,查询数据中所有用户id 拼接后去会员接口查询
		if(selectSellOrderList.size() > 0){
			//将重复用户id的数据过滤
		    HashSet<SellOrderView> hashSet = new HashSet<>(selectSellOrderList);
	        List<SellOrderView> newList = new ArrayList(hashSet); 
	        List<UserInfo> userinfos = new ArrayList<UserInfo>();
	          //得到集合中所有用户id逗号拼接
	          String userids=null;
	          StringBuilder userid = new StringBuilder();
				for(SellOrderView sellOrderView : newList){
					userid.append("'"+sellOrderView.getUserid()+"',");
				}
				userids = userid.substring(0, userid.length() - 1);
				
				CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
	          try {
				userinfos = commonService.getUserinfo(userInfo.getTenantid(),userids, null, null, null,null);
				} catch (Exception e) {
					e.printStackTrace();
				}
		        //前台显示用户名称  
				for (int i = 0; i < selectSellOrderList.size(); i++) {
					for (int j = 0; j < userinfos.size(); j++) {
						if(selectSellOrderList.get(i).getUserid().equals(userinfos.get(j).getUserid())){
							selectSellOrderList.get(i).setUsername(userinfos.get(j).getUsername());
						}
					}
				}
			}
		gridData.setData(selectSellOrderList);
		return gridData;
	}
}
