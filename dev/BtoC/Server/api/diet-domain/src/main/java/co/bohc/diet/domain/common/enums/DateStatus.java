package co.bohc.diet.domain.common.enums;

/**
 * Created by gk
 * 2014-12-25
 */
public enum DateStatus {
    NOW(0, "now", 0), NEXT(1, "next", 7), BEFORE(2, "before", -7);

    private final int value;

    private final String label;
    
    private final int days;

    private DateStatus(int value, String label, int days) {
        this.value = value;
        this.label = label;
        this.days = days;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
    
    public Integer getDays() {
        return days;
    }

    public static DateStatus valueOf(int value) {
        for (DateStatus enums : DateStatus.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        throw new IllegalArgumentException();
    }
}
