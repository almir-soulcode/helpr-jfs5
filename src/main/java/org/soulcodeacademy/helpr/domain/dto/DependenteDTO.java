package org.soulcodeacademy.helpr.domain.dto;
import org.hibernate.validator.constraints.br.CPF;

//Nome (não-vazio);
//CPF (formato cpf);
//Data de Nascimento (não-nula);
//Escolaridade (não-vazio);
//IdResponsavel (funcionário) (não-nulo);

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;



public class DependenteDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @CPF (message = "CPF inválido")
    @NotBlank (message = "CPF é obrigatório")
    private String cpf;

    @NotNull(message = "Insira uma data de nascimento válida")
    private LocalDate dataDeNascimento;

    @NotBlank(message = "Escolaridade é obrigatório")
    private String escolaridade;

    @NotNull
    private  Integer idFuncionario;

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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }


}