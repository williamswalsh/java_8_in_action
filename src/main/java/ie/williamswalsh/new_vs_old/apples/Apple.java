package ie.williamswalsh.new_vs_old.apples;

public class Apple extends Fruit { // implements Comparable<Apple> {

    // Mass(Weight) in grams
    private Integer weight;
    private String color;
    private boolean fresh;

    public Apple() {
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public Integer getWeight() {
        return weight;
    }

    //    Auto-unboxing to test ToIntFunction<T> functional interface
    public int getIntWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
