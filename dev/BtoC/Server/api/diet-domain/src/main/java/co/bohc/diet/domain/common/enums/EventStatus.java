package co.bohc.diet.domain.common.enums;


public enum EventStatus {
	UNDO(0, "未済"),
	OVER(1, "済み"),
	REJECT(2, "差戻し");

	private int value;
	private String info;
	

	private EventStatus(int value ,String info) {
		this.value = value;
		this.info = info;
	}		
	public static EventStatus infoOf(String info){
		for (EventStatus enums : EventStatus.values()) {
			if (enums.info.equals(info)) {
				return enums;
			}
		}
		return null;
	}
	
	public static EventStatus valOf(int value) {
		for (EventStatus enums : EventStatus.values()) {
			if (enums.value == value) {
				return enums;
			}
		}
		return null;
	}

	
	public int getValue() {
		return value;
	}

	public String getInfo() {
		return info;
	}


}
