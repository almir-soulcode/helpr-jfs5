package org.soulcodeacademy.helpr.domain.dto;

//Nome (não-vazio);
//CPF (formato cpf);
//Data de Nascimento (não-nula);
//Escolaridade (não-vazio);
//IdResponsavel (funcionário) (não-nulo);

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DependenteDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

        @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotNull(message = "Insira uma data de nascimento válida")
    private Integer dataDeNascimento;

    @NotBlank(message = "Escolaridade é obrigatório")
    private String escolaridade;

    @NotNull(message = "Insira um IdResponsavel válido")
    private String idDependente ;

}