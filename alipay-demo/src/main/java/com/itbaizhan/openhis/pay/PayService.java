package com.itbaizhan.openhis.pay;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.builder.AlipayTradeRefundRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.model.result.AlipayF2FRefundResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付服务
 */
public class PayService {

    static Log log = LogFactory.getLog("trade_precreate");

    static AlipayTradeService alipayTradeService;

    static {
        Configs.init("zfbinfo.properties");
        alipayTradeService = new AlipayTradeServiceImpl.ClientBuilder().build();
    }

    //商户门店id（必填）
    static String storeId = "test_store_id";
    //商户操作员编号
    static String operatorId = "test_operator_id";
    // 支付超时，定义为120分钟
    static String timeoutExpress = "120m";

    /**
     * 支付方法
     * @param outTradeNo    (必填) 商户网站订单系统中唯一订单号
     * @param subject       (必填) 订单标题，粗略描述用户的支付目的
     * @param totalAmount   (必填) 订单总金额，单位为元，不能超过1亿元
     * @param undiscountableAmount  (可选) 订单不可打折金额
     * @param body  订单描述
     * @param notifyUrl  //支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
     * @return
     */
    public static Map<String,Object> pay(String outTradeNo,
                                         String subject,
                                         String totalAmount,
                                         String undiscountableAmount,
                                         String body,
                                         String notifyUrl){
        System.out.println(notifyUrl);
        AlipayTradePrecreateRequestBuilder builder =new AlipayTradePrecreateRequestBuilder()
                .setSubject(subject)
                .setTotalAmount(totalAmount)
                .setOutTradeNo(outTradeNo)
                .setUndiscountableAmount(undiscountableAmount)
                .setBody(body)
                .setOperatorId(operatorId)
                .setStoreId(storeId)
                .setTimeoutExpress(timeoutExpress)
                .setNotifyUrl(notifyUrl);   //支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置

        AlipayF2FPrecreateResult result = alipayTradeService.tradePrecreate(builder);
        HashMap<String, Object> map = new HashMap<>();
        String msg;
        Integer code;
        switch (result.getTradeStatus()) {
            case SUCCESS:
                log.info("支付宝预下单成功: )");
                AlipayTradePrecreateResponse res = result.getResponse();
                String qrCode = res.getQrCode();
                map.put("qrCode",qrCode);
                msg = "下单成功";
                code = 200;
                break;
            case FAILED:
                log.error("支付宝预下单失败!!!");
                msg = "下单失败";
                code = 500;
                break;
            case UNKNOWN:
                log.error("系统异常，预下单状态未知!!!");
                msg = "系统异常";
                code = 404;
                break;
            default:
                log.error("不支持的交易状态，交易返回异常!!!");
                msg = "不支持的交易状态";
                code = 404;
                break;
        }
        map.put("msg",msg);
        map.put("code",code);
        return map;
    }

    /**
     * 退款
     * @param outTradeNo (必填) 外部订单号
     * @param tradeNo 平台在支付成功之后返回的id
     * @param refundAmount  (必填) 退款金额
     * @param refundReason  (必填) 退款原因
     * @param outRequestNo  是否支付部分退款
     * @return
     */
    public static Map<String,Object> payBack(String outTradeNo,String tradeNo,
                                             String refundAmount,String refundReason,
                                             String outRequestNo){

        AlipayTradeRefundRequestBuilder builder = new AlipayTradeRefundRequestBuilder()
                .setOutTradeNo(outTradeNo)
                .setRefundAmount(refundAmount)
                .setRefundReason(refundReason)
                .setOutRequestNo(outRequestNo)
                .setStoreId(storeId);
        AlipayF2FRefundResult result = alipayTradeService.tradeRefund(builder);
        HashMap<String, Object> map = new HashMap<>();
        String msg = "";
        Integer code = null;
        switch (result.getTradeStatus()) {
            case SUCCESS:
                log.info("支付宝退款成功: )");
                code = 200;
                msg = result.getResponse().getSubMsg();
                break;
            case FAILED:
                log.error("支付宝退款失败!!!");
                code = 500;
                msg = result.getResponse().getSubMsg();
                break;
            case UNKNOWN:
                log.error("系统异常，订单退款状态未知!!!");
                code = 500;
                msg = result.getResponse().getSubMsg();
                break;
            default:
                log.error("不支持的交易状态，交易返回异常!!!");
                code = 500;
                msg = result.getResponse().getSubMsg();
                break;
        }
        map.put("code",code);
        map.put("msg",msg);
        return map;

    }
}
