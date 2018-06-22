package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.SellRefund;
import com.pcitc.oilmachine.model.SellRefundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellRefundMapper {
    int countByExample(SellRefundExample example);

    int deleteByExample(SellRefundExample example);

    int deleteByPrimaryKey(String id);

    int insert(SellRefund record);

    int insertSelective(SellRefund record);

    List<SellRefund> selectByExample(SellRefundExample example);

    SellRefund selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SellRefund record, @Param("example") SellRefundExample example);

    int updateByExample(@Param("record") SellRefund record, @Param("example") SellRefundExample example);

    int updateByPrimaryKeySelective(SellRefund record);

    int updateByPrimaryKey(SellRefund record);
}