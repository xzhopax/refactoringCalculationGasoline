package calculationGasoline.cars;

import calculationGasoline.road.GasolineСonsumption;

public class VolkswagenPolo extends Car implements ActionСar, GasolineСonsumption {


    private final double[] ARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10
            = new double[]{7.0, 8.0, 9.0, 10.0, 12.0, 14.0, 15.0, 16.0, 18.0, 20.0};
    private final double[] ARRAY_FUEL_CONSUMPTION_CAR_SPEED
            = new double[]{9.5, 6.0, 4.8, 4.0, 3.5, 4.0, 5.0, 6.0, 8.0, 10.5};
//    private static double allGas;
//    private static double allMoney;

    private final StringBuilder sb = new StringBuilder();
    private String date = "";
    private double price = 0, distance = 0, speed = 0, gas = 0, resultGas = 0, midGasoline = 0;
    private int traffic = 0;
    private boolean conditioner = true, dynamicDriving = true;

    //Getter and Setter
    private double[] getARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10 () {
        return ARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10 ;
    }
    private double[] getARRAY_FUEL_CONSUMPTION_CAR_SPEED() {
        return ARRAY_FUEL_CONSUMPTION_CAR_SPEED;
    }
    private StringBuilder getSb() {
        return sb;
    }
    private String getDate() {
        return date;
    }
    private void setDate(String date) {
        this.date = date;
    }
    private double getPrice() {
        return price;
    }
    private void setPrice(double price) {
        this.price = price;
    }
    private double getDistance() {
        return distance;
    }
    private void setDistance(double distance) {
        this.distance = distance;
    }
    private double getSpeed() {
        return speed;
    }
    private void setSpeed(double speed) {
        this.speed = speed;
    }
    private double getGas() {
        return gas;
    }
    private void setGas(double gas) {
        this.gas = gas;
    }
    private double getResultGas() {
        return resultGas;
    }
    private void setResultGas(double resultGas) {
        this.resultGas = resultGas;
    }
    private double getMidGasoline() {
        return midGasoline;
    }
    private void setMidGasoline(double midGasoline) {
        this.midGasoline = midGasoline;
    }
    private int getTraffic() {
        return traffic;
    }
    private void setTraffic(int traffic) {
        this.traffic = traffic;
    }
    private boolean isConditioner() {
        return conditioner;
    }
    private void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }
    private boolean isDynamicDriving() {
        return dynamicDriving;
    }
    private void setDynamicDriving(boolean dynamicDriving) {
        this.dynamicDriving = dynamicDriving;
    }
    //End Getter and Setter


//    public VolkswagenPolo
//            (String date, double price, double distance, int traffic, boolean conditioner, boolean dynamicDriving) {
//        this.date = date;
//        this.price = price;
//        this.distance = distance;
//        this.traffic = traffic;
//        this.conditioner = conditioner;
//        this.dynamicDriving = dynamicDriving;
//    }
    //(double speed, double distance, double price, boolean conditioner, boolean dynamicDriving)

//    public VolkswagenPolo
//            (String date, double price, double distance, double speed, boolean conditioner, boolean dynamicDriving) {
//        this.date = date;
//        this.price = price;
//        this.distance = distance;
//        this.speed = speed;
//        this.conditioner = conditioner;
//        this.dynamicDriving = dynamicDriving;
//    }

    @Override
    public void onOffConditioner(boolean conditionerOn) {
        if (conditionerOn) {
            if (getTraffic() != 0) setGas(getGas()
                    + getARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10()[traffic - 1] + 0.5);
            else setGas(getGas() + getMidGasoline() + 0.5);
        }
    }

    @Override
    public void onOffDynamicDriving(boolean dynamicDriving){
        if (dynamicDriving) setGas(getGas() + 2.0);
        if (getTraffic() == 0 && getMidGasoline() == 0) setGas(0);
    }

    protected void priceInCityGAS(){
        onOffConditioner(isConditioner());
        onOffDynamicDriving(isDynamicDriving());
        setGas((getGas() / 100) * distance);
        setResultGas(getGas() * getPrice()); // gasolinePrice --> getPrice()
    }





}
