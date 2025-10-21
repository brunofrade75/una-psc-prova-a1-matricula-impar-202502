//Nome: Bruno Henrique Frade Silva
//RA: 325222381

import java.util.Scanner;

public class Main {

    public static double calcularTaxaReducao(int populacaoInicial, int populacaoAtual) {
        double taxa = (1 - (double) populacaoAtual / populacaoInicial) * 100;
        return taxa;
    }

    public static boolean estaEmRiscoCritico(double taxaReducao) {
        return taxaReducao >= 90.0;
    }

    public static int simularImpactoAbate(int populacaoAtual, int abatesAnuais, int anosSimulados) {
        int populacaoRestante = populacaoAtual - (abatesAnuais * anosSimulados);
        return populacaoRestante;
    }

    public static void exibirDeclaracaoFinal(int populacaoRestante, int anos) {
    System.out.println("\n Resultado da Simulação  ");
    System.out.println("População restante após " + anos + " anos: " + populacaoRestante + " jumentos.");

        if (populacaoRestante <= 0) {
    System.out.println(" Alerta: A espécie pode ser extinta se os abates continuarem nesse ritmo.");
        } else {
    System.out.println("Ainda há esperança. Iniciativas de conservação são essenciais.");
        }

        System.out.println("\nPrograma de Monitoramento Finalizado.");
    }

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        int populacaoInicial = 1400000;
        int populacaoAtual = 84000;
        int abatesAnuais = 50000;

        System.out.println(" S.O.S. JUMENTO NORDESTINO - SISTEMA DE MONITORAMENTO ");
        System.out.println("População inicial de referência: " + populacaoInicial);
        System.out.println("População atual estimada: " + populacaoAtual);
        System.out.println("Abates anuais (simulados): " + abatesAnuais);

        double taxaReducao = calcularTaxaReducao(populacaoInicial, populacaoAtual);
        System.out.printf("\n[Análise Inicial] Taxa de Redução Histórica: %.2f%%\n", taxaReducao);

        boolean emRisco = estaEmRiscoCritico(taxaReducao);
        if (emRisco) {
            System.out.println(" Espécie em Risco Crítico (Redução > 90%)!");
        } else {
            System.out.println("[Status] Espécie sob risco moderado.");
        }

        System.out.print("\nQuantos anos futuros você deseja simular o impacto dos abates (Ex: 1, 3, 5)? ");
        int anosSimulados = scanner.nextInt();

        int populacaoRestante = simularImpactoAbate(populacaoAtual, abatesAnuais, anosSimulados);

        exibirDeclaracaoFinal(populacaoRestante, anosSimulados);

    }
}
