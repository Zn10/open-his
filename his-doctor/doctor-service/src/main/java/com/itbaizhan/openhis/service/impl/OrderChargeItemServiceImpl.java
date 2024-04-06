package com.itbaizhan.openhis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itbaizhan.openhis.domain.OrderChargeItem;
import com.itbaizhan.openhis.mapper.OrderChargeItemMapper;
import com.itbaizhan.openhis.service.OrderChargeItemService;
import org.springframework.stereotype.Service;

/**
* @author a
* @description 针对表【his_order_charge_item(支付订单详情表)】的数据库操作Service实现
*/
@Service
public class OrderChargeItemServiceImpl extends ServiceImpl<OrderChargeItemMapper, OrderChargeItem>
    implements OrderChargeItemService{

}




