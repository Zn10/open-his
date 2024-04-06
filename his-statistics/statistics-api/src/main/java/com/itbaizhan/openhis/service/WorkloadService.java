package com.itbaizhan.openhis.service;

import com.itbaizhan.openhis.domain.Workload;
import com.itbaizhan.openhis.domain.WorkloadStat;
import com.itbaizhan.openhis.dto.WorkloadQueryDto;

import java.util.List;

public interface WorkloadService {
    List<Workload> queryWorkload(WorkloadQueryDto workloadQueryDto);

    List<WorkloadStat> queryWorkloadStat(WorkloadQueryDto workloadQueryDto);
}
