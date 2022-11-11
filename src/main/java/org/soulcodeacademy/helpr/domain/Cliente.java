package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {
    @Column(length = 25) // VARCHAR(25)
    private String telefone;

    public Cliente() { // obrigatório para a ORM mapear as tabelas/dados

    }

    public Cliente(Integer id, String nome, String email, String cpf, String senha, String telefone) {
        super(id, nome, email, cpf, senha, Perfil.CLIENTE);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
