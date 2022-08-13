package com.springboot.papajohns.web.controller.api.user;

import com.springboot.papajohns.config.auth.PrincipalDetails;
import com.springboot.papajohns.domain.user.User;
import com.springboot.papajohns.service.user.UserService;
import com.springboot.papajohns.web.controller.api.user.dto.UserJoinReqDto;
import com.springboot.papajohns.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserJoinReqDto userJoinReqDto) {
        boolean result;

        userJoinReqDto.setPassword(passwordEncoder.encode(userJoinReqDto.getPassword()));

        try {
            result = userService.userJoin(userJoinReqDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "회원가입 실패", null));
        }
        System.out.println(userJoinReqDto);
        return ResponseEntity.ok().body(new CMRespDto<>(1, "회원가입 성공", result));
    }
    
    @GetMapping(value="/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> page() {
        System.out.println("page 호출");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal == null) {
            return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "조회 실패", null));
        }

        User user = ((PrincipalDetails) principal).getUser();
        System.out.println(user);

        return ResponseEntity.ok().body(new CMRespDto<>(1, "조회 성공", user.toRespDto()));
    }

    @GetMapping("/check")
    public String check(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        try {
            System.out.println(principalDetails.getUsername());
        } catch (NullPointerException e) {
            return "null";
        }
        return principalDetails.getUsername();
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
