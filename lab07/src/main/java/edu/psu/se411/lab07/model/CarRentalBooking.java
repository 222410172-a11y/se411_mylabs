package edu.psu.se411.lab07.model;

import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;
import edu.psu.se411.lab07.util.Config;
import java.util.Date;

public class CarRentalBooking extends Booking {

    private double dailyRentalRate;
    private Integer numberOfDays;

    public CarRentalBooking(String bookingId, String customerName,
            Date travelDate, String destinationCity,
            double dailyRentalRate,
            Integer numberOfDays)
throws InvalidArgumentException {

super(bookingId, customerName, travelDate, destinationCity);

this.dailyRentalRate = dailyRentalRate;

if (numberOfDays != null) {
setNumberOfDays(numberOfDays);
}
}

    public void setNumberOfDays(int numberOfDays)
            throws InvalidArgumentException {

        if (numberOfDays < Config.MIN_RENTAL_DAYS ||
            numberOfDays > Config.MAX_RENTAL_DAYS) {

            throw new InvalidArgumentException(
                    "Invalid number of rental days.");
        }

        this.numberOfDays = numberOfDays;
    }

    @Override
    public double calculateTotalPrice()
            throws MissingInformationException {

        if (numberOfDays == null) {
            throw new MissingInformationException(
                    "Number of rental days is missing.");
        }

        return dailyRentalRate * numberOfDays;
    }
}