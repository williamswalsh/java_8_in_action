package ie.williamswalsh.optionals;

import java.util.Optional;

public class Creating {
    public static void main(String[] args) {

//        Create empty optional
        Optional<Car> optionalCar = Optional.empty();

//        Create optional from definitely non null Object
//        Null Object -> NPE thrown
        Car car = null;
//        optionalCar = Optional.of(car);


//        Create optional from possibly null Object
//        Null Object -> No issue
        optionalCar = Optional.ofNullable(car);

        car = new Car("Audi R8");

        optionalCar = Optional.ofNullable(car);
        System.out.println("Car name: " + optionalCar.map(Car::getName));       // Optional[Audi R8]

//        System.out.println("Car name: " + optionalCar.flatMap(car1 -> {
//            return car1.getName(); }));       // Audi R8
    }
}

class Car{
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}