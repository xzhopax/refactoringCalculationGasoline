package calculationGasoline.cars.onBoardComputerCar.workData;

import calculationGasoline.MenuGUI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCounting {
    private static double allGas;
    private static double allMoney;

    public static double getAllGas() {
        return allGas;
    }
    public static void setAllGas(double allGas) {
        DataCounting.allGas = allGas;
    }
    public static double getAllMoney() {
        return allMoney;
    }
    public static void setAllMoney(double allMoney) {
        DataCounting.allMoney = allMoney;
    }

    /**
     * countNumber - accepts two double numbers as input to add one to the other
     * @param number - the number to be added
     * @param resultNumber - to it you need to add
     * @return - will return the result of adding numbers
     */
    public static double countNumber(double number, double resultNumber) {
        resultNumber = resultNumber + number;
        return resultNumber;
    }// end countNumber

//    /**
//     * resetGas() - reset static variable total gasoline
//     */
//    protected void resetValue(double value) {
//        value = 0;
//    }// end resetGas

    /**
     * findInFileGas(String str) - searches the history file for gasoline spent on it,
     * for writing his into variable to display all costs.
     * @param str - accepts a string as input to search for gasoline.
     */
    public static void findInFileGas(String str){
        setAllGas(0);
        String regex1 = "(Бензин\\s*:\\s*(\\d+,?(\\d*)))";
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher1 = pattern.matcher(str);
        findFiles(matcher1,getAllGas());

    }//end find gas

    /**
     * findInFileMoney(String str) - searches the history file for money   spent ,
     * for writing them into variable to display all costs.
     * @param str - accepts a string as input to search for money.
     */
    public static void findInFileMoney(String str){
        setAllMoney(0);
        String regex2 = "(Денег\\s*:\\s*(\\d+,?(\\d*)))";
        Matcher matcher2 = Pattern.compile(regex2).matcher(str);
        findFiles(matcher2,getAllMoney());
    } //end find money

    public static double findFiles(Matcher matcher, double writeResult){
        String str;
        while (matcher.find()) {
            str = matcher.group();
            String[] arrOfStr = str.split(":\\s?");
            for (String s : arrOfStr) {
                s = s.replaceAll(",", ".").trim();
                if (s.matches("(\\d+(\\.?\\d+))")) {
                    writeResult = countNumber(Double.parseDouble(s), writeResult);
                }
            }
        }
        return writeResult;
    }

    /**
     * cleanResult() - delete records from the file and reset the static
     * fields to display the report history on the screen
     */
    public static void cleanResult() {// start clean
        setAllMoney(0);
        setAllGas(0);
        try (Writer reportFile = new FileWriter
                ("reportFile.txt", false)) {
            reportFile.write("");
        } catch (IOException e) {
            MenuGUI.error();
            e.printStackTrace();
        }
    }// end clean

    /**
     * reportTheTotal() - displays the total amount of consumed gasoline and money spent on it
     * @return - returns a string with information about parameters of all gasoline costs and money for it
     */
    public static String reportTheTotal() {
        setAllMoney(0);
        setAllGas(0);
        return String.format("Общая сумма денег была потрачена на бензин : %.2f\n", getAllMoney()) +
                String.format("Общее количество бензина израсходаванно : %.2f", getAllGas());
    }//end reportTheTotal









}
