package com.itbaizhan.openhis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.domain.VerificationCode;

/**
* @author a
* @description 针对表【his_verification_code】的数据库操作Service
*/
public interface VerificationCodeService extends IService<VerificationCode> {
    int sendSms(String phoneNumber);

    VerificationCode checkCode(String phoneNumber, Integer code);
}
