package ie.williamswalsh.patterns;

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
    }
}
