package ie.williamswalsh.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notify(String tweet) {
        this.observers.forEach(observer -> observer.notify(tweet));
    }
}
