package com.springboot.papajohns.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    private int getDrinkRec;
    private int getPagePopup;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
