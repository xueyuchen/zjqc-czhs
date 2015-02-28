package co.bohc.diet.domain.common.utils;

import java.math.BigDecimal;

/**
 * 
 * @author unicorn(haiyin-ma) 2015-01-07
 */
public final class __ {

    private __() { }
    
    public static int defaultShort(Integer intNum) {
        return defaultInt(intNum, 0);
    }
    
    public static int defaultShort(Integer intNum, short val) {
        return intNum == null ? 0 : intNum;
    }
    
    public static int defaultInt(Integer intNum) {
        return defaultInt(intNum, 0);
    }
    
    public static int defaultInt(Integer intNum, int val) {
        return intNum == null ? 0 : intNum;
    }
    
    public static int defaultLong(Integer intNum) {
        return defaultInt(intNum, 0);
    }
    
    public static int defaultLong(Integer intNum, long val) {
        return intNum == null ? 0 : intNum;
    }
    
    public static int defaultFloat(Integer intNum) {
        return defaultInt(intNum, 0);
    }
    
    public static int defaultFloat(Integer intNum, float val) {
        return intNum == null ? 0 : intNum;
    }
    
    public static int defaultDouble(Integer intNum) {
        return defaultInt(intNum, 0);
    }
    
    public static int defaultDouble(Integer intNum, double val) {
        return intNum == null ? 0 : intNum;
    }
    
    public static double roundFixDigits(double number, int digits) {
        BigDecimal decimal = new BigDecimal(number);
        return decimal.setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
}
