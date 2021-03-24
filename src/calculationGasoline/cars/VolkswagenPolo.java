package calculationGasoline.cars;


import calculationGasoline.workData.CheckingEnteredData;

public class VolkswagenPolo extends Car implements ActionCar, MovementOnRoad {

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



    @Override
    public void drivingWithConditioningInCity(boolean conditioner, int traffic) {
        int thisTraffic =  CheckingEnteredData.fixErrorTraffic(traffic);

        if (conditioner)
             setGasolineCosts(getGasolineCosts()
                            + RoadLoad.VOLKSWAGEN_POLO.getFuelConsumptionFromRoadLoad()[thisTraffic - 1] + 0.5);
        else setGasolineCosts(getGasolineCosts()
                            + RoadLoad.VOLKSWAGEN_POLO.getFuelConsumptionFromRoadLoad()[thisTraffic - 1]);
    }

    @Override
    public void drivingWithConditioningOnHighway(boolean conditioner, double speed) {
        if (conditioner)
            setGasolineCosts(getGasolineCosts()
                           + returnGasolineConsumptionWithCarSpeed(speed) + 0.5);
        else setGasolineCosts(getGasolineCosts()
                            + returnGasolineConsumptionWithCarSpeed(speed));
    }

    @Override
    public void drivingWithDynamicStyle(boolean dynamicDriving){
        if (dynamicDriving) setGasolineCosts(getGasolineCosts() + 2.0);
    }



    public double gasolineConsumptionWithCarSpeed(double speed){
       setGasolineCosts(CarSpeedAndPetrol.VOLKSWAGEN_POLO.returnGasolineConsumptionWithCarSpeed(speed));
        return gasolineCosts;
    }




    /**
     * double ReturnGasolineConsumptionWithCarSpeed - calculates gas mileage depending on speed (VW polo)
     * @param speed - takes your average speed at the entrance
     * @return - returns gas mileage depending on input speed
     */



}
