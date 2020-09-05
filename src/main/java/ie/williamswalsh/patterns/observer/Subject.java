package ie.williamswalsh.patterns.observer;

public interface Subject {
    void registerObserver(Observer o);
    void notify(String tweet);
}
