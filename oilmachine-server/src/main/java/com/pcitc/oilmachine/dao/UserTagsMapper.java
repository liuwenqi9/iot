package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.UserTags;
import com.pcitc.oilmachine.model.UserTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTagsMapper {
    int countByExample(UserTagsExample example);

    int deleteByExample(UserTagsExample example);

    int deleteByPrimaryKey(String usertagsid);

    int insert(UserTags record);

    int insertSelective(UserTags record);

    List<UserTags> selectByExample(UserTagsExample example);

    UserTags selectByPrimaryKey(String usertagsid);

    int updateByExampleSelective(@Param("record") UserTags record, @Param("example") UserTagsExample example);

    int updateByExample(@Param("record") UserTags record, @Param("example") UserTagsExample example);

    int updateByPrimaryKeySelective(UserTags record);

    int updateByPrimaryKey(UserTags record);
}