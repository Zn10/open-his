package com.zn.openhis.model.statistics.domain;

import com.zn.openhis.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Refund extends BaseEntity {

    private Double backAmount;  //退费金额

    private String backType;    //退费方式
}
