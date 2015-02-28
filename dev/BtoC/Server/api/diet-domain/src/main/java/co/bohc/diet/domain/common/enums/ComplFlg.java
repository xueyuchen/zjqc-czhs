package co.bohc.diet.domain.common.enums;

/**
 * Created by dhc
 * 2014-12-01
 */
public enum ComplFlg {
    OFF(0, "off"), ON(1, "on");

    private final int value;

    private final String label;

    private ComplFlg(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static ComplFlg valueOf(int value) {
        for (ComplFlg enums : ComplFlg.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
