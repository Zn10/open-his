package com.itbaizhan.openhis.pay;

public class AlipayConfig {

    //#SHA1withRsa对应支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkloioiI10m9CGgEpxXtCXzOEQXb3Rm2xslqjc6iPJ0NDs5koXy8lFNm9n2iZAH7rSQjFKJxxs/e4uQrei535bIimsfVtEM2Wz7WVdkOHRGj7mQHZvJFVFhazBRxMqR3HagDCImCGG/+X6QKFFxfMxxYgWK33eLaTNeAXPsR3JhMxXc1NMu8XpZIcallX+8du1Rs63+k4mkGG1iuXafxA0magdFUMnx9CxzCZCd5+945fYRYVB7v2OaBCl3djLlusijj3OVWfEP8ZQ3DcQW38WXAPhacru+HBzxedgJGD6sxt3sZLt5Ki47djTlx5WDaH5hayhD/MC7sYhfnCLI3+JwIDAQAB";

    //签名方式
    public static String  sign_type = "RSA2";

    //字符集
    public static String charset = "utf-8";
}
