package com.springboot.papajohns.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
    private int user_code;
    private String name;
    private String username;
    private String password;
    private String email;
    private String contact_phone;
    private String contact_house;
    private String role;
    private LocalDateTime birthday;
    private int gender;

    private int getEmail;
    private int getSms;
    private int getPost;
    private int reward;
    private int popup_drink;
    private int popup_page;

    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
