package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.DeviceFault;
import com.pcitc.oilmachine.model.DeviceFaultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceFaultMapper {
    int countByExample(DeviceFaultExample example);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String id);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    DeviceFault selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);
}