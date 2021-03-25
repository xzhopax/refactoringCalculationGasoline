package calculationGasoline.cars.enumsForCar;

public enum RoadLoad {
    CAR(new double[]{6.0, 7.0, 8.0, 9.0, 11.0, 13.0, 14.0, 15.0, 17.0, 19.0}),
    VOLKSWAGEN_POLO(new double[]{7.0, 8.0, 9.0, 10.0, 12.0, 14.0, 15.0, 16.0, 18.0, 20.0}),
    FORD_FOCUS_3(new double[]{6.0, 7.0, 8.0, 9.0, 11.0, 13.0, 14.0, 15.0, 17.0, 19.0});

    /**
     * double[] fuelConsumptionFromRoadLoad -
     * Average consumption per 100 km depending on traffic in the city (from 1 to 10 points)
     */
    private final double[] fuelConsumptionFromRoadLoad;

    RoadLoad(double[] fuelConsumptionFromRoadLoad){ //constructor
        this.fuelConsumptionFromRoadLoad = fuelConsumptionFromRoadLoad;
    }

    //getter
    public double[] getFuelConsumptionFromRoadLoad() {
        return fuelConsumptionFromRoadLoad;
    }
    //end getter

}
