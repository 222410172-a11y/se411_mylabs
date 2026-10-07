package edu.psu.se411.lab08.subject;

import java.util.HashSet;
import java.util.Set;

import edu.psu.se411.lab08.observer.Observer;

public abstract class AbstractSubject implements Subject {

    protected Set<Observer> observers = new HashSet<>();

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public Set<Observer> getObservers() {
        return observers;
    }

    public void setObservers(Set<Observer> observers) {
        this.observers = observers;
    }
}