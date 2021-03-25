package calculationGasoline.cars.enumsForCar;

public enum NameCar {
    Car("Car"),VOLKSWAGENPOLO("Volkswagen POLO");

    private final String name;

    NameCar(String name){
          this.name = name;
    }

    public String getName() {
        return name;
    }
}
