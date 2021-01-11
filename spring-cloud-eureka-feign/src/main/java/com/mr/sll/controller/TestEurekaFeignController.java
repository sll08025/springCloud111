package com.mr.sll.controller;

import com.mr.sll.entity.UserEntity;
import com.mr.sll.feign.TestEurekaFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestEurekaFeignController
 * @Description: TODO
 * @Author shenyaqi
 * @Date 2020/12/16
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "eureka-feign-controller")
public class TestEurekaFeignController {
    @Autowired
    private TestEurekaFeign testEurekaFeign;

    @GetMapping
    public String test(String name){
        String test = testEurekaFeign.test(name);
        return test;
    }
    @GetMapping(value = "obj")
     public  String test2(UserEntity userEntity){
        String test2 = testEurekaFeign.test2(userEntity);
        return  test2;
    }

}
