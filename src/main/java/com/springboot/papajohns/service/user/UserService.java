package com.springboot.papajohns.service.user;

import com.springboot.papajohns.web.api.user.dto.UserJoinReqDto;

public interface UserService {
    public boolean userJoin(UserJoinReqDto userJoinReqDto) throws Exception;

}
