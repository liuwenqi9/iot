package com.pcitc.oilmachine.service.modelservice.devices;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.dao.DeviceFaultMapper;
import com.pcitc.oilmachine.model.DeviceFault;
import com.pcitc.oilmachine.service.BaseService;

@Service
public class DeviceFaultService extends BaseService{

	@Resource
	private DeviceFaultMapper deviceFaultMapper;
	
	public DeviceFault saveOrupdate(DeviceFault deviceFault,String username){
		String id = deviceFault.getId();
		Date date = new Date();
		if(StringUtils.isBlank(id)){
			id = StringUtils.makeUUID();
			deviceFault.setId(id);
			deviceFault.setStatus(Constant.DEFAULT_VALUE_BYTE);
			deviceFault.setSorts(Constant.DEFAULT_VALUE_LONG);
			deviceFault.setCreatedate(date);
			deviceFault.setUpdatetime(date);
			deviceFault.setCreator(username);
			deviceFault.setUpdateuser(username);
			deviceFaultMapper.insert(deviceFault);
		}else{
			DeviceFault deviceFaultTemp = deviceFaultMapper.selectByPrimaryKey(id);
			if(deviceFaultTemp == null){
				id = StringUtils.makeUUID();
				deviceFault.setId(id);
				deviceFault.setStatus(Constant.DEFAULT_VALUE_BYTE);
				deviceFault.setSorts(Constant.DEFAULT_VALUE_LONG);
				deviceFault.setCreatedate(date);
				deviceFault.setUpdatetime(date);
				deviceFault.setCreator(username);
				deviceFault.setUpdateuser(username);
				deviceFaultMapper.insert(deviceFault);
			}else{
				deviceFaultTemp.setNodecode(deviceFault.getNodecode());
				deviceFaultTemp.setNodetag(deviceFault.getNodetag());
				deviceFaultTemp.setTenantid(deviceFault.getTenantid());
				deviceFaultTemp.setDeviceconnid(deviceFault.getDeviceconnid());
				deviceFaultTemp.setFaulttypecode(deviceFault.getFaulttypecode());
				deviceFaultTemp.setFaulttypename(deviceFault.getFaulttypename());
				deviceFaultTemp.setCodeno(deviceFault.getCodeno());
				deviceFaultTemp.setUpdatetime(date);
				deviceFaultTemp.setUpdateuser(username);
				deviceFault = deviceFaultTemp;
				deviceFaultMapper.updateByPrimaryKey(deviceFaultTemp);
			}
		}
		return deviceFault;
	}
}
