package com.mr.sll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName TestEurekaFeignApplication
 * @Description: TODO
 * @Author shenyaqi
 * @Date 2020/12/16
 * @Version V1.0
 **/
@SpringBootApplication
@EnableFeignClients
public class TestEurekaFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestEurekaFeignApplication.class);
    }
}
