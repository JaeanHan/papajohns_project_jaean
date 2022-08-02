package com.springboot.papajohns.service.authentication;

import com.springboot.papajohns.web.controller.api.authentication.coolAPI.dto.CoolAPIReqDto;
import com.springboot.papajohns.web.controller.api.authentication.coolAPI.dto.CoolAPIRespDto;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public interface AuthService {
    public CoolAPIRespDto<?> sendSMS(CoolAPIReqDto coolAPIReqDto) throws CoolsmsException;
}
