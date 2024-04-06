package com.itbaizhan.openhis.service;

import com.itbaizhan.openhis.dto.RevenueQueryDto;

import java.util.Map;

public interface RevenueService {
    Map<String, Object> queryAllRevenueData(RevenueQueryDto revenueQueryDto);
}
