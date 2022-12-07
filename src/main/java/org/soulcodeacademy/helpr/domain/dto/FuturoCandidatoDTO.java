package org.soulcodeacademy.helpr.domain.dto;

import org.soulcodeacademy.helpr.domain.enums.Setor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class FuturoCandidatoDTO {


   @NotBlank(message = "Campo nome é obrigatório")
   private String nome;

   @NotBlank(message = "Email é obrigatório")
   @Email(message = "Email inválido")
   private String email;

   @NotBlank(message = "Campo descrição é obrigatório")
   private String descricao;

   @NotBlank(message = "Campo descrição é obrigatório")
   private Setor setor;

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
