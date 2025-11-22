package Trabalho_POO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RoupaPMG extends Peca {
    private int quantidadeP;
    private int quantidadeM;
    private int quantidadeG;

    public RoupaPMG(String descricao, int quantidadeP, int quantidadeM, int quantidadeG,
                    int estoqueMinimo, int estoqueMaximo) {
        super(descricao, (quantidadeP + quantidadeM + quantidadeG), estoqueMinimo, estoqueMaximo);
        this.quantidadeP = quantidadeP;
        this.quantidadeM = quantidadeM;
        this.quantidadeG = quantidadeG;
    }

    public void venda() {
        try {
            Scanner kb = new Scanner(System.in);
            boolean ok = false;

            do {
                System.out.println("Qual o tamanho? (P/M/G)");
                char tam = kb.next().toUpperCase().charAt(0);
                if (tam == 'P') {
                    this.quantidadeP--;
                    ok = true;

                } else {
                    if (tam == 'M') {
                        if (this.quantidadeP <= 0) {
                            System.out.println("Erro: Estoque insuficiente para tamanho M!");
                        }
                    this.quantidadeM--;
                    ok = true;

                    } else {
                        if (tam == 'G') {
                            if (this.quantidadeP <= 0) {
                                System.out.println("Erro: Estoque insuficiente para tamanho G!");
                            }
                        this.quantidadeG--;
                        ok = true;

                        } else {
                            System.out.println("Op inválida. Escolha P, M ou G.");
                        }
                    }
                }
            } while (!ok);
            setQuantidade(quantidadeP + quantidadeM + quantidadeG);
        } catch (InputMismatchException e) {
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

    @Override
    public void mostrarEstoqueTamanhos(){
        System.out.println(  "P: " + quantidadeP +
                " | M: " + quantidadeM +
                " | G: " + quantidadeG);
    }
}
