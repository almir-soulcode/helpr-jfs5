package org.soulcodeacademy.helpr.domain.enums;

public enum Setor {

    MARKETING("Marketing"), MANUTENCAO("Manutenção"),
    RECURSOS_HUMANO("Recursos Humanos"), DESENVOLVIMENTO("Desenvolvimento"),
    SUSTENTACAO("Sustentação");

    private final String descricao;

    Setor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
