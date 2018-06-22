package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.SellDiscounts;
import com.pcitc.oilmachine.model.SellDiscountsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellDiscountsMapper {
    int countByExample(SellDiscountsExample example);

    int deleteByExample(SellDiscountsExample example);

    int deleteByPrimaryKey(String id);

    int insert(SellDiscounts record);

    int insertSelective(SellDiscounts record);

    List<SellDiscounts> selectByExample(SellDiscountsExample example);

    SellDiscounts selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SellDiscounts record, @Param("example") SellDiscountsExample example);

    int updateByExample(@Param("record") SellDiscounts record, @Param("example") SellDiscountsExample example);

    int updateByPrimaryKeySelective(SellDiscounts record);

    int updateByPrimaryKey(SellDiscounts record);
}