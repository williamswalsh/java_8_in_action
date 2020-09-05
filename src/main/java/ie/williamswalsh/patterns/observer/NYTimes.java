package ie.williamswalsh.patterns.observer;

public class NYTimes implements Observer{
    @Override
    public void notify(String tweet) {
        if( tweet != null && !tweet.isEmpty() && tweet.contains("money")) {
            System.out.println("This is the New York Times reporting on:" + tweet);
        }
    }
}
