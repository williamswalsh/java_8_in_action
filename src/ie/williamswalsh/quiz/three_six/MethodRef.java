package ie.williamswalsh.quiz.three_six;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class MethodRef {
    public static void main(String[] args) {


        // General functional interface
        // Lambda
        Function<String, Integer> stringIntegerFunctionA = (String s) -> Integer.parseInt(s);

        // No autoboxing
        // Method reference
        ToIntFunction<String> stringIntegerFunctionB = Integer::parseInt;

        // Lambda
        BiPredicate<List<String>, String> containsA = (List<String>list, String element) -> list.contains(element);

        // Method reference
        BiPredicate<List<String>, String> containsB = List::contains;

    }
}
