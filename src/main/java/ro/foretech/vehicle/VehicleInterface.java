package ro.foretech.vehicle;

import ro.foretech.exception.InvalidGearException;

public interface VehicleInterface {

    int getNumberOfWheels();

    int getMaxSpeed();

    String getProducer();

    int getProductionStartYear();

    int getProductionEndYear();

    int getNumberOfGears();

    int getMaxSpeedForGear(int gear) throws InvalidGearException;
}
