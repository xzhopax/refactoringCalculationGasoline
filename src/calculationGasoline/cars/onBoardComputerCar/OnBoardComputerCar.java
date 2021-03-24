package calculationGasoline.cars.onBoardComputerCar;

import calculationGasoline.cars.Car;
import calculationGasoline.cars.onBoardComputerCar.workData.CheckingEnteredData;
import calculationGasoline.cars.onBoardComputerCar.workData.DataCounting;
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

    public void priceOnGasolineCosts (double distance, double price) {
        getCar().setGasolineCosts((getCar().getGasolineCosts() / 100) * distance);
        setResultGas(getCar().getGasolineCosts() * price);
    }// end priceOnGasolineCosts

//    public void priceInCityGAS(double distance, double price) {
//        getCar().setGasolineCosts((getCar().getGasolineCosts() / 100) * distance);
//        setResultGas(getCar().getGasolineCosts() * price);
//    } // end priceInCityGAS

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
            DataCounting.findInFileGas(sb.toString());
            DataCounting.findInFileMoney(sb.toString());
        } catch (IOException e) {
            MenuGUI.error();
            e.printStackTrace();
        }
        return sb.toString();
    }//end outDisplayReport






}
