package ie.williamswalsh.patterns.execute_around;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo{
    public static void main(String[] args) throws IOException {

        // Pass a method ref
        System.out.println(processFile(BufferedReader::readLine));

        // Pass a lambda
        System.out.println(processFile((BufferedReader br) -> br.readLine()));

        // Pass a different lambda
        System.out.println(processFile((BufferedReader br) -> br.readLine()));

        // NB: Boiler plate code stays the same for all different behaviours.
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            return processor.process(br);
        }
    }
}
