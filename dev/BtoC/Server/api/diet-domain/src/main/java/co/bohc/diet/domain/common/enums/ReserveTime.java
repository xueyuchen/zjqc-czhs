package co.bohc.diet.domain.common.enums;

public enum ReserveTime {

	T_10_00(0, "10:00"),
	T_11_30(1, "11:30"),
	T_13_30(2, "13:30"),
	T_15_00(3, "15:00"),
	T_16_30(4, "16:30"),
	T_18_00(5, "18:00"),
	T_19_30(6, "19:30");

    private final int value;

    private final String label;

    private ReserveTime(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static ReserveTime valueOf(int value) {
        for (ReserveTime enums : ReserveTime.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
    
}
