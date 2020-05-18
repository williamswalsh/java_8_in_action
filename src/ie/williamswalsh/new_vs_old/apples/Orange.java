package ie.williamswalsh.new_vs_old.apples;

public class Orange extends Fruit{
    // Mass(Weight) in grams
    private Integer weight;

    public Orange(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
