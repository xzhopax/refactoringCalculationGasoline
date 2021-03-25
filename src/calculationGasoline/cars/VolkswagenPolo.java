package calculationGasoline.cars;


import calculationGasoline.cars.enumsForCar.CarSpeedAndPetrol;
import calculationGasoline.cars.enumsForCar.NameCar;
import calculationGasoline.cars.enumsForCar.RoadLoad;
import calculationGasoline.onBoardComputerCar.workData.CheckingEnteredData;

public class VolkswagenPolo extends Car {

    private final String name = NameCar.VOLKSWAGENPOLO.getName();
    private double  speed = 0, gasolineCosts  = 0;
    private boolean conditioner = true, dynamicDriving = true;

    //Getter and Setter
    @Override
    public double getSpeed() {
        return speed;
    }
    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    @Override
    public double getGasolineCosts() {
        return gasolineCosts;
    }
    @Override
    public void setGasolineCosts(double gasolineCosts) {
        this.gasolineCosts = gasolineCosts;
    }
    @Override
    public boolean isConditioner() {
        return conditioner;
    }
    @Override
    public void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }
    @Override
    public boolean isDynamicDriving() {
        return dynamicDriving;
    }
    @Override
    public void setDynamicDriving(boolean dynamicDriving) {
        this.dynamicDriving = dynamicDriving;
    }
    @Override
    public String getName() {
        return name;
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
