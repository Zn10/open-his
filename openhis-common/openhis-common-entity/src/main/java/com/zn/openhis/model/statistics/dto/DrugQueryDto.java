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
public class DrugQueryDto extends BaseDto {

    private String drugName;

    private String queryDate;

}
