package com.springboot.papajohns.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    int save(User user) throws Exception;
}
