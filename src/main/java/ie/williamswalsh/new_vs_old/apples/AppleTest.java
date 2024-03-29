package ie.williamswalsh.new_vs_old.apples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class AppleTest {
    public static void main(String[] args) {

        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple(50,"green"));
        apples.add(new Apple(60,"red"));
        apples.add(new Apple(87,"green"));
        apples.add(new Apple(23,"brown"));
        apples.add(new Apple(60,"green"));


        // new
        apples.sort(comparing(Apple::getWeight));


        // old
        Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
    }
}
