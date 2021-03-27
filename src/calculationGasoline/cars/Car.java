package calculationGasoline.cars;

import calculationGasoline.cars.enumsForCar.CarSpeedAndPetrol;
import calculationGasoline.cars.enumsForCar.NameCar;
import calculationGasoline.cars.enumsForCar.RoadLoad;
import calculationGasoline.onBoardComputerCar.workData.CheckingEnteredData;

public abstract class Car {
    private final String name = NameCar.CAR.getName();
    private double  speed = 0, gasolineCosts  = 0;
    private boolean conditioner = true, dynamicDriving = true;

    /**
     * drivingWithOrNotConditioningInCity - calculates the spent amount of
     * gasoline when driving around the city with air conditioning or without air conditioning
     *
     * @param conditioner - Air conditioning on or off during a trip
     * @param traffic - How many cork points in the city
     */
    public void drivingWithOrNotConditioningInCity(boolean conditioner, int traffic) {
        int thisTraffic = CheckingEnteredData.fixErrorTraffic(traffic); // fix out bound array

        if (conditioner)
            setGasolineCosts(getGasolineCosts()
                    + RoadLoad.CAR.getFuelConsumptionFromRoadLoad()[thisTraffic - 1] + 0.6);
        else setGasolineCosts(getGasolineCosts()
                + RoadLoad.CAR.getFuelConsumptionFromRoadLoad()[thisTraffic - 1]);
    }

    /**
     * drivingWithOrNotConditioningOnHighway - Calculates the spent the amount of
     * gasoline when driving on the highway with air conditioning or without air conditioning
     *
     * @param conditioner - Air conditioning on or off during a trip
     * @param speed - Average vehicle speed throughout the trip
     */
    public void drivingWithOrNotConditioningOnHighway(boolean conditioner, double speed) {
        setSpeed(speed);
        if (conditioner)
            setGasolineCosts(getGasolineCosts()
                    + CarSpeedAndPetrol.CAR.returnGasolineConsumptionWithCarSpeed(speed) + 0.6);
        else setGasolineCosts(getGasolineCosts()
                + CarSpeedAndPetrol.CAR.returnGasolineConsumptionWithCarSpeed(speed));
    }

    /**
     * drivingWithDynamicStyle -  Fast (sharp) acceleration and sharp car brakes
     *
     * @param dynamicDriving - Dynamic ride was used or not
     */
    public void drivingWithDynamicStyle(boolean dynamicDriving) {
        if (dynamicDriving) setGasolineCosts(getGasolineCosts() + 2.5);
    }

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
    public String getName() {
        return name;
    }
    //End Getter and Setter
}
