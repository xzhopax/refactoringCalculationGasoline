package calculationGasoline.onBoardComputerCar.workData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CheckingEnteredData implements Check {

    /**
     * validDouble - checking a string for a number double
     * @param StringNumPrice - accepts a string as input to check it for double
     * @return - if the input parameter is correct, then it returns the number of doubles
     */
    public static double validDoubleInString(String StringNumPrice) {
        double result = 0;
        if (StringNumPrice.matches("(\\d+(\\.\\d+))") && Double.parseDouble(StringNumPrice) > 0
                || StringNumPrice.matches("\\d+") && Integer.parseInt(StringNumPrice) > 0) {
            result = Double.parseDouble(StringNumPrice);
            return result;
        }
        return result;
    }// end validDouble

    /**
     * validInteger(String StringNumPrice) - checking a string for a number integer
     * @param StringNumPrice - accepts a string as an input to check it for an integer
     * @return - if the input parameter is correct, then it returns an integer
     */
     public static int validIntegerInString(String StringNumPrice) {
        int result = 0;
        if (StringNumPrice.matches("\\d+") && Integer.parseInt(StringNumPrice) > 0) {
            result = Integer.parseInt(StringNumPrice);
            return result;
        }
        return result;
    }// end validInteger

    /**
     * isDateValid(String date) - checking if the date is entered correctly
     * @param date - accepts a string as input to check it for a date
     * @return - if the input parameter is correct, then it returns true otherwise return false
     */
    public static boolean isDateValidInString(String date) {
        try {
            DateFormat df = new SimpleDateFormat("d.M.yyyy");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }// end isDateValid

    /**
     * fixErrorTraffic - Catch an incorrect
     * @param traffic - How many cork points in the city
     * @return - If you go beyond 1 to 10, returns 1 or If true, then transmitted value
     */
    public static int fixErrorTraffic(int traffic){
        return (traffic == 0 || traffic == 11) ? 1 : traffic;
    }


}
