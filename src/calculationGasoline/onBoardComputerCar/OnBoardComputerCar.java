package calculationGasoline.onBoardComputerCar;

import calculationGasoline.cars.Car;
import calculationGasoline.onBoardComputerCar.workData.CheckingEnteredData;
import calculationGasoline.onBoardComputerCar.workData.DataCounting;
import calculationGasoline.MenuGUI;

import java.io.*;


public class OnBoardComputerCar {
    private String date;
    private double resultGas = 0, midGasoline = 0, distance = 0, price = 0;
    public int traffic = 0;
    private StringBuilder sb = new StringBuilder();

    private final Car car;
    public OnBoardComputerCar(Car car){
        this.car = car;
    }

    //getter and setter
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getResultGas() {
        return resultGas;
    }
    public void setResultGas(double resultGas) {
        this.resultGas = resultGas;
    }
    public double getMidGasoline() {
        return midGasoline;
    }
    public void setMidGasoline(double midGasoline) {
        this.midGasoline = midGasoline;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public int getTraffic() {
        return traffic;
    }
    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Car getCar() {
        return car;
    }
    //end getter and setter

    /**
     * priceOnGasolineCosts - The method calculates the spent gasoline liters and the cost of this gasoline.
     * 1. Formula for calculating the spent gasoline:
     * Average consumption per 100 km * all the way (km) / 100 = spent liters.
     * 2. The value formula of the spent gasoline = spent gasoline * on the price per liter
     * @param distance - Distance traveled on car
     * @param price - Cost 1 liter of gasoline
     */
    public void priceOnGasolineCosts (double distance, double price) {
        getCar().setGasolineCosts((getCar().getGasolineCosts() * distance) / 100);
        setResultGas(getCar().getGasolineCosts() * price);
    }// end priceOnGasolineCosts

    /**
     * Checks the method CheckingEnteredData.isDateValidInString(date) that the date is entered correctly
     * and if true, then writes the result
     * else leaves the field empty
     *
     * @param date - Takes the date on the line in the form of a string
     */
    public void todayDate(String date) {
        CheckingEnteredData.isDateValidInString(date);
        if (CheckingEnteredData.isDateValidInString(date)) {
            setDate(date);
        } else {
            setDate("");
        }
    }// end todayDate

    /**
     * resetGasAndResultGas() - reset static variable total gasoline and total money
     */
    public void resetGasAndResultGas() {
        getCar().setGasolineCosts(0);
        setResultGas(0);
    }// end resetGasAndResultGas

    /**
     * reportCity() - city driving report for display
     * @return - returns a line with a report of the cost of city driving on the specified day
     */
    public String reportCity() {
        sb.setLength(0);
        sb.append("\n=============================================\n");
        sb.append(getDate()).append("\n");
        sb.append("За пройденный путь в населенном пункте вы потратили:\n");
        sb.append(String.format("Бензин : %.2f литров\n", getCar().getGasolineCosts()));
        sb.append(String.format("Денег: %.2f рублей\n", getResultGas()));
        sb.append("=============================================\n");
        saveReport(sb.toString());
        return sb.toString();
    } // end reportCity

    /**
     * reportHighway() - track driving report for display
     * @return - returns a line with a report of the cost of driving on the highway on the specified day
     */
    public String reportHighway() {
        sb.setLength(0);
        sb.append("\n=============================================\n");
        sb.append(getDate()).append("\n");
        sb.append("За пройденный путь по трассе вы потратили:\n");
        sb.append(String.format("Бензин : %.2f литров\n", getCar().getGasolineCosts()));
        sb.append(String.format("Денег: %.2f рублей\n", getResultGas()));
        sb.append("=============================================\n");
        saveReport(sb.toString());
        return sb.toString();
    } //end reportHighway

    /**
     * saveReport(String line) - save the report to a file
     * @param line - takes a string as input to be written to a file
     */
    protected void saveReport(String line) {
        try (Writer reportFile = new FileWriter
                ("reportFile.txt", true)) {
            reportFile.write(line);
        } catch (IOException e) {
            MenuGUI.error();
            e.printStackTrace();
        }
    }// end save report

    /**
     * outDisplayReport() - reading history from a file to display it on the screen
     * @return - returns a string with information read from a file
     */
    public String outDisplayReport() {
        StringBuilder sb = new StringBuilder();
        try (Reader reader = new FileReader
                ("reportFile.txt")) {
            int data = reader.read();
            while (data != -1) {
                sb.append((char) data);
                data = reader.read();
            }
            DataCounting.setAllGas(DataCounting.findInFileGas(sb.toString()));
            DataCounting.setAllMoney(DataCounting.findInFileMoney(sb.toString()));
        } catch (IOException e) {
            MenuGUI.error();
            e.printStackTrace();
        }
        return sb.toString();
    }//end outDisplayReport






}
