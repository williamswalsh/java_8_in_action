package ie.williamswalsh.quiz.two;

import ie.williamswalsh.new_vs_old.apples.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(200, "green"),
                new Apple(100, "red"),
                new Apple(220, "red"),
                new Apple(90, "red"),
                new Apple(200, "green"),
                new Apple(20, "brown"),
                new Apple(209, "green"),
                new Apple(100, "red"),
                new Apple(50, "brown"),
                new Apple(500, "green"));

        prettyPrintApple(inventory, new WeightAppleFormatter());
        prettyPrintApple(inventory, new ColorAppleFormatter());
    }

    private static void prettyPrintApple(List<Apple> apples, AppleFormatter appleFormatter) {
        for (Apple apple : apples) {
            String output = appleFormatter.format(apple);
            System.out.println(output);
        }
    }
}
