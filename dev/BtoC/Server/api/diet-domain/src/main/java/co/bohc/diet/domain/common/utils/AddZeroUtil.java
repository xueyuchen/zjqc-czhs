package co.bohc.diet.domain.common.utils;

import java.util.Calendar;

public class AddZeroUtil {

    public static String addZero(Integer num, Integer length) {
        String NumStr = String.valueOf(num);
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR) % 10;
        Integer month = cal.get(Calendar.MONTH) + 1;
        Integer zeroNum = length - NumStr.length() - 3;
        String zeroStr = "";
        for (int i = 0; i < zeroNum; i++) {
            zeroStr = "0" + zeroStr;
        }
        if (month < 10) {
            return "" + year + "0" + month + zeroStr + NumStr;
        } else {
            return "" + year + month + zeroStr + NumStr;
        }
    }
}
