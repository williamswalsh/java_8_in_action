package ie.williamswalsh.functional_interface.resource_processing;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ResourceProcessingTest {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(new File(".").listFiles()));

//        Can add any behaviour to the process method
//        Behaviour parameterization
        processFile((BufferedReader br) -> br.readLine() + br.readLine());

//        Same meaning
        processFile((BufferedReader br) -> br.readLine());
        processFile(BufferedReader::readLine);

        processFile((BufferedReader br) -> String.valueOf(br.read(new char[10],5, 15)));
        processFile((BufferedReader br) -> null);
    }

    private static String processFile(@NotNull BufferedReaderProcessor processor) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return processor.process(br);
        }
    }
}
