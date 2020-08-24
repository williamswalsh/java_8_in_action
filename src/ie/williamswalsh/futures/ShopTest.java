package ie.williamswalsh.futures;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ShopTest {
    private static List<Shop> shops = Arrays.asList(
            new Shop("Lidl"),
            new Shop("Aldi"),
            new Shop("Tesco"),
            new Shop("Supervalu"));

    private static final Executor sizedExecutor =
            Executors.newFixedThreadPool(Math.max(shops.size(), 100), new ThreadFactory() {
                @Override
                public Thread newThread(@NotNull Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true);          // This allows the Java program running on the main thread to stop all other forked threads.
                    return t;
                }
            });

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(findPricesSequentiallyBlock());             // This method blocks for getPriceSync result -> 4 x 1 seconds
        long endOfInvocation = System.nanoTime();
        System.out.println("Duration of invocation: " + ((endOfInvocation - start)/1_000_000)); // 4082 milliseconds

//        start = System.nanoTime();
//        System.out.println(findPricesParallel());             // This method runs each check in a different thread 4 seconds in parallel - >1sec
//        endOfInvocation = System.nanoTime();
//        System.out.println("Duration of invocation: " + ((endOfInvocation - start)/1_000_000));

        start = System.nanoTime();
        System.out.println(findPriceFutures());
        endOfInvocation = System.nanoTime();
        System.out.println("Duration of invocation: " + ((endOfInvocation - start)/1_000_000));

        start = System.nanoTime();
        System.out.println(findPriceFuturesBlocking());
        endOfInvocation = System.nanoTime();
        System.out.println("Duration of invocation: " + ((endOfInvocation - start)/1_000_000));

        start = System.nanoTime();
        System.out.println(findPriceCustomExecutor());
        endOfInvocation = System.nanoTime();
        System.out.println("Duration of invocation: " + ((endOfInvocation - start)/1_000_000));

    }



    public static List<String> findPricesSequentiallyBlock() {
        return shops.stream()
                .map(shop -> String.format("%s has the product at price %.2f", shop.getName(), shop.getPriceSync()))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesParallel() {
        return shops.parallelStream()
                .map(shop -> String.format("%s has the product at price %.2f", shop.getName(), shop.getPriceSync()))
                .collect(Collectors.toList());
    }

    public static List<String> findPriceFutures() {
        List<CompletableFuture<String>> priceStrFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s has the product at price %.2f", shop.getName(), shop.getPriceSync())))
                .collect(Collectors.toList());

//        Splitting these stream operations allow the first stream to collect and begin processing of the shops prices futures
//        Then the futures are processed to data pieces -> String

        return priceStrFutures.stream()
                .map(CompletableFuture::join)   // Blocking
                .collect(Collectors.toList());
    }

    public static List<String> findPriceFuturesBlocking() {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s has the product at price %.2f", shop.getName(), shop.getPriceSync())))
                .map(CompletableFuture::join)   // Blocking
                .collect(Collectors.toList());
    }

    public static List<String> findPriceCustomExecutor() {
        List<CompletableFuture<String>> priceStrFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s has the product at price %.2f", shop.getName(), shop.getPriceSync()), sizedExecutor))
                .collect(Collectors.toList());

//        Splitting these stream operations allow the first stream to collect and begin processing of the shops prices futures
//        Then the futures are processed to data pieces -> String

        return priceStrFutures.stream()
                .map(CompletableFuture::join)   // Blocking
                .collect(Collectors.toList());
    }
}
