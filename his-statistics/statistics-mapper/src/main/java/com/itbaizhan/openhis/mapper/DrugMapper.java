package com.itbaizhan.openhis.mapper;

import com.itbaizhan.openhis.domain.Drug;
import com.itbaizhan.openhis.domain.DrugStat;
import com.itbaizhan.openhis.dto.DrugQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugMapper {
    List<Drug> queryDrug(@Param("drug") DrugQueryDto drugQueryDto);

    List<DrugStat> queryDrugStat(@Param("drug") DrugQueryDto drugQueryDto);
}
