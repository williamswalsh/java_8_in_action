package ie.williamswalsh.work_testing;

import java.util.Optional;

public class OptionalOfNullable {
    public static void main(String[] args) {
        Optional<Integer> i = Optional.of(new Integer(7));
//        Optional<Integer> i2 = Optional.of(null);  // NPE

        Optional<Integer> i3 = Optional.ofNullable(new Integer(7));
        Optional<Integer> i4 = Optional.ofNullable(null);

        System.out.println("Present: " + i4.isPresent());
    }
}
