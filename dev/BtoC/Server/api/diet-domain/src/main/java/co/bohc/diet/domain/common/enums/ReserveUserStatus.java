package co.bohc.diet.domain.common.enums;

/**
 * Created by dhc
 * 2014-12-01
 */
public enum ReserveUserStatus {
	WEALTHY(0, "Wealthy"),  POVERTY(1, "Poverty"), REQUEST(2, "Request");

    private final int value;

    private final String label;

    private ReserveUserStatus(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static ReserveUserStatus valueOf(int value) {
        for (ReserveUserStatus enums : ReserveUserStatus.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
