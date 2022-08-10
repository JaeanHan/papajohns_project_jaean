package com.springboot.papajohns.config.oauth.provider;

public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();
    String getEmail();
    String getName();
    String getBirthYear();
    String getBirthday();
    String getPhone();
}
