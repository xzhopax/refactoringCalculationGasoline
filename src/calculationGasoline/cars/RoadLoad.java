package calculationGasoline.cars;

public enum RoadLoad {
    VOLKSWAGEN_POLO(new double[]{7.0, 8.0, 9.0, 10.0, 12.0, 14.0, 15.0, 16.0, 18.0, 20.0});

    private final double[] fuelConsumptionFromRoadLoad;

    RoadLoad(double[] fuelConsumptionFromRoadLoad){
        this.fuelConsumptionFromRoadLoad = fuelConsumptionFromRoadLoad;
    }

    public double[] getFuelConsumptionFromRoadLoad() {
        return fuelConsumptionFromRoadLoad;
    }

}
