package com.itbaizhan.openhis;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.domain.InventoryLog;
import com.itbaizhan.openhis.dto.InventoryLogDto;
import com.itbaizhan.openhis.vo.DataGridView;

/**
* @author a
* @description 针对表【stock_inventory_log】的数据库操作Service
*/
public interface InventoryLogService extends IService<InventoryLog> {

    DataGridView listInventoryLogForPage(InventoryLogDto inventoryLogDto);
}
