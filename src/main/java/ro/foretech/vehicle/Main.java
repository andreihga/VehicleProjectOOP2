package ro.foretech.vehicle;

import ro.foretech.exception.*;
import ro.foretech.vehicle.car.DaciaDuster;


public class Main {
    public static void main(String[] args) throws InvalidProductionYearException {

        Color color = Color.BLACK;
        DaciaDuster daciaDuster = new DaciaDuster(2000, color);

        try {

            daciaDuster.startEngine();
            daciaDuster.changeGear(3);
            daciaDuster.accelerate(50);
            daciaDuster.stopEngine();
            daciaDuster.startEngine();
            System.out.println(daciaDuster.getMaxSpeedForGear(5));

        } catch (EngineNotStartedException | InvalidGearException | InvalidSpeedException | EngineNotStoppedException e) {
            System.out.println(e.getMessage());
        }
    }
}
