package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.DevicesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevicesMapper {
    int countByExample(DevicesExample example);

    int deleteByExample(DevicesExample example);

    int deleteByPrimaryKey(String devicesid);

    int insert(Devices record);

    int insertSelective(Devices record);

    List<Devices> selectByExample(DevicesExample example);

    Devices selectByPrimaryKey(String devicesid);

    int updateByExampleSelective(@Param("record") Devices record, @Param("example") DevicesExample example);

    int updateByExample(@Param("record") Devices record, @Param("example") DevicesExample example);

    int updateByPrimaryKeySelective(Devices record);

    int updateByPrimaryKey(Devices record);
}