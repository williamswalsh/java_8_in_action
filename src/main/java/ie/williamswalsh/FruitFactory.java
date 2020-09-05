package ie.williamswalsh;

import ie.williamswalsh.new_vs_old.apples.Apple;
import ie.williamswalsh.new_vs_old.apples.Fruit;
import ie.williamswalsh.new_vs_old.apples.Orange;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FruitFactory {
    private static Map<String, Function<Integer, Fruit>> fruitMap = new HashMap<>();

    static {
        fruitMap.put("apple", Apple::new);
        fruitMap.put("orange", Orange::new);
    }

    public static void main(String[] args) {
        Apple apple = (Apple)giveMeFruit("apple", 180);
        Orange orange = (Orange)giveMeFruit("orange", 180);

        // instanceof keyword
    }

    private static Fruit giveMeFruit(String fruit, Integer weight){
        return (fruitMap.get(fruit.toLowerCase())).apply(weight);
    }
}
