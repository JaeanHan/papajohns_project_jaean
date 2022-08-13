package com.springboot.papajohns.web.controller.api.user.dto;

import com.springboot.papajohns.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserJoinReqDto {
    @NotBlank(message = "이름은 필수항목 입니다.")
    private String name;
    @NotBlank(message = "영문, 숫자만 포함한 4~12자리 문자여야합니다.")
    @Pattern(regexp = "^\\w{4,12}$")
    private String username;
    @NotBlank(message = "영문, 숫자, 특수문자를 각각 1이상씩 포함한 8~16자리 문자여야합니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[-~!@#$%^&*_+=])[a-zA-Z\\d-~!@#$%^&*_+=]{8,16}$")
    private String password;
    @NotBlank(message = "이메일은 필수항목입니다")
    private String email;
    private String contactHome;
    @NotBlank(message = "휴대전화 번호는 필수항목입니다.")
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
                .get_email(getEmail)
                .get_sms(getSMS)
                .get_post(getPost)
                .reward(reward)
                .popup_drink(getDrinkRec)
                .popup_page(getPagePopup)
                .build();
    }
}
