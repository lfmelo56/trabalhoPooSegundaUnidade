package Trabalho_POO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Item[] estoque = new Item[5];

        estoque[0] = new Acessorio("Camisa", 10, 2, 20);
        estoque[1] = new RoupaTamanhoUnico("Saia", 15, 3, 25);
        estoque[2] = new Acessorio("Cinto", 8, 1, 15);
        estoque[3] = new Acessorio("Pulseira", 20, 5, 30);
        estoque[4] = new RoupaPMG("Saída de praia", 5, 5, 5, 2, 10);

        try {
            int opcao = -1;
            String menu = "0 – Camisa\n"
                    + "1 – Saia\n"
                    + "2 – Cinto\n"
                    + "3 – Pulseira\n"
                    + "4 – Saída de praia\n"
                    + "5 – Sair do sistema\n"
                    + "Escolha uma opção:";

            while (opcao != 5) {
                System.out.println("\n--- SISTEMA DE CONTROLE DE ESTOQUE ---");
                System.out.println(menu);

                opcao = scanner.nextInt();

                if (opcao >= 0 && opcao <= 4) {
                    Item produto = estoque[opcao];

                    System.out.println("\nProduto: " + produto.getDescricao());
                    System.out.println("Estoque atual: " + produto.getQuantidade());

                    produto.venda();

                    produto.reposicaoEstoque();

                    System.out.println("Estoque atualizado: " + produto.getQuantidade());

                } else if (opcao == 5) {
                    System.out.println("\n---------------------------------------");
                    System.out.println("       ESTOQUE FINAL DOS PRODUTOS");
                    System.out.println("---------------------------------------");

                    for (int i = 0; i < estoque.length; i++) {
                        Item produto = estoque[i];
                        System.out.println("\n" + i + " - " + produto.getDescricao());
                        System.out.println("   Estoque: " + produto.getQuantidade());

                        produto.mostrarEstoqueTamanhos();
                    }

                    System.out.println("\n---------------------------------------");
                    System.out.println("           Sistema encerrado!\n                  :D");
                    System.out.println("---------------------------------------");

                } else {
                    System.out.println("\nOp inválida! Tente novamente.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um número válido.");
        } 
        scanner.close();
    }
}