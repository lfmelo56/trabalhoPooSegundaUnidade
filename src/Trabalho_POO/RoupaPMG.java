package Trabalho_POO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RoupaPMG implements Item {
    private int quantidadeP;
    private int quantidadeM;
    private int quantidadeG;
    private int quantidade;  
    private int getEstoqueMinimo() {
        return 5;  
    }

    public RoupaPMG(String descricao, int quantidadeP, int quantidadeM, int quantidadeG, int estoqueMinimo, int estoqueMaximo) {
        this.quantidadeP = quantidadeP;
        this.quantidadeM = quantidadeM;
        this.quantidadeG = quantidadeG;
        this.quantidade = quantidadeP + quantidadeM + quantidadeG;
    }

    private int getEstoqueMaximo() {
        return 10; 
    }

    public void venda() {
        try {
            Scanner kb = new Scanner(System.in);
            boolean ok = false;

            do {
                System.out.println("Qual o tamanho? (P/M/G)");
                String input = kb.next();
                if (input.length() == 0) {
                    System.out.println("Entrada inválida. Escolha P, M ou G.");
                    continue;
                }
                char tam = input.toUpperCase().charAt(0);
                if (tam == 'P') {
                    this.quantidadeP--;
                    ok = true;

                } else if (tam == 'M') {
                    this.quantidadeM--;
                    ok = true;

                } else if (tam == 'G') {
                    this.quantidadeG--;
                    ok = true;

                } else {
                    System.out.println("Op inválida. Escolha P, M ou G.");
                }
            } while (!ok);
            setQuantidade(quantidadeP + quantidadeM + quantidadeG);

        } catch (
                InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um caractere válido.");
        }
    }

    public void reposicaoEstoque() {
        if (quantidadeP < getEstoqueMinimo()) {
            quantidadeP = getEstoqueMaximo();
        }
        if (quantidadeM < getEstoqueMinimo()) {
            quantidadeM = getEstoqueMaximo();
        }
        if (quantidadeG < getEstoqueMinimo()) {
            quantidadeG = getEstoqueMaximo();
        }
        setQuantidade(quantidadeP + quantidadeM + quantidadeG);
    }

    public int getQuantidadeP() {
        return quantidadeP;
    }

    public int getQuantidadeM() {
        return quantidadeM;
    }

    public int getQuantidadeG() {
        return quantidadeG;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public void mostrarEstoqueTamanhos() {
        System.out.println("P: " + quantidadeP +
                " | M: " + quantidadeM +
                " | G: " + quantidadeG);
    }
}
