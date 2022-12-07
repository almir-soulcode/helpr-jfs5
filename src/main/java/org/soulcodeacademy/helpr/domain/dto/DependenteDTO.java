package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class DependenteDTO {
    @NotBlank(message = "Campo Dependente obrigatório")
    private String nome;

    @NotBlank(message = "Campo CPF obrigatório")
    private String cpf;

    @NotNull(message = "Campo data nascimento obrigatório")
    private Date dataNascimento;

    @NotBlank(message = "Campo Escolaridade obrigatório")
    private String escolaridade;

    @NotNull(message = "Campo Responsável Obrigatório")
    private Integer idResponsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }
}

