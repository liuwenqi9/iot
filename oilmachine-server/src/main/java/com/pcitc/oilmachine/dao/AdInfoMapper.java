package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.AdInfo;
import com.pcitc.oilmachine.model.AdInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdInfoMapper {
    int countByExample(AdInfoExample example);

    int deleteByExample(AdInfoExample example);

    int deleteByPrimaryKey(String adinfoid);

    int insert(AdInfo record);

    int insertSelective(AdInfo record);

    List<AdInfo> selectByExample(AdInfoExample example);

    AdInfo selectByPrimaryKey(String adinfoid);

    int updateByExampleSelective(@Param("record") AdInfo record, @Param("example") AdInfoExample example);

    int updateByExample(@Param("record") AdInfo record, @Param("example") AdInfoExample example);

    int updateByPrimaryKeySelective(AdInfo record);

    int updateByPrimaryKey(AdInfo record);
}