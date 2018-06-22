package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.MqSendException;
import com.pcitc.oilmachine.model.MqSendExceptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MqSendExceptionMapper {
    int countByExample(MqSendExceptionExample example);

    int deleteByExample(MqSendExceptionExample example);

    int deleteByPrimaryKey(String mqsendexceptionid);

    int insert(MqSendException record);

    int insertSelective(MqSendException record);

    List<MqSendException> selectByExample(MqSendExceptionExample example);

    MqSendException selectByPrimaryKey(String mqsendexceptionid);

    int updateByExampleSelective(@Param("record") MqSendException record, @Param("example") MqSendExceptionExample example);

    int updateByExample(@Param("record") MqSendException record, @Param("example") MqSendExceptionExample example);

    int updateByPrimaryKeySelective(MqSendException record);

    int updateByPrimaryKey(MqSendException record);
}