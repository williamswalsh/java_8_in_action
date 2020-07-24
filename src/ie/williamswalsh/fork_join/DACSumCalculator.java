package ie.williamswalsh.fork_join;

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class DACSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD=10_000;

    public DACSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public DACSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if(length < THRESHOLD){
            return computeSequentially();
        }
        DACSumCalculator leftTask = new DACSumCalculator(numbers, start, length/2);
        leftTask.fork();
        DACSumCalculator rightTask = new DACSumCalculator(numbers, start + length/2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially(){
        long sum = 0;
        for (int i=start;i< end;i++){
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1,10_000_000).toArray();
        DACSumCalculator calculator = new DACSumCalculator(numbers);
        System.out.println("Result: " + calculator.compute());
    }

}
