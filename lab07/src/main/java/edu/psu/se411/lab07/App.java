package edu.psu.se411.lab07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.lab07.model.Booking;
import edu.psu.se411.lab07.model.CarRentalBooking;
import edu.psu.se411.lab07.model.FlightBooking;
import edu.psu.se411.lab07.model.SeatClass;
import edu.psu.se411.lab07.model.TrainBooking;

public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    public static double computeTotalPrice(Booking booking)
            throws Exception {

        return booking.calculateTotalPrice();
    }

    public static void main(String[] args) {

        logger.info("Application is starting...");

        try {

            // Flight Booking
            Booking fbooking = new FlightBooking(
                    "B001",
                    "John Doe",
                    new java.util.Date(),
                    "New York",
                    200.0,
                    30.0,
                    20.0
            );

            System.out.println(
                    "Flight Total Price: "
                    + computeTotalPrice(fbooking)
            );


            // Car Rental Booking
            Booking cbooking = new CarRentalBooking(
                    "B002",
                    "Jane Smith",
                    new java.util.Date(),
                    "Los Angeles",
                    50.0,
                    10
            );

            System.out.println(
                    "Car Rental Total Price: "
                    + computeTotalPrice(cbooking)
            );


            // Train Booking
            SeatClass seatClass = SeatClass.STANDARD;

            Booking tbooking = new TrainBooking(
                    "B003",
                    "Alice Johnson",
                    new java.util.Date(),
                    "Chicago",
                    seatClass,
                    100.0
            );

            System.out.println(
                    "Train Total Price: "
                    + computeTotalPrice(tbooking)
            );

        } catch (Exception e) {

            System.out.println(e.getMessage());

            logger.error(
                    "Exception occurred: " + e.getMessage()
            );

        } finally {

            logger.info("Application is stopping...");
        }
    }
}