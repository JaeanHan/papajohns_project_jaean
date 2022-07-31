package com.springboot.papajohns.web.api.authentication;

import com.springboot.papajohns.service.authentication.AuthService;
import com.springboot.papajohns.web.api.authentication.coolAPI.CoolAPIKey;
import com.springboot.papajohns.web.api.authentication.coolAPI.dto.CoolAPIReqDto;
import com.springboot.papajohns.web.api.authentication.coolAPI.dto.CoolAPIRespDto;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
