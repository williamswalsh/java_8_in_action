package ie.williamswalsh.quiz.two;

import ie.williamswalsh.new_vs_old.apples.Apple;

public class WeightAppleFormatter implements AppleFormatter {
    @Override
    public String format(Apple apple) {
        return "Weight: " + apple.getWeight();
    }
}
