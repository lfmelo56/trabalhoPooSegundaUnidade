package Trabalho_POO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Acessorio extends Peca implements Item{
    public Acessorio(String descricao, int quantidade, int estoqueMinimo, int estoqueMaximo) {
        super(descricao, quantidade, estoqueMinimo, estoqueMaximo);
    }
    
    @Override
    public void venda() {
        try {
            Scanner kb = new Scanner(System.in);
            System.out.println("Escreva a quantidade vendida em números");
            int quantidadeVendida = kb.nextInt();
            boolean excecao = false;
            while (!excecao) {
                if (quantidadeVendida <= 0) {
                    System.out.println("Erro: Quantidade deve ser maior que zero!");
                    quantidadeVendida = kb.nextInt();
                } else {
                    if (quantidadeVendida > getQuantidade()) {
                        System.out.println("Erro: Estoque insuficiente! Tente novamente.");
                        quantidadeVendida = kb.nextInt();
                    } else {
                        excecao = true;
                    }
                }
            }
            int novaQuantidade = getQuantidade() - quantidadeVendida;
            setQuantidade(novaQuantidade);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um número válido.");
        }
    }
}
