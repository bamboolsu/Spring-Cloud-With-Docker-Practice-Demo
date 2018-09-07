package com.hjwzyy.contorllers;

import com.hjwzyy.dao.UserRepository;
import com.hjwzyy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangwei.huang@hand-china.com.
 * @version 1.0
 * @name
 * @description
 * @date 2018/6/13 0013.
 */
@RestController
@RefreshScope
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Value("${profile}")
    private String profile;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User u = new User();
        u.setId(id);
        User findOne = this.userRepository.getOne(id);
        return findOne;
    }

    @GetMapping("/getProfile")
    public String getProfileValue(){
        return this.profile;
    }
}
