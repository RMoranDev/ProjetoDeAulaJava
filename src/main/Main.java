package main;

import modelo.Financiamento;
import util.InterfaceUsuario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento>  listaDeFinanciamentos = new ArrayList<Financiamento>();
        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;
        double totalEntradas = 0;

        for (int i = 1; i <= 2; i++) {

            System.out.println("\n--- FINANCIAMENTO " + i + " ---");
            double valorImovel = interfaceUsuario.pedirValorImovel();
            double entrada = interfaceUsuario.pedirValorEntrada(valorImovel);
            int prazoFinanciamentoAnos = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.pedirTaxaJuros();

            Financiamento financiamento = new Financiamento(valorImovel, entrada, prazoFinanciamentoAnos, taxaJurosAnual);
            listaDeFinanciamentos.add(financiamento); // adiciona o mesmo objeto que já foi criado.

            totalEntradas += financiamento.getEntrada();
            totalValorImoveis += financiamento.getValorImovel();
            totalValorFinanciamentos += financiamento.calcularTotalPagamento();
        }
        /* for-each
        int index = 0;
                TIPO        VARIAVEL           LISTA
        for (Financiamento financiamento : listaDeFinanciamentos){
            System.out.println("\n--- DADOS DO FINANCIAMENTO " + index + " ---");
            financiamento.mostrarDados();
            index++;
        }
        */
        for (int i = 0; i < listaDeFinanciamentos.size(); i++) {
            System.out.println("\n--- DADOS DO FINANCIAMENTO " + (i + 1) + " ---");
            listaDeFinanciamentos.get(i).mostrarDados();
        }

        System.out.printf("\nValor total dos imóveis: R$ %.2f%n", totalValorImoveis);
        System.out.printf("\nValor total das entradas: R$ %.2f%n", totalEntradas);
        System.out.printf("\nValor total financiado (sem juros): R$ %.2f%n", totalValorImoveis - totalEntradas);
        System.out.printf("\nValor total financiado (com juros): R$ %.2f%n", totalValorFinanciamentos);
    }
}
