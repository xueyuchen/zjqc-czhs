package co.bohc.diet.domain.common.enums;

public enum ReserveStatus {

	REQUEST(0, "request"), RESEVED(1, "reserved");

    private final int value;

    private final String label;

    private ReserveStatus(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static ReserveStatus valueOf(int value) {
        for (ReserveStatus enums : ReserveStatus.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
    
}
