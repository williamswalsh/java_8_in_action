package ie.williamswalsh.functional_interface.resource_processing;

import java.util.function.Function;

public class FunctionPipeline {
    public static void main(String[] args) {



    }

    Function<String, String> addHeader = Letter::addHeader;
    Function<String, String> checkSpelling = Letter::checkSpelling;

//    Just like UNIX pipe - cat file.txt | head 30 | grep "william" | wc -l
    Function<String, String> pipeline = addHeader.andThen(checkSpelling);
}

class Letter {

    protected static String addHeader(String input){
        return "From william walsh: " + input
    }
    protected static String checkSpelling(String input){
        return input.replace("labda", "lambda");
    }
}
