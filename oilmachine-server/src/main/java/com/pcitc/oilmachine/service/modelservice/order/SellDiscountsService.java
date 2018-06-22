package com.pcitc.oilmachine.service.modelservice.order;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.SellDiscountsMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.model.SellDiscounts;
import com.pcitc.oilmachine.model.SellDiscountsExample;
import com.pcitc.oilmachine.model.UserLoginfo;
import com.pcitc.oilmachine.model.SellDiscountsExample.Criteria;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.view.GridData;

@Service
public class SellDiscountsService extends BaseService{

	@Resource
	private SellDiscountsMapper sellDiscountsMapper;
	
	@Resource
	private RelationMapper relationMapper;

	/**
	 * 根据订单流水号查询订单优惠信息
	 * @param selldiscounts
	 * @return
	 */
	public GridData getSellDiscountsPageList(SellDiscounts selldiscounts) {
		GridData gridData = new GridData();
		SellDiscountsExample example = new SellDiscountsExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(selldiscounts);
		if(StringUtils.isNotBlank(selldiscounts.getSaleno())){
			createCriteria.andSalenoEqualTo(selldiscounts.getSaleno());
			condition.put("saleno", selldiscounts.getSaleno());
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		condition.put("status", Constant.DEFAULT_VALUE_BYTE);
		int total = sellDiscountsMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = selldiscounts.getLength();
		int start = selldiscounts.getStart();
		gridData.setLength(length);
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		List<SellDiscounts> selectSellProductList = relationMapper.selectSellDiscountsList(condition);
		gridData.setData(selectSellProductList);
		return gridData;
	}

	public SellDiscounts saveSelDiscounts(SellDiscounts selldiscounts,UserLoginfo userLoginInfo) throws PTPECAppException {
		try {
			Date date = new Date();
			selldiscounts.setId(StringUtils.makeUUID());
			selldiscounts.setCreatedate(date);
			selldiscounts.setUpdatetime(date);
			selldiscounts.setSorts(Constant.DEFAULT_VALUE_LONG);
			selldiscounts.setStatus(Constant.DEFAULT_VALUE_BYTE);
			selldiscounts.setCreator(userLoginInfo.getUserid());
			selldiscounts.setUpdateuser(userLoginInfo.getUserid());
			sellDiscountsMapper.insert(selldiscounts);
		} catch (Exception e) {
			throw new PTPECAppException("保存订单优惠信息异常："+e.getMessage(),e);
		}
		return selldiscounts;
	}
}
