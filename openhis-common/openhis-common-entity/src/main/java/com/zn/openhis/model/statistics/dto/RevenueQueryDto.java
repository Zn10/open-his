package com.zn.openhis.model.statistics.dto;

import com.zn.openhis.model.base.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RevenueQueryDto extends BaseDto {

    private String queryDate;
}
