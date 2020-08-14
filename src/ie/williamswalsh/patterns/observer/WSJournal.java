package ie.williamswalsh.patterns.observer;

public class WSJournal implements Observer{
    @Override
    public void notify(String tweet) {
        if( tweet != null && !tweet.isEmpty() && tweet.contains("injustice")) {
            System.out.println("This is the Wall Street Journal reporting on:" + tweet);
        }
    }
}
