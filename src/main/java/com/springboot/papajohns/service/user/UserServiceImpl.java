package com.springboot.papajohns.service.user;

import com.springboot.papajohns.domain.user.UserRepository;
import com.springboot.papajohns.web.api.user.dto.UserJoinReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public boolean userJoin(UserJoinReqDto userJoinReqDto) throws Exception {
        return userRepository.save(userJoinReqDto.toEntity()) > 0;
    }
}
