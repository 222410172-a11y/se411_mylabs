package edu.psu.se411.lab07.model;

import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;
import edu.psu.se411.lab07.util.Config;
import java.util.Date;

public class FlightBooking extends Booking {

    private double baseTicketPrice;
    private double includedLuggageWeight;
    private Double luggageWeight;

    public FlightBooking(String bookingId, String customerName,
            Date travelDate, String destinationCity,
            double baseTicketPrice,
            double includedLuggageWeight,
            Double luggageWeight)
throws InvalidArgumentException {

super(bookingId, customerName, travelDate, destinationCity);

this.baseTicketPrice = baseTicketPrice;
this.includedLuggageWeight = includedLuggageWeight;

if (luggageWeight != null) {
setLuggageWeight(luggageWeight);
}
}

    public void setLuggageWeight(double luggageWeight)
            throws InvalidArgumentException {

        if (luggageWeight < 0 || luggageWeight > Config.MAX_LUGGAGE_WEIGHT) {
            throw new InvalidArgumentException("Invalid luggage weight.");
        }

        this.luggageWeight = luggageWeight;
    }

    @Override
    public double calculateTotalPrice()
            throws MissingInformationException {

        if (luggageWeight == null) {
            throw new MissingInformationException(
                    "Luggage weight is missing.");
        }

        double extraWeight = luggageWeight - includedLuggageWeight;

        if (extraWeight < 0) {
            extraWeight = 0;
        }

        return (baseTicketPrice +
                (extraWeight * Config.EXTRA_LUGGAGE_RATE))
                * (1 + Config.TAX_RATE);
    }
}