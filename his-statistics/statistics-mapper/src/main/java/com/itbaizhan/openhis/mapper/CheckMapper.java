package com.itbaizhan.openhis.mapper;

import com.itbaizhan.openhis.domain.Check;
import com.itbaizhan.openhis.domain.CheckStat;
import com.itbaizhan.openhis.dto.CheckQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckMapper {
    List<Check> queryCheck(@Param("check") CheckQueryDto checkQueryDto);

    List<CheckStat> queryCheckStat(@Param("check") CheckQueryDto checkQueryDto);
}
