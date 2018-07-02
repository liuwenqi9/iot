package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.NozzleStatus;
import com.pcitc.oilmachine.model.NozzleStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NozzleStatusMapper {
    int countByExample(NozzleStatusExample example);

    int deleteByExample(NozzleStatusExample example);

    int deleteByPrimaryKey(String id);

    int insert(NozzleStatus record);

    int insertSelective(NozzleStatus record);

    List<NozzleStatus> selectByExample(NozzleStatusExample example);

    NozzleStatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NozzleStatus record, @Param("example") NozzleStatusExample example);

    int updateByExample(@Param("record") NozzleStatus record, @Param("example") NozzleStatusExample example);

    int updateByPrimaryKeySelective(NozzleStatus record);

    int updateByPrimaryKey(NozzleStatus record);
}