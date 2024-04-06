package com.itbaizhan.openhis.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itbaizhan.openhis.config.SmsConfig;
import com.itbaizhan.openhis.domain.VerificationCode;
import com.itbaizhan.openhis.mapper.VerificationCodeMapper;
import com.itbaizhan.openhis.service.VerificationCodeService;
import com.itbaizhan.openhis.utils.HttpUtils;
import com.itbaizhan.openhis.utils.IdGeneratorSnowFlake;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URLEncoder;

@Service(timeout = 5000,methods = {@Method(name="sendSms",retries = 0)})
public class VerficationCodeServiceImpl extends ServiceImpl<VerificationCodeMapper, VerificationCode> implements VerificationCodeService {

    @Autowired
    private VerificationCodeMapper verificationCodeMapper;

    @Autowired
    private SmsConfig smsConfig;


    /**
     * 发送短信
     * @param phoneNumber
     */
    @Override
    public int sendSms(String phoneNumber){
        Integer code = IdGeneratorSnowFlake.generateVerificationCode();
        try {
            String result = this.execute(phoneNumber,code);
            JSONObject jsonObject = (JSONObject)JSON.parse(result);
            if(jsonObject != null && StringUtils.isNotEmpty(jsonObject.getString("respCode"))){
                if(jsonObject.getString("respCode").equals("0000")){
                    return saveVerification(phoneNumber,code);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public VerificationCode checkCode(String phoneNumber, Integer code) {
        QueryWrapper<VerificationCode> wrapper = new QueryWrapper<>();
        wrapper.eq(VerificationCode.PHONE_NUMBER,phoneNumber);
        wrapper.eq(VerificationCode.VERIFICATION_CODE,code);
        wrapper.eq(VerificationCode.IS_CHECK,0);
        return verificationCodeMapper.selectOne(wrapper);
    }

    /**
     * 发送成功后把验证码保存到his_verification_code表
     * @param phoneNumber
     * @param code
     * @return
     */
    private int saveVerification(String phoneNumber, Integer code) {
        VerificationCode verificationCode = new VerificationCode();
        verificationCode.setPhoneNumber(phoneNumber);
        verificationCode.setVerificationCode(code);
        verificationCode.setCreateTime(DateUtil.date());
        verificationCode.setIsCheck(0);
        return verificationCodeMapper.insert(verificationCode);
    }

    /**
     * 短信发送(验证码通知，会员营销)
     * 接口文档地址：http://www.danmi.com/developer.html#smsSend
     */
    public String execute(String phoneNumber, Integer code) throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("accountSid").append("=").append(smsConfig.getACCOUNT_SID());  //客户id
        sb.append("&to").append("=").append(phoneNumber);
        sb.append("&templateid").append("=").append(smsConfig.getTEMPLATE_ID());     //模板id
        sb.append("&param").append("=").append(URLEncoder.encode(code.toString(),"UTF-8"));
        String body = sb.toString() + smsConfig.createCommonParam(smsConfig.getACCOUNT_SID(), smsConfig.getAUTH_TOKEN());
        return HttpUtils.post(smsConfig.getBASE_URL(), body);
    }
}
