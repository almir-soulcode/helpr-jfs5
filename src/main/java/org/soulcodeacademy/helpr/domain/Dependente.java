package org.soulcodeacademy.helpr.domain;

import javax.persistence.*;

//Nome;
//CPF;
//Data de Nascimento;
//Escolaridade;

@Entity
public class Dependente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDependente;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String dataDeNascimento;

    @Column(nullable = false)
    private String escolaridade;

    @ManyToOne
    @JoinColumn(name = "id_responsavel", nullable = false) // Cria a coluna "id_responsavel" em dependente
    private Funcionario responsavel;

    public Dependente() {}

    public Dependente(Integer idDependente, String nome, String cpf, String dataDeNascimento, String escolaridade) {
        this.idDependente = idDependente;
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.escolaridade = escolaridade;
    }

    public Integer getIdDependente() {
        return idDependente;
    }

    public void setIdDependente(Integer idDependente) {
        this.idDependente = idDependente;
    }

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

    public void setEscolaridade (String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }
}
