package calculationGasoline.cars;

public interface ActionCar {

    default void onOffDynamicDriving(boolean dynamicDriving) {

    }
    default void onOffConditioner(boolean conditionerOn) {

    }

    double returnGasolineConsumptionWithCarSpeed(double speed);

    double gasolineConsumptionWithCarSpeed(double speed);
}
