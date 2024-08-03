package com.example.demo.Enum;

import lombok.Getter;

@Getter
public enum Sexo {

    MASCULINO(0, 'M', "Masculino"),
    FEMININO(1, 'F', "Feminino"),
    NAO_INFORMADO(2, 'N', "Outros");

    private final int codigo;
    private final char abreviacao;
    private final String descricao;

    Sexo(int codigo, char abreviacao, String descricao) {
        this.codigo = codigo;
        this.abreviacao = abreviacao;
        this.descricao = descricao;
    }

    public static Sexo fromCodigo(int codigo) {
        for (Sexo sexo : values()) {
            if (sexo.getCodigo() == codigo) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Código Inválido" + codigo);
        //return Sexo.NAO_INFORMADO
    }
}
