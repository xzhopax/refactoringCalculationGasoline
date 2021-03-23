package calculationGasoline.cars;

import calculationGasoline.cars.Car;
import calculationGasoline.stationGas.StationGAS;

public class OnBoardComputerCar {
    private String date;
    private double distance = 0, resultGas = 0, midGasoline = 0;
    private int traffic = 0;

    private Car car;
    private StationGAS stationGAS;

    public OnBoardComputerCar(Car car, StationGAS stationGAS){
        this.car = car;
        this.stationGAS = stationGAS;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public double getResultGas() {
        return resultGas;
    }
    public void setResultGas(double resultGas) {
        this.resultGas = resultGas;
    }
    public double getMidGasoline() {
        return midGasoline;
    }
    public void setMidGasoline(double midGasoline) {
        this.midGasoline = midGasoline;
    }
    public int getTraffic() {
        return traffic;
    }
    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }
    public Car getCar() {
        return car;
    }
    public StationGAS getStationGAS() {
        return stationGAS;
    }


    protected void priceOnHighwayGAS () {
        //double speed, double distance, double price, boolean conditioner, boolean dynamicDriving

        if (getCar().isConditioner()) {
            getCar().setGas(getCar().getGas() + getCar().ReturnGasolineConsumptionWithCarSpeed(getCar().getSpeed()) + 0.5);
        } else getCar().setGas(getCar().getGas() + getCar().ReturnGasolineConsumptionWithCarSpeed(getCar().getSpeed()));

        if (getCar().isDynamicDriving()) {
            getCar().setGas(getCar().getGas() + 2.0);
        }
        getCar().setGas((getCar().getGas() / 100) * getDistance());
        setResultGas(getCar().getGas() * getStationGAS().getPriceGasoline());
    }// end priceOnHighwayGAS

    protected void priceInCityGAS() {
        //double distance, int traffic,double midGasoline, double gasolinePrice, boolean conditioner, boolean dynamicDriving

        if (getCar().isConditioner()) {
            if (getTraffic() != 0) {
                getCar().setGas(
                                getCar().getGas()
                              + getCar().getARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10()[traffic - 1] + 0.5);
            } else  {
                getCar().setGas(
                                getCar().getGas()
                              + getMidGasoline() + 0.5);
            }
        } else if (getTraffic() != 0) {
            getCar().setGas(
                            getCar().getGas()
                          + getCar().getARRAY_FUEL_CONSUMPTION_FROM_ROAD_LOAD_1_10()[traffic - 1]);
        } else {
            getCar().setGas(
                            getCar().getGas()
                          + getMidGasoline());
        }

        if (getCar().isDynamicDriving()) {
            getCar().setGas(getCar().getGas() + 2.0);
        }
        if (getTraffic() == 0 && getMidGasoline() == 0) {
            getCar().setGas(0);
        }
        getCar().setGas((getCar().getGas() / 100) * getDistance());
        setResultGas(getCar().getGas() * getStationGAS().getPriceGasoline());
    } // end priceInCityGAS



}
