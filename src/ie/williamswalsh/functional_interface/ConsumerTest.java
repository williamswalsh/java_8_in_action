package ie.williamswalsh.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
//    Consumer
//    Takes parameter returns void
//    (T t) -> {}
    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T element:list) {
//
            c.accept(element);
        }
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("what", "are", "you", "truly", "capable", "of", "william", "", "?", "Just", "Do", "it", "!");
        Consumer<String> consumer = (String s) -> System.out.println(s);
        forEach(stringList, consumer);
    }
}
