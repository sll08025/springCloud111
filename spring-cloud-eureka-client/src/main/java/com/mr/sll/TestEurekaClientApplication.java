package com.mr.sll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName TestEurekaClientApplication
 * @Description: TODO
 * @Author shenyaqi
 * @Date 2020/12/16
 * @Version V1.0
 **/

@SpringBootApplication
@EnableEurekaClient
public class TestEurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestEurekaClientApplication.class);
    }

}
