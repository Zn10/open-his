package com.itbaizhan.openhis.service.impl;

import com.itbaizhan.openhis.domain.Drug;
import com.itbaizhan.openhis.domain.DrugStat;
import com.itbaizhan.openhis.dto.DrugQueryDto;
import com.itbaizhan.openhis.mapper.DrugMapper;
import com.itbaizhan.openhis.service.DrugService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public List<Drug> queryDrug(DrugQueryDto drugQueryDto) {
        return drugMapper.queryDrug(drugQueryDto);
    }

    @Override
    public List<DrugStat> queryDrugStat(DrugQueryDto drugQueryDto) {
        return drugMapper.queryDrugStat(drugQueryDto);
    }
}
