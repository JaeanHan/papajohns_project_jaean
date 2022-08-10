package com.springboot.papajohns.domain.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface UserRepository {
    public int save(User user) throws Exception;

    public User loadUserByUsername(String username) throws UsernameNotFoundException;
}
