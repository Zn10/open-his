package com.zn.openhis.model.statistics.dto;

import com.zn.openhis.model.base.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WorkloadQueryDto extends BaseDto {

    private String doctorName;

    private String queryDate;
}
