package calculationGasoline.cars;

public interface ActionCar {

    default void onOffDynamicDriving(boolean dynamicDriving) {

    }
    default void onOffConditioner(boolean conditionerOn) {

    }

    default double returnGasolineConsumptionWithCarSpeed(double speed) {
        return 0;
    }

    double gasolineConsumptionWithCarSpeed(double speed);
}
