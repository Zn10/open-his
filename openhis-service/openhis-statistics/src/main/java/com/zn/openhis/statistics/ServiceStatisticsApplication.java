package com.zn.openhis.statistics;


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
@ComponentScan({"com.zn.openhis"})
@EnableDiscoveryClient
@Slf4j
@MapperScan("com.zn.openhis.*.mapper")
public class ServiceStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceStatisticsApplication.class, args);
        log.info("statistics服务启动成功");
    }

}

