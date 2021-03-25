package calculationGasoline.test;

import calculationGasoline.cars.Car;
import calculationGasoline.cars.VolkswagenPolo;
import calculationGasoline.onBoardComputerCar.workData.DataCounting;
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

    @Test
    public void testFindInFileGas(){
        String str = "25.12.1111\n" +
                "За пройденный путь по трассе вы потратили:\n" +
                "Бензин : 10,20 литров\n" +
                "Денег: 499,80 рублей\n" +
                "=============================================\n" +
                "\n" +
                "=============================================\n" +
                "25.12.1111\n" +
                "За пройденный путь по трассе вы потратили:\n" +
                "Бензин : 7,20 литров\n" +
                "Денег: 352,80 рублей\n" +
                "=============================================";
        double result = DataCounting.findInFileGas(str);

        Assert.assertEquals(17.40, result, 0.01);
    }
}
