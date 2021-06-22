package ro.foretech.vehicle;

import ro.foretech.exception.*;

public abstract class Vehicle implements VehicleInterface {
    int currentGear;
    int currentSpeed;
    int productionYear;
    Color color;

    private Vehicle() {
        this(-1, -1);
    }

    private Vehicle(int currentGear, int currentSpeed) {
        this.currentGear = currentGear;
        this.currentSpeed = currentSpeed;
    }

    public Vehicle(int productionYear, Color color) throws InvalidProductionYearException {
        this();
        try {
            setProductionYear(productionYear);
        } catch (InvalidProductionYearException e) {
            throw new VehicleRuntimeException("The year should be between " + getProductionStartYear() + " and " + getProductionEndYear() + ".");
        }
        this.color = color;
    }

    private void setProductionYear(int productionYear) throws InvalidProductionYearException {

        if (productionYear >= getProductionStartYear() && productionYear <= getProductionEndYear()) {
            this.productionYear = productionYear;
        } else throw new InvalidProductionYearException("The production year is invalid");

    }

    public void changeGear(int newGear) throws InvalidGearException {
        if (getMaxSpeedForGear(newGear) < currentSpeed || newGear > getNumberOfGears()) {
            throw new InvalidGearException("Invalid Gear. Too low or out of range");
        } else currentGear = newGear;
    }

    public void accelerate(int acceleration) throws EngineNotStartedException, InvalidGearException, InvalidSpeedException {
        if (acceleration < 0) {
            throw new InvalidSpeedException("The value for acceleration isn't valid.");
        }
        if (currentGear < 0 || currentSpeed < 0) {
            throw new EngineNotStartedException("The engine is not turned on.");
        }
        if ((currentSpeed + acceleration) > getMaxSpeedForGear(currentGear)) {
            throw new InvalidGearException("The speed exceeds the vehicle's current gear.");
        }
        currentSpeed += acceleration;
        System.out.println("The speed is now " + currentSpeed);
    }

    public void startEngine() throws EngineNotStoppedException {
        if (currentGear < 0 || currentSpeed < 0) {
            currentSpeed = 0;
            currentGear = 1;
            System.out.println("Engine starts.");
        } else throw new EngineNotStoppedException("The engine is not stopped so it cannot start.");
    }

    public void stopEngine() throws EngineNotStartedException {
        if (currentGear >= 0 || currentSpeed >= 0) {
            System.out.println("Engine Stopping");
            currentGear = -1;
            currentSpeed = -1;
        } else throw new EngineNotStartedException("The engine is not on so it cannot be off.");
    }

}
