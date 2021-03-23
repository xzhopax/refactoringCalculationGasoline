package calculationGasoline.cars;

public interface ActionCar {

    void onOffDynamicDriving(boolean dynamicDriving);
    double ReturnGasolineConsumptionWithCarSpeed(double speed);
    default void onOffConditioner(boolean conditionerOn) {

    }
}
