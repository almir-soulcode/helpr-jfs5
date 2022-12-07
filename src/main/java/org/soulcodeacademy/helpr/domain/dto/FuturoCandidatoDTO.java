package org.soulcodeacademy.helpr.domain.dto;

import org.soulcodeacademy.helpr.domain.enums.Setor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FuturoCandidatoDTO {

    @NotBlank(message = "O nome completo é obrigatório")
    private String nomeCompleto;

    @Email(message = "Email inválido")
    @NotBlank(message = "O E-mail é obrigatório")
    private String email;


    @NotBlank(message = "A descrição das habilidades são obrigatórias")
    @Size(max = 120)
    private String descricaoDasHabilidades;

    @NotBlank(message = "O setor é obrigatório")
    private Setor setor;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricaoDasHabilidades() {
        return descricaoDasHabilidades;
    }

    public void setDescricaoDasHabilidades(String descricaoDasHabilidades) {
        this.descricaoDasHabilidades = descricaoDasHabilidades;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
