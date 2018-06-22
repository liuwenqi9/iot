package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.AdTags;
import com.pcitc.oilmachine.model.AdTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdTagsMapper {
    int countByExample(AdTagsExample example);

    int deleteByExample(AdTagsExample example);

    int deleteByPrimaryKey(String adtagsid);

    int insert(AdTags record);

    int insertSelective(AdTags record);

    List<AdTags> selectByExample(AdTagsExample example);

    AdTags selectByPrimaryKey(String adtagsid);

    int updateByExampleSelective(@Param("record") AdTags record, @Param("example") AdTagsExample example);

    int updateByExample(@Param("record") AdTags record, @Param("example") AdTagsExample example);

    int updateByPrimaryKeySelective(AdTags record);

    int updateByPrimaryKey(AdTags record);
}