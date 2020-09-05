package ie.williamswalsh.optionals;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<Integer> i = Optional.empty();
        i.get();
    }
}
