package calculationGasoline.cars;


public class VolkswagenPolo extends Car implements ActionCar, MovementInCity, MovementOnHighway {


    private final double[] ARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10
            = new double[]{7.0, 8.0, 9.0, 10.0, 12.0, 14.0, 15.0, 16.0, 18.0, 20.0};
    private final double[] ARRAY_FUEL_CONSUMPTION_CAR_SPEED
            = new double[]{9.5, 6.0, 4.8, 4.0, 3.5, 4.0, 5.0, 6.0, 8.0, 10.5};
//    private static double allGas;
//    private static double allMoney;

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
    //End Getter and Setter



    /**
     * void onOffConditioner - Sets the condition of air conditioner
     * @param conditionerOn - condition conditioner
     */
    @Override
    public void onOffConditioner(boolean conditionerOn) {
        setConditioner(conditionerOn);
    }

    /**
     * void onOffDynamicDriving - Sets the state of dynamic driving
     * @param dynamicDriving - condition conditioner
     */

    @Override
    public void onOffDynamicDriving(boolean dynamicDriving) {
        setDynamicDriving(dynamicDriving);
    }

    /**
     * double ReturnGasolineConsumptionWithCarSpeed - calculates gas mileage depending on speed (VW polo)
     * @param speed - takes your average speed at the entrance
     * @return - returns gas mileage depending on input speed
     */
    @Override
    public double ReturnGasolineConsumptionWithCarSpeed(double speed) {
        if (speed <= 10 && speed > 0) {
            return getARRAY_FUEL_CONSUMPTION_CAR_SPEED()[0];
        } else if (speed <= 20) {
            return getARRAY_FUEL_CONSUMPTION_CAR_SPEED()[1];
        } else if (speed <= 30) {
            return getARRAY_FUEL_CONSUMPTION_CAR_SPEED()[2];
        } else if (speed <= 40) {
            return getARRAY_FUEL_CONSUMPTION_CAR_SPEED()[3];
        } else if (speed <= 60) {
            return getARRAY_FUEL_CONSUMPTION_CAR_SPEED()[4];
        } else if (speed <= 80) {
            return getARRAY_FUEL_CONSUMPTION_CAR_SPEED()[5];
        } else if (speed <= 100) {
            return getARRAY_FUEL_CONSUMPTION_CAR_SPEED()[6];
        } else if (speed <= 120) {
            return getARRAY_FUEL_CONSUMPTION_CAR_SPEED()[7];
        } else if (speed <= 150) {
            return getARRAY_FUEL_CONSUMPTION_CAR_SPEED()[8];
        } else if (speed <= 200) {
            return getARRAY_FUEL_CONSUMPTION_CAR_SPEED()[9];
        } else return 0;
    }





    //    @Override
//    public void onOffConditioner(boolean conditionerOn) {
//        if (conditionerOn) {
//            if (getTraffic() != 0) setGas(getGas()
//                    + getARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10()[traffic - 1] + 0.5);
//            else setGas(getGas() + getMidGasoline() + 0.5);
//        }
//    }
//
//    @Override
//    public void onOffDynamicDriving(boolean dynamicDriving){
//        if (dynamicDriving) setGas(getGas() + 2.0);
//        if (getTraffic() == 0 && getMidGasoline() == 0) setGas(0);
//    }
//
//    protected void priceInCityGAS(){
//        onOffConditioner(isConditioner());
//        onOffDynamicDriving(isDynamicDriving());
//        setGas((getGas() / 100) * distance);
//        setResultGas(getGas() * getPrice()); // gasolinePrice --> getPrice()
//    }









}
