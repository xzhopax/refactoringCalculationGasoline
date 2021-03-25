package calculationGasoline.cars.enumsForCar;

public enum NameCar {
    CAR("Car"),
    VOLKSWAGEN_POLO("Volkswagen POLO"),
    FORD_FOCUS_3("Ford Focus 3");

    private final String name;

    NameCar(String name){
          this.name = name;
    }

    public String getName() {
        return name;
    }


}
