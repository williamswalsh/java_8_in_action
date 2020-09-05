package ie.williamswalsh.constructor_ref;

import ie.williamswalsh.new_vs_old.apples.Apple;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {

        // Supplied -> get()

        // Lambda
        // Provide nothing
        // == new Apple();
        Supplier<Apple> fx1 = () -> new Apple();
        Apple a1 = fx1.get();

        // Provide nothing
        // ~ new Apple();
        Supplier<Apple> fx2 = Apple::new;
        Apple a2 = fx2.get();

        // ~ new Apple(int i);
        // Provide an int
        // Construct & return an apple
        IntFunction<Apple> fx3 = Apple::new;
        Apple a3 = fx3.apply(110);

        // naming the variable that can be passed to the constructor
        Function<Integer, Apple> fx4 = (weight) -> new Apple(weight);
        Apple a4 = fx4.apply(110);

        // More specific functional interface
        IntFunction<Apple> fx5 = (weight) -> new Apple(weight);

        // Method reference taking int returning Apple
        IntFunction<Apple> fx6 = Apple::new;

        // Constructing Apple object
        BiFunction<Integer, String, Apple> fx7 = Apple::new;
        Apple a7 = fx7.apply(230, "green");

    }
}
