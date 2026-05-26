package modelo;

import util.InterfaceUsuario;

public class Financiamento {
    private double valorImovel;
    private double entrada;
    private int prazoFinanciamentoAnos;
    private double taxaJurosAnual;


    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamentoAnos() {
        return this.prazoFinanciamentoAnos;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public double getEntrada() {
        return this.entrada;
    }

    // Construtor
    public Financiamento(double valorImovel,double entrada, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.entrada = entrada;
        this.prazoFinanciamentoAnos = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Métodos
    public double calcularPagamentoMensal() {
        double taxaMensal = (this.taxaJurosAnual / 100) / 12;
        int meses = this.prazoFinanciamentoAnos * 12;
        double valorFinalFinanciamento = this.valorImovel - this.entrada;
        return valorFinalFinanciamento * (taxaMensal * Math.pow(1 + taxaMensal, meses))
                / (Math.pow(1 + taxaMensal, meses) - 1);
    }


    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamentoAnos * 12;
    }


    public void mostrarDados() {
        System.out.println("-".repeat(45));
        System.out.printf("Valor do imóvel: R$ %.2f%n", this.valorImovel);
        System.out.printf("Valor de entrada: R$ %.2f%n", this.entrada);
        System.out.printf("Valor total financiado: R$ %.2f%n", this.valorImovel - this.entrada);
        System.out.printf("Valor da Parcela: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Valor total do financiamento: R$ %.2f%n", calcularTotalPagamento());
        System.out.println("-".repeat(45));

    }
}
