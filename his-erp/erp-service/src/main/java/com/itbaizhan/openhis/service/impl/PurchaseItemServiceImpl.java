package com.itbaizhan.openhis.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itbaizhan.openhis.PurchaseItemService;
import com.itbaizhan.openhis.mapper.PurchaseItemMapper;
import com.itbaizhan.openhis.domain.PurchaseItem;
import org.springframework.stereotype.Service;

/**
* @author a
* @description 针对表【stock_purchase_item】的数据库操作Service实现
*/
@Service
public class PurchaseItemServiceImpl extends ServiceImpl<PurchaseItemMapper, PurchaseItem>
    implements PurchaseItemService {

}




