package co.bohc.diet.domain.common.enums;

public enum WorkStatus {

     SLEEP(0, "休み"), UNRESEVED(1, "空き"), RESEVED(2, "予約");

    private final int value;

    private final String label;

    private WorkStatus(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static WorkStatus valueOf(int value) {
        for (WorkStatus enums : WorkStatus.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
    
}
