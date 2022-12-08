package org.soulcodeacademy.helpr.domain.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class DependenteDTO {
    //Nome (não-vazio);
    //CPF (formato cpf);
    //Data de Nascimento (não-nula);
    //Escolaridade (não-vazio);
    //IdResponsavel (funcionário) (não-nulo);
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "CPF é obrigatório!")
    @CPF(message = "O CPF informado é inválido!")
    private String cpf;

    @NotNull(message = "Campo data de Nascimento é obrigatório.")
    private LocalDate dataNasc;

    @NotBlank(message = "Campo escolaridade é obrigatório.")
    private String escolaridade;

    @NotNull(message = "Campo Id do Responsável é obrigatório.")
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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
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
