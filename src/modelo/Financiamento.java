package modelo;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamentoAnos;
    private double taxaJurosAnual;

    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamentoAnos(){
        return this.prazoFinanciamentoAnos;
    }

    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual;
    }



    // Construtor
    public Financiamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamentoAnos = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Métodos
    public double calcularPagamentoMensal() {
        double taxaMensal = (this.taxaJurosAnual / 100) / 12;
        int meses = this.prazoFinanciamentoAnos * 12;
        return this.valorImovel * (taxaMensal * Math.pow(1 + taxaMensal, meses))
                / (Math.pow(1 + taxaMensal, meses) - 1);
    }

    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamentoAnos * 12;
    }

    public void mostrarDados() {
        System.out.printf("Valor do imóvel: R$ %.2f%n", this.valorImovel);
        System.out.printf("Valor da Parcela: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Valor total do financiamento: R$ %.2f%n", calcularTotalPagamento());

    }
}
