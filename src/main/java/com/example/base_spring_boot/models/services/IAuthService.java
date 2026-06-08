package com.example.base_spring_boot.models.services;

import com.example.base_spring_boot.models.dtos.req.LoginReq;
import com.example.base_spring_boot.models.dtos.req.RegisterReq;
import com.example.base_spring_boot.models.dtos.req.TokenRefreshRequest;
import com.example.base_spring_boot.models.dtos.res.JwtRes;
import com.example.base_spring_boot.models.dtos.res.TokenRefreshResponse;

public interface IAuthService
{

    void register(RegisterReq req);

    JwtRes login(LoginReq req);

    TokenRefreshResponse refreshToken(TokenRefreshRequest request);

    void logout();

}
