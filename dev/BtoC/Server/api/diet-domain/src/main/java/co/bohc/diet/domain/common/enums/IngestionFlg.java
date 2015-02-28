package co.bohc.diet.domain.common.enums;

/**
 * @author LiuYifan Jan 4, 2015 1:10:21 PM
 *
 */
public enum IngestionFlg {

    NOT_EAT(1),
    EATEN(0);
    
    private int value;
    
    private IngestionFlg(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public static IngestionFlg getType(int value) {
        IngestionFlg type = null;
        IngestionFlg[] types = values();
        for (IngestionFlg t : types) {
            if (t.value == value) {
                type = t;
                break;
            }
        }
        return type;
    }
}
