package ie.williamswalsh.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateInfiniteStream {
    public static void main(String[] args) {

        // Create a stream which starts at 0,
        // the lambda is used to create the next elem from the existing element
//        Stream.iterate(0, n -> n+2)
//                .limit(10)
//                .forEach(System.out::println);

        // Fibonacci Sequence with Stream.iterate
        // Starting Value: new int[]{0, 1}
        // Next instance formula is a lambda:
        //                  n -> new int[]{ (n[0] + n[1]), (n[1] + (n[0] + n[1]) ) }
        //
        Stream.iterate(new int[]{0, 1}, n -> new int[]{ (n[0] + n[1]), (n[1] + (n[0] + n[1]) ) })
                .limit(10)
                .forEach(t -> System.out.print(t[0] + "," + t[1] + ","));
        System.out.println();

        // Raoul-Gabriel Urma Method: Java 8 in action
        Stream.iterate(new int[]{0, 1}, n -> new int[]{ n[1], (n[0] + n[1]) })
                .limit(10)
                .map(n -> n[0])
                .forEach(n -> System.out.print(n + ","));



        // Creates an infinite stream of 1s
        IntStream ints = IntStream.generate(() -> 1);
    }
}
