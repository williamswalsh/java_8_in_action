package ie.williamswalsh.streams.restaurant;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Testing {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish("tagelatelli romana", true, 290, Dish.Type.OTHER),
                new Dish("tagelatelli d'Allesandro", false, 320, Dish.Type.MEAT),
                new Dish("spagetti bolognese", false, 360, Dish.Type.MEAT),
                new Dish("fruitti de la mer", false, 300, Dish.Type.FISH),
                new Dish("tagelatelli carbonara", false, 355, Dish.Type.MEAT));

        List<Dish> highCalorieDishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .collect(Collectors.toList());

//       Filtering and printing elements names using streams
        menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .forEach(System.out::println);

//        Collectors to gather sub collections
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
    }

}
