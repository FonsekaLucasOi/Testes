package br.com.testes.lambdas.test;

import java.util.List;

public class Carrinho {

    private List<Produto> produtos;

    public Carrinho(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void aplicarDesconto(int porcentagem, Condition<Produto> condition) {
        for (Produto produto : produtos) {
            if (condition.incluir(produto)) {
                produto.setValor(produto.getValor() * (100 - porcentagem) / 100);
            }
        }
    }
}
