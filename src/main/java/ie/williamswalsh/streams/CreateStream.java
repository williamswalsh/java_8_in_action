package ie.williamswalsh.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        // From text values
        Stream<String> stringStream = Stream.of("Hello", "World", "Java", "8", "in", "Action", "Whuupahhh!!");
        stringStream.forEach(System.out::println);

        // Empty Stream
        Stream<String> empty = Stream.empty();

        // From Arrays
        int[] intArr = { 4, 5, 88, 9};
        Arrays.stream(intArr).filter(a -> a % 2==1).forEach(System.out::println);
        //          IntStream.sum() .max() .min()


        // From File
        // ~ in file path doesn't work
        // Relative  path doesn't work
        try(Stream<String> fileLines = Files.lines(Paths.get("/Users/will/code/java/java_8_in_action/src/ie/williamswalsh/streams/notes"), Charset.defaultCharset())){
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
