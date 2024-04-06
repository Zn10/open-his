package com.itbaizhan.openhis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itbaizhan.openhis.domain.SmsLog;
import com.itbaizhan.openhis.mapper.SmsLogMapper;
import com.itbaizhan.openhis.service.SmsLogService;
import org.springframework.stereotype.Service;

/**
* @author a
* @description 针对表【sys_sms_log(短息发送记录表)】的数据库操作Service实现
*/
@Service
public class SmsLogServiceImpl extends ServiceImpl<SmsLogMapper, SmsLog>
    implements SmsLogService {

}




