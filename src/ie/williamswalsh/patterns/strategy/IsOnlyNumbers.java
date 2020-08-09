package ie.williamswalsh.patterns.strategy;

public class IsOnlyNumbers implements ValidationStrategy {

    /**
     * Checks if a string is only numbers
     *
     * @param str String to check
     * @return Whether the string is only numbers
     */
    @Override
    public boolean execute(String str) {
        return str.matches("\\d+");
    }
}
