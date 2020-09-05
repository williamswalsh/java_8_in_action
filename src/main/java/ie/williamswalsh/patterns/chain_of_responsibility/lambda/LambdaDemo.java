package ie.williamswalsh.patterns.chain_of_responsibility.lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class LambdaDemo {
    private final static UnaryOperator<String> headerProcessing = (String text) -> "William's Heading:\n" + text;
    private final static UnaryOperator<String> spellingProcessing = (String text) -> text.replaceAll("lamda", "lambda");
    private final static Function<String, String> pipeline = headerProcessing.andThen(spellingProcessing);

    public static void main(String[] args) {
        System.out.println(pipeline.apply("I really like Java 8 streams and lamdas.")); // Typo intended
    }
}
