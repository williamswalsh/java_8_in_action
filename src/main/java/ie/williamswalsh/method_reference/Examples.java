package ie.williamswalsh.method_reference;

import ie.williamswalsh.new_vs_old.apples.Apple;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Examples {
    public static void main(String[] args) {

        // 1
        // Function
        Function<Apple, Integer> fxA = (Apple a) -> a.getWeight();

        // More specialised functional interface
        // int returned not Integer
        ToIntFunction<Apple> fxB = (Apple a) -> a.getIntWeight();

        // Method reference
        // int returned not Integer
        ToIntFunction<Apple> fxC = Apple::getIntWeight;


        // 2
        // Static method dumpStack explicitly called from current thread
        Runnable rA = () -> Thread.currentThread().dumpStack();

        // Static method dumpStack of current thread
        Runnable rB = () -> Thread.dumpStack();

        // Method reference
        Runnable rC = Thread::dumpStack;


        // 3
        // Lambda
        BiFunction<String, Integer, String> fxD = (str, i) -> str.substring(i);

        // Method reference
        BiFunction<String, Integer, String> fxE = String::substring;

        // outer function that accepts behaviour
        myFunction(fxD);
    }

    private static void myFunction(BiFunction<String, Integer, String> behaviour){
        System.out.println(behaviour.apply("Hello", 3));
    }
}
