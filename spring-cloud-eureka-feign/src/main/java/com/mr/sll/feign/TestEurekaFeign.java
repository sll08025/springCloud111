package com.mr.sll.feign;

import com.mr.sll.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EUREKA-CLIENT")
public interface TestEurekaFeign {
    @GetMapping(value = "eureka-client-controller")
    String test(@RequestParam String name);
    @GetMapping(value = "eureka-client-controller/obj",consumes = MediaType.APPLICATION_JSON_VALUE)
    String test2(@SpringQueryMap UserEntity userEntity);

}
