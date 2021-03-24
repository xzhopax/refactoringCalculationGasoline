package calculationGasoline;

import calculationGasoline.cars.ActionCar;
import calculationGasoline.cars.Car;
import calculationGasoline.cars.VolkswagenPolo;

public class RunRoad {
    public static void main(String[] args) {
        Car car = new VolkswagenPolo();


        System.out.println( car.gasolineConsumptionWithCarSpeed(201));
    }

}
