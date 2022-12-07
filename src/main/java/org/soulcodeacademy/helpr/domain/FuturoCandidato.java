package org.soulcodeacademy.helpr.domain;

import javax.persistence.*;

@Entity
public class FuturoCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuturoCandidato;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(nullable = false, length = 500)
    private String descricaoHabilidades;

    @Column(nullable = false, length = 80)
    private String setor;

    // Construtor  vazio para ser usado pela ORM
    public FuturoCandidato() {}

    public FuturoCandidato(Integer idFuturoCandidato,String nome,String descricaoHabilidades,String setor) {

        this.idFuturoCandidato = idFuturoCandidato;
        this.nome = nome;
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

    public String getDescricaoHabilidades() {
        return descricaoHabilidades;
    }

    public void setDescricaoHabilidades(String descricaoHabilidades) {
        this.descricaoHabilidades = descricaoHabilidades;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
