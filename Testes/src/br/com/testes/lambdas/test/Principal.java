package br.com.testes.lambdas.test;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Tênis", 300));
        produtos.add(new Produto("Camiseta", 80));
        produtos.add(new Produto("Calça", 100));

        Carrinho carrinho = new Carrinho(produtos);

        carrinho.aplicarDesconto(20, produto -> produto.getValor() < 110);

        carrinho.getProdutos().forEach(System.out::println);

    }

}
