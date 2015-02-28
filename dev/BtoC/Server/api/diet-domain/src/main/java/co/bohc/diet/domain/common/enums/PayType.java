package co.bohc.diet.domain.common.enums;




public enum PayType {
    
    CREDITCARD(0,"CD", new int[]{8,9,10,11,12,13,14}),
    PAYEASY(4,"PE",new int[]{8,30,31,32,33,38,14} );
    
    private final int value;

    private final String label;
    
    private final int[] parts;

    private PayType(int value, String label, int[] parts) {
        this.value = value;
        this.label = label;
        this.parts= parts;
    }
    public static String getLabelByValue(int value){
        return valueOf(value).getLabel();
    }
    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
    
    public static PayType valueOf(int value) {
        for (PayType enums : PayType.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }

    public int[] getParts() {
        return parts;
    }
    
    
}
