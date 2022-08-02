package com.springboot.papajohns.web.controller.api.authentication.coolAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CoolAPIReqDto {
    private String phoneNumber;
}
