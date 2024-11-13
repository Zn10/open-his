package com.zn.openhis.model.statistics.domain;

import com.zn.openhis.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DrugStat extends BaseEntity {

    //药品id
    private String medicinesId;

    //药品名称
    private String medicinesName;

    //总金额
    private BigDecimal totalAmount;

    //销售数量
    private BigDecimal count;
}
