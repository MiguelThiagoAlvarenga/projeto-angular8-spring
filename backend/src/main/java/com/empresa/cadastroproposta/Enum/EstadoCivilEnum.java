package com.empresa.cadastroproposta.Enum;

public enum EstadoCivilEnum {

    SOLTEIRO(1, "Solteiro(a)"),
    DIVORCIADO(2, "Divorciado(a)"),
    CASADO(3, "Casado(a)"),
    VIUVO(4, "Viúvo(a)");

    public final String descricao;
    public final Integer id;

    EstadoCivilEnum(Integer id, String nome) {
        this.descricao = nome;
        this.id = id;
    }
}
