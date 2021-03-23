package calculationGasoline.cars;

public interface MovementOnHighway {
    default void priceGasolineRefuelingOnHighway
            (double distance, int traffic, double gasolinePrice, boolean conditioner, boolean dynamicDriving) {

    }

    default void drivingWithConditioningOnHighway(boolean conditioner){

    }

    default void drivingWithDynamicStyleOnHighway(boolean dynamicDriving){

    }
}
