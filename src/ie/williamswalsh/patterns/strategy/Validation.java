package ie.williamswalsh.patterns.strategy;

public class Validation {
    private final ValidationStrategy strategy;

    public Validation(ValidationStrategy v) {
        strategy = v;
    }

    public boolean validate(String str) {
        return strategy.execute(str);
    }

    public static void main(String[] args) {

        String str = "hello";
        System.out.println("Only Numbers: " + new Validation(new IsOnlyNumbers()).validate(str));
        System.out.println("Only lowercase: " + new Validation(new IsOnlyLowerCase()).validate(str));


        // No need to construct new class
        System.out.println("Only whitespace: " + new Validation( (String s) -> s.matches("\\w+")).validate(str));
    }
}
