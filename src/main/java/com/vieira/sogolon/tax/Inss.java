package com.vieira.sogolon.tax;

import com.vieira.sogolon.controller.impl.TributacaoComValidacao;

public class Inss extends TributacaoComValidacao {
    @Override
    protected double getValorTributado(double value) {
        if (value >= 0 && value <= 1212.00) {
            return value * 0.075;
        }
        if (value >= 1212.01 && value <= 2427.35) {
            return value * 0.09;
        }
        if (value >= 2427.36 && value <= 3641.03) {
            return value * 0.12;
        }
        if (value >= 3641.04 && value <= 7087.22) {
            return value * 0.14;
        }
        if (value >= 7087.23) {
            return 900.00;
        }
        return 0.00;
    }
}
