package Trabalho_POO;

public abstract class Peca {
    private String descricao;
    private int quantidade;
    private int estoqueMaximo;
    private int estoqueMinimo;

    public Peca(String descricao, int quantidade, int estoqueMinimo, int estoqueMaximo){
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
    }

    public abstract void venda();

    public void mostrarEstoqueTamanhos(){}

    public void reposicaoEstoque(){
        if (this.quantidade < this.estoqueMinimo)
            this.quantidade = this.estoqueMaximo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 
    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
}
