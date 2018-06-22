package com.pcitc.oilmachine.service.modelservice.order;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.afs.base.util.MySpringContextUtil;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.BeanUtil;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.PreAuthorizationMapper;
import com.pcitc.oilmachine.dao.relationdao.RelationMapper;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.PreAuthorization;
import com.pcitc.oilmachine.model.PreAuthorizationExample;
import com.pcitc.oilmachine.model.PreAuthorizationExample.Criteria;
import com.pcitc.oilmachine.service.mobile.CommonService;

/**
 * 预授权结果回调服务类
 * @author zizhi.zhang
 *
 */
@Service
public class PreAuthorizationService {

	@Resource
	private PreAuthorizationMapper preAuthorizationMapper;
	
	@Resource
	private RelationMapper relationMapper;
	/**
	 *  mchCode 商户号
	 * @param orderid 流水号
	 * @param btradeNo 业务订单号
	 * @param accId 交易账号
	 * @param tradeType 交易类型 30-预授权申请 32-预授权完成 31-预授权取消
	 * @param dealresult 处理结果 00-成功；11-失败
	 */
	public void updateCallBackMsg(String mchCode,String sysUserCode,String orderid,String btradeNo, String accId,
			String tradeType, String dealresult)  throws PTPECAppException{
		PreAuthorizationExample pae = new PreAuthorizationExample();
		mchCode = "f652e66ac0714627aa66c58471455680";
		btradeNo = btradeNo.substring(0, btradeNo.length() - 2);
		pae.createCriteria().andTenantidEqualTo(mchCode).andMemcardnumEqualTo(sysUserCode).andAccountidEqualTo(accId).andSalenoEqualTo(btradeNo).andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
		List<PreAuthorization> preAuthorizations = preAuthorizationMapper.selectByExample(pae);
		PreAuthorization pa = null;
		if("30".equals(tradeType)){
			if(preAuthorizations.size() == 1){
				pa = preAuthorizations.get(0);
				pa.setPresqno(orderid);
				pa.setSqopetime(new Date());
				pa.setSqresult(dealresult);
				preAuthorizationMapper.updateByPrimaryKey(pa);
			}else{
				throw new PTPECAppException("同一用户账户查到两张预授权申请单");
			}
		}else if("31".equals(tradeType)){
			if(preAuthorizations.size() == 1){
				pa = preAuthorizations.get(0);
				pa.setPrewcqx(orderid);
				pa.setQxopetime(new Date());
				pa.setQxresult(dealresult);
				preAuthorizationMapper.updateByPrimaryKey(pa);
			}else{
				throw new PTPECAppException("同一用户账户查到两张预授权申请单");
			}
		}else if("32".equals(tradeType)){
			if(preAuthorizations.size() == 1){
				pa = preAuthorizations.get(0);
				pa.setPrewcno(orderid);
				pa.setWcopetime(new Date());
				pa.setWcresult(dealresult);
				preAuthorizationMapper.updateByPrimaryKey(pa);
			}else{
				throw new PTPECAppException("同一用户账户查到两张预授权申请单");
			}
		}else{
			throw new PTPECAppException("暂不支持的回调类型");
		}
	}
	
	/**
	 * 查看预授权结果
	 * @param tenantid租户ID
	 * @param userid 用户ID
	 * @param saleno 订单流水号
	 * @param approveId 下单申请单号
	 * @return
	 * @throws PTPECAppException 
	 */
	public PreAuthorization findPreAuthorization(String tenantid,
			String userid, String saleno) throws PTPECAppException {
		try {
			PreAuthorizationExample pae = new PreAuthorizationExample();
			Criteria criteria = pae.createCriteria().andTenantidEqualTo(tenantid).andUseridEqualTo(userid).andSalenoEqualTo(saleno);
			criteria.andStatusEqualTo(Constant.DEFAULT_VALUE_BYTE);
			List<PreAuthorization> preAuthorizations = preAuthorizationMapper.selectByExample(pae);
			if(preAuthorizations.size() == 1){
				return preAuthorizations.get(0);
			}else{
				throw new Exception("查询到多条或未查到预授权信息：订单号"+saleno);
			}
		} catch (Exception e) {
			throw new PTPECAppException("获取预授权结果信息异常："+e.getMessage(),e);
		}
	}

	/**
	 * 下单数据
	 * @param userid
	 * @param saleno
	 * @param approveId
	 * @param accountid
	 * @param tenantid
	 * @return
	 * @throws PTPECAppException 
	 */
	public PreAuthorization savepreAuthorization(String userid, String memcardnum,String saleno,
			String approveId, String accountid, String tenantid,Long preamount) throws PTPECAppException {
		PreAuthorization pa = new PreAuthorization();
		try {
			String id = StringUtils.makeUUID();
			pa.setId(id);
			pa.setTenantid(tenantid);
			pa.setUserid(userid);
			pa.setSaleno(saleno);
			pa.setAccountid(accountid);
			pa.setApproveid(approveId);
			pa.setPreamount(preamount);
			pa.setMemcardnum(memcardnum);
			pa.setStatus(Constant.DEFAULT_VALUE_BYTE);
			pa.setSorts(Constant.DEFAULT_VALUE_LONG);
			pa.setCreator(userid);
			pa.setUpdateuser(userid);
			pa.setUpdatetime(new Date());
			pa.setCreatedate(new Date());
			preAuthorizationMapper.insert(pa);
		} catch (Exception e) {
			throw new PTPECAppException("保存预授权申请信息异常："+e.getMessage(),e);
		}
		return pa;
	}

	/**
	 * 查询预授权申请成功的订单，但未完成加油的订单，取消预授权申请
	 */
	public void selectAndPreQX() {
		PreAuthorization pa = new PreAuthorization();
		Map<String, Object> condition = BeanUtil.objectToMap(pa);
		List<PreAuthorization> list = relationMapper.selectPreAuthorizationList(condition);
		CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
		Devices devices = null;
		if(list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				devices = new Devices();
				devices.setTenantid( list.get(i).getTenantid());
				String userid = list.get(i).getUserid();
				String accountid = list.get(i).getAccountid();
				String saleno = list.get(i).getSaleno();
				//预授权取消
				commonService.ntranpreAuthorizationQX(userid,accountid, saleno, devices);
			}	
		}
	}
}
