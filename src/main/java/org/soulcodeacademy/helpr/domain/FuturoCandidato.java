package org.soulcodeacademy.helpr.domain;
import org.soulcodeacademy.helpr.domain.enums.Setor;

import javax.persistence.*;

@Entity
public class FuturoCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String nomeCompleto;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(nullable = false)
    private String descricaoDasHabilidades;

    @Enumerated(EnumType.STRING)
    private Setor setor;

    public FuturoCandidato (){}

    public FuturoCandidato(Integer id, String nomeCompleto, String email, String descricaoDasHabilidades, Setor setor) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.descricaoDasHabilidades = descricaoDasHabilidades;
        this.setor = setor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "FuturoCandidato{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                ", descricaoDasHabilidades='" + descricaoDasHabilidades + '\'' +
                ", setor=" + setor +
                '}';
    }
}
