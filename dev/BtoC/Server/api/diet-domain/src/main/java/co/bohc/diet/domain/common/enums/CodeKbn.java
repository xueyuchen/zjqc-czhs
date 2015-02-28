package co.bohc.diet.domain.common.enums;

public enum CodeKbn {
    PS(0, "PS"), NG(1, "NG");

    private final int value;

    private final String label;

    private CodeKbn(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static CodeKbn valueOf(int value) {
        for (CodeKbn enums : CodeKbn.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
    public static Integer labelOf(String label) {
        for (CodeKbn enums : CodeKbn.values()) {
            if (enums.label .equals(label)) {
                return enums.value;
            }
        }
        return null;
    }
}
