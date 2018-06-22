package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.SellOrder;
import com.pcitc.oilmachine.model.SellOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellOrderMapper {
    int countByExample(SellOrderExample example);

    int deleteByExample(SellOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(SellOrder record);

    int insertSelective(SellOrder record);

    List<SellOrder> selectByExample(SellOrderExample example);

    SellOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SellOrder record, @Param("example") SellOrderExample example);

    int updateByExample(@Param("record") SellOrder record, @Param("example") SellOrderExample example);

    int updateByPrimaryKeySelective(SellOrder record);

    int updateByPrimaryKey(SellOrder record);
}