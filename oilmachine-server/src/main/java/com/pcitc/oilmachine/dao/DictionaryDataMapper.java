package com.pcitc.oilmachine.dao;

import com.pcitc.oilmachine.model.DictionaryData;
import com.pcitc.oilmachine.model.DictionaryDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryDataMapper {
    int countByExample(DictionaryDataExample example);

    int deleteByExample(DictionaryDataExample example);

    int deleteByPrimaryKey(String dictionarydataid);

    int insert(DictionaryData record);

    int insertSelective(DictionaryData record);

    List<DictionaryData> selectByExample(DictionaryDataExample example);

    DictionaryData selectByPrimaryKey(String dictionarydataid);

    int updateByExampleSelective(@Param("record") DictionaryData record, @Param("example") DictionaryDataExample example);

    int updateByExample(@Param("record") DictionaryData record, @Param("example") DictionaryDataExample example);

    int updateByPrimaryKeySelective(DictionaryData record);

    int updateByPrimaryKey(DictionaryData record);
}