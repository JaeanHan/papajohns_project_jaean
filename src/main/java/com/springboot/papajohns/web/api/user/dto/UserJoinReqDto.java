package com.springboot.papajohns.web.api.user.dto;

import com.springboot.papajohns.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserJoinReqDto {
    private String name;
    private String username;
    private String password;
    private String email;
    private String contactHome;
    private String contactPhone;
    private LocalDateTime birthday;
    private int gender;

    private int getEmail;
    private int getSMS;
    private int getPost;

    private int reward;

    private int getDrinkRec;
    private int getPagePopup;

    public User toEntity() {
        return User.builder()
                .name(name)
                .username(username)
                .password(password)
                .email(email)
                .contact_house(contactHome)
                .contact_phone(contactPhone)
                .birthday(birthday)
                .gender(gender)
                .getEmail(getEmail)
                .getSms(getSMS)
                .getPost(getPost)
                .reward(reward)
                .popup_drink(getDrinkRec)
                .popup_page(getPagePopup)
                .build();
    }
}
