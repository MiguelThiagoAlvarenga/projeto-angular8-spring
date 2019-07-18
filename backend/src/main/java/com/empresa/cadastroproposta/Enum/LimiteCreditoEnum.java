package com.empresa.cadastroproposta.Enum;

public enum LimiteCreditoEnum {

    ENTRE_500_1000(1, "Entre 500 - 1000"),
    ENTRE_100_500(2, "Entre 100 - 500"),
    ENTRE_1500_2000(3, "Entre 1500 - 2000"),
    REPROVADO(4, "Reprovado pela política de crédito"),
    RENDA_BAIXA(5, "Renda baixa"),
    SUPERIOR_2000(6, "Superior a 2000");

    public final String descricao;
    public final long id;

    LimiteCreditoEnum(long id, String nome) {

        this.descricao = nome;
        this.id = id;
    }
}
