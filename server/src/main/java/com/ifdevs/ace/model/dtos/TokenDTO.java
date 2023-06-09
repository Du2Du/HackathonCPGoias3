package com.ifdevs.ace.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TokenDTO {
    private TokenType tokenType;
    private String tokenValue;
    private Long duration;
    private LocalDateTime expiryDate;

    public enum TokenType {
        ACCESS, REFRESH
    }
}