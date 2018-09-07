package com.hjwzyy.contorllers;

import com.hjwzyy.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiangwei.huang@hand-china.com.
 * @version 1.0
 * @name
 * @description
 * @date 2018/6/13 0013.
 */
@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback2")
    @GetMapping("/user/{id}")
    public User findById2(@PathVariable Long id){
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id,User.class);
    }

    public User findByIdFallback2(@PathVariable Long id){
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;

    }

    @GetMapping("/log-user-instance")
    public void logUserinstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        UserController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
