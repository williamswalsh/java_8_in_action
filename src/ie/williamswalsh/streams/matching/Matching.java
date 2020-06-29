package ie.williamswalsh.streams.matching;

import ie.williamswalsh.streams.restaurant.Dish;

import java.util.Optional;

import static ie.williamswalsh.streams.restaurant.Restauraunt.menu;

public class Matching {
    public static void main(String[] args) {

//        anyMatch: Checks if any element fulfills the predicate
//        if any dish is vegetarian
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("Menu has at least one element that matches the isVegetarian predicate.");
        }

//        allMatch: Checks if all elements fulfill the predicate
//        if all dishes have a calorie count less than 1000
        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);


//        noneMatch: Checks if no elements fulfill the predicate
//        if no dish has a calorie count less than 1000
        boolean isNotHealthy = menu.stream().noneMatch(d -> d.getCalories() < 1000);

//        findAny: returns an arbitrary element
//        returns one of the vegetarian dishes
//        returns an Optional<Object>
        Optional<Dish> aVegDish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
    }
}
