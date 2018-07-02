package com.pcitc.oilmachine.service.modelservice.devices;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.NozzleStatusMapper;
import com.pcitc.oilmachine.model.NozzleStatus;
import com.pcitc.oilmachine.service.BaseService;

@Service
public class NozzleStatusService extends BaseService{

	@Resource
	private NozzleStatusMapper nozzleStatusMapper;
	
	public NozzleStatus saveOrupdate(NozzleStatus nozzleStatus,String username){
		String id = nozzleStatus.getId();
		Date date = new Date();
		if(StringUtils.isBlank(id)){
			id = StringUtils.makeUUID();
			nozzleStatus.setId(id);
			nozzleStatus.setStatus(Constant.DEFAULT_VALUE_BYTE);
			nozzleStatus.setSorts(Constant.DEFAULT_VALUE_LONG);
			nozzleStatus.setCreatedate(date);
			nozzleStatus.setUpdatetime(date);
			nozzleStatus.setCreator(username);
			nozzleStatus.setUpdateuser(username);
			nozzleStatusMapper.insert(nozzleStatus);
		}else{
			NozzleStatus nozzleStatusTemp = nozzleStatusMapper.selectByPrimaryKey(id);
			if(nozzleStatusTemp == null){
				id = StringUtils.makeUUID();
				nozzleStatus.setId(id);
				nozzleStatus.setStatus(Constant.DEFAULT_VALUE_BYTE);
				nozzleStatus.setSorts(Constant.DEFAULT_VALUE_LONG);
				nozzleStatus.setCreatedate(date);
				nozzleStatus.setUpdatetime(date);
				nozzleStatus.setCreator(username);
				nozzleStatus.setUpdateuser(username);
				nozzleStatusMapper.insert(nozzleStatus);
			}else{
				nozzleStatusTemp.setNodecode(nozzleStatus.getNodecode());
				nozzleStatusTemp.setNodetag(nozzleStatus.getNodetag());
				nozzleStatusTemp.setTenantid(nozzleStatus.getTenantid());
				nozzleStatusTemp.setDeviceconnid(nozzleStatus.getDeviceconnid());
				nozzleStatusTemp.setNozzleno(nozzleStatus.getNozzleno());
				nozzleStatusTemp.setNozzlestatus(nozzleStatus.getNozzlestatus());
				nozzleStatusTemp.setVtot(nozzleStatus.getVtot());
				nozzleStatusTemp.setUpdatetime(date);
				nozzleStatusTemp.setUpdateuser(username);
				nozzleStatus = nozzleStatusTemp;
				nozzleStatusMapper.updateByPrimaryKey(nozzleStatusTemp);
			}
			
		}
		return nozzleStatus;
	}
}
