package calculationGasoline;

import calculationGasoline.cars.ActionCar;
import calculationGasoline.cars.VolkswagenPolo;

public class RunRoad {
    public static void main(String[] args) {
        ActionCar car = new VolkswagenPolo();

        System.out.println(((VolkswagenPolo) car).getDistance());
    }

}
