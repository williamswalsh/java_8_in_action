package ie.williamswalsh.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("what", "are", "you", "truly", "capable", "of", "william", "", "?", "Just", "Do", "it", "!");

        Predicate<String> p = (String s) -> !s.isEmpty();
//        Same one with stream
        filter(stringList,p).forEach(System.out::println);

//        cannot pass !String::isEmpty
//        filter(stringList, String::isEmpty).forEach(System.out::println);
//        filter(stringList,(String s) -> !s.isEmpty()).stream().forEach(System.out::println);
    }

    private static <T> List<T> filter(List<T> elements, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for(T e: elements){
            if(predicate.test(e)){
                results.add(e);
            }
        }
        return results;
    }
}


