package com.itbaizhan.openhis.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itbaizhan.openhis.InventoryLogService;
import com.itbaizhan.openhis.mapper.InventoryLogMapper;
import com.itbaizhan.openhis.domain.InventoryLog;
import com.itbaizhan.openhis.dto.InventoryLogDto;
import com.itbaizhan.openhis.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author a
* @description 针对表【stock_inventory_log】的数据库操作Service实现
*/
@Service
public class InventoryLogServiceImpl extends ServiceImpl<InventoryLogMapper, InventoryLog> implements InventoryLogService {

    @Autowired
    private InventoryLogMapper inventoryLogMapper;

    @Override
    public DataGridView listInventoryLogForPage(InventoryLogDto inventoryLogDto) {
        Page<InventoryLog> page = new Page<>(inventoryLogDto.getPageNum(), inventoryLogDto.getPageSize());
        QueryWrapper<InventoryLog> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(inventoryLogDto.getPurchaseId()),InventoryLog.COL_PURCHASE_ID,
                inventoryLogDto.getPurchaseId());
        wrapper.like(StringUtils.isNotBlank(inventoryLogDto.getMedicinesName()),InventoryLog.COL_MEDICINES_NAME,
                inventoryLogDto.getMedicinesName());
        wrapper.eq(StringUtils.isNotBlank(inventoryLogDto.getMedicinesType()),InventoryLog.COL_MEDICINES_TYPE,
                inventoryLogDto.getMedicinesType());
        wrapper.eq(StringUtils.isNotBlank(inventoryLogDto.getProducterId()),InventoryLog.COL_PRODUCTER_ID,
                inventoryLogDto.getProducterId());
        wrapper.eq(StringUtils.isNotBlank(inventoryLogDto.getPrescriptionType()),InventoryLog.COL_PRESCRIPTION_TYPE,
                inventoryLogDto.getPrescriptionType());
        wrapper.ge(inventoryLogDto.getBeginTime() != null,InventoryLog.COL_CREATE_TIME,
                inventoryLogDto.getBeginTime());
        wrapper.le(inventoryLogDto.getEndTime() != null,InventoryLog.COL_CREATE_TIME,
                inventoryLogDto.getEndTime());
        wrapper.orderByDesc(InventoryLog.COL_CREATE_TIME);
        inventoryLogMapper.selectPage(page,wrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }
}




