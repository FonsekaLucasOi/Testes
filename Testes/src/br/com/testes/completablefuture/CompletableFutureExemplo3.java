package br.com.testes.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExemplo3 {

    public static void main(String... args) throws InterruptedException {
        final CompletableFuture<String> cf1 = new CompletableFuture<>();
        new Thread(() -> {
            try {
                if (new Random().nextInt(2) == 0) {
                    throw new InterruptedException("Exceção");
                } else {
                    cf1.complete("OK");
                }
            } catch (Exception ex) {
                cf1.completeExceptionally(ex);
            }
        }).start();

        cf1.exceptionally(ex -> {
            System.out.println("Erro =" + ex.getMessage());
            return "Erro";
        }).thenAccept(string -> System.out.println("Ok = " + string));

        Thread.sleep(1000);

    }

}
