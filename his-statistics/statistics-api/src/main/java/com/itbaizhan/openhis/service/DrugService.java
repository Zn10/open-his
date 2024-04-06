package com.itbaizhan.openhis.service;

import com.itbaizhan.openhis.domain.Drug;
import com.itbaizhan.openhis.domain.DrugStat;
import com.itbaizhan.openhis.dto.DrugQueryDto;

import java.util.List;

public interface DrugService {
    List<Drug> queryDrug(DrugQueryDto drugQueryDto);

    List<DrugStat> queryDrugStat(DrugQueryDto drugQueryDto);
}
