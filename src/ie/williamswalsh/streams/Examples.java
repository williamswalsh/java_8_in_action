package ie.williamswalsh.streams;

import ie.williamswalsh.streams.restaurant.Dish;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ie.williamswalsh.streams.restaurant.Restauraunt.menu;
import static java.util.Comparator.comparing;

public class Examples {
    public static void main(String[] args) {
        Optional<Dish> lowestCalorieDish = menu.stream()
                                                .min(comparing(Dish::getCalories));

        int min = (lowestCalorieDish.isPresent())? lowestCalorieDish.get().getCalories():0;
        int min2=  lowestCalorieDish.map(Dish::getCalories).orElse(0);

        System.out.println("Lowest Calorie Count: " + min2);



//        This line is slow as autoboxing occurs every cycle
        int sum = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);       // 0-based sum

//        Primitive specializations
//        IntStream, DoubleStream, LongStream
//        Avoid boxing costs

//        Stream -> Primitive Stream
//        mapToInt, mapToLong, mapToDouble

        int sumWithNoBoxing = menu.stream()                     // Stream<Dish>
                .mapToInt(Dish::getCalories)                    // IntStream
                .sum();                                         // int

        // Stream pipeline?? Sonarlint rule
        IntStream primitiveIntStream = menu.stream()             // Stream<Dish>
                .mapToInt(Dish::getCalories);                    // IntStream

//        Primitive Stream -> Stream
        Stream<Integer> reboxedStream = primitiveIntStream.boxed();

//        Optional<Object> also has primitive specializations
//        OptionalInt, OptionalDouble, OptionalLong
        OptionalInt maxCalories = menu.stream()
                                      .mapToInt(Dish::getCalories)
                                      .max();

//        Provide explicit default value 0
//        max returns Optional -> max().orElse(0);
//        can build in the default into the stream statement
        int answer = maxCalories.orElse(0);

    }
}
