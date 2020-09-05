package ie.williamswalsh.streams.pythagorean_triple;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Generator {
    public static void main(String[] args) {
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 500).boxed().flatMap(a ->
                IntStream.rangeClosed(1, 500).filter( b -> Math.sqrt(a*a + b*b) % 1 == 0)
                .mapToObj( b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)}));

        pythagoreanTriples
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));


        // OR

        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 500).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 500)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                                .filter(t -> t[2] % 1 == 0));


        pythagoreanTriples2
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    }
}
