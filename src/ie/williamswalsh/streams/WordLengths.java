package ie.williamswalsh.streams;

import java.util.Arrays;
import java.util.List;

public class WordLengths {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "my", "name", "is", "william");

        words.stream()
                .map(String::length)
                .forEach(System.out::println);

        char[] chars = "william".toCharArray();

//        words.stream()


    }
}
