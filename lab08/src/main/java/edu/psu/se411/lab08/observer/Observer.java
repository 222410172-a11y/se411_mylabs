package edu.psu.se411.lab08.observer;

import edu.psu.se411.lab08.subject.Subject;

public interface Observer {

    void update(Subject subject);
}