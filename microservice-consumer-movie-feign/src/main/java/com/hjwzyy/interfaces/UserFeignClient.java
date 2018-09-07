package com.hjwzyy.interfaces;

import com.hjwzyy.config.FooConfiguration;
import com.hjwzyy.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author jiangwei.huang@hand-china.com.
 * @version 1.0
 * @name
 * @description
 * @date 2018/8/7 0007.
 */
@FeignClient(name = "microservice-provider-user",configuration = FooConfiguration.class)
public interface UserFeignClient {

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") Long id);

    @GetMapping(value = "/get")
    public User get(@RequestParam Map<String,Object> map);
}
