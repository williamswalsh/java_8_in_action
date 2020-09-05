package ie.williamswalsh.streams;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class NumberSquares {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

//        Given a list of ints return a list of squares of the ints
        List<Integer> squares = integers.stream()
                .map(d -> d * d)
                .collect(toList());




//        Given 2 lists of ints return all pairs
        List<Integer> listA = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listB = Arrays.asList(3, 4, 5, 6, 7, 8);

        List<int[]> pairs = listA.stream()
                .flatMap(i -> listB.stream()
                                   .map(j -> new int[]{i,j}))
                .collect(toList());


        List<int[]> pairsDivisibleByThree = listA.stream()
                .flatMap(i -> listB.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i,j}))
                .collect(toList());
    }
}
