package ie.williamswalsh.quiz.three_five;

import java.util.function.Function;

public class WontCompileTest {
    public static void main(String[] args) {
//        This is incorrect, why?
//        Object o = () -> { System.out.println("Challenge"); };

        Runnable runnable = () -> { System.out.println("Challenge"); };
//        Assignment return type is Object
//        Takes no parameters
//        returns void
//        Runnable
//        () -> void
    }
}
