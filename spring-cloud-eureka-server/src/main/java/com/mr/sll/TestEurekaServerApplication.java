package com.mr.sll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName TestEurekaServerApplication
 * @Description: TODO
 * @Author shenyaqi
 * @Date 2020/12/14
 * @Version V1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class TestEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestEurekaServerApplication.class);
    }
}
