package calculationGasoline.cars;

public enum CarSpeedAndPetrol {
    VOLKSWAGEN_POLO(new double[]{9.5, 6.0, 4.8, 4.0, 3.5, 4.0, 5.0, 6.0, 8.0, 10.5},
                    new double[]{0,9.5, 6.0, 4.8, 4.0, 3.5, 4.0, 5.0, 6.0, 8.0, 10.5},
                    new double[]{0, 10, 20, 30, 40, 60, 80, 100, 120, 150, 200} );


    private final double[] fuelConsumptionCarSpeed;
    private final double[] gasolineConsumption;
    private final double[] speedCar;


    CarSpeedAndPetrol(double[] fuelConsumptionCarSpeed, double[] gasolineConsumption, double[] speedCar){
        this.fuelConsumptionCarSpeed = fuelConsumptionCarSpeed;
        this.gasolineConsumption = gasolineConsumption;
        this.speedCar = speedCar;
    }

    public double[] getFuelConsumptionCarSpeed() {
        return fuelConsumptionCarSpeed;
    }
    public double[] getSpeedCar() {
        return speedCar;
    }
    public double[] getGasolineConsumption() {
        return gasolineConsumption;
    }

    public double returnGasolineConsumptionWithCarSpeed(double speed){
        double result = 0;
        drop: {
            for (int i = 0; i < gasolineConsumption.length; i++){
                if (speed <= getSpeedCar()[i]){
                    result = gasolineConsumption[i];
                    break drop;
                }
            }
        }
        return result;
    }
}


