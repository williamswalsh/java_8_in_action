package ie.williamswalsh.comparing;

import java.util.Comparator;

public class Test {
    public static void main(String[] args) {

        // comparing -> Accepts a function that extracts a Comparable sort key from a type T,
        //              and returns a Comparator<T> that compares by that sort key.
        Comparator<Person> byLastAndFirstName = Comparator.comparing(Person::getLastName)
                                                          .thenComparing(Person::getFirstName);

//        .reversed() Allows for natural order reversing
    }
}

class Person {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
