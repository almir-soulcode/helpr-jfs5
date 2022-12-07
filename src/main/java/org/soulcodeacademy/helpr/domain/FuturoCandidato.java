package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Setor;

import javax.persistence.*;

@Entity
public class FuturoCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuturoCandidato;

    @Column(length = 150, nullable = false)
    private String nomeCompleto;

    @Column(unique = false)
    private String emailCandidato;

    @Column(length = 250)
    private String descricao;

    @Column(length = 100)
    private Setor setor;

    public FuturoCandidato () {}

    public FuturoCandidato(Integer idFuturoCandidato, String nomeCompleto, String emailCandidato, String descricao, Setor setor) {
        this.idFuturoCandidato = idFuturoCandidato;
        this.nomeCompleto = nomeCompleto;
        this.emailCandidato = emailCandidato;
        this.descricao = descricao;
        this.setor = setor;
    }

    public Integer getIdFuturoCandidato() {
        return idFuturoCandidato;
    }

    public void setIdFuturoCandidato(Integer idFuturoCandidato) {
        this.idFuturoCandidato = idFuturoCandidato;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmailCandidato() {
        return emailCandidato;
    }

    public void setEmailCandidato(String emailCandidato) {
        this.emailCandidato = emailCandidato;
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
