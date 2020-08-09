package ie.williamswalsh.patterns.strategy;

public class IsOnlyLowerCase implements ValidationStrategy {

    /**
     * Checks if a string is lowercase
     *
     * @param str String to check
     * @return Whether the string is only lowercase characters
     */
    @Override
    public boolean execute(String str) {
        return str.matches("[a-z]+");
    }
}
