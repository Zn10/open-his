package com.itbaizhan.openhis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.domain.OrderCharge;
import com.itbaizhan.openhis.domain.OrderChargeItem;
import com.itbaizhan.openhis.dto.OrderChargeDto;
import com.itbaizhan.openhis.dto.OrderChargeFromDto;
import com.itbaizhan.openhis.vo.DataGridView;

import java.util.List;

/**
* @author a
* @description 针对表【his_order_charge(收费表)】的数据库操作Service
*/
public interface OrderChargeService extends IService<OrderCharge> {

    void saveOrderAndItems(OrderChargeFromDto orderChargeFromDto);

    void paySuccess(String orderId, String platFormId, String payType0);

    OrderCharge queryOrderChargeByOrderId(String orderId);

    DataGridView queryAllOrderChargeForPage(OrderChargeDto orderChargeDto);

    List<OrderChargeItem> queryOrderChargeItemByOrderId(String orderId);

    OrderChargeItem queryOrderChargeItemByItemId(String itemId);

    void cancelPayOrder(String orderId);
}
