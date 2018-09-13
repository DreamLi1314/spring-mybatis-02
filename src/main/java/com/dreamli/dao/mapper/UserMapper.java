package com.dreamli.dao.mapper;

import org.springframework.stereotype.Repository;

import com.dreamli.domain.User;

/**
 * @Description: User Mapper, @Repository 标注这是一个 DAO 层的 Mapper
 * @Warning: 
 * @Author: dreamli
 * @Package: spring-mybatis-01 - com.dreamli.dao.mapper.UserMapper.java
 * @Date: Sep 12, 2018 11:41:13 PM
 * @Version: 1.0.0
 */
@Repository
public interface UserMapper {
	public User findUserById(int id) throws Exception;
}
