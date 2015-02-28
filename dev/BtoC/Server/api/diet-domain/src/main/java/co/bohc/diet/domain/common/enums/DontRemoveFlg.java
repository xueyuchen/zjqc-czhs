package co.bohc.diet.domain.common.enums;

public enum DontRemoveFlg {

    OFF(1, "off"), ON(0, "on");

    private final int value;

    private final String label;

    private DontRemoveFlg(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static DontRemoveFlg valueOf(int value) {
        for (DontRemoveFlg enums : DontRemoveFlg.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
