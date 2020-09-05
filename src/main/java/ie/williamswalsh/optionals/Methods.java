package ie.williamswalsh.optionals;

import java.util.Optional;

public class Methods {
    public static void main(String[] args) {
        Optional<Car> optionalCar = Optional.ofNullable((new Car("Porche 911")));
        Optional<Car> nullCar = Optional.ofNullable(null);


        // get method not the best
        // throws NoSuchElementException if Optional empty
        System.out.println("Car Name: " + optionalCar.get());
//        System.out.println("Car Name: " + nullCar.get());


//         orelse method -> get-or-else method -> get() excluded
        System.out.println("Car Name: " + optionalCar.orElse(new Car("Default: Toyota")));
        System.out.println("Car Name: " + nullCar.orElse(new Car("Default: Toyota")));

//        ifPresent do something
        nullCar.ifPresent((Car car) -> System.out.println("Null car optional contains a Car"));
        optionalCar.ifPresent((Car car) -> System.out.println("\'Non null car\' optional contains a Car"));

//        orElseGet(Supplier) -> lazy counterpart of orElse
//        orElseThrow(ExceptionSupplier) -> can select which exception is thrown
    }
}
