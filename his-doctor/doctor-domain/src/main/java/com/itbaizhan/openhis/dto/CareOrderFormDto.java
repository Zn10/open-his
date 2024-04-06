package com.itbaizhan.openhis.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @Author:
 */
@ApiModel(value="com-itbaizhan-openhis-dto-CareOrderFormDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CareOrderFormDto implements Serializable {
    //处方
    private com.itbaizhan.openhis.dto.CareOrderDto careOrder;
    //处方详情
    @NotEmpty(message = "处方详情不能为空")
    private List<com.itbaizhan.openhis.dto.CareOrderItemDto> careOrderItems;
}
