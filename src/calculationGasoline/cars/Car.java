package calculationGasoline.cars;

import calculationGasoline.cars.enumsForCar.CarSpeedAndPetrol;
import calculationGasoline.cars.enumsForCar.RoadLoad;
import calculationGasoline.onBoardComputerCar.workData.CheckingEnteredData;

public abstract class Car {

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
    //End Getter and Setter

    public void drivingWithConditioningInCity(boolean conditioner, int traffic) {
        int thisTraffic = CheckingEnteredData.fixErrorTraffic(traffic);

        if (conditioner)
            setGasolineCosts(getGasolineCosts()
                    + RoadLoad.CAR.getFuelConsumptionFromRoadLoad()[thisTraffic - 1] + 0.6);
        else setGasolineCosts(getGasolineCosts()
                + RoadLoad.CAR.getFuelConsumptionFromRoadLoad()[thisTraffic - 1]);
    }

    public void drivingWithConditioningOnHighway(boolean conditioner, double speed) {
        setSpeed(speed);
        if (conditioner)
            setGasolineCosts(getGasolineCosts()
                    + CarSpeedAndPetrol.CAR.returnGasolineConsumptionWithCarSpeed(speed) + 0.6);
        else setGasolineCosts(getGasolineCosts()
                + CarSpeedAndPetrol.CAR.returnGasolineConsumptionWithCarSpeed(speed));
    }

    public void drivingWithDynamicStyle(boolean dynamicDriving) {
        if (dynamicDriving) setGasolineCosts(getGasolineCosts() + 2.5);
    }
}
