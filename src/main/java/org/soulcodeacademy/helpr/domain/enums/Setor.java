package org.soulcodeacademy.helpr.domain.enums;

// Usamos enum pelo numero de opcoes limitadas que temos para setor


public enum Setor {
    MARKETING("ROLE_MARKETING"),

    MANUTECAO("ROLE_MANUTENCAO"),

    RH("ROLE_RH"),

    DESENVOLVIMENTOESUSTENTACAO("ROLE_DESENVOLVIMENTOESUSTENTACAO"),
    ;

    private String descricao;

    Setor(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
