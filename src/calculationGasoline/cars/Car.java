package calculationGasoline.cars;

public abstract class Car extends Vehicle implements ActionCar {
    private final double[] ARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10
            = new double[]{7.0, 8.0, 9.0, 10.0, 12.0, 14.0, 15.0, 16.0, 18.0, 20.0};
    private final double[] ARRAY_FUEL_CONSUMPTION_CAR_SPEED
            = new double[]{9.5, 6.0, 4.8, 4.0, 3.5, 4.0, 5.0, 6.0, 8.0, 10.5};

    private final StringBuilder sb = new StringBuilder();
    private String date = "";
    private double price = 0, distance = 5, speed = 0, gas = 0, resultGas = 0, midGasoline = 0;
    private int traffic = 0;
    private boolean conditioner = true, dynamicDriving = true;

    //Getter and Setter
    protected double[] getARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10 () {
        return ARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10 ;
    }
    protected double[] getARRAY_FUEL_CONSUMPTION_CAR_SPEED() {
        return ARRAY_FUEL_CONSUMPTION_CAR_SPEED;
    }
    private StringBuilder getSb() {
        return sb;
    }

    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getGas() {
        return gas;
    }
    public void setGas(double gas) {
        this.gas = gas;
    }
    public boolean isConditioner() {
        return conditioner;
    }
    public void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }
    public boolean isDynamicDriving() {
        return dynamicDriving;
    }
    public void setDynamicDriving(boolean dynamicDriving) {
        this.dynamicDriving = dynamicDriving;
    }

    @Override
    public void onOffDynamicDriving(boolean dynamicDriving) {

    }
    @Override
    public void onOffConditioner(boolean conditionerOn) {

    }

    @Override
    public double ReturnGasolineConsumptionWithCarSpeed(double speed) {

        return 0;
    }


}
