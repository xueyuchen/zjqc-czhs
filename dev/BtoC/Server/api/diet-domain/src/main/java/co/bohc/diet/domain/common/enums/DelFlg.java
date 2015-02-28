package co.bohc.diet.domain.common.enums;

/**
 * Created by dhc
 * 2014-12-01
 */
public enum DelFlg {
    OFF(0, "off"), ON(1, "on");

    private final int value;

    private final String label;

    private DelFlg(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static DelFlg valueOf(int value) {
        for (DelFlg enums : DelFlg.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
