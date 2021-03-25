package calculationGasoline.cars.enumsForCar;

import calculationGasoline.cars.FordFocus3;
import calculationGasoline.cars.VolkswagenPolo;

public enum ObjectCar {
    VOLKSWAGEN_POLO(new VolkswagenPolo()),
    FORD_FOCUS_3(new FordFocus3());

    private final Object car;

    ObjectCar(Object car){
        this.car = car;
    }

    public Object getCar() {
        return car;
    }
}
