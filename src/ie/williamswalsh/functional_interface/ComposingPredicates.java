package ie.williamswalsh.functional_interface;

import java.util.function.Predicate;

public class ComposingPredicates {
    public static void main(String[] args) {

//        Predicate chaining
//        !     .negate()
//        and   .and()
//        or    .or()


        Predicate<String> isEmpty = (String s) -> s.isEmpty();

//        negate ()
        Predicate<String> isNotEmpty = isEmpty.negate();

        Predicate<String> isEmptyAndShort = isEmpty.and((String s)-> s.length() < 10);

        Predicate<String> isEmptyAndShortOr20Long = isEmptyAndShort.or((String s) -> s.length() == 20);
    }
}
