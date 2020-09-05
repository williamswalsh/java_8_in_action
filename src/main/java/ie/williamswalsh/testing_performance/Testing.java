package ie.williamswalsh.testing_performance;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Testing {

    // Old - 3 msecs
    // NO AutoBoxing time
    // For loop works at much lower level(not a large startup time)
    public static long iterativeSum(long n) {
        long result = 0;
        for (long l = 1L; l <= n; l++) {
            result += l;
        }
        return result;
    }

    // Java8 - 99 msecs
    // AutoBoxing time
    // Larger startup fee
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    // Java8 multicore - 130 msecs
    // AutoBoxing time
    // Larger startup fee
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long rangeClosedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long rangeClosedSumParallel(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    // Testing Harness
    public static long measureAdderPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static void main(String[] args) {
        System.out.println("Iterative Sum function duration(milliseconds): " + measureAdderPerf(Testing::iterativeSum, 10_000_000));
        System.out.println("Sequential Sum function duration(milliseconds): " + measureAdderPerf(Testing::sequentialSum, 10_000_000));
        System.out.println("Parallel Sum function duration(milliseconds): " + measureAdderPerf(Testing::parallelSum, 10_000_000));
        System.out.println("Range Closed Sum Unboxed function duration(milliseconds): " + measureAdderPerf(Testing::rangeClosedSum, 10_000_000));
        System.out.println("Parallel Range Closed Sum Unboxed duration(milliseconds): " + measureAdderPerf(Testing::rangeClosedSumParallel, 10_000_000));
    }



}
