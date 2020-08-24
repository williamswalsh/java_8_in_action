package ie.williamswalsh.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
//        Future<Double> futureOfPrice = getPriceAsync();
        Future<Double> futureOfPrice = getPriceAsyncShort();
        long endOfInvocation = System.nanoTime();
        System.out.println("Duration of invocation: " + ((endOfInvocation - start)/1_000_000));

        try {
            double price = futureOfPrice.get();
            long endOfExecution = System.nanoTime();
            System.out.println("Duration of execution: " + ((endOfExecution - start)/1_000_000));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static double getPriceSync(){
        calcPrice();
        return 43.07725189119 * 1266.9000200; // ~5 milliseconds
    }

    // Long way
    public static Future<Double> getPriceAsync(){
        CompletableFuture<Double> future = new CompletableFuture<>();

        new Thread(() -> {
            try{
                double price = calcPrice();
//                throw new IllegalArgumentException("What an exception");              // (Just for testing)
                future.complete(price);
            } catch (Exception e){
                future.completeExceptionally(e);        // Will wrap the thrown exception and will log it in the main thread
            }
        }).start();

        return future;
    }

    /**
     * This method performs all the exception handling just as the long version does
     * @return double wrapped in a Completable Future
     */
    public static Future<Double> getPriceAsyncShort(){
        return CompletableFuture.supplyAsync(() -> calcPrice());
    }

    /**
     * @return Just a double
     */
    public static double calcPrice(){
        delay();
        return 43.07725189119 * 1266.9000200; // ~5 milliseconds
    }

    private static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
