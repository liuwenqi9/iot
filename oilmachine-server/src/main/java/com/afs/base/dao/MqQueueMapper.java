package com.afs.base.dao;

import com.afs.base.model.MqQueue;

public interface MqQueueMapper {
    int insert(MqQueue record);

    int insertSelective(MqQueue record);
}