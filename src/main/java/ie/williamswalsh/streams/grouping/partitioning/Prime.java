package ie.williamswalsh.streams.grouping.partitioning;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.partitioningBy;

public class Prime {

    public static boolean isPrime(int candidate) {
        return IntStream.range(2,candidate)
                .noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrime2(int candidate) {
        int candidateRoot = (int) Math.sqrt((double)candidate);
        return IntStream.rangeClosed(2,candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitioningPrimes(int n){
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(partitioningBy(candidate -> isPrime2(candidate)));
    }

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> map = partitioningPrimes(100);
        System.out.println(map);

        IntStream.range(0, 101).boxed().collect(Collectors.toCollection(HashSet::new)); // ~= collect(toSet());
    }
}
