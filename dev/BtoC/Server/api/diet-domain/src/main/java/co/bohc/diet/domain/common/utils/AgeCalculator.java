package co.bohc.diet.domain.common.utils;

import java.util.Calendar;
import java.util.Date;

public class AgeCalculator {
    
    public static Integer bthToAge(String bthDayStr){
        Date bthDate = TimeUtils.strToDate(bthDayStr);
        Date nowDate = new Date();
        Calendar bthCal = Calendar.getInstance();
        Calendar nowCal = Calendar.getInstance();
        bthCal.setTime(bthDate);
        nowCal.setTime(nowDate);
        Integer bthYear = bthCal.get(Calendar.YEAR);
        Integer nowYear = nowCal.get(Calendar.YEAR);
        Integer bthMonth = bthCal.get(Calendar.MONTH);
        Integer nowMonth = nowCal.get(Calendar.MONTH);
        if(nowMonth > bthMonth){
            return (nowYear - bthYear);
        }else{
            return (nowYear - bthYear) - 1;
        }
        
    }
}
