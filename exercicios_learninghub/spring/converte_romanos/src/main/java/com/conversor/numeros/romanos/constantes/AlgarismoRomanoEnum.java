package com.conversor.numeros.romanos.constantes;

public enum AlgarismoRomanoEnum {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    private Integer valor;

    AlgarismoRomanoEnum(Integer valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor(String algarismo) {
        if (algarismo == null || "".equals(algarismo)) {
            return null;
        }
        if (this.name().equals(algarismo.toUpperCase().trim())) {
            return this.valor;
        }
        return null;
    }
}
