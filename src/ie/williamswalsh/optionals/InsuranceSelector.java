package ie.williamswalsh.optionals;

import java.util.Optional;

public class InsuranceSelector {
    public static void main(String[] args) {
    }

    private static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car){
        if(person.isPresent() && car.isPresent()){
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
    }

    private static Insurance findCheapestInsurance(Person person, Car car){
        return new Insurance(100.00);
    }
}
