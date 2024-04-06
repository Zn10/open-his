package com.itbaizhan.openhis.mapper;

import com.itbaizhan.openhis.domain.Income;
import com.itbaizhan.openhis.domain.Refund;
import com.itbaizhan.openhis.dto.RevenueQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RevenueMapper {
    List<Income> queryIncome(@Param("revenue") RevenueQueryDto revenueQueryDto);

    List<Refund> queryRefund(@Param("revenue") RevenueQueryDto revenueQueryDto);
}
