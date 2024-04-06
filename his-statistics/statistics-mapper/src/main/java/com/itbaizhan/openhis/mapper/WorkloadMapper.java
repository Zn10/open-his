package com.itbaizhan.openhis.mapper;

import com.itbaizhan.openhis.domain.Workload;
import com.itbaizhan.openhis.domain.WorkloadStat;
import com.itbaizhan.openhis.dto.WorkloadQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkloadMapper {
    List<Workload> queryWorkload(@Param("workload") WorkloadQueryDto workloadQueryDto);

    List<WorkloadStat> queryWorkloadStat(@Param("workload") WorkloadQueryDto workloadQueryDto);
}
