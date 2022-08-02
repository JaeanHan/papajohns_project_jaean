package com.springboot.papajohns.web.controller;

import com.springboot.papajohns.service.authentication.AuthService;
import com.springboot.papajohns.web.controller.api.authentication.coolAPI.dto.CoolAPIReqDto;
import com.springboot.papajohns.web.controller.api.authentication.coolAPI.dto.CoolAPIRespDto;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/authentication")
@RequiredArgsConstructor
public class SendController {
    private final AuthService authService;

    @GetMapping("cool")
    public String coolAPI(String phoneNumber) {
        CoolAPIReqDto coolAPIReqDto = CoolAPIReqDto.builder()
                .phoneNumber(phoneNumber)
                .build();
        CoolAPIRespDto coolAPIRespDto;
        try {
            coolAPIRespDto = authService.sendSMS(coolAPIReqDto);
        } catch (CoolsmsException e) {
            e.printStackTrace();
            return "false";
        }
        return coolAPIRespDto.getSecret();
    }
}
