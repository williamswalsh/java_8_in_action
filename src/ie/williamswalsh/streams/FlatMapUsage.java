package ie.williamswalsh.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapUsage {
    public static void main(String[] args) {

        // From File
        // ~ in file path doesn't work
        // Relative  path doesn't work
        // good use of flatmap
        // Instead of creating a Stream<Stream<String>> using  map
        // we create a Stream<String> which are words using flatmap
        try(Stream<String> fileLines = Files.lines(Paths.get("/Users/will/code/java/java_8_in_action/src/ie/williamswalsh/streams/notes"), Charset.defaultCharset())){
            long distinctWordCount = fileLines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println("# of distinct words: " + distinctWordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
