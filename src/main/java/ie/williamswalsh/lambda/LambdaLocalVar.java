package ie.williamswalsh.lambda;

public class LambdaLocalVar {


    public static void main(String[] args) {

//        Working
        int portA = 8080;
        Runnable rA = () -> System.out.println(portA);



//        Non working
//        Local variables referenced from a lambda must be final or effectively final
        int portB = 8080;
//        Runnable rB = () -> System.out.println(portB);
        portB = 344;
    }
}
