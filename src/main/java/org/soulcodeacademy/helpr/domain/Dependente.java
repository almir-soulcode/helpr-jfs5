package org.soulcodeacademy.helpr.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

//Não faz 'extends' de Usuario
@Entity
public class Dependente {
    //Nome;
    //CPF;
    //Data de Nascimento;
    //Escolaridade;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dependente")
    private Integer idDependente;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNasc;

    @Column(nullable = false,length = 50)
    private String escolaridade;

    @ManyToOne
    @JoinColumn(name = "id_responsavel", nullable = false)
    private Funcionario responsavel;

    public Dependente(){

    }

    public Dependente(Integer idDependente, String nome, String cpf, LocalDate dataNasc, String escolaridade) {
        this.idDependente = idDependente;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.escolaridade = escolaridade;

    }

    public Integer getIdDependente() {
        return idDependente; // Long?
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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    @Override //para visualizar no console
    public String toString() {
        return "Dependente{" +
                "idDependente=" + idDependente +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNasc=" + dataNasc +
                ", escolaridade='" + escolaridade + '\'' +
                ", funcionario=" + responsavel +
                '}';
    }
}
