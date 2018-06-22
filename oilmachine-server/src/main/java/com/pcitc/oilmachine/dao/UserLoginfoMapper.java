package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.UserLoginfo;
import com.pcitc.oilmachine.model.UserLoginfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLoginfoMapper {
    int countByExample(UserLoginfoExample example);

    int deleteByExample(UserLoginfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserLoginfo record);

    int insertSelective(UserLoginfo record);

    List<UserLoginfo> selectByExample(UserLoginfoExample example);

    UserLoginfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserLoginfo record, @Param("example") UserLoginfoExample example);

    int updateByExample(@Param("record") UserLoginfo record, @Param("example") UserLoginfoExample example);

    int updateByPrimaryKeySelective(UserLoginfo record);

    int updateByPrimaryKey(UserLoginfo record);
}