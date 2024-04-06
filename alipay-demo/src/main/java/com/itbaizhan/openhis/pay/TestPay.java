package com.itbaizhan.openhis.pay;

import java.util.Map;

public class TestPay {
    public static void main(String[] args) {
        String outTradeNo="ODC1465872958810619934";
        String subject="OPEN-HIS医疗管理系统支付平台";
        String totalAmount="100";
        String undiscountableAmount=null;
        String body="买药用的";
        String notifyUrl="http://45314rh250.qicp.vip/pay/callback/"+outTradeNo;
        Map<String, Object> map = PayService.pay(outTradeNo, subject, totalAmount, undiscountableAmount, body, notifyUrl);
        System.out.println(map);
    }
}
