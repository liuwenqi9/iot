package com.afs.base.dao;

import com.afs.base.model.MqQueuedata;

public interface MqQueuedataMapper {
    int insert(MqQueuedata record);

    int insertSelective(MqQueuedata record);
}