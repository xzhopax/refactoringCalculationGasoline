package calculationGasoline.cars;

import java.util.Map;
import java.util.TreeMap;

public class CreateCar {
    private static final Map<Integer, Car> mapCars = new TreeMap<>();
    static {
        mapCars.put(1,new VolkswagenPolo());
        mapCars.put(2,new FordFocus3());
    }

    public static Map<Integer, Car> getMapCars() {
        return mapCars;
    }
}
