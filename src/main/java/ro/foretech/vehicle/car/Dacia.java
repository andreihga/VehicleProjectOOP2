package ro.foretech.vehicle.car;

import ro.foretech.vehicle.Color;
import ro.foretech.exception.InvalidProductionYearException;

public abstract class Dacia extends Car{

    public Dacia(int productionYear, Color color) throws InvalidProductionYearException {
        super(productionYear, color);
    }

    @Override
    public String getProducer() {
        return "Dacia";
    }
}
