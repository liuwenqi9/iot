package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.SellProduct;
import com.pcitc.oilmachine.model.SellProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellProductMapper {
    int countByExample(SellProductExample example);

    int deleteByExample(SellProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(SellProduct record);

    int insertSelective(SellProduct record);

    List<SellProduct> selectByExample(SellProductExample example);

    SellProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SellProduct record, @Param("example") SellProductExample example);

    int updateByExample(@Param("record") SellProduct record, @Param("example") SellProductExample example);

    int updateByPrimaryKeySelective(SellProduct record);

    int updateByPrimaryKey(SellProduct record);
}