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
public class Income extends BaseEntity {

    private Double orderAmount;     //收入金额

    private String payType; //收入方式


}
