package cz.naentou.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void register(Observer observer) {
        this.observers.add(observer);
    }

    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    public int notifyAllObservers() {
        for(Observer observer: observers) {
            observer.update();
        }

        return observers.size();
    }
}
