package com.mr.sll.controller;

import com.mr.sll.entity.UserEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestEurekaClientController
 * @Description: TODO
 * @Author shenyaqi
 * @Date 2020/12/14
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "eureka-client-controller")
public class TestEurekaClientController {
    @GetMapping
    public String test(String name){
        return  "eureka成功，参数:"+name;
        //test方法
    }
    @GetMapping(value = "obj")
    public String test2(UserEntity entity){
        return "eureka成功，参数："+entity.getName();
    }
}
