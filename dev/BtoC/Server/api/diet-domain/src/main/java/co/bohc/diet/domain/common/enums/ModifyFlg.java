package co.bohc.diet.domain.common.enums;

public enum ModifyFlg {

    OFF(0, "off"), ON(1, "on");
    
    private final int value;
    
    private final String lable;
    
    private ModifyFlg(int value, String lable){
        this.value = value;
        this.lable = lable;
    }

    public int getValue() {
        return value;
    }

    public String getLable() {
        return lable;
    }
    
    public static ModifyFlg valueOf(int value) {
        for (ModifyFlg enums : ModifyFlg.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
