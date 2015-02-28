package co.bohc.diet.domain.common.enums;

/**
 * Created by dhc
 * 2014-12-01
 */
public enum BaseFlg {
    OFF(0, "off"), ON(1, "on");

    private final int value;

    private final String label;

    private BaseFlg(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static BaseFlg valueOf(int value) {
        for (BaseFlg enums : BaseFlg.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
