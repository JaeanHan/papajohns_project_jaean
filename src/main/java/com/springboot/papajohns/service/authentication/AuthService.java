package com.springboot.papajohns.service.authentication;

import com.springboot.papajohns.web.api.authentication.coolAPI.dto.CoolAPIReqDto;
import com.springboot.papajohns.web.api.authentication.coolAPI.dto.CoolAPIRespDto;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;

import java.util.Map;

public interface AuthService {
    public CoolAPIRespDto<?> sendSMS(CoolAPIReqDto coolAPIReqDto) throws CoolsmsException;
}
