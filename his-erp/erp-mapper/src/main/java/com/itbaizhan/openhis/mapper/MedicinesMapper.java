package com.itbaizhan.openhis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itbaizhan.openhis.domain.Medicines;
import org.apache.ibatis.annotations.Param;

/**
* @author a
* @description 针对表【stock_medicines(药品信息表)】的数据库操作Mapper
* @Entity com.itbaizhan.openhis.domain.Medicines
*/
public interface MedicinesMapper extends BaseMapper<Medicines> {

    int deductionMedicinesStorage(@Param("medicineId") Long medicineId, @Param("num") long num);
}




