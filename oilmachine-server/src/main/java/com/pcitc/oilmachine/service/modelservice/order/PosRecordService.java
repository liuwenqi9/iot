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
		PosRecordExample pre = new PosRecordExample();
		Criteria createCriteria =  pre.createCriteria();
		createCriteria.andTenantidEqualTo(tenantid).andStncodeEqualTo(stncode).andOrderstatusEqualTo((byte)1);
		if(StringUtils.isNotBlank(deviceidconnid)){
			createCriteria.andDeviceconnidEqualTo(deviceidconnid);
		}
		if(nozzleno != null){
			createCriteria.andNznEqualTo(nozzleno);
		}
		return posRecordMapper.selectByExample(pre);
	}

}
