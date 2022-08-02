package com.springboot.papajohns.web.controller;

import com.springboot.papajohns.service.user.UserService;
import com.springboot.papajohns.web.controller.api.user.dto.UserJoinReqDto;
import com.springboot.papajohns.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserJoinReqDto userJoinReqDto) {
        boolean result;
        try {
            result = userService.userJoin(userJoinReqDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "회원가입 실패", null));
        }
        System.out.println(userJoinReqDto);
        return ResponseEntity.ok().body(new CMRespDto<>(1, "회원가입 성공", result));
    }

    @GetMapping("/duplication/{username}")
    public ResponseEntity<?> username(@PathVariable String username) {
        boolean result;

        try {
            result = userService.checkUsernameDuplication(username);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "아이디 중복", null));
        }
        System.out.println(username);
        return ResponseEntity.ok().body(new CMRespDto<>(1, "아이디 사용 가능", result));
    }
}
