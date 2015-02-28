package co.bohc.diet.domain.common.enums;



/**
 * @author GUOKAI Jan 4, 2015 1:10:21 PM
 * 
 */
public enum ReserveValid {
	
	
	VALID(1, "valid"),
	VCUBE_INVALID(2, "vcube invalid"),
	DATE_INVALID(3, "date invalid");
	
	private int value;
	
	private String lable;
	
    private ReserveValid(int value, String lable) {
        this.value = value;
        this.lable = lable;
    }

	public String getLable() {
		return lable;
	}



	public Integer getValue() {
        return value;
    }

    public static ReserveValid valueOf(int value) {
        for (ReserveValid enums : ReserveValid.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        throw new IllegalArgumentException(String.valueOf(value));
    }
    
}
