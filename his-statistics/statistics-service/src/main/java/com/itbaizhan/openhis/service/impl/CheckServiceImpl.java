package com.itbaizhan.openhis.service.impl;

import com.itbaizhan.openhis.domain.Check;
import com.itbaizhan.openhis.domain.CheckStat;
import com.itbaizhan.openhis.dto.CheckQueryDto;
import com.itbaizhan.openhis.mapper.CheckMapper;
import com.itbaizhan.openhis.service.CheckService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public List<Check> queryCheck(CheckQueryDto checkQueryDto) {
        return checkMapper.queryCheck(checkQueryDto);
    }

    @Override
    public List<CheckStat> queryCheckStat(CheckQueryDto checkQueryDto) {
        return checkMapper.queryCheckStat(checkQueryDto);
    }
}
