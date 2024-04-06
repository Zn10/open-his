package com.itbaizhan.openhis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itbaizhan.openhis.domain.CareOrderItem;
import com.itbaizhan.openhis.mapper.CareOrderItemMapper;
import com.itbaizhan.openhis.service.CareOrderItemService;
import org.springframework.stereotype.Service;

/**
* @author a
* @description 针对表【his_care_order_item(开诊细表)】的数据库操作Service实现
*/
@Service
public class CareOrderItemServiceImpl extends ServiceImpl<CareOrderItemMapper, CareOrderItem>
    implements CareOrderItemService{

}




