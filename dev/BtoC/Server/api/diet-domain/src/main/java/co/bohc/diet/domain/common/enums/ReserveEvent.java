package co.bohc.diet.domain.common.enums;

/**
 * Created by dhc
 * 2014-12-01
 */
public enum ReserveEvent {
    RELIEVE(0, "Relieve"),  RSERVE(1, "Reserve");

    private final int value;

    private final String label;

    private ReserveEvent(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static ReserveEvent valueOf(int value) {
        for (ReserveEvent enums : ReserveEvent.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
