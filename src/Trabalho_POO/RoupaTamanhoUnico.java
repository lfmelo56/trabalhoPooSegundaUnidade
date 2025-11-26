package Trabalho_POO;

public class RoupaTamanhoUnico extends Peca implements Item{
    public RoupaTamanhoUnico(String descricao, int quantidade, int estoqueMinimo, int estoqueMaximo) {
        super(descricao, quantidade, estoqueMinimo, estoqueMaximo);
    }

    @Override
    public void venda() {
        setQuantidade(getQuantidade() - 1);
    }
}
