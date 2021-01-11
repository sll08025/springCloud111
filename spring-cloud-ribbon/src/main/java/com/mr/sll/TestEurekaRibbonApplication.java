package com.mr.sll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName TestEurekaRibbonApplication
 * @Description: TODO
 * @Author shenyaqi
 * @Date 2020/12/16
 * @Version V1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class TestEurekaRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestEurekaRibbonApplication.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
