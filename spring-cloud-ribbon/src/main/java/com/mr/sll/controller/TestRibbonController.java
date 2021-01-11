package com.mr.sll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName TestRibbonController
 * @Description: TODO
 * @Author shenyaqi
 * @Date 2020/12/16
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "test-ribbon")
public class TestRibbonController {
    @Autowired
    private  RestTemplate restTemplate;

    @GetMapping
    public String test(String name){
        String url = "http://EUREKA-CLIENT/eureka-client-controller?name="+name;
        String forObject = restTemplate.getForObject(url,String.class);
        return forObject;
    }

}
