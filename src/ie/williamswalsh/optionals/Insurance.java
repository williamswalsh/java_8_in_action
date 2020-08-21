package ie.williamswalsh.optionals;

public class Insurance {
    private double cost;

    public Insurance(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "cost=" + cost +
                '}';
    }
}
