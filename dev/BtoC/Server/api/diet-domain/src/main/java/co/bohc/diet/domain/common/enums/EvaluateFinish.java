package co.bohc.diet.domain.common.enums;

public enum EvaluateFinish {
    FINISH(1, "済"),  UNFINISH(0, "未済"), NULL(9, "NULL");

    private final int value;

    private final String label;

    private EvaluateFinish(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static EvaluateFinish valueOf(int value) {
        for (EvaluateFinish enums : EvaluateFinish.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
