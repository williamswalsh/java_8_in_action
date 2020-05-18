package ie.williamswalsh.new_vs_old;

import ie.williamswalsh.new_vs_old.apples.Apple;

import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {

        // latest
        Comparator<Apple> byWeightA = Comparator.comparing(Apple::getWeight);

        // new
        Comparator<Apple> byWeightB = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        // old
//        Comparator<Apple> byWeight = new Comparator<Apple>(){
//            public int compare(Apple a1, Apple a2){
//                return a1.getWeight().compareTo(a2.getWeight());
//            }
//        }
    }
}
