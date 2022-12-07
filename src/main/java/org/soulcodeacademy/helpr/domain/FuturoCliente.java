package org.soulcodeacademy.helpr.domain;

import javax.persistence.*;

@Entity
public class FuturoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 70, nullable = false)
    public String nome;
    @Column(unique = true, nullable = false)
    public String telefone;

    @Column(unique = true, nullable = false)
    public String email;
    @Column(unique = true, nullable = false)
    public String cpf;

    public FuturoCliente() {
    }

    public FuturoCliente(Integer id, String nome, String telefone, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
