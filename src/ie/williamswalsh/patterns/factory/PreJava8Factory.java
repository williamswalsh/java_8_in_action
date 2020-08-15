package ie.williamswalsh.patterns.factory;

import java.util.function.Supplier;

public class PreJava8Factory {
    public static Product getInstance(String name){
        switch (name){
            case "loan": return new Loan();
            case "bond": return new Bond();
            case "stock": return new Stock();
            default: throw new RuntimeException("No such product " + name);
        }
    }

    public static void main(String[] args) {
        Product p = PreJava8Factory.getInstance("loan");
        Loan    l = (Loan) PreJava8Factory.getInstance("loan");


        // Functional Interface to create an Object
        Supplier<Product> loanSupplier  = Loan::new;
        Supplier<Product> bondSupplier  = Bond::new;
        Supplier<Product> stockSupplier = Stock::new;
    }
}
