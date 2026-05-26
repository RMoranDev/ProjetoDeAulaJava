package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner sc = new Scanner(System.in); // cria o objeto scanner com o nome sc

    public double pedirValorImovel() {
        double valor = -1; // valor inválido garante que o loop execute pelo menos uma vez
        do {
            System.out.println("Digite o valor do imóvel: ");

            try {
                valor = sc.nextDouble();
                if (valor <= 0) {
                    System.out.println("Erro: o valor deve ser positivo. Tente novamente.");
                }
            } catch (InputMismatchException erro) {
                System.out.println("Erro: digite um valor válido. Tente novamente.");
                sc.next(); // serve para consumir e descartar essa entrada inválida da fila
            }
        } while (valor <= 0); // continua repetindo se for inválido
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = -1; // valor inválido garante que o loop execute pelo menos uma vez
        do {
            System.out.println("Digite o prazo do financiamento (entre 20 e 35 anos): ");

            try {
                prazo = sc.nextInt();
                if (prazo < 20 || prazo > 35) {
                    System.out.println("Erro: o prazo deve estar entre 20 e 35 anos. Tente novamente.");
                }
            } catch (InputMismatchException erro) {
                System.out.println("Erro: digite um valor válido. Tente novamente.");
                sc.next();
            }
        } while (prazo < 20 || prazo > 35); // continua no laço se estiver fora de 20 e 35
        return prazo;
    }

    public double pedirTaxaJuros() {
        double taxa = -1; // valor inválido garante que o loop execute pelo menos uma vez
        do {
            System.out.println("Digite a taxa de juros anual (ex: 10): ");
            try {
                taxa = sc.nextDouble();
                if (taxa < 6 || taxa > 15) {
                    System.out.println("Erro: a taxa deve estar entre (6 e 15). Tente novamente.");
                }
            } catch (InputMismatchException erro) {
                System.out.println("Erro: digite um valor válido. Tente novamente.");
                sc.next();
            }
        } while (taxa < 6 || taxa > 15);
        return taxa;
    }
}
