package com.vieira.sogolon;

import com.vieira.sogolon.controller.Tributavel;
import com.vieira.sogolon.controller.factory.TributacaoFactory;

import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Scanner;

public class CalculadoraSalarioLiquido {

    private static final DecimalFormat formatador = new DecimalFormat("0.00");

    public static void main(String[] args) {
        int imposto = lerNumero("Olá, escolha o desconto a ser calculado: " + "\n" + "Digite 1 para desconto de INSS: ");
        double salario = lerValor("Digite o valor do salário mensal recebido: ");
        double decimoTerceiro = lerValor("Digite o valor do décimo terceiro recebido: ");
        double ferias = lerValor("Digite o valor da remuneração de férias recebido: ");
        double salarioAnualBruto = salario * 12;
        double tributacao = tributar(salario, imposto);
        double tributacaoDecimoTerceiro = tributar(decimoTerceiro/2, imposto);
        double tributacaoSalarialTotal = tributacao * 12;
        double tributacaoTotal = tributacaoSalarialTotal + tributacaoDecimoTerceiro;
        double salarioAnualLiquido = salarioAnualBruto - tributacaoSalarialTotal;
        System.out.println("O seu salário anual bruto é de: " + formatador.format(salarioAnualBruto));
        System.out.println("O seu salário anual líquido é de: " + formatador.format(salarioAnualLiquido));
        System.out.println("O valor total descontado foi de: " + formatador.format(tributacaoTotal));
    }

    private static double tributar(double salario, int imposto) {
        Optional<Tributavel> tributacao = new TributacaoFactory().criar(imposto);

        if (tributacao.isEmpty()) {
            throw new IllegalArgumentException(String.valueOf(imposto));
        }
        return tributacao.get().tributar(salario);
    }

    private static int lerNumero(String mensagem) {
        Scanner entrada = new Scanner(System.in);
        System.out.print(mensagem);
        return entrada.nextInt();
    }

    private static double lerValor(String mensagem) {
        Scanner entrada = new Scanner(System.in);
        System.out.print(mensagem);
        return entrada.nextDouble();
    }
}
