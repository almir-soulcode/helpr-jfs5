package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Setor;

import javax.persistence.*;

@Entity
public class FuturoCandidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuturoCandidato;

    @Column(nullable = false, length = 100)
    private String nomeCompleto;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 120)
    private String descricaoDasHabilidades;

    @Column(nullable = false)
    private Setor setor;

    public FuturoCandidato() {

    }

    public FuturoCandidato(Integer idFuturoCandidato, String nomeCompleto, String email, String descricaoDasHabilidades, Setor setor) {
        this.idFuturoCandidato = idFuturoCandidato;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.descricaoDasHabilidades = descricaoDasHabilidades;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricaoDasHabilidades() {
        return descricaoDasHabilidades;
    }

    public void setDescricaoDasHabilidades(String descricaoDasHabilidades) {
        this.descricaoDasHabilidades = descricaoDasHabilidades;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
