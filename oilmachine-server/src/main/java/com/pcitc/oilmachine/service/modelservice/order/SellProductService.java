package com.pcitc.oilmachine.service.modelservice.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.SellProductMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.model.SellDiscounts;
import com.pcitc.oilmachine.model.SellOrder;
import com.pcitc.oilmachine.model.SellProduct;
import com.pcitc.oilmachine.model.SellProductExample;
import com.pcitc.oilmachine.model.SellProductExample.Criteria;
import com.pcitc.oilmachine.model.UserLoginfo;
import com.pcitc.oilmachine.service.BaseService;
import com.pcitc.oilmachine.view.GridData;

@Service
public class SellProductService extends BaseService{

	@Resource
	private SellProductMapper sellProductMapper;
	
	@Resource
	private RelationMapper relationMapper;

	public SellProduct saveSellProduct(UserLoginfo userLoginInfo,
			SellOrder sellOrder,String liter,SellDiscounts selldiscounts) throws PTPECAppException {
		try {
			SellProduct sp = new SellProduct();
			sp.setId(StringUtils.makeUUID());
			sp.setTenantid(sellOrder.getTenantid());
			sp.setUserid(userLoginInfo.getUserid());
			sp.setSaleno(sellOrder.getSaleno());
			sp.setProductname(userLoginInfo.getOilno());
			sp.setProductcode(userLoginInfo.getOilcode());
			sp.setProductprice(userLoginInfo.getPrice());
			sp.setVolume(new BigDecimal(liter));
			sp.setMeasure((byte)0);
			sp.setYhtotal(selldiscounts.getDiscountsamount());
			sp.setYstotal(sellOrder.getYstotal());
			sp.setSstotal(sellOrder.getYstotal() - selldiscounts.getDiscountsamount());
			sp.setStatus(Constant.DEFAULT_VALUE_BYTE);
			sp.setSorts(Constant.DEFAULT_VALUE_LONG);
			sp.setCreator(userLoginInfo.getUserid());
			sp.setUpdateuser(userLoginInfo.getUserid());
			sp.setUpdatetime(new Date());
			sp.setCreatedate(new Date());
			sellProductMapper.insert(sp);
			return sp;
		} catch (Exception e) {
			throw new PTPECAppException("保存订单商品信息异常："+e.getMessage(),e);
		}
	}

	/**
	 * 根据订单流水号查询商品明细信息
	 * @param sellProduct
	 * @return
	 */
	public GridData getSellProductPageList(SellProduct sellProduct) {
		GridData gridData = new GridData();
		SellProductExample example = new SellProductExample();
		Criteria createCriteria = example.createCriteria();
		Map<String, Object> condition = BeanUtil.objectToMap(sellProduct);
		if(StringUtils.isNotBlank(sellProduct.getSaleno())){
			createCriteria.andSalenoEqualTo(sellProduct.getSaleno());
			condition.put("saleno", sellProduct.getSaleno());
		}
		createCriteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		condition.put("status", Constant.DEFAULT_VALUE_BYTE);
		int total = sellProductMapper.countByExample(example);
		if (total < 1) {
			return gridData;
		}
		gridData.setRecordsFiltered(total);
		gridData.setRecordsTotal(total);
		int length = sellProduct.getLength();
		int start = sellProduct.getStart();
		gridData.setLength(length);
		gridData.setStart(start);

		condition.put("start", start);
		condition.put("limit", length);
		List<SellProduct> selectSellProductList = relationMapper.selectSellProductList(condition);
		gridData.setData(selectSellProductList);
		return gridData;
	}
}
