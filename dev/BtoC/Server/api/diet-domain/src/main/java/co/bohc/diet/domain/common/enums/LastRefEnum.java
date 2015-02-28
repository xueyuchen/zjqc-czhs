package co.bohc.diet.domain.common.enums;


/**
 * @author GUOKAI Jan 4, 2015 1:10:21 PM
 * 
 */
public enum LastRefEnum {

	MA(0, "MA", "食事アドバイス"),
	TM(1, "TM", "タイムライン"),
	IF(2, "IF", "お知らせ"),
	MV(3, "MV", "動画"),
	CS(4, "CS", "カウンセリング");
	
	private int value;
	
	private String label;
	
	private String description;
    
    private LastRefEnum(int value, String label, String description) {
        this.value = value;
        this.label = label;
        this.description = description;
    }

    public String getDescription() {
		return description;
	}

	public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static LastRefEnum valueOf(int value) {
        for (LastRefEnum enums : LastRefEnum.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        throw new IllegalArgumentException(String.valueOf(value));
    }
}
