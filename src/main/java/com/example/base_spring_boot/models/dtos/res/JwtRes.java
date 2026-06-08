package com.example.base_spring_boot.models.dtos.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JwtRes {
    private String accessToken;
    private String refreshToken;
    @Builder.Default
    private final String type = "Bearer";
    private Set<String> roles;
}
