package com.itbaizhan.openhis.service.impl;

import com.itbaizhan.openhis.domain.Workload;
import com.itbaizhan.openhis.domain.WorkloadStat;
import com.itbaizhan.openhis.dto.WorkloadQueryDto;
import com.itbaizhan.openhis.mapper.WorkloadMapper;
import com.itbaizhan.openhis.service.WorkloadService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class WorkloadServiceImpl implements WorkloadService {

    @Autowired
    private WorkloadMapper workloadMapper;

    @Override
    public List<Workload> queryWorkload(WorkloadQueryDto workloadQueryDto) {
        return workloadMapper.queryWorkload(workloadQueryDto);
    }

    @Override
    public List<WorkloadStat> queryWorkloadStat(WorkloadQueryDto workloadQueryDto) {
        return workloadMapper.queryWorkloadStat(workloadQueryDto);
    }
}
