package org.soulcodeacademy.helpr.domain;

import javax.persistence.*;

@Entity
public class FuturoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuturoCliente;
    @Column(nullable = false, length = 120)
    private String nome;
    @Column (nullable = false)
    private String telefone;
    @Column (nullable = false)
    private String email;
    @Column (nullable = false)
    private String cpf;

    public FuturoCliente (){

    }
    public FuturoCliente(Integer idFuturoCliente, String nome, String telefone, String email, String cpf) {
        this.idFuturoCliente = idFuturoCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;

    }

    public Integer getIdFuturoCliente() {
        return idFuturoCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setIdFuturoCliente(Integer idFuturoCliente) {
        this.idFuturoCliente = idFuturoCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

