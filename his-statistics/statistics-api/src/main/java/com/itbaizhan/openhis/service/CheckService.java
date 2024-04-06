package com.itbaizhan.openhis.service;

import com.itbaizhan.openhis.domain.Check;
import com.itbaizhan.openhis.domain.CheckStat;
import com.itbaizhan.openhis.dto.CheckQueryDto;

import java.util.List;

public interface CheckService {
    List<Check> queryCheck(CheckQueryDto checkQueryDto);

    List<CheckStat> queryCheckStat(CheckQueryDto checkQueryDto);
}
