package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.AdInfoDetail;
import com.pcitc.oilmachine.model.AdInfoDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdInfoDetailMapper {
    int countByExample(AdInfoDetailExample example);

    int deleteByExample(AdInfoDetailExample example);

    int deleteByPrimaryKey(String adinfodetailid);

    int insert(AdInfoDetail record);

    int insertSelective(AdInfoDetail record);

    List<AdInfoDetail> selectByExample(AdInfoDetailExample example);

    AdInfoDetail selectByPrimaryKey(String adinfodetailid);

    int updateByExampleSelective(@Param("record") AdInfoDetail record, @Param("example") AdInfoDetailExample example);

    int updateByExample(@Param("record") AdInfoDetail record, @Param("example") AdInfoDetailExample example);

    int updateByPrimaryKeySelective(AdInfoDetail record);

    int updateByPrimaryKey(AdInfoDetail record);
}