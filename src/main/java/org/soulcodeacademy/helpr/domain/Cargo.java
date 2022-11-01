package org.soulcodeacademy.helpr.domain;

import javax.persistence.*; // JPA = JAVA PERSISTENCE API

// Transformar a classe em uma entidade/tabela no banco
@Entity
public class Cargo { // nome da tabela = cargo
    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Integer idCargo; // será a chave primária da tabela

    @Column(nullable = false, length = 50) // NOT NULL, e máximo de 50 caracteres
    private String nome;
    @Column(nullable = false, length = 120) // NOT NULL, e 120 caracteres
    private String descricao;
    @Column(nullable = false) // @Column serve para customizar a coluna
    private Double salario;

    // a ORM irá usar este construtor em conjunto dos getters/setters
    public Cargo() {}

    public Cargo(Integer idCargo, String nome, String descricao, Double salario) {
        this.idCargo = idCargo;
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
