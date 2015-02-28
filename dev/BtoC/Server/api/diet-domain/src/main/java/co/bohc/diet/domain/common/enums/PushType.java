package co.bohc.diet.domain.common.enums;

/**
 * Created by dhc
 * 2014-12-01
 */
public enum PushType {
	
    TL(0, "time line", "#u0009", "TL"), 
    IN(1, "info", "#u0010", "IN"), 
    // TODO
    CO(3, "counseling", "#u0013", "CO"),
    MA(4, "meal comment", "#u0018", "MA"),
    WS(5, "weeksummary", "#u0016", "WS"),
    RM(6, "remind", "#u0002", "RM");

    private final int value;

    private final String msg;
    
    private final String url;
    
    private final String kbn;

    private PushType(int value, String msg, String url, String kbn) {
        this.value = value;
        this.msg = msg;
        this.url = url;
        this.kbn = kbn;
    }

    public Integer getValue() {
        return value;
    }

    
    public String getMsg() {
		return msg;
	}

	public String getUrl() {
		return url;
	}

	public String getKbn() {
		return kbn;
	}

	public static PushType valueOf(int value) {
        for (PushType enums : PushType.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
