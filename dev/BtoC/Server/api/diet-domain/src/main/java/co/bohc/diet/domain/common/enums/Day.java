package co.bohc.diet.domain.common.enums;

import java.util.Calendar;

public enum Day {
	MON(0, "mon", "月", Calendar.MONDAY), 
	TUE(1, "tue", "火", Calendar.TUESDAY), 
	WED(2, "wed", "水", Calendar.WEDNESDAY), 
	THU(3, "thu", "木", Calendar.THURSDAY), 
	FRI(4, "fri", "金", Calendar.FRIDAY), 
	SAT(5, "sat", "土", Calendar.SATURDAY), 
	SUN(6, "sun", "日", Calendar.SUNDAY);

	private int value;
	private String field;
	private String title;
	private int calendarValue;
	

	private Day(int value ,String field,String title, int calendarValue) {
		this.value = value;
		this.field = field;
		this.title = title;
		this.calendarValue = calendarValue;
	}		
	public static Day titleOf(String title){
		for (Day enums : Day.values()) {
			if (enums.title.equals(title)) {
				return enums;
			}
		}
		return null;
	}
	public static Day valOf(int value) {
		for (Day enums : Day.values()) {
			if (enums.value == value) {
				return enums;
			}
		}
		return null;
	}
	
	public static Day calendarValueOf(int calendarValue) {
		for (Day enums : Day.values()) {
			if (enums.calendarValue == calendarValue) {
				return enums;
			}
		}
		return null;
	}
	
	public int getValue() {
		return value;
	}

	public String getField() {
		return field;
	}

	public String getTitle() {
		return title;
	}

}
