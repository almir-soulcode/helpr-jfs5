package org.soulcodeacademy.helpr.domain.dto;

import org.soulcodeacademy.helpr.domain.enums.Setor;;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FuturoCandidatoDTO {

    @NotBlank(message = "Obrigatório o preenchimento deste campo!")
    private String nomeCompleto;

    @NotNull(message = "Email é obrigatório!")
    @Email(message = "Email inválido")
    private String emailCandidato;

    @NotNull(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Setor é obrigatório!")
    private Setor setor;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmailCandidato() {
        return emailCandidato;
    }

    public void setEmailCandidato(String emailCandidato) {
        this.emailCandidato = emailCandidato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}

