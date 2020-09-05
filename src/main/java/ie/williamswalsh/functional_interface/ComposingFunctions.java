package ie.williamswalsh.functional_interface;

import java.util.function.Function;

public class ComposingFunctions {
    public static void main(String[] args) {
        Function<Integer,Integer> fx1 = x -> x + 1;
        Function<Integer,Integer> fx2 = x -> x * 2;

        Function<Integer,Integer> fx3 = fx1.andThen(fx2);   // Result fx3(3): 3 + 1 then 4 * 2 = 8
        Function<Integer,Integer> fx4 = fx1.compose(fx2);   // Result fx4(3): 3 * 2 then 6 + 1 = 7

//        andThen g(f(x))
//        compose f(g(x))
    }
}
