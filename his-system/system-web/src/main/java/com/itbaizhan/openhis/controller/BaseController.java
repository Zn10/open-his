package com.itbaizhan.openhis.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itbaizhan.openhis.dto.ProviderDto;
import com.itbaizhan.openhis.vo.AjaxResult;

public class BaseController {


    public static AjaxResult handleException(ProviderDto providerDto, BlockException blockException){
        return AjaxResult.fail("系统压力过大，请稍后再试");
    }
}
