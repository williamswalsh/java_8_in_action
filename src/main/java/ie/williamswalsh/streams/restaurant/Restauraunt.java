package ie.williamswalsh.streams.restaurant;

import java.util.Arrays;
import java.util.List;

public class Restauraunt {
    public static List<Dish> menu = Arrays.asList(new Dish("tagelatelli romana", true, 290, Dish.Type.OTHER),
            new Dish("tagelatelli d'Allesandro", false, 320, Dish.Type.MEAT),
            new Dish("spagetti bolognese", false, 360, Dish.Type.MEAT),
            new Dish("fruitti de la mer", false, 300, Dish.Type.FISH),
            new Dish("tagelatelli carbonara", false, 355, Dish.Type.MEAT),
            new Dish("chicken milanese", false, 370, Dish.Type.MEAT));

    private Restauraunt() {}
}
