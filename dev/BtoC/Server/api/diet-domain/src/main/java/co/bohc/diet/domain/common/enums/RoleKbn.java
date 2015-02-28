package co.bohc.diet.domain.common.enums;

public enum RoleKbn {

     SU(0, "SU"), KE(1, "KE");

    private final int value;

    private final String label;

    private RoleKbn(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static RoleKbn valueOf(int value) {
        for (RoleKbn enums : RoleKbn.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
    
}
