package ie.williamswalsh.functional_interface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class Exceptions {
    public static void main(String[] args) throws FileNotFoundException {

        Function<BufferedReader, String> fx = (BufferedReader br) -> {
            try{
                return br.readLine() + "\n" +  br.readLine();
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        };
        System.out.println(processFile(fx));
    }

    private static String processFile(Function<BufferedReader,String> fx) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        return fx.apply(br);
    }
}
