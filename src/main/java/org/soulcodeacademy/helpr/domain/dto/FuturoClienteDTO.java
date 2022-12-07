package org.soulcodeacademy.helpr.domain.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FuturoClienteDTO {

    @Column(length = 120)
    @NotNull(message = "O nome é obrigatorio")
    private String nome;

    @NotNull
    private String telefone;

    @NotNull(message = "Email é obrigatorio")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "CPF é obrigatorio")
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
