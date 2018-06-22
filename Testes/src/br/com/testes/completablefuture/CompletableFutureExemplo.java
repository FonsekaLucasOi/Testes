package br.com.testes.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExemplo {

    public static void main(String... args) throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(string -> System.out.print(string));
        Thread.sleep(1000);

        CompletableFuture<String> completableFuture1 = new CompletableFuture<>();
        completableFuture1.complete("Olá Mundo!");
        completableFuture1.thenAccept(string -> System.out.println(string));
        Thread.sleep(1000);
    }

}
