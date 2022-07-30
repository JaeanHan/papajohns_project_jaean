package com.springboot.papajohns.web.api.user;

import com.springboot.papajohns.web.dto.CMRespDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("join")
    public ResponseEntity<?> join() {
        return ResponseEntity.ok().body(new CMRespDto<>(1, "url ok", null));
    }
}
