package edu.psu.se411.lab08.observer;

import edu.psu.se411.lab08.subject.Sensor;
import edu.psu.se411.lab08.subject.Subject;

public class Dashboard implements Observer {

    @Override
    public void update(Subject subject) {

        Sensor sensor = (Sensor) subject;

        System.out.printf(
                "Dashboard: %s reading = %.2f%n",
                sensor.getName(),
                sensor.getReading()
        );
    }
}