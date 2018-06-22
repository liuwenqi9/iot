package com.afs.base.dao;

import com.afs.base.model.MqConfig;

public interface MqConfigMapper {
    int insert(MqConfig record);

    int insertSelective(MqConfig record);
}