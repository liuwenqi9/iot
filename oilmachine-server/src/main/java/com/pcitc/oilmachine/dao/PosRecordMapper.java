package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.PosRecord;
import com.pcitc.oilmachine.model.PosRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PosRecordMapper {
    int countByExample(PosRecordExample example);

    int deleteByExample(PosRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(PosRecord record);

    int insertSelective(PosRecord record);

    List<PosRecord> selectByExample(PosRecordExample example);

    PosRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PosRecord record, @Param("example") PosRecordExample example);

    int updateByExample(@Param("record") PosRecord record, @Param("example") PosRecordExample example);

    int updateByPrimaryKeySelective(PosRecord record);

    int updateByPrimaryKey(PosRecord record);
}