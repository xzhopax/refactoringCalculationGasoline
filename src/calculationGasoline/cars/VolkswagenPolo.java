package calculationGasoline.cars;


import calculationGasoline.cars.onBoardComputerCar.OnBoardComputerCar;
import calculationGasoline.cars.onBoardComputerCar.workData.CheckingEnteredData;

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
       int thisTraffic = CheckingEnteredData.fixErrorTraffic(traffic);

        if (conditioner)
             setGasolineCosts(getGasolineCosts()
                            + RoadLoad.VOLKSWAGEN_POLO.getFuelConsumptionFromRoadLoad()[thisTraffic - 1] + 0.5);
        else setGasolineCosts(getGasolineCosts()
                            + RoadLoad.VOLKSWAGEN_POLO.getFuelConsumptionFromRoadLoad()[thisTraffic - 1]);
    }

    @Override
    public void drivingWithConditioningOnHighway(boolean conditioner, double speed) {
        setSpeed(speed);
        if (conditioner)
            setGasolineCosts(getGasolineCosts()
                           + CarSpeedAndPetrol.VOLKSWAGEN_POLO.returnGasolineConsumptionWithCarSpeed(speed) + 0.5);
        else setGasolineCosts(getGasolineCosts()
                            + CarSpeedAndPetrol.VOLKSWAGEN_POLO.returnGasolineConsumptionWithCarSpeed(speed));
    }

    @Override
    public void drivingWithDynamicStyle(boolean dynamicDriving){
        if (dynamicDriving) setGasolineCosts(getGasolineCosts() + 2.0);
    }



}
