package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.AdInfoTags;
import com.pcitc.oilmachine.model.AdInfoTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdInfoTagsMapper {
    int countByExample(AdInfoTagsExample example);

    int deleteByExample(AdInfoTagsExample example);

    int deleteByPrimaryKey(String adinfotagsid);

    int insert(AdInfoTags record);

    int insertSelective(AdInfoTags record);

    List<AdInfoTags> selectByExample(AdInfoTagsExample example);

    AdInfoTags selectByPrimaryKey(String adinfotagsid);

    int updateByExampleSelective(@Param("record") AdInfoTags record, @Param("example") AdInfoTagsExample example);

    int updateByExample(@Param("record") AdInfoTags record, @Param("example") AdInfoTagsExample example);

    int updateByPrimaryKeySelective(AdInfoTags record);

    int updateByPrimaryKey(AdInfoTags record);
}