package com.pcitc.oilmachine.service.modelservice.order;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.PosRecordMapper;
import com.pcitc.oilmachine.model.PosRecord;
import com.pcitc.oilmachine.model.PosRecordExample;
import com.pcitc.oilmachine.model.PosRecordExample.Criteria;

import org.springframework.stereotype.Service;

/**
 * 加油机成交记录
 * @author zhzhi.zhang
 *
 */
@Service
public class PosRecordService {
	
	@Resource
	private PosRecordMapper posRecordMapper;
	
	/**
	 * 保存加油机成交记录
	 * @param posRecord
	 * @return
	 * @throws PTPECAppException 
	 */
	public PosRecord insertPosRecord(PosRecord posRecord) throws PTPECAppException{
		try {
			PosRecordExample pre = new PosRecordExample();
			Criteria createCriteria =  pre.createCriteria();
			createCriteria.andTenantidEqualTo(posRecord.getTenantid()).andStncodeEqualTo(posRecord.getStncode()).andOrderstatusEqualTo((byte)1).andPosttcEqualTo(posRecord.getPosttc()).andNznEqualTo(posRecord.getNzn());
			List<PosRecord> prs = posRecordMapper.selectByExample(pre);
			if(prs.size() >= 1) {
				return prs.get(0);
			}
			posRecord.setId(StringUtils.makeUUID());
			posRecord.setStatus(Constant.DEFAULT_VALUE_BYTE);
			posRecord.setSorts(Constant.DEFAULT_VALUE_LONG);
			Date date = new Date();
			posRecord.setCreatedate(date);
			posRecord.setUpdatetime(date);
			posRecordMapper.insert(posRecord);
			return posRecord;
		} catch (Exception e) {
			throw new PTPECAppException("保存加油机成交记录信息异常："+e.getMessage(),e);
		}
	}
	
	public List<PosRecord> getPosRecord(String tenantid, String stncode,
			String deviceidconnid, Long nozzleno) throws PTPECAppException{
		try{
			PosRecordExample pre = new PosRecordExample();
			Criteria createCriteria =  pre.createCriteria();
			createCriteria.andTenantidEqualTo(tenantid).andStncodeEqualTo(stncode).andOrderstatusEqualTo((byte)1).andSalenoNotEqualTo("0");
			if(StringUtils.isNotBlank(deviceidconnid)){
				createCriteria.andDeviceconnidEqualTo(deviceidconnid);
			}
			if(nozzleno != null){
				createCriteria.andNznEqualTo(nozzleno);
			}
			return posRecordMapper.selectByExample(pre);
		}catch(Exception e){
			throw new PTPECAppException("获取加油机成交记录信息异常："+e.getMessage(),e);
		}
		
	}
	
	public List<PosRecord> getPosRecord(String tenantid,String saleno) throws PTPECAppException{
		try{
			PosRecordExample pre = new PosRecordExample();
			Criteria createCriteria =  pre.createCriteria();
			createCriteria.andTenantidEqualTo(tenantid).andSalenoEqualTo(saleno).andOrderstatusEqualTo((byte)1).andSalenoNotEqualTo("0");
			return posRecordMapper.selectByExample(pre);
		}catch(Exception e){
			throw new PTPECAppException("获取加油机成交记录信息异常："+e.getMessage(),e);
		}
		
	}
	
	public PosRecord updatePosRecord(PosRecord posRecord,String username)  throws PTPECAppException{
		try {
			posRecord.setUpdatetime(new Date());
			posRecord.setUpdateuser(username);
			posRecordMapper.updateByPrimaryKey(posRecord);
		}catch(Exception e) {
			throw new PTPECAppException("更新加油机成交记录信息异常："+e.getMessage(),e);
		}
		return posRecord;
	}

}
