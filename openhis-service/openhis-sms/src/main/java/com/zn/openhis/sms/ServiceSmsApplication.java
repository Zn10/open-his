package com.zn.openhis.sms;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: 赵念
 * @create-date: 2023/2/11/14:06
 */
@SpringBootApplication
@ComponentScan({"com.zn.gmall"})
@EnableDiscoveryClient
@Slf4j
@MapperScan("com.zn.gmall.*.mapper")
public class ServiceSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSmsApplication.class, args);
        log.info("用户服务启动成功");
    }

}

