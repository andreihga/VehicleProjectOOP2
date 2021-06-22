package ro.foretech.vehicle.car;

import ro.foretech.vehicle.Color;
import ro.foretech.vehicle.Vehicle;
import ro.foretech.exception.InvalidProductionYearException;

public abstract class Car extends Vehicle {

    public Car(int productionYear, Color color) throws InvalidProductionYearException {
        super(productionYear, color);
    }

    @Override
    public int getNumberOfWheels() {
        return 4;
    }
}
