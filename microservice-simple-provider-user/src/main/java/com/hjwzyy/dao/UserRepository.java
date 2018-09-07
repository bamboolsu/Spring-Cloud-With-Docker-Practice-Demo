package com.hjwzyy.dao;

import com.hjwzyy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jiangwei.huang@hand-china.com.
 * @version 1.0
 * @name
 * @description
 * @date 2018/6/13 0013.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
