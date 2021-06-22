package ro.foretech.vehicle.car;

import ro.foretech.vehicle.Color;
import ro.foretech.exception.InvalidGearException;
import ro.foretech.exception.InvalidProductionYearException;

public class DaciaDuster extends Dacia {

    private static final int[] GEAR_RANGES = {0, 20, 40, 80, 120, 180};

    public DaciaDuster(int productionYear, Color color) throws InvalidProductionYearException {
        super(productionYear, color);
    }

    @Override
    public int getMaxSpeed() {
        return GEAR_RANGES[GEAR_RANGES.length - 1];
    }

    @Override
    public int getProductionStartYear() {
        return 2000;
    }

    @Override
    public int getProductionEndYear() {
        return 2005;
    }

    @Override
    public int getNumberOfGears() {
        return GEAR_RANGES.length -1;
    }

    @Override
    public int getMaxSpeedForGear(int gear) throws InvalidGearException {
        if (gear <= 0 || gear > getNumberOfGears())
            throw new InvalidGearException("Invalid gear. It should be between 1 and " + getNumberOfGears());
        else
            return GEAR_RANGES[gear];
    }
}
