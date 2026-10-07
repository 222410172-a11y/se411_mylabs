package edu.psu.se411.lab08.subject;

import edu.psu.se411.lab08.observer.Observer;

public interface Subject {

    void register(Observer o);

    void unregister(Observer o);

    void notifyObservers();
}