package ie.williamswalsh.default_methods;

public class MultipleInheritancePriority implements A,B
{
    public static void main(String[] args) {
        // You are forced to override the method in the implementing class when there is a
        // interface default method choice conflict

        MultipleInheritancePriority mip = new MultipleInheritancePriority();
        mip.hello();
    }

    // Can use new (Java8) syntax
    @Override
    public void hello() {
        B.super.hello();
    }
}

interface A { default void hello(){System.out.println("Hello from " + this.getClass().getName());}}
interface B { default void hello(){System.out.println("Hello from " + this.getClass().getName());}}