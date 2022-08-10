package com.springboot.papajohns.config.oauth.provider;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class NaverUserInfo implements OAuth2UserInfo {
    private Map<String, Object> attributes;

    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getProvider() {
        return "Naver";
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getBirthYear() {
        return null;
    }

    @Override
    public String getBirthday() {
        return (String) attributes.get("birthday");
    }

    @Override
    public String getPhone() {
        return null;
    }
}
