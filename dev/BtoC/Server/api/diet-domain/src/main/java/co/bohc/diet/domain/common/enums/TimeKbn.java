package co.bohc.diet.domain.common.enums;

import org.joda.time.DateTime;

/**
 * @author LiuYifan Jan 4, 2015 1:47:28 PM
 *
 */
public enum TimeKbn {

    BR("BR", 7),
    LC("LC", 12),
    DN("DN", 18),
    KS("KS", null);

    private String value;
    
    private Integer time;
    
    private TimeKbn(String value, Integer time) {
        this.value = value;
        this.time = time;
    }
    
    public String getValue() {
        return value;
    }
    
    public static TimeKbn getType(String value) {
        TimeKbn kbn = null;
        TimeKbn[] kbns = values();
        for (TimeKbn k : kbns) {
            if (k.value.equals(value)) {
                kbn = k;
                break;
            }
        }
        return kbn;
    }
    
    public static TimeKbn getLatestTimeKbn() {
        int hourOfDay = DateTime.now().getHourOfDay();
        
        if (hourOfDay < BR.time) {
            return null;
        }
        if (hourOfDay < LC.time) {
            return BR;
        }
        if (hourOfDay < DN.time) {
            return LC;
        }
        return DN;
    }
}
