package ie.williamswalsh.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("what", "are", "you", "truly", "capable", "of", "william", "", "?", "Just", "Do", "it", "!");

        List<Integer> lengthUsingLambda = map(stringList, (String s)-> s.length());
        List<Integer> lengthUsingMethodReference = map(stringList, String::length);
    }

    private static <T, R> List<R> map(List<T> list, Function<T,R> function){
        List<R> result = new ArrayList<>();
        for(T element: list){
            result.add(function.apply(element));
        }
        return result;
    }
}