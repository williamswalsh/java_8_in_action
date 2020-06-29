import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Test {
    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(1,2,3,4,5);
        List<Integer> listB = Arrays.asList(4,5,6,7,8,9);

        List<int[]> pairs =listA.stream()
                .flatMap(i -> listB.stream()
                                .map(j -> new int[]{i, j})
                ).collect(toList());

        for (int[] pair:pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
