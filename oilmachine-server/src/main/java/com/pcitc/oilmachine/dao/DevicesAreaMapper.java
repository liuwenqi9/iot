package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.DevicesArea;
import com.pcitc.oilmachine.model.DevicesAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevicesAreaMapper {
    int countByExample(DevicesAreaExample example);

    int deleteByExample(DevicesAreaExample example);

    int deleteByPrimaryKey(String devicesareaid);

    int insert(DevicesArea record);

    int insertSelective(DevicesArea record);

    List<DevicesArea> selectByExample(DevicesAreaExample example);

    DevicesArea selectByPrimaryKey(String devicesareaid);

    int updateByExampleSelective(@Param("record") DevicesArea record, @Param("example") DevicesAreaExample example);

    int updateByExample(@Param("record") DevicesArea record, @Param("example") DevicesAreaExample example);

    int updateByPrimaryKeySelective(DevicesArea record);

    int updateByPrimaryKey(DevicesArea record);
}