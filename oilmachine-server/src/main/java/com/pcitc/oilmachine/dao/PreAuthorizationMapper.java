package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.PreAuthorization;
import com.pcitc.oilmachine.model.PreAuthorizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PreAuthorizationMapper {
    int countByExample(PreAuthorizationExample example);

    int deleteByExample(PreAuthorizationExample example);

    int deleteByPrimaryKey(String id);

    int insert(PreAuthorization record);

    int insertSelective(PreAuthorization record);

    List<PreAuthorization> selectByExample(PreAuthorizationExample example);

    PreAuthorization selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PreAuthorization record, @Param("example") PreAuthorizationExample example);

    int updateByExample(@Param("record") PreAuthorization record, @Param("example") PreAuthorizationExample example);

    int updateByPrimaryKeySelective(PreAuthorization record);

    int updateByPrimaryKey(PreAuthorization record);
}