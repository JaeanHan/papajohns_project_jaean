package com.springboot.papajohns.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CMRespDto<T> {
    private int code;
    private String msg;
    private T data;
}
