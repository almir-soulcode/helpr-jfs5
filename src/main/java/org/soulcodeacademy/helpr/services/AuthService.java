package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.dto.CredenciaisDTO;
import org.soulcodeacademy.helpr.domain.dto.TokenDTO;
import org.soulcodeacademy.helpr.security.TokenUtil;
import org.soulcodeacademy.helpr.security.UsuarioSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioSecurityService service;

    @Autowired
    private TokenUtil tokenUtil;

    public TokenDTO login(CredenciaisDTO dto) {
        // Essa linha verifica se o usuário é autêntico/pertence a aplicação/possui acesso
        // O usuário só será autenticado se passar dessa linha abaixo
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha()));
        UserDetails usuario = this.service.loadUserByUsername(dto.getEmail());
        String perfil = this.getPerfil(usuario.getAuthorities());
        String token = this.tokenUtil.gerarToken(dto.getEmail(), perfil);

        return new TokenDTO(token);
    }

    private String getPerfil(Collection<? extends GrantedAuthority> authorities) {
        String perfil = null;

        for (GrantedAuthority authority : authorities) {
            perfil = authority.getAuthority(); // ROLE_...
        }

        return perfil;
    }
}
