package ie.williamswalsh.new_vs_old;

public class LambdaVSAnonymous {
    public static void main(String[] args) {

        Runnable r1 = () -> System.out.println("Hello World - non inline Lambda");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World - Anonymous Class");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello World - Inline Lambda"));
    }
    public static void process(Runnable r){
        r.run();
    }
}

