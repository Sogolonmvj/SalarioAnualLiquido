package com.vieira.sogolon.controller.factory;

import com.vieira.sogolon.controller.Tributavel;
import com.vieira.sogolon.tax.Inss;

import java.util.Map;
import java.util.Optional;

public class TributacaoFactory {

    private final Map<Integer, Tributavel> tributavelMap = Map.of(
            1, new Inss()
    );

    public Optional<Tributavel> criar(Integer imposto) {
        return Optional.ofNullable(tributavelMap.get(imposto));
    }

}
