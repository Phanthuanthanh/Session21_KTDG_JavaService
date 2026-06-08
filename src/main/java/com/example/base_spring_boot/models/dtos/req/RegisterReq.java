package com.example.base_spring_boot.models.dtos.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterReq {
    @NotBlank(message = "fullName must be not empty")
    private String fullName;
    @NotBlank(message = "username must be not empty")
    private String username;
    @NotBlank(message = "password must be not empty")
    private String password;
}
