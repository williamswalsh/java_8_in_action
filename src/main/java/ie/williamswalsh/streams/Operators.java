package ie.williamswalsh.streams;

import ie.williamswalsh.streams.restaurant.Dish;

import java.util.Arrays;
import java.util.List;

public class Operators {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish("tagelatelli romana", true, 290, Dish.Type.OTHER),
                new Dish("tagelatelli d'Allesandro", false, 320, Dish.Type.MEAT),
                new Dish("spagetti bolognese", false, 360, Dish.Type.MEAT),
                new Dish("fruitti de la mer", false, 300, Dish.Type.FISH),
                new Dish("tagelatelli carbonara", false, 355, Dish.Type.MEAT));

//        Get only distinct dish names - no duplicates
//        System.out.println("distinct dish names:");
//        smenu.stream().distinct().forEach(System.out::println);

//        Get the number of distinct dish names
        System.out.println("Number of distinct dish names: " + menu.stream().distinct().count());

//        Intermediate operators -> return streams
//        Terminal operators -> return results


//        Order of stream operators is important:
        System.out.println("---------------------");
        menu.stream()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("---------------------");
        menu.stream()
                .limit(2)
                .skip(1)
                .forEach(System.out::println);

    }
}
