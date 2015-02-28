package co.bohc.diet.domain.common.enums;

public enum GroupKbn {
    ET("ET","食事"),
    SP("SP","運動"),
    ST("ST","その他");
    private String value;
    private String desc;
    private GroupKbn(String value , String desc){
        this.value = value;
        this.desc = desc;
    }
    
    public static GroupKbn getGroupKbnByValue(String value) {
        for (GroupKbn enums : GroupKbn.values()) {
            if (enums.value.equals(value)) {
                return enums;
            }
        }
        throw new IllegalArgumentException();
    }
    
    public String getValue(){
        return this.value;
    }

	public String getDesc() {
		return desc;
	}
    
}
