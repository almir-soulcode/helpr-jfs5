package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.SetorFuturoCandidato;

import javax.persistence.*;

@Entity
public class FuturoCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuturoCandidato;

    @Column(nullable = false, length = 150)
    private String nomeCompleto;

    @Column(nullable = false, unique = false, length = 120)
    private String email;

    @Column(nullable = false, length = 1200)
    private String descricaoHabilidades;

    @Enumerated(EnumType.STRING)
    private SetorFuturoCandidato setor;

    public FuturoCandidato() { }

    // Construtor
    public FuturoCandidato(Integer idFuturoCandidato, String nomeCompleto, String email, String descricaoHabilidades, SetorFuturoCandidato setor) {
        this.idFuturoCandidato = idFuturoCandidato;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.descricaoHabilidades = descricaoHabilidades;
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

    public String getDescricaoHabilidades() {
        return descricaoHabilidades;
    }
    public void setDescricaoHabilidades(String descricaoHabilidades) {
        this.descricaoHabilidades = descricaoHabilidades;
    }

    public SetorFuturoCandidato getSetor() {
        return setor;
    }
    public void setSetor(SetorFuturoCandidato setor) {
        this.setor = setor;
    }
}
