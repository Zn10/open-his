package com.itbaizhan.openhis.pay;

import java.util.Map;

public class TestRefund {
    public static void main(String[] args) {
        String outTradeNo="ODC1465872958810619933";
        String subject="OPEN-HIS医疗管理系统支付平台";
        String refundAmount="20";
        String refundReason="不想要了";
        Map<String, Object> map = PayService.payBack(
                outTradeNo, "", refundAmount, refundReason, outTradeNo);
        System.out.println(map);
    }
}
