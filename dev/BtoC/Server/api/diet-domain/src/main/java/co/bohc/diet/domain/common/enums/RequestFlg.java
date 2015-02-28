package co.bohc.diet.domain.common.enums;

/**
 * Created by dhc
 * 2014-12-01
 */
public enum RequestFlg {
    NO(0, "NO"), YES(1, "YES"), BACK(2, "BACK");

    private final int value;

    private final String label;

    private RequestFlg(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static RequestFlg valueOf(int value) {
        for (RequestFlg enums : RequestFlg.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
