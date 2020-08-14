package ie.williamswalsh.patterns.observer;

public class ObserverTest {
    public static void main(String[] args) {
        Feed feed = new Feed();
        NYTimes nyTimes = new NYTimes();
        WSJournal wsJournal = new WSJournal();
        LeMonde leMonde = new LeMonde();

        feed.registerObserver(nyTimes);
        feed.registerObserver(wsJournal);
        feed.registerObserver(leMonde);

        // Feed should notify all observers
        // some of which will output text to the console
        feed.notify("I am Donald Trump, I like wine and money.");
    }
}
