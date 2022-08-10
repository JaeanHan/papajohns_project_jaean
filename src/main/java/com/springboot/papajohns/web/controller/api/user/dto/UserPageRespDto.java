package com.springboot.papajohns.web.controller.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserPageRespDto {
    private String name;
    private String username;
    private String email;
    private String contactHome;
    private String contactPhone;
    private LocalDateTime birthday;
    private int gender;

    private int getEmail;
    private int getSms;
    private int getPost;
    private int reward;
    private int popupDrink;
    private int popupPage;

}
