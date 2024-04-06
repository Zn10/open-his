package com.itbaizhan.openhis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.domain.OrderBackfee;
import com.itbaizhan.openhis.domain.OrderBackfeeItem;
import com.itbaizhan.openhis.dto.OrderBackfeeDto;
import com.itbaizhan.openhis.dto.OrderBackfeeFormDto;
import com.itbaizhan.openhis.vo.DataGridView;

import java.util.List;

/**
* @author a
* @description 针对表【his_order_backfee(退费主表)】的数据库操作Service
*/
public interface OrderBackfeeService extends IService<OrderBackfee> {

    void saveOrderAndItems(OrderBackfeeFormDto orderBackfeeFormDto);

    void backSuccess(String backId, String backPlatformId, String payType0);

    DataGridView queryAllOrderBackfeeForPage(OrderBackfeeDto orderBackfeeDto);

    List<OrderBackfeeItem> queryOrderBackfeeItemByBackId(String backId);
}
