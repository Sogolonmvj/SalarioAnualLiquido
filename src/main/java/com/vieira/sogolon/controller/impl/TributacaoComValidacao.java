package com.vieira.sogolon.controller.impl;

import com.vieira.sogolon.controller.Tributavel;
import com.vieira.sogolon.controller.Validavel;

public abstract class TributacaoComValidacao implements Tributavel, Validavel {

    @Override
    public final double tributar(double value) {
        if (this.eValido(value)) {
            return this.calcularValorTributado(value);
        }
        throw new IllegalArgumentException("Falha ao tributar o valor = " + value + ".");
    }

    @Override
    public final boolean eValido(double value) {
        return value > 0;
    }

    private double calcularValorTributado(double value) {
      return this.getValorTributado(value);
    }

    protected abstract double getValorTributado(double value);

}
