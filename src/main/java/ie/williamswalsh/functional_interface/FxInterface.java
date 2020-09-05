package ie.williamswalsh.functional_interface;

import ie.williamswalsh.new_vs_old.apples.Apple;

import java.util.function.Predicate;

public class FxInterface {

    public static void main(String[] args) {
        Predicate<Apple> p = (Apple a) -> a.isFresh();
//        Doesn't match signature of abstract method in functional interface
//        Predicate<Apple> p = (Apple a) -> a.getWeight();
    }
}




