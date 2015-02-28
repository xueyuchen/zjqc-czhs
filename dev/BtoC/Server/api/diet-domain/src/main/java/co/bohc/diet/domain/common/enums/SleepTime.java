package co.bohc.diet.domain.common.enums;

/**
 * Created by GuoKai
 * 2014-12-01
 */
public enum SleepTime {
    START(0, 210000, "21:00:00", 21, 0), 
    END(1, 80000, "08:00:00", 8, 0);

    private final int value;

    private final int time;
    
    private final String label;
    
    private int hour;
    
    private int minute;

    private SleepTime(int value, int time, String label, int hour, int minute) {
        this.value = value;
        this.label = label;
        this.time = time;
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
		return hour;
	}


	public int getMinute() {
		return minute;
	}


	public Integer getTime() {
		return time;
	}


	public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static SleepTime valueOf(int value) {
        for (SleepTime enums : SleepTime.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
