package ie.williamswalsh.functional_design;

public class RecursiveVsIterative {
    private static long factorial(long n) {
        return n==1? 1: n * factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(1000000000));      // Stack overflow
    }
}
