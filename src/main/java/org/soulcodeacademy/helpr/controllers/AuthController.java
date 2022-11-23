package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.dto.CredenciaisDTO;
import org.soulcodeacademy.helpr.domain.dto.TokenDTO;
import org.soulcodeacademy.helpr.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/auth/login")
    public TokenDTO login(@Valid @RequestBody CredenciaisDTO dto) {
        return this.authService.login(dto);
    }
}
