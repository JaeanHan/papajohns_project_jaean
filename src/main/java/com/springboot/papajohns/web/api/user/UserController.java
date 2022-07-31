package com.springboot.papajohns.web.api.user;

import com.springboot.papajohns.service.user.UserService;
import com.springboot.papajohns.web.api.user.dto.UserJoinReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    @CrossOrigin
    public String join(@RequestBody UserJoinReqDto userJoinReqDto) {
        try {
            userService.userJoin(userJoinReqDto);
        } catch (Exception e) {
            e.printStackTrace();
            return "bad";
        }
        System.out.println(userJoinReqDto);
        return "good";
    }
}
