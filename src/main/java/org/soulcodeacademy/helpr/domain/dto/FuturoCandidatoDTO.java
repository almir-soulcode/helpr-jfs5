package org.soulcodeacademy.helpr.domain.dto;


import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class FuturoCandidatoDTO {

    @NotBlank(message = "Campo nome é obrigatório! Por favor manter campor preenchido.")
    private String nome;

    @NotBlank(message = "Campo email é obrigatório! Por favor manter campor preenchido.")
    private String email;

    @NotBlank(message = "Campo Descricao de Habilidades é obrigatório! Por favor manter campor preenchido.")
    private String descricaoHabilidades;

    @NotBlank(message = "Campo setor é obrigatório! Por favor manter campor preenchido.")
    private String setor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricaoHabilidades() {
        return descricaoHabilidades;
    }

    public void setDescricaoHabilidades(String descricaoHabilidades) {
        this.descricaoHabilidades = descricaoHabilidades;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
