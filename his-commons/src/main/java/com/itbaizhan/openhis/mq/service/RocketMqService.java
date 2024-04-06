package com.itbaizhan.openhis.mq.service;

import com.itbaizhan.openhis.mq.dto.BaseMqDto;

public interface RocketMqService {

    void sendDelayed(String topic, BaseMqDto<?> data, int delayLevel);
}
