package org.soulcodeacademy.helpr.domain.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DependenteDTO {
  @NotBlank(message = "Campo nome é obrigatório")
  public String nome;

   @CPF
   public String cpf;

   @NotBlank(message = "Campo data de nascimento é obrigatório")
    public String dataDeNascimento;

   @NotNull(message = "Campo escolaridade é obrigatório")
   public String escolaridade;

    @NotNull
    private Integer idFuncionario;

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

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
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
