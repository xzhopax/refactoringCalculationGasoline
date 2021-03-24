package calculationGasoline.cars;

public abstract class Car implements ActionCar, MovementOnRoad {

    private final StringBuilder sb = new StringBuilder();

    private double  speed = 0, gasolineCosts  = 0;
    private boolean conditioner = true, dynamicDriving = true;


    //Getter and Setter
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
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
    public double getGasolineCosts() {
        return gasolineCosts;
    }
    public void setGasolineCosts(double gasolineCosts) {
        this.gasolineCosts = gasolineCosts;
    }

    @Override
    public void onOffDynamicDriving(boolean dynamicDriving) {

    }
    @Override
    public void onOffConditioner(boolean conditionerOn) {

    }

    @Override
    public double gasolineConsumptionWithCarSpeed(double speed){

        return 0;
    }

    @Override
    public void drivingWithConditioningInCity(boolean conditioner, int traffic) {

    }

    @Override
    public void drivingWithConditioningOnHighway(boolean conditioner, double speed) {

    }

    @Override
    public void drivingWithDynamicStyle(boolean dynamicDriving) {

    }
}
