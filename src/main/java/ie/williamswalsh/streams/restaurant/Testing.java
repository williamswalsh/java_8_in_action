package ie.williamswalsh.streams.restaurant;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static ie.williamswalsh.streams.restaurant.Restauraunt.menu;
import static java.util.stream.Collectors.groupingBy;

public class Testing {

    public static void main(String[] args) {

        List<Dish> highCalorieDishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .collect(Collectors.toList());

//       Filtering and printing elements names using streams
        System.out.println("---------------------");
        menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .forEach(System.out::println);

//        Collectors to gather sub collections
        System.out.println("---------------------");
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));


        System.out.println("---------------------");
        menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .forEach(System.out::println);
    }

}
