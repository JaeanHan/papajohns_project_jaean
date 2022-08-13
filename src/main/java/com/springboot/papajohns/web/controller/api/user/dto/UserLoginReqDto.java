package com.springboot.papajohns.web.controller.api.user.dto;

import javax.validation.constraints.NotBlank;

public class UserLoginReqDto {
    @NotBlank(message = "필수 항목입니다.")
    private String username;
    @NotBlank(message = "필수 항목입니다.")
    private String password;

}
