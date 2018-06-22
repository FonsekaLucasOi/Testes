package br.com.testes.completablefuture.loja;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class NovaLojaTeste {
    public static void main(String[] args) {
        List<Loja> lojas = asList(
                new Loja("Americanas"),
                new Loja("Casas Bahia"),
                new Loja("WalMart"),
                new Loja("BestBuy"),
                new Loja("Americanas"),
                new Loja("Casas Bahia"),
                new Loja("WalMart"),
                new Loja("BestBuy"),
                new Loja("Americanas"),
                new Loja("Casas Bahia"),
                new Loja("WalMart"),
                new Loja("BestBuy"),
                new Loja("Americanas"),
                new Loja("Casas Bahia"),
                new Loja("WalMart"),
                new Loja("BestBuy"));
        acharPrecos(lojas);
        acharPrecosAsync(lojas);
        acharPrecosAsyncCompletableFuture(lojas);
        acharPrecosAsyncCompletableFutureDivindoStreams(lojas);
    }

    private static List<String> acharPrecos(List<Loja> lojas) {
        System.out.println("Stream sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.stream()
                .map(loja -> String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco()))
                .collect(Collectors.toList());
        System.out.println("Tempo que levou para pegar o resultado: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecosAsync(List<Loja> lojas) {
        System.out.println("Stream paralela");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.parallelStream()
                .map(loja -> String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco()))
                .collect(Collectors.toList());
        System.out.println("Tempo que levou para pegar o resultado: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecosAsyncCompletableFuture(List<Loja> lojas) {
        System.out.println("Completable Future Sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco())
                ))
                .map(CompletableFuture::join)
                .collect(Collectors.toList());


        System.out.println("Tempo de invocação: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecosAsyncCompletableFutureDivindoStreams(List<Loja> lojas) {
        System.out.println("Completable Future");
        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> precoFuturo = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco())
                ))
                .collect(Collectors.toList());
        System.out.println("Tempo de invocação: " + (System.currentTimeMillis() - start) + "ms");

        List<String> collect = precoFuturo.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("Tempo que levou para pegar o resultado: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println(collect);

        return collect;
    }
}
