package com.itbaizhan.openhis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.domain.CareHistory;
import com.itbaizhan.openhis.domain.CareOrder;
import com.itbaizhan.openhis.domain.CareOrderItem;
import com.itbaizhan.openhis.dto.CareHistoryDto;
import com.itbaizhan.openhis.dto.CareOrderFormDto;

import java.util.List;

/**
* @author a
* @description 针对表【his_care_history(病例表)】的数据库操作Service
*/
public interface CareHistoryService extends IService<CareHistory> {

    List<CareHistory> queryCareHistoryByPatientId(String patientId);

    List<CareOrder> queryCareOrdersByChId(String chId);

    List<CareOrderItem> queryCareOrderItemsByCoId(String coId,String detailStatus);

    CareHistory saveOrUpdateCareHistory(CareHistoryDto careHistoryDto);

    CareHistory queryCareHistoryByRegId(String regId);

    CareHistory queryCareHistoryByChId(String chId);

    int saveCareOrderItem(CareOrderFormDto careOrderFormDto);

    CareOrderItem queryCareOrderItemsByItemId(String itemId);

    int deleteCareOrderItemById(String itemId);

    int visitComplete(String regId);

    String doMedicine(List<String> itemIds);

    List<CareOrderItem> queryCareOrderItemsByStatus(String coTypeCheck, String orderDetailsStatus1);

    CareOrder queryCareOrderByCoId(String coId);
}
