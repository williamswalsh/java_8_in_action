package ie.williamswalsh.testing_performance;

import java.util.stream.LongStream;

public class BadAccumulator {
    public static long sideEffect(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(0, n)
                .forEach(accumulator::add);
        return accumulator.total;
    }


    public static long sideEffectParallel(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(0, n)
                .parallel()
                .forEach(accumulator::add);
        return accumulator.total;
    }

    public static void main(String[] args) {
        System.out.println("Iterative style method: " + sideEffect(10_000_000));            // Works
        System.out.println("Iterative style method: " + sideEffectParallel(10_000_000));    // Doesn't work due to threads writing to the same shared state
    }
}

class Accumulator {
    public long total = 0;

    public void add(long value) {
        total += value;             // This is not an Atomic operation -> This breaks when multiple threads are executing this
    }
}