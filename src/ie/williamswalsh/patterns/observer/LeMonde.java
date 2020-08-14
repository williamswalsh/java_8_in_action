package ie.williamswalsh.patterns.observer;

public class LeMonde implements Observer{
    @Override
    public void notify(String tweet) {
        if( tweet != null && !tweet.isEmpty() && tweet.contains("wine")) {
            System.out.println("This is LeMonde reporting on:" + tweet);
        }
    }
}
