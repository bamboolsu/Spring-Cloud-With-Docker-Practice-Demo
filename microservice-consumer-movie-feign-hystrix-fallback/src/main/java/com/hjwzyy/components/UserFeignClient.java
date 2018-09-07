package com.hjwzyy.components;

import com.hjwzyy.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
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
@FeignClient(name = "microservice-provider-user",fallback = FeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") Long id);

    @GetMapping(value = "/get")
    public User get(@RequestParam Map<String,Object> map);
}

/**
 * 回退类FeignClientFallback 需要实现UserFeignClient 接口
 */
@Component
class FeignClientFallback implements FallbackFactory<UserFeignClient>{


    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(@PathVariable("id") Long id) {
                User user = new User();
                user.setId(-1L);
                user.setName("默认用户");
                return user;
            }

            @Override
            public User get(@RequestParam Map<String, Object> map) {
                User user = new User();
                user.setId(-1L);
                user.setName("默认用户");
                return user;
            }
        };
    }
}
