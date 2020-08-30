package ie.williamswalsh.futures;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ShopTest {
    private static List<Shop> shops = Arrays.asList(
            new Shop("Lidl"),
            new Shop("Aldi"),
            new Shop("Tesco"),
            new Shop("Supervalu"));

    // Testing Harness
    public static long measurePerf(Supplier<List<String>> priceFinder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long start = System.nanoTime();
            priceFinder.get();
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static void main(String[] args) {
        long numOfTests = 1;
        System.out.println("findPricesSequentiallyBlock: " + (measurePerf(() -> findPricesSequentiallyBlock(), numOfTests)));    // This method blocks for getPriceSync result -> 4 x 1 seconds
        System.out.println("findPricesParallel: " + (measurePerf(() -> findPricesParallel(), numOfTests)));                      // This method runs each check in a different thread 4 seconds in parallel - >1sec
        System.out.println("findPriceFutures: " + (measurePerf(() -> findPriceFutures(), numOfTests)));
        System.out.println("findPriceFuturesBlocking: " + (measurePerf(() -> findPriceFuturesBlocking(), numOfTests)));
        System.out.println("findPriceCompletableFutures: " + (measurePerf(() -> findPriceCompletableFutures(), numOfTests)));
        System.out.println("findPriceCustomExecutor: " + (measurePerf(() -> findPriceCustomExecutor(), numOfTests)));

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
//        Will start all threads at a very similar time
//        Then the futures are processed to data pieces -> String

        return priceStrFutures.stream()
                .map(CompletableFuture::join)   // Blocking
                .collect(Collectors.toList());
    }

    public static List<String> findPriceFuturesBlocking() {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s has the product at price %.2f", shop.getName(), shop.getPriceSync())))
                .map(CompletableFuture::join)   // Blocking - block all other stream operations
                .collect(Collectors.toList());
    }

    public static List<String> findPriceCompletableFutures() {
        List<CompletableFuture<String>> priceStrFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s has the product at price %.2f", shop.getName(), shop.getPriceSync())))
                .collect(Collectors.toList());

//        Splitting these stream operations allow the first stream to collect and begin processing of the shops prices futures
//        Then the futures are processed to data pieces -> String

        return priceStrFutures.stream()
                .map(CompletableFuture::join)   // Blocking
                .collect(Collectors.toList());
    }

    public static List<String> findPriceCustomExecutor() {
        Executor sizedExecutor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
                    @Override
                    public Thread newThread(@NotNull Runnable r) {
                        Thread thread = new Thread();

                        thread.setDaemon(true);
                        // Daemon threads don't prevent the termination of a program - non-daemons do
                        // This allows the Java program running on the main thread to stop all other forked threads.

                        return thread;
                    }
                });

        List<CompletableFuture<String>> priceStrFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> String.format("%s has the product at price %.2f", shop.getName(), shop.getPriceSync()),
                        sizedExecutor))         // Custom executor
                .collect(Collectors.toList());

        return priceStrFutures.stream()
                .map(CompletableFuture::join)   // Blocking
                .collect(Collectors.toList());
    }
}
