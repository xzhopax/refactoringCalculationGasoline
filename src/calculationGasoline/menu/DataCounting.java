package calculationGasoline.menu;

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
    protected double countNumber(double number, double resultNumber) {
        resultNumber = resultNumber + number;
        return resultNumber;
    }// end countNumber

    /**
     * resetGas() - reset static variable total gasoline
     */
    protected void resetValue(double value) {
        value = 0;
    }// end resetGas

//    /**
//     * resetResultGas() - reset static variable total money
//     */
//    protected double resetResultGas(double resultGas) {
//        return resultGas = 0;
//    }// end resetResultGas

    /**
     * findInFileGasAndMoney(String str) - searches the history file for gasoline and the money spent on it,
     * for writing them into variables to display all costs.
     * @param str - accepts a string as input to search for money or gasoline.
     */


    protected void findInFileGas(String str){
        String s1;
        String reportString;
        String regex1 = "(Бензин\\s*:\\s*(\\d+,?(\\d*)))";
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher1 = pattern.matcher(str);

        // find gas
        while (matcher1.find()) {
            s1 = matcher1.group();
            String[] arrOfStr = s1.split(":\\s?");
            for (String s : arrOfStr) {
                s = s.replaceAll(",", ".");
                if (s.matches("(\\d+(\\.?\\d+))")) {
                    // countAllMoney(Double.parseDouble(s));
                    setAllGas(countNumber(Double.parseDouble(s), getAllGas()));
                }
            }
        }//end while find gas
    }

    protected void findInFileMoney(String str){
        String s2;
        String regex2 = "(Денег\\s*:\\s*(\\d+,?(\\d*)))";
        Matcher matcher2 = Pattern.compile(regex2).matcher(str);

        //find money
        while (matcher2.find()) {
            s2 = matcher2.group();
            String[] arrOfStr = s2.split(":\\s?");
            for (String s : arrOfStr) {
                s = s.replaceAll(",", ".").trim();
                if (s.matches("(\\d+(\\.?\\d+))")) {
                    //countAllMoney(Double.parseDouble(s));
                    setAllMoney(countNumber(Double.parseDouble(s), getAllMoney()));
                }
            }
        } //end while find money



    }







}
