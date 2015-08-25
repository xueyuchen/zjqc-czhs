package co.bohc.diet.domain.common.utils;

import java.util.Calendar;

public class AddZeroUtil {
    
    public static Integer TIMELENGTH = 5;

    public static String addZero(Integer num, Integer length) {
        length = 10;
        String NumStr = String.valueOf(num);
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR) % 10;
        Integer month = cal.get(Calendar.MONTH) + 1;
        String monthStr = "";
        Integer day = cal.get(Calendar.DAY_OF_MONTH);
        String dayStr = "";
        Integer zeroNum = length - NumStr.length() - TIMELENGTH;
        String zeroStr = "";
        for (int i = 0; i < zeroNum; i++) {
            zeroStr = "0" + zeroStr;
        }
        if (month < 10) {
            monthStr = "0" + month;
        } else {
            monthStr = "" + month;
        }
        if (day < 10) {
            dayStr = "0" + day;
        } else {
            dayStr = "" + day;
        }
        return "" + year + monthStr + dayStr + zeroStr + NumStr;
    }
}
