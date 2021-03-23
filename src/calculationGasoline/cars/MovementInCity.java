package calculationGasoline.cars;

public interface MovementInCity {
    default void priceGasolineRefuelingInCity
            (double distance, int traffic, double gasolinePrice, boolean conditioner, boolean dynamicDriving) {

    }

    default void drivingWithConditioningInCity(boolean conditioner){

    }

    default void drivingWithDynamicStyleInCity(boolean dynamicDriving){

    }

}
