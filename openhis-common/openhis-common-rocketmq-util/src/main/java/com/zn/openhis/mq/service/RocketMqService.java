package com.zn.openhis.mq.service;


import com.zn.openhis.mq.dto.BaseMqDto;

public interface RocketMqService {

    void sendDelayed(String topic, BaseMqDto<?> data, int delayLevel);
}
