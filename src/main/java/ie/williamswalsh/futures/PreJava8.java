package ie.williamswalsh.futures;

import java.util.concurrent.*;

public class PreJava8 {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        // Begin calc in executor thread
        Future<Double> future = executor.submit(new Callable<Double>() {
            public Double call() throws Exception {
                return veryLongCalculation();
            }});

        // Run this while synchronous calculation is executing
        shortCalculation();

        // Get the result if there is one
        // If not wait 10 seconds for a result
        // then timeout
        try {
            Double result = future.get(10, TimeUnit.SECONDS);
            System.out.println("Result: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
    public static double veryLongCalculation(){
        return (((10000000.89 % 3.56)* 2.71)/3.4);
    }
    public static void shortCalculation(){
        System.out.println("Short Calculation Result: " + (2.71/3.4));
    }
}
