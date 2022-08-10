package com.springboot.papajohns.config.oauth;

import com.springboot.papajohns.config.auth.PrincipalDetails;
import com.springboot.papajohns.config.oauth.provider.NaverUserInfo;
import com.springboot.papajohns.config.oauth.provider.OAuth2UserInfo;
import com.springboot.papajohns.domain.user.User;
import com.springboot.papajohns.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        OAuth2UserInfo oAuth2UserInfo = null;

        if(oAuth2UserRequest.getClientRegistration().getRegistrationId().equals("naver")) {
            oAuth2UserInfo = new NaverUserInfo(oAuth2User.getAttribute("response"));
            System.out.println(oAuth2UserInfo.getName());
        }

        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();

        String username = provider + "_" + providerId;
        String password = new BCryptPasswordEncoder().encode("1234");

        String email = oAuth2UserInfo.getEmail();
        String name = oAuth2UserInfo.getName();

        System.out.println(username);

        User user = userRepository.loadUserByUsername(username);

        if(user == null) {
            System.out.println("hi");
            user = User.builder()
                    .username(username)
                    .password(password)
                    .contact_phone(provider)
                    .email(email)
                    .name(name)
                    .role("ROLE_USER")
                    .build();
            System.out.println(user);

            try {
                userRepository.save(user);
            } catch (Exception e) {
                System.out.println("예외");
            }
        }

        return new PrincipalDetails(user, oAuth2User.getAttributes());
    }
}
