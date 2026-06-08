package com.example.base_spring_boot.controllers;

import com.example.base_spring_boot.models.dtos.req.LoginReq;
import com.example.base_spring_boot.models.dtos.req.RegisterReq;
import com.example.base_spring_boot.models.dtos.req.TokenRefreshRequest;
import com.example.base_spring_boot.models.dtos.wrapper.DataRes;
import com.example.base_spring_boot.models.services.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController
{
    private final IAuthService authService;

    /**
     * @param req LoginReq
     * @apiNote handle login with { username , password }
     */
    @PostMapping("/login")
    public ResponseEntity<?> handleLogin(@Valid @RequestBody LoginReq req)
    {
        return ResponseEntity.status(HttpStatus.OK).body(
                DataRes.builder()
                        .status(HttpStatus.OK)
                        .code(200)
                        .data(authService.login(req))
                        .build()
        );
    }

    /**
     * @param req RegisterReq
     * @apiNote handle register with { fullName , username , password }
     */
    @PostMapping("/register")
    public ResponseEntity<?> handleRegister(@Valid @RequestBody RegisterReq req)
    {
        authService.register(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                DataRes.builder()
                        .status(HttpStatus.CREATED)
                        .code(201)
                        .data("Register successfully")
                        .build()
        );
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody TokenRefreshRequest request) {
        return ResponseEntity.ok(authService.refreshToken(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        authService.logout();
        return ResponseEntity.ok("Logout successfully");
    }

}