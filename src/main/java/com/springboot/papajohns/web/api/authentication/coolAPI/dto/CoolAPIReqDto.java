package com.springboot.papajohns.web.api.authentication.coolAPI.dto;

import com.springboot.papajohns.web.api.authentication.coolAPI.CoolAPIKey;
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
