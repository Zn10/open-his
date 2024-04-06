package com.itbaizhan.openhis.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itbaizhan.openhis.constants.Constants;
import com.itbaizhan.openhis.domain.CareOrderItem;
import com.itbaizhan.openhis.domain.CheckResult;
import com.itbaizhan.openhis.domain.OrderChargeItem;
import com.itbaizhan.openhis.dto.CheckResultDto;
import com.itbaizhan.openhis.dto.CheckResultFormDto;
import com.itbaizhan.openhis.mapper.CareOrderItemMapper;
import com.itbaizhan.openhis.mapper.CheckResultMapper;
import com.itbaizhan.openhis.mapper.OrderChargeItemMapper;
import com.itbaizhan.openhis.service.CheckResultService;
import com.itbaizhan.openhis.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author a
* @description 针对表【his_check_result】的数据库操作Service实现
*/
@Service
public class CheckResultServiceImpl extends ServiceImpl<CheckResultMapper, CheckResult> implements CheckResultService{

    @Autowired
    private CheckResultMapper checkResultMapper;

    @Autowired
    private CareOrderItemMapper careOrderItemMapper;

    @Autowired
    private OrderChargeItemMapper orderChargeItemMapper;

    @Override
    public int saveCheckResult(CheckResult checkResult) {
        //保存checkResult表
        int i = checkResultMapper.insert(checkResult);
        //更新收费详情状态
        OrderChargeItem orderChargeItem = new OrderChargeItem();
        orderChargeItem.setItemId(checkResult.getItemId());
        orderChargeItem.setStatus(Constants.ORDER_DETAILS_STATUS_3);    //已完成
        orderChargeItemMapper.updateById(orderChargeItem);
        //更新处方明细状态
        CareOrderItem careOrderItem = new CareOrderItem();
        careOrderItem.setItemId(checkResult.getItemId());
        careOrderItem.setStatus(Constants.ORDER_DETAILS_STATUS_3);
        careOrderItemMapper.updateById(careOrderItem);
        return i;
    }

    @Override
    public DataGridView queryAllCheckingResultForPage(CheckResultDto checkResultDto) {
        Page<CheckResult> page = new Page<>();
        QueryWrapper<CheckResult> wrapper = new QueryWrapper<>();
        wrapper.in(checkResultDto.getCheckItemIds().size() > 0,CheckResult.COL_CHECK_ITEM_ID,
                checkResultDto.getCheckItemIds());
        wrapper.like(StringUtils.isNotBlank(checkResultDto.getPatientName()),CheckResult.COL_PATIENT_NAME,
                checkResultDto.getPatientName());
        wrapper.like(StringUtils.isNotBlank(checkResultDto.getRegId()),CheckResult.COL_REG_ID,
                checkResultDto.getRegId());
        wrapper.eq(StringUtils.isNotBlank(checkResultDto.getResultStatus()),CheckResult.COL_RESULT_STATUS,
                checkResultDto.getResultStatus());
        this.checkResultMapper.selectPage(page,wrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public int completeCheck(CheckResultFormDto checkResultFormDto) {
        CheckResult checkResult = new CheckResult();
        BeanUtil.copyProperties(checkResultFormDto,checkResult);
        checkResult.setResultStatus(Constants.RESULT_STATUS_1);
        checkResult.setUpdateBy(checkResultFormDto.getSimpleUser().getUserName());
        return checkResultMapper.updateById(checkResult);
    }

    @Override
    public DataGridView queryAllCheckResultForPage(CheckResultDto checkResultDto) {
        Page<CheckResult> page = new Page<>();
        QueryWrapper<CheckResult> wrapper = new QueryWrapper<>();
        wrapper.in(checkResultDto.getCheckItemIds().size() > 0,CheckResult.COL_CHECK_ITEM_ID,
                checkResultDto.getCheckItemIds());
        wrapper.like(StringUtils.isNotBlank(checkResultDto.getPatientName()),CheckResult.COL_PATIENT_NAME,
                checkResultDto.getPatientName());
        wrapper.like(StringUtils.isNotBlank(checkResultDto.getRegId()),CheckResult.COL_REG_ID,
                checkResultDto.getRegId());
        wrapper.eq(StringUtils.isNotBlank(checkResultDto.getResultStatus()),CheckResult.COL_RESULT_STATUS,
                checkResultDto.getResultStatus());
        this.checkResultMapper.selectPage(page,wrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }
}




