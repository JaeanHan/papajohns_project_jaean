package com.springboot.papajohns.service.user;

import com.springboot.papajohns.web.controller.api.user.dto.UserJoinReqDto;

public interface UserService {
    public boolean userJoin(UserJoinReqDto userJoinReqDto) throws Exception;

    public boolean checkUsernameDuplication(String username) throws Exception;
}
