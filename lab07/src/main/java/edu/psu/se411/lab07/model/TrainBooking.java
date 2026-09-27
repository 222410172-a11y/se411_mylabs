package edu.psu.se411.lab07.model;

import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;
import edu.psu.se411.lab07.util.Config;
import java.util.Date;

public class TrainBooking extends Booking {

    private SeatClass seatClass;
    private Double distance;

    public TrainBooking(String bookingId, String customerName,
            Date travelDate, String destinationCity,
            SeatClass seatClass,
            Double distance)
throws InvalidArgumentException {

super(bookingId, customerName, travelDate, destinationCity);

this.seatClass = seatClass;

if (distance != null) {
setDistance(distance);
}
}

    public void setDistance(double distance)
            throws InvalidArgumentException {

        if (distance < 1 || distance > Config.MAX_TRAIN_DISTANCE) {
            throw new InvalidArgumentException("Invalid train distance.");
        }

        this.distance = distance;
    }

    @Override
    public double calculateTotalPrice()
            throws MissingInformationException {

        if (distance == null) {
            throw new MissingInformationException(
                    "Train distance is missing.");
        }

        if (seatClass == SeatClass.STANDARD) {
            return distance * Config.TRAIN_STANDARD_RATE;
        } else {
            return distance * Config.TRAIN_FIRST_CLASS_RATE;
        }
    }
}