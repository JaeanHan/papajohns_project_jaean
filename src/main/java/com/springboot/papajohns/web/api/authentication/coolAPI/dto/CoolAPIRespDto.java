package com.springboot.papajohns.web.api.authentication.coolAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CoolAPIRespDto<T> {
    private T data;
    private String secret;
}
