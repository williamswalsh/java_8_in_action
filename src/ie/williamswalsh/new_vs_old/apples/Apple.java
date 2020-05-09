package ie.williamswalsh.new_vs_old.apples;

public class Apple{ // implements Comparable<Apple> {

    // Mass(Weight) in grams
    private Integer weight;

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

//    @Override
//    public int compareTo(Apple otherApple) {
//        if (weight > otherApple.getWeight()) {
//            return 1;
//        } else if (weight < otherApple.getWeight()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
}
