package calculationGasoline.cars;

public interface MovementOnRoad {
    default void priceGasolineRefuelingInCity
            (double distance, int traffic, double gasolinePrice, boolean conditioner, boolean dynamicDriving) {

    }

    default void drivingWithConditioningInCity(boolean conditioner, int traffic){

    }

    default void drivingWithConditioningOnHighway(boolean conditioner, double speed){

    }

    default void drivingWithDynamicStyle(boolean dynamicDriving){

    }

}
