package edu.psu.se411.lab08;

import edu.psu.se411.lab08.observer.Dashboard;
import edu.psu.se411.lab08.observer.Logger;
import edu.psu.se411.lab08.subject.Sensor;
import edu.psu.se411.lab08.subject.SensorType;


import java.util.Random;

import org.slf4j.LoggerFactory;

public class App {

	
	static org.slf4j.Logger appLogger =
	        LoggerFactory.getLogger(App.class);
	
	
	
    public static void main(String[] args) {
    	
    	appLogger.info("Application is starting...");

        Sensor temp = new Sensor(
                "Temperature Sensor",
                SensorType.TEMPERATURE
        );

        Sensor humidity = new Sensor(
                "Humidity Sensor",
                SensorType.HUMIDITY
        );

        Dashboard dashboard = new Dashboard();
        Logger logger = new Logger();

        temp.register(dashboard);
        temp.register(logger);

        humidity.register(dashboard);
        humidity.register(logger);
        
        
        
        Random random = new Random();

        for (int i = 0; i < 10; i++) {

            temp.setReading(20 + random.nextDouble() * 15);

            humidity.setReading(40 + random.nextDouble() * 20);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        Sensor clonedTemp = temp.clone();

        System.out.println("Original observers: "
                + temp.getObservers().size());

        System.out.println("Cloned observers: "
                + clonedTemp.getObservers().size());
        
        
        appLogger.info("Application is stopping...");
    }
}