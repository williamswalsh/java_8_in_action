package ie.williamswalsh.streams.optionals;

import ie.williamswalsh.streams.restaurant.Dish;

import static ie.williamswalsh.streams.restaurant.Restauraunt.menu;

public class OptionalTest {

    public static void main(String[] args) {
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()                          // Returns an Optional<Dish>
                .ifPresent(System.out::println);    // Works on optional
                // Takes a consumer ^^ -> Takes an argument returns void


    }
}
