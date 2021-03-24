package calculationGasoline.test;

import calculationGasoline.cars.Car;
import calculationGasoline.cars.VolkswagenPolo;
import org.junit.Assert;
import org.junit.Test;

public class TestProgram {

    @Test
   public void testGasolineConsumptionWithCarSpeed(){
        Car car = new VolkswagenPolo();

       Assert.assertEquals(10.5,car.gasolineConsumptionWithCarSpeed(200),0.1);
       Assert.assertEquals(8.0,car.gasolineConsumptionWithCarSpeed(150),0.1);
       Assert.assertEquals(0,car.gasolineConsumptionWithCarSpeed(210),0.1);
       Assert.assertEquals(0,car.gasolineConsumptionWithCarSpeed(0),0.1);
       Assert.assertEquals(6,car.gasolineConsumptionWithCarSpeed(11),0.1);
       Assert.assertEquals(4.8,car.gasolineConsumptionWithCarSpeed(21),0.1);
       Assert.assertEquals(0,car.gasolineConsumptionWithCarSpeed(-10),0.1);
    }
}
