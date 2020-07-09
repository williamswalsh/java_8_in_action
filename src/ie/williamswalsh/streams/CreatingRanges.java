package ie.williamswalsh.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CreatingRanges {
    public static void main(String[] args) {
        IntStream evenInts = IntStream.rangeClosed(1, 500).filter(i -> i%2==0);
        System.out.println("Number of even ints in range: " + evenInts.count());
    }
}
