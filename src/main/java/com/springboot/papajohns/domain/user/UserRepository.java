package com.springboot.papajohns.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    public int save(User user) throws Exception;

    public User loadUserByUsername(String username) throws Exception;
}
