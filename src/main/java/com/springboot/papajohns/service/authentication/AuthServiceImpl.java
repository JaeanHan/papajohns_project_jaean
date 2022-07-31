package com.springboot.papajohns.service.authentication;

import com.springboot.papajohns.web.api.authentication.coolAPI.CoolAPIKey;
import com.springboot.papajohns.web.api.authentication.coolAPI.dto.CoolAPIReqDto;
import com.springboot.papajohns.web.api.authentication.coolAPI.dto.CoolAPIRespDto;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final CoolAPIKey coolAPIKey;

    @Override
    public CoolAPIRespDto<Object> sendSMS(CoolAPIReqDto coolAPIReqDto) throws CoolsmsException {
        Message coolsms = new Message(coolAPIKey.getApiKey(), coolAPIKey.getApiSecret());
        String randCode = makeRandCode();
        String comment = "[스프링부트 프로젝트] 휴대전화 인증 코드입니다 : ";

        HashMap<String, String> map = new HashMap<>();

        map.put("from", "01035189984");
        map.put("to", coolAPIReqDto.getPhoneNumber());
        map.put("type", "sms");
        map.put("text", comment + randCode);
        map.put("app_version", "text app 1.0");

        JSONObject obj = (JSONObject) coolsms.send(map);
        return CoolAPIRespDto.builder()
                .data(obj)
                .secret(randCode)
                .build();
    }

    private String makeRandCode() {
        Random random = new Random();
        StringBuilder secret = new StringBuilder();

        for(int i=0; i<4; i++) {
            String tmp = Integer.toString(random.nextInt(10));
            secret.append(tmp);
        }

        System.out.println(secret);

        return secret.toString();
    }
}
