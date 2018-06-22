package br.com.testes.completablefuture.loja;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class LojaTeste {
    public static void main(String[] args) {
        Loja americanas = new Loja();
        Loja casasBahia = new Loja();
        Loja walmart = new Loja();
        Loja bestBuy = new Loja();

        long start = System.currentTimeMillis();

/*        System.out.println(americanas.getPreco());
        System.out.println(casasBahia.getPreco());
        System.out.println(bestBuy.getPreco());
        System.out.println(walmart.getPreco());
        System.out.println(System.currentTimeMillis() - start + "ms");*/

        Future<Double> precoAsync = americanas.getPrecoSupplyAsync();
        Future<Double> precoAsync2 = casasBahia.getPrecoSupplyAsync();
        Future<Double> precoAsync3 = walmart.getPrecoSupplyAsync();
        Future<Double> precoAsync4 = bestBuy.getPrecoSupplyAsync();

        long end = System.currentTimeMillis();
        System.out.println("Tempo de invocação: " + (end - start) + "ms");

        enrolando();

        try {
            System.out.println("Americanas: " + precoAsync.get());
            System.out.println("Casas Bahia: " + precoAsync2.get());
            System.out.println("Best Buy: " + precoAsync3.get());
            System.out.println("Walmart: " + precoAsync4.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Tempo que levou para pegar o resultado: " + (System.currentTimeMillis() - start) + "ms");
    }

    public static void enrolando() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma =+ i;
        }
        System.out.println(soma);
    }
}
